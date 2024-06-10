package com.base_servicio_nominas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.base_servicio_nominas.model.entity.Nomina;

@Service
public interface NominaService {

    public List<Nomina> findAll();

    public Nomina findById(Long id);
}
