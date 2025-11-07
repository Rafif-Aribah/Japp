package com.rafif.japp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "katakana")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Katakana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "katakana", length = 10)
    private String katakana;

    @Column(name = "romaji", length = 10)
    private String romaji;

    @Column(name = "category", length = 20)
    private String category;

    @Column(name = "stroke_order", length = 255)
    private String stroke_order;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "enum('base','dakuten','handakuten')")
    private Type type;
}
