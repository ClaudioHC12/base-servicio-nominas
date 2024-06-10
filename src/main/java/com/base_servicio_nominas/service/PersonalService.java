package com.base_servicio_nominas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.base_servicio_nominas.model.entity.Personal;

@Service
public interface PersonalService {

    public List<Personal> findAll();

    public Personal findById(Long id);
}
