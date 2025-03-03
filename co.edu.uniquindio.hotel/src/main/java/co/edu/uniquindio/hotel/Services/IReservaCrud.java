package co.edu.uniquindio.hotel.Services;

import java.time.LocalDate;

import co.edu.uniquindio.hotel.model.Cliente;
import co.edu.uniquindio.hotel.model.Habitacion;
import co.edu.uniquindio.hotel.model.Reserva;

public interface IReservaCrud {
    boolean crearReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Habitacion habitacion);
    boolean actualizarReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Habitacion habitacion);
    boolean eliminarReserva(Cliente Cliente);
    Reserva buscarReserva(Cliente Cliente);
}
