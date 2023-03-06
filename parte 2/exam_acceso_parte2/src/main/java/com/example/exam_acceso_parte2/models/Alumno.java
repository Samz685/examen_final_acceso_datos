package com.example.exam_acceso_parte2.models;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "alumnado")
public class Alumno {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "ad")
    private double ad;

    @Column(name = "di")
    private double di;

}
