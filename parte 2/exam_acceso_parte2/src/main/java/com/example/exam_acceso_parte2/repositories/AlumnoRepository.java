/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.exam_acceso_parte2.repositories;

import com.example.exam_acceso_parte2.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Syzer
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
}
