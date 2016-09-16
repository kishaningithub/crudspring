package com.kishan.repository;

import com.kishan.dto.NoteDto;
import com.kishan.model.QNote;
import com.mysema.query.types.ConstructorExpression;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepository extends AbstractRepository{

    private QNote note = QNote.note;

    public List<NoteDto> getNotes()
    {
        return from(note).list(constructNote());
    }

    private ConstructorExpression<NoteDto> constructNote()
    {
        return ConstructorExpression.create(NoteDto.class, note.id, note.content);
    }
}
