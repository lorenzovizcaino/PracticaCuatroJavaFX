package com.example.practicacuatrojavafx;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String apellidos;
    private String nif;
    private String codigoPostal;
    private String email;
    private ArrayList<Modulo> modulos;

    public Alumno() {
        nombre=new String();
        apellidos=new String();
        nif=new String();
        codigoPostal=new String();
        modulos=new ArrayList<>();
    }

    public Alumno(String nombre, String apellidos, String nif, String codigoPostal, String email, ArrayList<Modulo> modulos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.modulos = modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }


@Override
    public String toString() {
        String cadenaModulos="";
        for (Modulo m:modulos) {

            cadenaModulos+="  -"+m.getNombre()+"\n\tHoras: "+String.valueOf(m.getHoras())+"\n";
        }
        return "Nombre: " + nombre + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "NIF: " + nif + "\n" +
                "Codigo Postal: " + codigoPostal + "\n" +
                "Email: " + email + "\n" +
                "Modulos matriculados: " + "\n" +
                cadenaModulos;
    }
}
