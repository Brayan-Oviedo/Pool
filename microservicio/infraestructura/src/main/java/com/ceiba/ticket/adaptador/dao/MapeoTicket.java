package com.ceiba.ticket.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTicket implements ResultSetExtractor<DtoTicket>, MapperResult {


    @Override
    public DtoTicket extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        DtoTicket ticket = null;

        if(resultSet.next()) {
            var id = resultSet.getLong("id");
            var costoTotal = resultSet.getFloat("costo_total");
            var fechaVencimiento = extraerLocalDateTime(resultSet, "fecha_vencimiento");

            ticket = new DtoTicket(id, costoTotal, fechaVencimiento);
        }

        return ticket;
    }
}
