package com.kishan.controller;

import com.kishan.dto.CommentDto;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {

    @GET
    @Path("/comments.json")
    public List<CommentDto> getComments(){
        List<CommentDto> returnList = new ArrayList<>();
        returnList.add(new CommentDto().builder().comment("First comment").build());
        returnList.add(new CommentDto().builder().comment("Second comment").build());
        return returnList;
    }
}
