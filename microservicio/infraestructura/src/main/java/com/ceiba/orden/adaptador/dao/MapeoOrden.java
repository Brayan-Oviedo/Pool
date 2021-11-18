package com.ceiba.orden.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.orden.modelo.dto.DtoOrden;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoOrden implements ResultSetExtractor<DtoOrden>, MapperResult {

    @Override
    public DtoOrden extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        DtoOrden orden = null;
        if(resultSet.next()) {
            orden = mapearOrden(resultSet, this);
        }

        return orden;
    }

    public static DtoOrden mapearOrden(ResultSet resultSet, MapperResult mapperResult) throws SQLException {
        var id = resultSet.getLong("id");
        var tiempoExtra = resultSet.getInt("tiempo_extra");

        // Ticket
        var ticketId = resultSet.getLong("ticket_id");
        var costoTotal = resultSet.getFloat("costo_total");
        var fechaVencimiento = mapperResult.extraerLocalDateTime(resultSet, "fecha_vencimiento");

        // Cliente
        var identificacion = resultSet.getString("cliente_identificacion");
        var fechaNacimiento = mapperResult.extraerLocalDate(resultSet, "fecha_nacimiento");


        var ticket = new DtoTicket(ticketId, costoTotal, fechaVencimiento);
        var cliente = new DtoCliente(identificacion, fechaNacimiento);

        return new DtoOrden(id, tiempoExtra, ticket, cliente);
    }
}
