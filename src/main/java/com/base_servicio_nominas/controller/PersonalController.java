package com.base_servicio_nominas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base_servicio_nominas.exception.ModelNotFoundException;
import com.base_servicio_nominas.model.entity.Personal;
import com.base_servicio_nominas.service.PersonalService;

@RestController
@RequestMapping("/api/v1/dev")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping("/personal")
    public ResponseEntity<List<Personal>> consultarPersonal() {
        return new ResponseEntity<>(personalService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/personal/{id:\\d+}")
    public ResponseEntity<Personal> consultarPersonalId(@PathVariable("id") Long id) {
        Personal persona = personalService.findById(id);
        if (persona == null) {
           throw new ModelNotFoundException("Personal not found with id: " + id);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
}
