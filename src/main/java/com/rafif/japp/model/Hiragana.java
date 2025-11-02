package com.rafif.japp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hiragana")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hiragana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hiragana", length = 10)
    private String hiragana;

    @Column(name = "romaji", length = 10)
    private String romaji;

    @Column(name = "category", length = 20)
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "enum('base','dakuten','handakuten')")
    private Type type;
}
