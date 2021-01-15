/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.reservas;

/**
 *
 * @author HOME
 */
public class Hotel {
    private String Nombre;
    private String Ciudad ;
    private String Direccion;
    private String Telefono;

    public Hotel(String Nombre, String Ciudad, String Direccion, String Telefono) {
        this.Nombre = Nombre;
        this.Ciudad = Ciudad;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }
    
}
