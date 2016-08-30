package com.kishan.controller;

import com.kishan.dto.CommentsDto;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentsController {

    @GET
    @Path("/comments.json")
    public List<CommentsDto> getComments(){
        List<CommentsDto> returnList = new ArrayList<>();
        returnList.add(new CommentsDto().builder().comment("First comment").build());
        returnList.add(new CommentsDto().builder().comment("Second comment").build());
        return returnList;
    }
}
