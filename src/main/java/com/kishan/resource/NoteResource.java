package com.kishan.resource;

import com.kishan.dto.NoteDto;
import com.kishan.model.Note;
import com.kishan.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Path("yournote/v1")
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {

    @Autowired
    private NoteRepository noteRepository;

    @GET
    @Path("/notes")
    public List<NoteDto> getNotes(){
        return noteRepository.getNotes().stream().map(this::getNoteDto).collect(Collectors.toList());
    }

    @GET
    @Path("/notes/{id}")
    public NoteDto getNote(@PathParam("id") Long id)
    {
        return getNoteDto(noteRepository.getNote(id));
    }

    @POST
    @Path("/notes")
    public Response addNote(@Context UriInfo uriInfo,  NoteDto noteDto)
    {
        Note createdNote = noteRepository.addNote(getNote(noteDto));
        URI newlyCreatedResourceURI = uriInfo.getAbsolutePathBuilder()
                .path(createdNote.getId().toString())
                .build();
        return Response.created(newlyCreatedResourceURI)
                .entity(getNoteDto(createdNote))
                .build();
    }

    @PUT
    @Path("/notes/{id}")
    public NoteDto updateNote(@PathParam("id") Long id, NoteDto noteDto)
    {
        return getNoteDto(noteRepository.updateNote(id, getNote(noteDto)));
    }

    @DELETE
    @Path("/notes/{id}")
    public Response deleteNote(@PathParam("id") Long id)
    {
        noteRepository.deleteNote(id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/notes")
    public Response deleteAllNotes()
    {
        noteRepository.deleteAllNotes();
        return Response.noContent().build();
    }

    private Note getNote(NoteDto noteDto)
    {
        return Note.builder()
                .id(noteDto.getId())
                .content(noteDto.getContent())
                .build();
    }

    private NoteDto getNoteDto(Note note)
    {
        return NoteDto.builder()
                .id(note.getId())
                .content(note.getContent())
                .build();
    }


}
