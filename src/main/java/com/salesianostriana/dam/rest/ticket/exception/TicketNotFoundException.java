package com.salesianostriana.dam.rest.ticket.exception;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;

public class TicketNotFoundException extends EntityNotFoundException {

    public TicketNotFoundException(){
        super("Ticket no encontrado");
    }

    public TicketNotFoundException(Long id){
        super("Ticket con el id "+id+" no encontrado");
    }
}
