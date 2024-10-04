package org.edu.unifaa.loja.handler;

import java.util.Date;

import org.edu.unifaa.loja.helper.ConversorData;
import org.edu.unifaa.loja.model.ErrorResponse;
import org.edu.unifaa.loja.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.loja.model.excetion.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
 
        var dataHora = ConversorData.converteDateParaDataEHora(new Date());
        var resposta = new ErrorResponse(dataHora, 404, "Not Found", ex.getMessage());

        return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResponse> handlerResourceBadRequestException(ResourceBadRequestException ex){
 
        var dataHora = ConversorData.converteDateParaDataEHora(new Date());
        var resposta = new ErrorResponse(dataHora, 400, "Bad Request", ex.getMessage());

        return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception ex){
 
        var dataHora = ConversorData.converteDateParaDataEHora(new Date());
        var resposta = new ErrorResponse(dataHora, 500, "Internal Server Error", ex.getMessage());

        return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
