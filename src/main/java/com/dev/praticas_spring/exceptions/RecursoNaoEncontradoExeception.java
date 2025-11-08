package com.dev.praticas_spring.exceptions;


public class RecursoNaoEncontradoExeception extends RuntimeException{

    public RecursoNaoEncontradoExeception(String mensagem){
        super(mensagem);
    }
}
