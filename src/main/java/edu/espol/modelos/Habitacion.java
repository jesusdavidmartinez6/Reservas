/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.modelos;

import edu.espol.reservas.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author famil
 */
public class Habitacion {
    private String nombreHotel;
    private String numeroHabitacion;
    private String precio ;
    private String servicio;
    private String categoria;
    public static ArrayList<Habitacion> habitaciones = new ArrayList<>();
    public static Set<String> hotels = new HashSet<>();//Para que no se repitan 
    public static Set<String> categorias = new HashSet<>();//Para que no se repitan
    

    public Habitacion(String nombreHotel, String numeroHabitacion, String precio, String servicio, String categoria) {
        this.nombreHotel = nombreHotel;
        this.numeroHabitacion = numeroHabitacion;
        this.precio = precio;
        this.servicio = servicio;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "nombreHotel=" + nombreHotel + ", numeroHabitacion=" + numeroHabitacion + ", precio=" + precio + ", servicio=" + servicio + ", categoria=" + categoria + '}';
    }
    
    
    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getServicio() {
        return servicio;
    }

    public String getCategoria() {
        return categoria;
    }

   

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public static void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        Habitacion.habitaciones = habitaciones;
    }
    
    public static void llenarHabitacion(){
        try {
            List<String> datos = Files.readAllLines(Paths.get("src/main/resources/files/Habitacion.txt"));
            for (String linea: datos){
                try{
                    String[]lineaS= linea.split(";");                  
                    habitaciones.add( new Habitacion(lineaS[0], lineaS[1], lineaS[2], lineaS[3], lineaS[4]));
                    hotels.add(lineaS[0]);
                    categorias.add(lineaS[4]);
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.err.println("Linea no valida: "+linea);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
