package ru.netology.exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
