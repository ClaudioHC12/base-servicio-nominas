package com.base_servicio_nominas.model.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Personal implements Serializable{
    private Long idPersonal;
    private String nombre;
    private String apellidoPaterno;
    private String telefono;
    private String email;
    private Integer salarioDiario;
    private List<Bono> bonos;
    private List<Retencion> retenciones;
}
