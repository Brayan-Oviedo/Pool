package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorObtenerCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags = "Controlador consulta cliente")
public class ConsultaControladorCliente {

    private final ManejadorObtenerCliente manejadorObtenerCliente;

    public ConsultaControladorCliente(ManejadorObtenerCliente manejadorObtenerCliente) {
        this.manejadorObtenerCliente = manejadorObtenerCliente;
    }

    @GetMapping(value="/{identificacion}")
    @ApiOperation("Obtener Cliente")
    public DtoCliente obtener(@PathVariable String identificacion) {
        return manejadorObtenerCliente.ejecutar(identificacion);
    }
}
