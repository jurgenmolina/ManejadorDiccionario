/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.ufps.colecciones_seed;

/**
 *  Está clase es la misma Secuencia en el paquete seed 
 *  https://gitlab.com/estructuras-de-datos/proyecto-seed
 * 
 *  Está clase va a ser símil a la clase ArrayList de la api de java
 
/**
 * 
 * @author Jurgenmolina <jurgenmolina29@gmail.com>
 * @author Daniel Omar Tijaro  -  Codigo: 1151859
 */
public class VectorGenerico<T> {
    
    
    private T vector[];
    private int posActual=0;

    public VectorGenerico() {
    }
    
    
    public VectorGenerico(int capacidad) {
        
        if (capacidad <=0 )
            throw new RuntimeException("No puedo crear vectores nulos o con capacidad negativa");
        //Tips:
        //this.vector=new T[capacidad];
        //Crear un vector de object y parametrizarlo
        this.vector=(T[])new Object[capacidad];
    }
    
    
    
    public void add(T datoNuevo)
    {
         if(this.posActual>=this.vector.length)
             throw new RuntimeException("No hay capacidad para insertar el dato");
           
         this.vector[posActual]=datoNuevo;
         this.posActual++;
        
    }
    
    /**
    
    
    */
    
    public T get(int i)
    {
        if(i<0 || i>=this.vector.length)
            throw new RuntimeException("índice fuera de rango:"+i);
        return (this.vector[i]);
    }
    
           
    public void set(int i, T datoNuevo)
    {
        if(i<0 || i>=this.vector.length)
            throw new RuntimeException("índice fuera de rango:"+i);
        this.vector[i]=datoNuevo;
    }

    @Override
    public String toString() {
        String msg="";
        for (T dato: vector)
            msg+=dato.toString();
        
        return msg;
    }
    
    
    public void clear()
    {
        this.vector=null;
        this.posActual=0;
    }
    
    public int length()
    {
        return this.vector.length;
    }
    
    public int capacity()
    {
        return this.posActual;
    }
    
    public void sort()
    {
     T aux;
       for(int i = 0 ; i < (vector.length - 1) ; i++){
            for (int j = 0; j < (vector.length - 1); j++) {
                
                // T hereda de object
                
                T dato2 = vector[j+1];
                // CompareTo --> Comparable
                int comparador = ((Comparable)(vector[j])).compareTo(dato2); 
                if(comparador == 1){
                    aux = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = aux;
                }
            }
    }
    }
    
    
    
}
