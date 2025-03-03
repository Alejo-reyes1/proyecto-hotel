package co.edu.uniquindio.hotel.model;

import java.util.ArrayList;

public class Habitacion {
    private String numero;
    private TipoHabitacion tipoHabitacion;
    private double precio;
    private Reserva reservaAsociada;
    private ArrayList<ServicioHabitacion> listaServiciosAsociados;
    private ArrayList<ServicioHabitacion> serviciosHabitacion;
    private boolean ocupada;
    private Cliente cliente;
    


    public Habitacion(String numero, TipoHabitacion tipoHabitacion, double precio, Reserva reservaAsociada) {
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.listaServiciosAsociados = new ArrayList<>();
        this.serviciosHabitacion = new ArrayList<>();
        this.ocupada = false;
        this.cliente = null;
    }

    public Habitacion() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
     public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reserva getReservaAsociada() {
        return reservaAsociada;
    }
    

    public void setReservaAsociada(Reserva reservaAsociada) {
        this.reservaAsociada = reservaAsociada;
    }

    public ArrayList<ServicioHabitacion> getListaServiciosAsociados() {
        return listaServiciosAsociados;
    }

    public void setListaServiciosAsociados(ArrayList<ServicioHabitacion> listaServiciosAsociados) {
        this.listaServiciosAsociados = listaServiciosAsociados;
    }
    public void crearServicio(ServicioHabitacion servicioHabitacion) {
        serviciosHabitacion.add(servicioHabitacion);
    }
    public void agregarServicio(ServicioHabitacion servicioHabitacion) {
        serviciosHabitacion.add(servicioHabitacion);
    }

	public void set(String tipo) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'set'");
	}

    
    
}
