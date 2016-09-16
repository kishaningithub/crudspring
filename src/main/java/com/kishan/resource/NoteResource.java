package com.kishan.resource;

import com.kishan.dto.NoteDto;
import com.kishan.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("yournote/v1")
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {

    @Autowired
    private NoteRepository noteRepository;

    @GET
    @Path("/notes")
    public List<NoteDto> getComments(){
        return noteRepository.getNotes();
    }
}
