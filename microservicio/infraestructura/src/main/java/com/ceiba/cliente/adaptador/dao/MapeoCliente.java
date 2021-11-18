package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements ResultSetExtractor<DtoCliente>, MapperResult {

    @Override
    public DtoCliente extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        DtoCliente cliente = null;

        if(resultSet.next()) {
            var identificacion = resultSet.getString("identificacion");
            var fechaNacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");

            cliente = new DtoCliente(identificacion, fechaNacimiento);
        }

        return cliente;
    }
}
