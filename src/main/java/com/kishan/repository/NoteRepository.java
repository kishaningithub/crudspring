package com.kishan.repository;

import com.kishan.model.Note;
import com.kishan.model.QNote;
import com.mysema.query.types.ConstructorExpression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NoteRepository extends AbstractRepository{

    private QNote note = QNote.note;

    public List<Note> getNotes()
    {
        return from(note).list(constructNote());
    }

    public Note getNote(Long id) {
        return from(note)
                .where(note.id.eq(id))
                .singleResult(note);
    }

    @Transactional
    public Note addNote(Note note)
    {
        entityManager.persist(note);
        return note;
    }

    @Transactional
    public Note updateNote(Long id, Note note) {
        Note updatedNote = Note.builder().id(id).content(note.getContent()).build();
        entityManager.persist(updatedNote);
        return updatedNote;
    }

    private ConstructorExpression<Note> constructNote()
    {
        return ConstructorExpression.create(Note.class, note.id, note.content);
    }

    @Transactional
    public void deleteAllNotes() {
        delete(note).execute();
    }

    @Transactional
    public void deleteNote(Long id) {
        delete(note).where(note.id.eq(id)).execute();
    }
}
