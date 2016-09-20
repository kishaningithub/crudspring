package com.kishan.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
}
