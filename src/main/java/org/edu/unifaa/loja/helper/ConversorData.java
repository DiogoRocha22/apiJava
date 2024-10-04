package org.edu.unifaa.loja.helper;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ConversorData {

    public static String converteDateParaDataEHora(Date data) {
    
        return new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(data);
    }
}
