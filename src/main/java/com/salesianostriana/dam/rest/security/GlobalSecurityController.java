package com.salesianostriana.dam.rest.security;

import com.salesianostriana.dam.rest.ticket.exception.TicketListEmptyException;
import com.salesianostriana.dam.rest.ticket.exception.TicketNotFoundException;
import com.salesianostriana.dam.rest.user.exception.NotVerifyPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalSecurityController{

    @ExceptionHandler({NotVerifyPasswordException.class})
    public ErrorResponse notVerifyPassword (NotVerifyPasswordException exception){
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, exception.getMessage())
                .title("Contraseña duplicada incorrecta")
                .type(URI.create("localhost:8080/miapi"))
                .property("timestamp", Instant.now())
                .build();

    }

    @ExceptionHandler({TicketListEmptyException.class})
    public ErrorResponse ticketListEmpty (TicketListEmptyException exception){
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, exception.getMessage())
                .title("Lista vacia")
                .type(URI.create("localhost:8080/miapi"))
                .property("timestamp", Instant.now())
                .build();

    }

    @ExceptionHandler({TicketNotFoundException.class})
    public ErrorResponse ticketNotFound (TicketNotFoundException exception){
        return ErrorResponse.builder(exception, HttpStatus.NOT_FOUND, exception.getMessage())
                .title("Ticket no encontrado")
                .type(URI.create("localhost:8080/miapi"))
                .property("timestamp", Instant.now())
                .build();

    }
}
