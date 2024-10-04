package org.edu.unifaa.loja.model.excetion;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
}
