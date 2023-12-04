package com.salesianostriana.dam.rest.user.exception;

public class NotVerifyPasswordException extends RuntimeException{
    public NotVerifyPasswordException(){
        super("Las contraseñas no coinciden");
    }
}
