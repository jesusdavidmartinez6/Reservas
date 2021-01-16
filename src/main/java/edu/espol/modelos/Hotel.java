/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.modelos;

/**
 *
 * @author HOME
 */
public class Hotel {
    private String Nombre;
    private String Ciudad ;
    private String Direccion;
    private int Telefono;

    public Hotel(String Nombre, String Ciudad, String Direccion, int Telefono) {
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

    public int getTelefono() {
        return Telefono;
    }
}
