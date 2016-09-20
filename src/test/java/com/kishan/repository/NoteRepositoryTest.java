package com.kishan.repository;

import com.kishan.model.Note;
import com.kishan.model.QNote;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NoteRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void shouldAddNote()
    {
        val note = Note.builder().content("Note 1").build();

        val addedNote = noteRepository.addNote(note);

        val noteFromDB = entityManager.find(Note.class, addedNote.getId());
        assertThat(addedNote.getContent(), is(noteFromDB.getContent()));
        assertThat(addedNote.getId(), is(noteFromDB.getId()));
    }

    @Test
    public void shouldGetAllNotes()
    {
        save(Note.builder().content("Note 1").build());
        save(Note.builder().content("Note 2").build());
        save(Note.builder().content("Note 3").build());

        val notes = noteRepository.getNotes();

        assertThat(notes.size(), is(3));
    }

    @Test
    public void shouldGetSingleNote()
    {
        val note = Note.builder().content("Note 1").build();
        entityManager.persist(note);

        val returnedNote = noteRepository.getNote(note.getId());

        assertThat(returnedNote.getId(), is(note.getId()));
        assertThat(returnedNote.getContent(), is(note.getContent()));
    }

    @Test
    public void shouldDeleteAllNotes()
    {
        save(Note.builder().content("Note 1").build());
        save(Note.builder().content("Note 2").build());
        save(Note.builder().content("Note 3").build());

        noteRepository.deleteAllNotes();

        val noOfNotesInDB = from(QNote.note).count();
        assertThat(noOfNotesInDB, is(0L));
    }

    @Test
    public void shouldDeleteNoteById()
    {
        val note = save(Note.builder().content("Note 1").build());
        val noteId = note.getId();

        noteRepository.deleteNote(noteId);

        val noteFromDB = from(QNote.note).where(QNote.note.id.eq(noteId)).singleResult(QNote.note);
        assertThat(noteFromDB, is(nullValue()));
    }

    @Test
    public void shouldUpdateNoteById()
    {
        val note1 = save(Note.builder().content("Note 1").build());
        val note2 = save(Note.builder().content("Note 2").build());
        val note3 = save(Note.builder().content("Note 3").build());
        val note2Id = note2.getId();
        val newContent = "New Note 2";
        val updatedNote2 = Note.builder().content(newContent).build();

        noteRepository.updateNote(note2Id, updatedNote2);

        val note1FromDB = getNoteFromDB(note1.getId());
        val note2FromDB = getNoteFromDB(note2.getId());
        val note3FromDB = getNoteFromDB(note3.getId());
        assertThat(note1FromDB.getContent(), is(note1.getContent()));
        assertThat(note2FromDB.getContent(), is(newContent));
        assertThat(note3FromDB.getContent(), is(note3.getContent()));
    }


    private Note getNoteFromDB(Long noteId)
    {
        return from(QNote.note).where(QNote.note.id.eq(noteId)).singleResult(QNote.note);
    }
}
