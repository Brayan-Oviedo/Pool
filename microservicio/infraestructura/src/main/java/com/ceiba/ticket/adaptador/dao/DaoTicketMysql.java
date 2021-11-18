package com.ceiba.ticket.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoTicketMysql implements DaoTicket {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "ticket", value = "obtenerPorId")
    private static String sqlObtenerPorId;

    public DaoTicketMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoTicket obtenerPorId(Long id) {
        var paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorId, paramSource, new MapeoTicket());
    }
}
