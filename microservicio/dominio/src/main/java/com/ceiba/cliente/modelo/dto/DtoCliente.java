package com.ceiba.cliente.modelo.dto;


import com.ceiba.orden.modelo.dto.DtoOrden;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class DtoCliente {

    private String identificacion;
    private LocalDate fechaNacimiento;
}
