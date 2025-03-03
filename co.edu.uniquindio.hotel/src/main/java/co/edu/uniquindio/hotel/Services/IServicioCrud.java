package co.edu.uniquindio.hotel.Services;

import co.edu.uniquindio.hotel.model.Servicio;

public interface IServicioCrud {
    boolean crearServicio(String nombre, double precio);
    boolean actualizarServicio(String nombre, double precio);
    boolean eliminarServicio(String nombre);
    Servicio buscarServicio(String nombre);
    
}
