package co.edu.uniquindio.hotel.Services;

import co.edu.uniquindio.hotel.model.Habitacion;
import co.edu.uniquindio.hotel.model.TipoHabitacion;

public interface IHabitacionCrud {
    boolean crearHabitacion(String numero, TipoHabitacion tipoHabitacion , double precio);
    boolean actualizarHabitacion(String numero, TipoHabitacion tipoHabitacion, double precio);
    boolean eliminarHabitacion(String numero);
    Habitacion buscarHabitacion(String numero);
}
