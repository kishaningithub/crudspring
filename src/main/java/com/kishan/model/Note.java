package com.kishan.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Builder(toBuilder = true)
@Value
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
}
