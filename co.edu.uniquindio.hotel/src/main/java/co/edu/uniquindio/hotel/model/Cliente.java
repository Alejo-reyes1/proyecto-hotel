package co.edu.uniquindio.hotel.model;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String edad;
    private ArrayList<Reserva> listaReservasAsociadas = new ArrayList<>();

    public Cliente(String nombre, String identificacion,String edad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
    }

    public Cliente(){
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public ArrayList<Reserva> getListaReservasAsociadas() {
        return listaReservasAsociadas;
    }

    public void setListaReservasAsociadas(ArrayList<Reserva> listaReservasAsociadas) {
        this.listaReservasAsociadas = listaReservasAsociadas;
    }

    public String getNombre() {
        return nombre;
    }
    public String getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
}
