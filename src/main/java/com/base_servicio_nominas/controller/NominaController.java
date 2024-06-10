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
import com.base_servicio_nominas.model.entity.Nomina;
import com.base_servicio_nominas.service.NominaService;

@RestController
@RequestMapping("/api/v1/dev")
public class NominaController {

    @Autowired
    private NominaService nominaService;

    @GetMapping("/nominas")
    public ResponseEntity<List<Nomina>> consultarNominas(){
        return new ResponseEntity<>(nominaService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/nominas/{id:\\d+}")
    public ResponseEntity<Nomina> consultarPersonalId(@PathVariable("id") Long id) {
        Nomina nomina = nominaService.findById(id);
        if (nomina == null) {
           throw new ModelNotFoundException("Nomina not found with id: " + id);
        }
        return new ResponseEntity<>(nomina, HttpStatus.OK);
    }

}
