package co.edu.uniquindio.hotel.Services;

import co.edu.uniquindio.hotel.model.Cliente;

public interface IClienteCrud {
    boolean crearCliente(String nombre, String identificacion, String edad);
    boolean actualizarCliente(String nombre, String identificacion, String edad);
    boolean eliminarCliente(String identificacion);
    Cliente buscarCliente(String identificacion);

}
