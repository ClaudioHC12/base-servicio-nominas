package com.base_servicio_nominas.model.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bono implements Serializable {
    private Long idBono;
    private String nombre;
    private Double porcentaje;
}
