/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;
import util.ufps.colecciones_seed.VectorGenerico;


/**
 * 
 * @author Jurgenmolina <jurgenmolina29@gmail.com> - 1151987
 * @author Daniel Omar Tijaro  -  Codigo: 1151859
 */

public class Palabra implements Comparable{
    
    private VectorGenerico<Character> caracteres;
    
    /**
     * Constructor palabra vacia
     */
    
    public Palabra() {
        
    }

    /**
     * A partir de la cadena crea el vector genérico
     *  Ejemplo: Cadena="ufps", this.caracteres={"u","f","p","s"}
     * @param cadena un String a ser pasado al vector
     */
    public Palabra(String cadena)
    {
            //Asigno el tamaño a la cadena y lo guardo
            this.caracteres=new VectorGenerico(cadena.length());
            for (int i = 0; i < caracteres.length(); i++) {
                    this.caracteres.add(cadena.charAt(i));
        }
    }
    /**
     * Obtiene los caracteres
     * @return 
     */
    public VectorGenerico<Character> getCaracteres() {
        return caracteres;
    }
    /**
     * Actualizar los caracteres
     * @param caracteres 
     */
    public void setCaracteres(VectorGenerico<Character> caracteres) {
        this.caracteres = caracteres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.caracteres);
        return hash;
    }
    
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        
        final Palabra other = (Palabra) obj;
        
        boolean confirmar = false;
        int validate = 0;
        if(this.caracteres.length() != other.getCaracteres().length()){
            confirmar = false;
            }else{
                for (int i = 0; i < this.caracteres.length(); i++) {
                if(this.caracteres.get(i).equals(other.getCaracteres().get(i))){
                    validate++;
                    if (validate == caracteres.length()) {
                        confirmar = true;
                    }
                }
            }
        }
        
        return confirmar;
    }
    
    /**
     * 
     * @param arg0
     * @return 
     */
    @Override
    public int compareTo(Object arg0) {
        
        final Palabra other = (Palabra) arg0;
        int num = 0;
        int validate = 0;
        if(this.caracteres.length() != other.getCaracteres().length()){
            num = -1;
            }else{
                for (int i = 0; i < this.caracteres.length(); i++) {
                if(this.caracteres.get(i).equals(other.getCaracteres().get(i))){
                    validate++;
                    if (validate == caracteres.length()) {
                        num = 1;
                    }
                }
            }
        }
        
        
        return num;
    }
    
    /**
     * Retorno una cadena de caracteres
     * @return 
     */
    @Override
    public String toString() {
        return "" + this.caracteres;
    }
    
    
    
    
    
    
    
}
