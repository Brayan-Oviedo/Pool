package com.ceiba.orden.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.orden.modelo.dto.DtoOrden;
import com.ceiba.orden.puerto.dao.DaoOrden;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoOrdenMysql implements DaoOrden {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "orden", value = "obtenerPorId")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace = "orden", value = "listarPorCliente")
    private static String sqlListarPorCliente;


    public DaoOrdenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoOrden> listarPorCliente(String identificacion) {
        var paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorCliente, paramSource, new MapeoOrdenLista());
    }

    @Override
    public DtoOrden obtenerPorId(Long id) {
        var paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorId, paramSource, new MapeoOrden());
    }
}
