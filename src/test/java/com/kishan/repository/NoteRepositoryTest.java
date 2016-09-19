package com.kishan.repository;

import com.kishan.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteRepositoryTest {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    @Transactional
    public void shouldAddNote()
    {
        Note note = Note.builder().content("Note 1").build();
        Note addedNote = noteRepository.addNote(note);

        Note noteFromDB = entityManager.find(Note.class, addedNote.getId());
        assertThat(addedNote.getContent(), is(noteFromDB.getContent()));
        assertThat(addedNote.getId(), is(noteFromDB.getId()));
    }
}
