/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ufps.util.varios.ArchivoLeerURL;

/**
 *
 * @author madar
 */
public class PruebaLeerURL_Palabra {
    
    public static void main(String[] args) {
        ArchivoLeerURL archivo=new ArchivoLeerURL("https://raw.githubusercontent.com/javierarce/palabras/master/listado-general.txt");
        Object datos[]=archivo.leerArchivo();
        int i=0;
        for(Object fila:datos)
        {
            System.out.println("Fila["+(i++)+"]:"+fila.toString());
        }
    }
}
