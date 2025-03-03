package co.edu.uniquindio.hotel.model;

public class ServicioHabitacion extends Servicio {
    
    private Habitacion habitacionasociada;
    private String Descipcion;

    public ServicioHabitacion(String numero,String nombre, double precio, Habitacion habitacionasociada, String Descipcion) {
        super(nombre, precio);
        
        this.habitacionasociada = habitacionasociada;
        this.Descipcion = Descipcion;
    }

    public Habitacion getHabitacionasociada() {
        return habitacionasociada;
    }

    public void setHabitacionasociada(Habitacion habitacionasociada) {
        this.habitacionasociada = habitacionasociada;
    }

    public String getDescipcion() {
        return Descipcion;
    }

    public void setDescipcion(String descipcion) {
        Descipcion = descipcion;
    }
    

    



    
}
