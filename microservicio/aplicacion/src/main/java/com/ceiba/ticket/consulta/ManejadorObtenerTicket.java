package com.ceiba.ticket.consulta;

import com.ceiba.ticket.modelo.dto.DtoTicket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerTicket {

    private final DaoTicket daoTicket;

    public ManejadorObtenerTicket(DaoTicket daoTicket) {
        this.daoTicket = daoTicket;
    }

    public DtoTicket ejecutar(Long id) {
        return this.daoTicket.obtenerPorId(id);
    }
}
