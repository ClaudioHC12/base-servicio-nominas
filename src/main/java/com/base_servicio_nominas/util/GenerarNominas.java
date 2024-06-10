package com.base_servicio_nominas.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.base_servicio_nominas.model.entity.Bono;
import com.base_servicio_nominas.model.entity.Nomina;
import com.base_servicio_nominas.model.entity.Personal;
import com.base_servicio_nominas.model.entity.Retencion;

@Service
public class GenerarNominas {

    // Funcion generar lista de nominas
    public List<Nomina> getNominas(List<Personal> personas) {
        List<Nomina> nominas = new ArrayList<>();
        Long contador = 1L;
        for (Personal persona : personas) {
            Long idNomina = contador;
            Long idPersonal = persona.getIdPersonal();
            Integer salarioDiario = persona.getSalarioDiario();
            Double totalBonos = calcularBonos(persona.getBonos(), salarioDiario);
            Double totalRetenciones = calcularRetenciones(persona.getRetenciones(), salarioDiario);
            Double sueldoSemanalBruto = calcularSalarioBruto(salarioDiario);
            Double sueldoSemanalLibre = calcularSalarioLibre(sueldoSemanalBruto, totalRetenciones, totalBonos);
            LocalDate fechaActual = LocalDate.now();
            nominas.add(new Nomina(idNomina, idPersonal, salarioDiario, totalBonos, totalRetenciones,
                    sueldoSemanalBruto, sueldoSemanalLibre, fechaActual));
            contador++;
        }
        return nominas;
    }

    // Funcion calcular retenciones totales
    public Double calcularRetenciones(List<Retencion> retenciones, Integer salarioDiario) {
        Double totalRetenciones = 0.0;
        Double porcentajeTotal = 0.0;
        for (int i = 0; i < retenciones.size(); i++) {
            porcentajeTotal += retenciones.get(i).getPorcentaje();
        }
        totalRetenciones = ((salarioDiario * 7) * porcentajeTotal / 100);
        return totalRetenciones;
    }

    // Función para calcular los bonos totales
    public Double calcularBonos(List<Bono> bonos, Integer salarioDiario) {
        double porcentajeTotal = bonos.stream()
                .mapToDouble(Bono::getPorcentaje)
                .sum();
        return (salarioDiario * 7 * porcentajeTotal / 100);
    }

    // Funcion calcular salario bruto
    public Double calcularSalarioBruto(Integer salarioDiario) {
        return Double.valueOf(salarioDiario * 7);
    }

    // Funcion calcular salario libre
    public Double calcularSalarioLibre(Double salarioBruto, Double retenciones, Double bonos) {
        return (salarioBruto - retenciones + bonos);
    }
}
