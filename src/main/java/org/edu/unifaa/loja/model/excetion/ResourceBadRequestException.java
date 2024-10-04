package org.edu.unifaa.loja.model.excetion;

public class ResourceBadRequestException extends RuntimeException {
    
    public ResourceBadRequestException(String mensagem){
        super(mensagem);
    }
}
