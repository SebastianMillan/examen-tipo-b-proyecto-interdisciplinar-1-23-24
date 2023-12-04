package com.salesianostriana.dam.rest.ticket.exception;

public class TicketListEmptyException extends RuntimeException{
    public TicketListEmptyException(){
        super("Lista de tickets vacia");
    }
}
