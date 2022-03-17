/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Diccionario;
import Vista.CargarPalabras;

/**
 * 
 * @author Jurgenmolina <jurgenmolina29@gmail.com> - 1151987
 * @author Daniel Omar Tijaro  -  Codigo: 1151859
 */
public class Main {

    public static void main(String[] args) {
       Diccionario diccionario = new Diccionario();
       CargarPalabras cargar = new CargarPalabras(diccionario);
       cargar.setVisible(true);
    }
    
    
}
