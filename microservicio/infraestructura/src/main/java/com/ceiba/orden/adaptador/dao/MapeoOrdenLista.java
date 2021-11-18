package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.orden.modelo.dto.DtoOrden;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ceiba.orden.adaptador.dao.MapeoOrden.mapearOrden;

public class MapeoOrdenLista implements RowMapper<DtoOrden>, MapperResult {

    @Override
    public DtoOrden mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return mapearOrden(resultSet, this);
    }
}
