package com.base_servicio_nominas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.base_servicio_nominas.model.entity.Bono;
import com.base_servicio_nominas.model.entity.Personal;
import com.base_servicio_nominas.model.entity.Retencion;
import com.base_servicio_nominas.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Override
    public List<Personal> findAll() {
        return dataSource();
    }

    @Override
    public Personal findById(Long id) {
        List<Personal> personas = dataSource();
        return personas.stream()
                .filter(persona -> persona.getIdPersonal().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Personal> dataSource() {
        List<Personal> personas = new ArrayList<>();
        List<Bono> bonos = new ArrayList<>();
        List<Retencion> retenciones = new ArrayList<>();

        bonos.add(new Bono(1l, "vales despensa", 10.0));
        bonos.add(new Bono(2l, "puntualidad y asistencia", 7.5));

        retenciones.add(new Retencion(1l, "ISR", 8.5));
        retenciones.add(new Retencion(2l, "IMSS", 6.5));

        personas.add(new Personal(1l, "claudio", "hdz", "871-000-3012", "claudio@gmail.com", 800, bonos, retenciones));
        personas.add(new Personal(2l, "luis", "hdz", "872-000-3012", "luis@gmail.com", 600, bonos, retenciones));
        personas.add(new Personal(3l, "jose", "hdz", "873-000-3012", "jose@gmail.com", 400, bonos, retenciones));
        personas.add(new Personal(4l, "rosa", "cst", "874-000-3012", "rosa@gmail.com", 500, bonos, retenciones));
        personas.add(new Personal(5l, "ignacio", "hdz", "875-000-3012", "ignacio@gmail.com", 1100, bonos, retenciones));

        return personas;
    }

}
