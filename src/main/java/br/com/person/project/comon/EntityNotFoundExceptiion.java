package br.com.person.project.comon;

public class EntityNotFoundExceptiion extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundExceptiion(String message){
        super(message);
    }
}
