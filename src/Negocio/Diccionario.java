/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Palabra;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import ufps.util.varios.ArchivoLeerURL;
import util.ufps.colecciones_seed.VectorGenerico;

/**
 * 
 * @author Jurgenmolina <jurgenmolina29@gmail.com> - 1151987
 * @author Daniel Omar Tijaro  -  Codigo: 1151859
 */
public class Diccionario {
    
    private String urlDiccionario;
    private VectorGenerico<Palabra> palabras;
    
    /**
     * Constructor vacio
     */
    
    public Diccionario() {
    }
    
    /**
     * Carga las palabras de la URL.
     * @param urlDiccionario 
     */
    public void cargar(String urlDiccionario) {
        ArchivoLeerURL archivo=new ArchivoLeerURL("https://raw.githubusercontent.com/javierarce/palabras/master/listado-general.txt");
        Object datos[]=archivo.leerArchivo();
        //Crear los espacios:
        this.palabras=new VectorGenerico<>(datos.length);
        //índice del arreglo
        for (Object dato : datos) {
            this.palabras.add(new Palabra(dato.toString()));
            //System.out.println("se agrego una palabra" + i);
        }
    }
    /**
     * Completado
     * @param palabra_A_buscar
     * @return 
     */
    
    public boolean buscarPalabra(String palabra_A_buscar) throws Exception
    {
        if(palabra_A_buscar.isEmpty())
            throw new Exception("No se puede realizar la búsqueda patrón o matriz vacías");
        
     //Debe convertir la palabra_A_buscar a un objeto palabra:
        Palabra myPalabra_A_buscar = new Palabra(palabra_A_buscar);
        //boolean aux;
            try {
                for (int i = 0; i < palabras.length(); i++) {
                    
                    if (this.palabras.get(i).compareTo(myPalabra_A_buscar) == 1) {
                        return true;
                    }
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Diccionario vacio");
            }
        return false;
    }
    
    /**
     * Completado
     * @param patron
     * @param patron_Nuevo
     * @return 
     * @throws java.lang.Exception 
     */
    
    public int buscarPatron(String patron, String patron_Nuevo) throws Exception {
        
         if(patron.isEmpty() || patron_Nuevo.isEmpty())
            throw new Exception("No se puede realizar la búsqueda patrón o matriz vacías");
        
        //Debe convertir el patrón a una palabra:
        Palabra myPatron=new Palabra(patron);
        Palabra myPatron_Nuevo=new Palabra(patron_Nuevo);
        
        int numeroCambios = 0;
        for (int i = 0; i < palabras.length(); i++) {
        for (int j = 0; this.palabras.get(i).getCaracteres().length() - j >= myPatron.getCaracteres().length(); j++) {

            int iterador = 0;
            boolean igual = true;
            if (this.palabras.get(i).getCaracteres().get(j).charValue() == myPatron.getCaracteres().get(iterador).charValue()) {
                int contador = j;
                while ( iterador != myPatron.getCaracteres().length() && igual) {
                    igual = (this.palabras.get(i).getCaracteres().get(contador).charValue() == myPatron.getCaracteres().get(iterador).charValue());
                    contador++;
                    iterador++;
                }
                if (igual) {
                    if (myPatron.getCaracteres().length() == myPatron_Nuevo.getCaracteres().length()) {
                        int contador2 = j;
                        for (int y = 0; y !=  myPatron.getCaracteres().length()&& contador2 != contador; y++) {
                            this.palabras.get(i).getCaracteres().set(contador2, myPatron_Nuevo.getCaracteres().get(y));
                            contador2++;
                            numeroCambios++;
                        }
                    } else {
                        VectorGenerico<Character> nuevo = new VectorGenerico(myPatron_Nuevo.getCaracteres().length()
                                - myPatron.getCaracteres().length() + this.palabras.get(i).getCaracteres().length());
                        int z = 0;
                        while (z != i) {
                            nuevo.set(z, this.palabras.get(i).getCaracteres().get(z));
                            z++;
                        }
                        for (int h = 0; h != myPatron_Nuevo.getCaracteres().length(); h++) {
                            nuevo.set(z, myPatron_Nuevo.getCaracteres().get(h));
                            z++;
                        }
                        while (nuevo.length() > z && contador <= this.palabras.get(i).getCaracteres().length()) {
                            
                            nuevo.set(z, this.palabras.get(i).getCaracteres().get(contador));
                            contador++;
                            z++;
                        }
                        this.palabras.get(i).setCaracteres(nuevo);
                        numeroCambios++;
                        }
                    }
                }
            }
        }
        return numeroCambios;
        
    }
    
    
    /**
     *  Retorna la información del diccionario
     * @return una cadena con la información del diccionario
     */
    public String getImprimir()
    {
        String msg = "";
        for (int i = 0; i < this.palabras.length(); i++) {
            msg += this.palabras.get(i).toString() + "\n";
        }
        return msg;
    }
    
    /**
     * 
     * @param cantidadPalabras
     * @throws FileNotFoundException
     * @throws DocumentException 
     */
    
    public void crearPDF(int cantidadPalabras) throws FileNotFoundException, DocumentException{
        if(cantidadPalabras <= this.palabras.length()){
            Document documento = new Document();
        
            FileOutputStream ficheroPDF = new FileOutputStream("src\\pdf\\diccionario.pdf");

            PdfWriter.getInstance(documento, ficheroPDF);

            documento.open();

            Paragraph titulo = new Paragraph("PDF creado con "+ cantidadPalabras + " palabras \n\n", FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK));

            documento.add(titulo);

            PdfPTable table = new PdfPTable(1);
            table.addCell("");

            for (int i = 0; i < cantidadPalabras; i++) {
                table.addCell(this.palabras.get(i).toString().toUpperCase());
            }

            documento.add(table);


            documento.close();
        }else{
            JOptionPane.showMessageDialog(null, "No hay tantas palabras");
        }
        
    }
    
    
}
