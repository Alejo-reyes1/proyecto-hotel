package co.edu.uniquindio.hotel;

import co.edu.uniquindio.hotel.Factory.ModelFactory;
import co.edu.uniquindio.hotel.model.Cliente;
import co.edu.uniquindio.hotel.model.Habitacion;
import co.edu.uniquindio.hotel.model.Reserva;
import co.edu.uniquindio.hotel.model.Servicio;
import co.edu.uniquindio.hotel.model.TipoHabitacion;

import java.time.LocalDate;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstancia();
        menuHotel(modelFactory);
        crudCliente(modelFactory);
        crudHabitacion(modelFactory);
        crudReserva(modelFactory);
        crudServicio(modelFactory);
    }

    private static void menuHotel(ModelFactory modelFactory) {
        String menuPrincipal = mensajeMenu();
        int opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null, menuPrincipal));
            String mensajeSubMenu = mensajeSubMenu(opcionSeleccionada);
            int opcionSubMenu = Integer.parseInt(JOptionPane.showInputDialog(null, mensajeSubMenu));
            metodosSubMenu(opcionSeleccionada, opcionSubMenu, modelFactory);

        } while (opcionSeleccionada < 8);
    }

    private static void metodosSubMenu(int opcionSelecciona, int opcionSubMenu, ModelFactory modelFactory) {
        switch (opcionSelecciona) {
            case 1:
                metodosCliente(opcionSubMenu, modelFactory);
                break;
            case 2:
                metodosReserva(opcionSubMenu, modelFactory);
                break;
            case 3:
                metodosHabitacion(opcionSubMenu, modelFactory);
                break;
            case 4:
                metodosServicio(opcionSubMenu, modelFactory);
                break;
        }
    }

    private static void metodosServicio(int opcionSubMenu, ModelFactory modelFactory) {
        switch (opcionSubMenu) {
            case 1:
                crearServicio(modelFactory);
                break;
            case 2:
                eliminarServicio(modelFactory);
                break;
            case 3:
                actualizarServicio(modelFactory);
                break;
            case 4:
                buscarServicio(modelFactory);
                break;
        }
    }

    private static void metodosHabitacion(int opcionSubMenu, ModelFactory modelFactory) {
        switch (opcionSubMenu) {
            case 1:
                crearHabitacion(modelFactory);
                break;
            case 2:
                eliminarHabitacion(modelFactory);
                break;
            case 3:
                actualizarHabitacion(modelFactory);
                break;
            case 4:
                buscarHabitacion(modelFactory);
                break;
        }
    }

    private static void metodosReserva(int opcionSubMenu, ModelFactory modelFactory) {
        switch (opcionSubMenu) {
            case 1:
                crearReserva(modelFactory);
                break;
            case 2:
                eliminarReserva(modelFactory);
                break;
            case 3:
                actualizarReserva(modelFactory);
                break;
            case 4:
                buscarReserva(modelFactory);
                break;
        }
    }

    private static void metodosCliente(int opcionSubMenu, ModelFactory modelFactory) {
        switch (opcionSubMenu) {
            case 1:
                crearCliente(modelFactory);
                break;
            case 2:
                eliminarCliente(modelFactory);
                break;
            case 3:
                actualizarCliente(modelFactory);
                break;
            case 4:
                buscarCliente(modelFactory);
                break;
            case 5:
                contarReservasCliente(modelFactory);
                break;
            case 6:
                calcularGastoTotalCliente(modelFactory);
                break;
        }
    }

    private static String mensajeSubMenu(int opcionSeleccionada) {
        String subMenu = "";
        switch (opcionSeleccionada) {
            case 1:
                subMenu = "1.Agregar Cliente\n" +
                        "2.Eliminar Cliente\n" + "3.Actualizar Cliente\n" + "4.Buscar Cliente\n" + "5.Contar Reservas de Cliente\n" + "6.Calcular Gasto Total de Cliente";
                break;
            case 2:
                subMenu = "1.Agregar Reserva\n" +
                        "2.Eliminar Reserva\n" + "3.Actualizar Reserva\n" + "4.Buscar Reserva";
                break;
            case 3:
                subMenu = "1.Agregar Habitacion\n" +
                        "2.Eliminar Habitacion\n" + "3.Actualizar Habitacion\n" + "4.Buscar Habitacion";
                break;
            case 4:
                subMenu = "1.Agregar Servicio\n" +
                        "2.Eliminar Servicio\n" + "3.Actualizar Servicio\n" + "4.Buscar Servicio";
                break;
            case 5:
                subMenu = "1.Generar Factura";
                break;  
        }

        return subMenu;
    }

    private static String mensajeMenu() {
        String menu = "Menu principal\n" +
                "1.Menu cliente\n" +
                "2.Menu Reserva\n" +
                "3.Menu Habitacion\n" +
                "4.Menu servicio" +
                "5.Generar Factura\n";

        return menu;
    }

    private static void crearCliente(ModelFactory modelFactory) {
        String nombreCliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente");
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese el identificacion del cliente");
        String edad = JOptionPane.showInputDialog(null, "Ingrese la edad del cliente");        
        boolean isAgregado = modelFactory.crearCliente(nombreCliente, identificacion, edad);
        mensajeResultado(isAgregado, "cliente agregado exitosamente", "Cliente no fue agregado");
    }

    private static void eliminarCliente(ModelFactory modelFactory) {
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese el identificacion del cliente");
        boolean isEliminado = modelFactory.eliminarCliente(identificacion);
        mensajeResultado(isEliminado, "El cliente fue eliminado exitosamente", "Cliente no fue eliminado");
    }

    private static void actualizarCliente(ModelFactory modelFactory) {
        String identificacion = JOptionPane.showInputDialog("Ingrese el identificacion del cliente");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre actualizado del cliente");
        String edad = JOptionPane.showInputDialog("Ingrese la edad actualizada del cliente");
        Boolean isActualizado = modelFactory.actualizarCliente(nombre, identificacion, edad);
        mensajeResultado(isActualizado, "El cliente fue actualizado exitosamente", "Cliente no fue actualizado");
    }

    private static void buscarCliente(ModelFactory modelFactory) {
        String identificacion = JOptionPane.showInputDialog("Ingrese el identificacion del cliente");
        Cliente cliente = modelFactory.buscarCliente(identificacion);
        boolean condicion = (cliente != null);
        mensajeResultado(condicion, "El cliente con identificacion " + identificacion + " fue encontrado y su nombre es " + cliente.getNombre(), "El cliente no fue encontrado");
    }

    private static void crearHabitacion(ModelFactory modelFactory) {
        String numero = JOptionPane.showInputDialog(null, "Ingrese el número de la habitación");
        String tipoHabitacionStr = JOptionPane.showInputDialog(null, "Ingrese el tipo de habitación (SIMPLE, DOBLE, SUITE)");
        TipoHabitacion tipoHabitacion = TipoHabitacion.valueOf(tipoHabitacionStr.toUpperCase());
        String precioStr = JOptionPane.showInputDialog(null, "Ingrese el precio de la habitación");
        double precio = Double.parseDouble(precioStr);      
        boolean isAgregado = modelFactory.crearHabitacion(numero, tipoHabitacion, precio);
        mensajeResultado(isAgregado, "Habitación agregada exitosamente", "Habitación no fue agregada");
    }

    private static void eliminarHabitacion(ModelFactory modelFactory) {
        String numero = JOptionPane.showInputDialog(null, "Ingrese el número de la habitación");
        boolean isEliminado = modelFactory.eliminarHabitacion(numero);
        mensajeResultado(isEliminado, "La habitación se eliminó exitosamente", "La habitación no fue eliminada");
    }

    private static void actualizarHabitacion(ModelFactory modelFactory) {
        String numero = JOptionPane.showInputDialog("Ingrese el número de la habitación");
        String tipoHabitacionStr = JOptionPane.showInputDialog("Ingrese el tipo actualizado de la habitación (SIMPLE, DOBLE, SUITE)");
        TipoHabitacion tipoHabitacion = TipoHabitacion.valueOf(tipoHabitacionStr.toUpperCase());
        String precioStr = JOptionPane.showInputDialog("Ingrese el precio actualizado de la habitación");
        double precio = Double.parseDouble(precioStr);
        Boolean isActualizado = modelFactory.actualizarHabitacion(numero, tipoHabitacion, precio);
        mensajeResultado(isActualizado, "La habitación fue actualizada exitosamente", "La habitación no fue actualizada");
    }

    private static void buscarHabitacion(ModelFactory modelFactory) {
        String numero = JOptionPane.showInputDialog("Ingrese el número de la habitación");
        Habitacion habitacion = modelFactory.buscarHabitacion(numero);
        boolean condicion = (habitacion != null);
        mensajeResultado(condicion, "La habitación con número " + numero + " fue encontrada y su tipo es " + habitacion.getTipoHabitacion(), "La habitación no fue encontrada");
    }

    private static void crearReserva(ModelFactory modelFactory) {
        String fechaEntradaStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de entrada (YYYY-MM-DD)");
        String fechaSalidaStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de salida (YYYY-MM-DD)");
        LocalDate fechaEntrada = LocalDate.parse(fechaEntradaStr);
        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);
        String clienteId = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente");
        Cliente cliente = modelFactory.buscarCliente(clienteId);
        String habitacionNumero = JOptionPane.showInputDialog(null, "Ingrese el número de la habitación");
        Habitacion habitacion = modelFactory.buscarHabitacion(habitacionNumero);
        boolean isAgregado = modelFactory.crearReserva(fechaEntrada, fechaSalida, cliente, habitacion);
        mensajeResultado(isAgregado, "Reserva agregada exitosamente", "Reserva no fue agregada");
    }

    private static void eliminarReserva(ModelFactory modelFactory) {
        String clienteStr = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente asociado a la reserva");
        Cliente cliente = modelFactory.buscarCliente(clienteStr);
        boolean isEliminado = modelFactory.eliminarReserva(cliente);
        mensajeResultado(isEliminado, "La reserva se eliminó exitosamente", "La reserva no fue eliminada");
    }

    private static void actualizarReserva(ModelFactory modelFactory) {
        String fechaEntradaStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de entrada (YYYY-MM-DD)");
        String fechaSalidaStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de salida (YYYY-MM-DD)");
        LocalDate fechaEntrada = LocalDate.parse(fechaEntradaStr);
        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);
        String clienteId = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente");
        Cliente cliente = modelFactory.buscarCliente(clienteId);
        String habitacionNumero = JOptionPane.showInputDialog(null, "Ingrese el número de la habitación");
        Habitacion habitacion = modelFactory.buscarHabitacion(habitacionNumero);
        boolean isActualizado = modelFactory.actualizarReserva(fechaEntrada, fechaSalida, cliente, habitacion);
        mensajeResultado(isActualizado, "La reserva fue actualizada exitosamente", "La reserva no fue actualizada");
    }

    private static void buscarReserva(ModelFactory modelFactory) {
        String clienteStr = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente asociado a la reserva");
        Cliente cliente = modelFactory.buscarCliente(clienteStr);
        Reserva reserva = modelFactory.buscarReserva(cliente);
        boolean condicion = (reserva != null);
        mensajeResultado(condicion, "La reserva para el cliente con nombre " + clienteStr + " fue encontrada", "La reserva no fue encontrada");
    }

    private static void crearServicio(ModelFactory modelFactory) {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del servicio");
        String precioStr = JOptionPane.showInputDialog(null, "Ingrese el precio del servicio");
        double precio = Double.parseDouble(precioStr);
        boolean isAgregado = modelFactory.crearServicio(nombre, precio);
        mensajeResultado(isAgregado, "Servicio agregado exitosamente", "Servicio no fue agregado");
    }
    private static void eliminarServicio(ModelFactory modelFactory) {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del servicio");
        boolean isEliminado = modelFactory.eliminarServicio(nombre);
        mensajeResultado(isEliminado, "El servicio fue eliminado exitosamente", "El servicio no fue eliminado");
    }

    private static void actualizarServicio(ModelFactory modelFactory) {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del servicio");
        String precioStr = JOptionPane.showInputDialog(null, "Ingrese el precio actualizado del servicio");
        double precio = Double.parseDouble(precioStr);
        boolean isActualizado = modelFactory.actualizarServicio(nombre, precio);
        mensajeResultado(isActualizado, "El servicio fue actualizado exitosamente", "El servicio no fue actualizado");
    }

    private static void buscarServicio(ModelFactory modelFactory) {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del servicio");
        Servicio servicio = modelFactory.buscarServicio(nombre);
        boolean condicion = (servicio != null);
        mensajeResultado(condicion, "El servicio con nombre " + nombre + " fue encontrado y su precio es " + servicio.getPrecio(), "El servicio no fue encontrado");
    }
    
    private static void mensajeResultado(boolean condicion, String opcion1, String opcion2) {
        JOptionPane.showMessageDialog(null, condicion ? opcion1 : opcion2);
    }

    //menu de metodos agregados
    private static void calcularGastoTotalCliente(ModelFactory modelFactory) {
        String clienteId = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente");
        double gastoTotal = modelFactory.calcularGastoTotalCliente(clienteId);
        JOptionPane.showMessageDialog(null, "El gasto total del cliente es: " + gastoTotal);
    }

    private static void contarReservasCliente(ModelFactory modelFactory) {
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del cliente");
        Cliente cliente = modelFactory.buscarCliente(identificacion);
        if (cliente != null) {
            int numeroReservas = modelFactory.contarReservasCliente(cliente);
            JOptionPane.showMessageDialog(null, "El cliente con identificación " + identificacion + " tiene " + numeroReservas + " reservas.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }

    private static void generarFactura(ModelFactory modelFactory) {
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del cliente");
        String factura = modelFactory.generarFactura(identificacion);
        JOptionPane.showMessageDialog(null, factura);
    }
    
    //CRUDScitos
    private static void crudCliente(ModelFactory modelFactory) {
        crearCliente(modelFactory);
        eliminarCliente(modelFactory);
        actualizarCliente(modelFactory);
        buscarCliente(modelFactory);
    }

    private static void crudHabitacion(ModelFactory modelFactory) {
        crearHabitacion(modelFactory);
        eliminarHabitacion(modelFactory);
        actualizarHabitacion(modelFactory);
        buscarHabitacion(modelFactory);   
    }

    private static void crudReserva(ModelFactory modelFactory) {
        crearReserva(modelFactory);
        eliminarReserva(modelFactory);
        actualizarReserva(modelFactory);
        buscarReserva(modelFactory);
    }

    private static void crudServicio(ModelFactory modelFactory) {
        crearServicio(modelFactory);
        eliminarServicio(modelFactory);
        actualizarServicio(modelFactory);
        buscarServicio(modelFactory);
    }


}
