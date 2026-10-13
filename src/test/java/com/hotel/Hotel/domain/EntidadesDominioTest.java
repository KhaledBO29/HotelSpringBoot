package com.hotel.Hotel.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntidadesDominioTest {

    @Test
    void testEncapsulamientoCliente() {
        Cliente cliente = new Cliente("Juan Perez", "juan@correo.com");

        assertEquals("Juan Perez", cliente.getNombre());
    }

    @Test
    void testEstadoHabitacion() {
        Habitacion habitacion = new HabitacionEstandar("301", 2, 150.0, 2);

        assertEquals(EstadoHabitacion.DISPONIBLE, habitacion.getEstado());

        habitacion.asignarAReserva();
        assertEquals(EstadoHabitacion.OCUPADA, habitacion.getEstado());
    }

    @Test
    void testComposicionReserva() {
        Cliente cliente = new Cliente("Ana Gomez", "ana@correo.com");
        Habitacion habitacion = new HabitacionEstandar("302", 2, 120.0, 2);
        RangoFechas periodo = new RangoFechas(
                LocalDateTime.of(2026, 11, 1, 14, 0),
                LocalDateTime.of(2026, 11, 3, 11, 0));

        Reserva reserva = new Reserva(cliente, habitacion, periodo);

        assertEquals("Ana Gomez", reserva.getCliente().getNombre());
    }

    @Test
    void testDatosRangoFechas() {
        LocalDateTime fechaInicio = LocalDateTime.of(2026, 11, 1, 14, 0);
        RangoFechas rango = new RangoFechas(
                fechaInicio,
                LocalDateTime.of(2026, 11, 3, 11, 0));

        assertEquals(fechaInicio, rango.fechaInicio());
    }

    @Test
    void testInstanciacionClienteNulo() {
        Cliente clienteNuevo = new Cliente();

        assertNull(clienteNuevo.getEmail());
    }
}

