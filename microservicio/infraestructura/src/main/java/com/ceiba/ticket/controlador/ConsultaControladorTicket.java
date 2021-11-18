package com.ceiba.ticket.controlador;

import com.ceiba.ticket.consulta.ManejadorObtenerTicket;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketes")
@Api(tags = "Controlador consulta ticket")
public class ConsultaControladorTicket {

    private final ManejadorObtenerTicket manejadorObtenerTicket;

    public ConsultaControladorTicket(ManejadorObtenerTicket manejadorObtenerTicket) {
        this.manejadorObtenerTicket = manejadorObtenerTicket;
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Obtener Ticket")
    public DtoTicket obtener(@PathVariable Long id) {
        return manejadorObtenerTicket.ejecutar(id);
    }
}
