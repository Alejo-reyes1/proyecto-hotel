package co.edu.uniquindio.hotel.Factory;

import java.time.LocalDate;

import co.edu.uniquindio.hotel.Services.IClienteCrud;
import co.edu.uniquindio.hotel.Services.IHabitacionCrud;
import co.edu.uniquindio.hotel.Services.IReservaCrud;
import co.edu.uniquindio.hotel.Services.IServicioCrud;
import co.edu.uniquindio.hotel.model.Cliente;
import co.edu.uniquindio.hotel.model.EmpresaHotel;
import co.edu.uniquindio.hotel.model.Habitacion;
import co.edu.uniquindio.hotel.model.Reserva;
import co.edu.uniquindio.hotel.model.Servicio;
import co.edu.uniquindio.hotel.model.TipoHabitacion;

public class ModelFactory implements IClienteCrud,IHabitacionCrud, IReservaCrud, IServicioCrud{
    private static ModelFactory modelFactory;
    private EmpresaHotel empresaHotel;

    private ModelFactory() {
        inicializarDatos();
    }

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    public void inicializarDatos() {
        empresaHotel = new EmpresaHotel("Hotel");

    }

    //metodos que creamos
    public double calcularGastoTotalCliente(String identificacion) {
        return empresaHotel.calcularGastoTotalCliente(identificacion);
    }

    public int contarReservasCliente(Cliente cliente) {
        return empresaHotel.contarReservasCliente(cliente);
    }

    public String generarFactura(String identificacion) {
        return empresaHotel.generarFactura(identificacion);
    }
    

    //overrides de Cruds
    @Override
    public boolean crearCliente(String nombre, String identificacion, String edad) {
        return empresaHotel.crearCliente(nombre, identificacion, edad);
    }
    @Override
    public boolean actualizarCliente(String nombre, String identificacion, String edad) {
        return empresaHotel.actualizarCliente(nombre, identificacion, edad);
    }
    @Override
    public boolean eliminarCliente(String identificacion) {
        return empresaHotel.eliminarCliente(identificacion);
    }
    @Override
    public Cliente buscarCliente(String identificacion) {
        return empresaHotel.buscarCliente(identificacion);
    }

    @Override
    public boolean crearServicio(String nombre, double precio) {
        return empresaHotel.crearServicio(nombre, precio);
    }

    @Override
    public boolean actualizarServicio(String nombre, double precio) {
        return empresaHotel.actualizarServicio(nombre, precio);
    }

    @Override
    public boolean eliminarServicio(String nombre) {
        return empresaHotel.eliminarServicio(nombre);
    }

    @Override
    public Servicio buscarServicio(String nombre) {
        return empresaHotel.buscarServicio(nombre);
    }

    @Override
    public boolean crearReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Habitacion habitacion) {
        return empresaHotel.crearReserva(fechaInicio, fechaFin, cliente, habitacion);
    }

    @Override
    public boolean actualizarReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente,
            Habitacion habitacion) {
        return empresaHotel.actualizarReserva(fechaInicio, fechaFin, cliente, habitacion);
    }

    @Override
    public boolean eliminarReserva(Cliente Cliente) {
        return empresaHotel.eliminarReserva(Cliente);
    }

    @Override
    public Reserva buscarReserva(Cliente Cliente) {
        return empresaHotel.buscarReserva(Cliente);
    }

    @Override
    public boolean crearHabitacion(String numero, TipoHabitacion tipoHabitacion, double precio) {
        return empresaHotel.crearHabitacion(numero, tipoHabitacion, precio);
    }

    @Override
    public boolean actualizarHabitacion(String numero, TipoHabitacion tipoHabitacion, double precio) {
        return empresaHotel.actualizarHabitacion(numero, tipoHabitacion, precio);
    }

    @Override
    public boolean eliminarHabitacion(String numero) {
        return empresaHotel.eliminarHabitacion(numero);
    }

    @Override
    public Habitacion buscarHabitacion(String numero) {
        return empresaHotel.buscarHabitacion(numero);
    }


}
