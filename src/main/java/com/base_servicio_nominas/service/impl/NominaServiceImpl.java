package com.base_servicio_nominas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base_servicio_nominas.model.entity.Nomina;
import com.base_servicio_nominas.service.NominaService;
import com.base_servicio_nominas.service.PersonalService;
import com.base_servicio_nominas.util.GenerarNominas;

@Service
public class NominaServiceImpl implements NominaService {

    @Autowired
    private PersonalService personalService;
    @Autowired
    private GenerarNominas generarNominas;

    @Override
    public List<Nomina> findAll() {
        List<Nomina> nominas = new ArrayList<>();
        nominas = generarNominas.getNominas(personalService.findAll());
        return nominas;
    }

    @Override
    public Nomina findById(Long id) {
        List<Nomina> nominas = generarNominas.getNominas(personalService.findAll());
        return nominas.stream()
                .filter(nomina -> nomina.getIdNomina().equals(id))
                .findFirst()
                .orElse(null);
    }

}
