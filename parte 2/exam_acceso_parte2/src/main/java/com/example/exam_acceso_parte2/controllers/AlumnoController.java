/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.exam_acceso_parte2.controllers;


import com.example.exam_acceso_parte2.models.Alumno;
import com.example.exam_acceso_parte2.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Syzer
 */
@RestController
@RequestMapping("/alumnado")
public class AlumnoController {

    @Autowired
    AlumnoRepository repo;

    @GetMapping()
    public List<Alumno> list() {
        return repo.findAll();
    }


    //Listar Alumno concreto con su ID
    @GetMapping("/{id}")

    public ResponseEntity<Alumno> get(@PathVariable Long id) {
        if (repo.existsById(id)) {
            return new ResponseEntity<Alumno>(repo.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Listar alumnos que tengan suspenso el modulo indicado
    @GetMapping("/suspensos/{modulo}")
    public ResponseEntity<List<LinkedHashMap<String, Object>>> alumnadoSuspenso(@PathVariable String modulo) {
        List<Alumno> alumnos = repo.findAll();
        LinkedHashMap<String, Object> alumnoDetalle = new LinkedHashMap<>();
        if (!alumnos.isEmpty()) {
            List<LinkedHashMap<String, Object>> alumnadoLista = new ArrayList<>();

            for (Alumno alumno : alumnos) {
                if (modulo.equals("ad")) {
                    if (alumno.getAd() < 5) {
                        alumnoDetalle.put("id", alumno.getId());
                        alumnoDetalle.put("nombre", alumno.getNombre());
                        alumnoDetalle.put("ad", alumno.getAd());
                    }
                } else if (modulo.equals("di")) {
                    if (alumno.getDi() < 5) {
                        alumnoDetalle.put("id", alumno.getId());
                        alumnoDetalle.put("nombre", alumno.getNombre());
                        alumnoDetalle.put("di", alumno.getDi());
                    }
                }


            }
            alumnadoLista.add(alumnoDetalle);
            return new ResponseEntity<List<LinkedHashMap<String, Object>>>(alumnadoLista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Crear un nuevo alumno
    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno input) {

        repo.save(input);
        System.out.println(input);

        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }


    //Borrar un Alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> delete(@PathVariable Long id) {

        ResponseEntity<Alumno> salida;

        if (repo.existsById(id)) {
            salida = new ResponseEntity<Alumno>(repo.findById(id).get(), HttpStatus.OK);
            repo.deleteById(id);
        } else {
            salida = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }

        return salida;
    }

}
