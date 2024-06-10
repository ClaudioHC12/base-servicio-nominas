package com.base_servicio_nominas.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Nomina implements Serializable{
    private Long idNomina;
    private Long idPersonal;
    private Integer salarioDiario;
    private Double totalBonos;
    private Double totalRetenciones;
    private Double sueldoSemanalBruto;
    private Double sueldoSemanalLibre;
    private LocalDate fecha;
}
