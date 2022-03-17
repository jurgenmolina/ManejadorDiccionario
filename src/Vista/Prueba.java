/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Negocio.Diccionario;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;


/**
 *
 * @author madarme
 */
public class Prueba {
    
    public static void main(String[] args) throws FileNotFoundException, DocumentException, Exception {
        Diccionario diccionario=new Diccionario();
        diccionario.cargar("https://raw.githubusercontent.com/javierarce/palabras/master/listado-general.txt");
        //System.out.println(diccionario.getImprimir());
        //System.out.println(diccionario.buscarPalabra("aba"));
        System.out.println(diccionario.buscarPatron("abxxxxxurxxar", "uwu"));
        
        //System.out.println(diccionario.getImprimir());
        //diccionario.crearPDF(40);
        
    }
    
}
