package co.edu.uniquindio.hotel.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private  LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Cliente clienteAsociado;
    private Habitacion habitacionAsociada;
    private double costoTotal;

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente clienteAsociado,
            Habitacion habitacionAsociada,double costoTotal) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.clienteAsociado = clienteAsociado;
        this.habitacionAsociada = habitacionAsociada;
        this.costoTotal = calcularCostoTotal();
    }

    public Reserva() {
    }
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }
    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }
    public Habitacion getHabitacionAsociada() {
        return habitacionAsociada;
    }
    public void setHabitacionAsociada(Habitacion habitacionAsociada) {
        this.habitacionAsociada = habitacionAsociada;
    }
    public double getCostoTotal() {
        return costoTotal;
    }

    public double calcularCostoTotal() {
        long dias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        return dias * habitacionAsociada.getPrecio();
    }
}
