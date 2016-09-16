package com.kishan.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoteDto {
    private Long id;
    private String content;

    public NoteDto(Long id, String content){
        this.id = id;
        this.content = content;
    }

}
