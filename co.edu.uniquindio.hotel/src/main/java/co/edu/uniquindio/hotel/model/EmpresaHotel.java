package co.edu.uniquindio.hotel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.hotel.Factory.ModelFactory;
import co.edu.uniquindio.hotel.Services.IClienteCrud;
import co.edu.uniquindio.hotel.Services.IHabitacionCrud;
import co.edu.uniquindio.hotel.Services.IReservaCrud;
import co.edu.uniquindio.hotel.Services.IServicioCrud;

public class EmpresaHotel implements IClienteCrud, IHabitacionCrud, IReservaCrud, IServicioCrud {
    private String nombre;
    private ArrayList<Reserva> listaReservas=new ArrayList<>();
    private ArrayList<Habitacion>listaHabitaciones=new ArrayList<>();
    private ArrayList<Cliente>listaClientes=new ArrayList<>();
    private ArrayList<Cliente> clientesMayores = new ArrayList<>();
    private List<Servicio> listaServicios = new ArrayList<>();
    private ArrayList<ServicioHabitacion>listaServiciosHabitacion=new ArrayList<>();

    public EmpresaHotel(String nombre) {
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<ServicioHabitacion> getListaServiciosHabitacion() {
        return listaServiciosHabitacion;
    }

    public void setListaServiciosHabitacion(ArrayList<ServicioHabitacion> listaServiciosHabitacion) {
        this.listaServiciosHabitacion = listaServiciosHabitacion;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    

    public ArrayList<Cliente> getClientesMayores() {
        return clientesMayores;
    }

    public void setClientesMayores(ArrayList<Cliente> clientesMayores) {
        this.clientesMayores = clientesMayores;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public void agregarServicio(ServicioHabitacion servicioHabitacion, Habitacion habitacion) {
    habitacion.agregarServicio(servicioHabitacion);
    getListaServiciosHabitacion().add(servicioHabitacion);
    System.out.println("Servicio agregado a la habitación " + habitacion.getNumero() + ": " + servicioHabitacion.getNombre() + " ($" + servicioHabitacion.getPrecio() + ")");
    }
    public void solicitarServicio(ServicioHabitacion servicioHabitacion, Habitacion habitacion) {
    habitacion.agregarServicio(servicioHabitacion);
    System.out.println(nombre + " ha solicitado el servicio: " + servicioHabitacion.getNombre());
    }

    public double calcularGastoTotal() {
    double total = 0;
    for (Reserva reserva : listaReservas) {
        total += reserva.calcularCostoTotal();
    }
    return total;
    }

    public int contarReservasCliente(Cliente cliente) {
    int contador = 0;
    for (Reserva reserva : listaReservas) {
        if (reserva.getClienteAsociado().equals(cliente)) {
            contador++;
        }
    }
    return contador;
    
    }
    public List<String> obtenerClientesMayores() {
    List<String> clientesMayores = new ArrayList<>();

    for (Cliente cliente : listaClientes) {
        try {
            int edad = Integer.parseInt(cliente.getEdad()); 
            if (edad >= 18) {
                clientesMayores.add(cliente.getNombre()); 
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir la edad del cliente " + cliente.getNombre());
        }
    }

    return clientesMayores;
    }
    
    public void estadoHabitaciones() {
    int habitacionesDisponibles = 0;
    int habitacionesOcupadas = 0;
    List<String> habitacionesOcupadasDetalles = new ArrayList<>();

    for (Habitacion habitacion : listaHabitaciones) {
        if (habitacion.isOcupada()) {
            habitacionesOcupadas++;
            habitacionesOcupadasDetalles.add("Habitación " + habitacion.getNumero() + " ocupada por " + habitacion.getCliente().getNombre());
        } else {
            habitacionesDisponibles++;
        }
    }

    System.out.println("Habitaciones disponibles: " + habitacionesDisponibles);
    System.out.println("Habitaciones ocupadas: " + habitacionesOcupadas);
    for (String detalle : habitacionesOcupadasDetalles) {
        System.out.println(detalle);
    }
    }



    //CRUD Cliente
    @Override
    public boolean crearCliente(String nombre, String identificacion, String edad) {
        Cliente ClienteExistente = buscarCliente(identificacion);
    
        if (ClienteExistente != null) {
            Cliente cliente=new Cliente();
            cliente.setNombre(nombre);
            cliente.setIdentificacion(identificacion);
            cliente.setEdad(edad);
            getListaClientes().add(cliente);
            return true;
        }else{
            return false;
        }   
    }

    @Override
    public boolean actualizarCliente(String nombre, String identificacion,String edad) {
        Cliente cliente=buscarCliente(identificacion);
        if(cliente!=null){
            cliente.setNombre(nombre);
            return true;
        }

        return false;
    }

    @Override
    public boolean eliminarCliente(String identificacion) {
        Cliente clienteExistente = buscarCliente(identificacion);
        if (clienteExistente != null) {
            getListaClientes().remove(clienteExistente);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Cliente buscarCliente(String identificacion) {
        Cliente clienteExistente = null;
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                clienteExistente = cliente;
                break;
            }
        }
        return clienteExistente;
    }

    //CRUD Habitacion
    @Override
    public boolean crearHabitacion(String numero, TipoHabitacion tipoHabitacion, double precio) {
        Habitacion habitacionExistente = buscarHabitacion(numero);

    if (habitacionExistente == null) {
        Habitacion habitacion = new Habitacion();
        habitacion.setNumero(numero);
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setPrecio(precio);
        getListaHabitaciones().add(habitacion);
        return true;
    } else {
        return false;
    }
    }

    @Override
    public boolean actualizarHabitacion(String numero, TipoHabitacion tipoHabitacion, double precio) {
        Habitacion habitacion = buscarHabitacion(numero);
    if (habitacion != null) {
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setPrecio(precio);
        return true;
    }

    return false;
    }

    @Override
    public boolean eliminarHabitacion(String numero) {
        Habitacion habitacionExistente = buscarHabitacion(numero);
    if (habitacionExistente != null) {
        getListaHabitaciones().remove(habitacionExistente);
        return true;
    } else {
        return false;
    }
    }

    @Override
    public Habitacion buscarHabitacion(String numero) {
        Habitacion habitacionExistente = null;
    for (Habitacion habitacion : getListaHabitaciones()) {
        if (habitacion.getNumero().equals(numero)) {
            habitacionExistente = habitacion;
            break;
        }
    }
    return habitacionExistente;
    }
    

    //CRUD Reserva
    @Override
    public boolean crearReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Habitacion habitacion) {
        Reserva reservaExistente = buscarReserva(cliente);
        if (reservaExistente == null) {
            Reserva reserva = new Reserva();
            reserva.setFechaEntrada(fechaInicio);
            reserva.setFechaSalida(fechaFin);
            reserva.setClienteAsociado(cliente);
            reserva.setHabitacionAsociada(habitacion);
            getListaReservas().add(reserva);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean actualizarReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Habitacion habitacion) {
        Reserva reserva = buscarReserva(cliente);
        if (reserva != null) {
            reserva.setFechaEntrada(fechaInicio);
            reserva.setFechaSalida(fechaFin);
            reserva.setClienteAsociado(cliente);
            reserva.setHabitacionAsociada(habitacion);
            return true;
        }
    
        return false;
    }

    @Override
    public boolean eliminarReserva(Cliente cliente) {
        Reserva reservaExistente = buscarReserva(cliente);
        if (reservaExistente != null) {
            getListaReservas().remove(reservaExistente);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Reserva buscarReserva(Cliente cliente) {
        Reserva reservaExistente = null;
        for (Reserva reserva : getListaReservas()) {
            if (reserva.getHabitacionAsociada().equals(cliente)) {
                reservaExistente = reserva;
                break;
            }
        }
        return reservaExistente;
    }
    
    //CRUD Servicio
    @Override
    public boolean crearServicio(String nombre, double precio) {
        Servicio servicioExistente = buscarServicio(nombre);
        if (servicioExistente == null) {
            Servicio servicio = new Servicio();
            servicio.setNombre(nombre);
            servicio.setPrecio(precio);
            getListaServicios().add(servicio);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean actualizarServicio(String nombre, double precio) {
        Servicio servicio = buscarServicio(nombre);
        if (servicio != null) {
            servicio.setNombre(nombre);
            servicio.setPrecio(precio);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarServicio(String nombre) {
        Servicio servicioExistente = buscarServicio(nombre);
        if (servicioExistente != null) {
            getListaServicios().remove(servicioExistente);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Servicio buscarServicio(String nombre) {
        Servicio servicioExistente = null;
        for (Servicio servicio : getListaServicios()) {
            if (servicio.getNombre().equals(nombre)) {
                servicioExistente = servicio;
                break;
            }
        }
        return servicioExistente;
    }
    
    

}


