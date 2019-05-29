/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callcenter.control;

import com.callcenter.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Dispatcher extends Thread {

    private List<Llamada> llamadas;
    private List<Empleado> empleados;
    private Timer teimpoLlamada;

    public Dispatcher() {
        this.llamadas = new ArrayList();
        this.empleados = new ArrayList();

    }

    public void agregarLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public void limpiarLladas(Llamada llamada) {
        llamadas.remove(llamada);
    }

    /**
     *
     */
    public void asignarllamda(Empleado empleado, Llamada llamada) {
        empleado.resicibirLlamada(llamada);
        System.out.println("se asigno....");
        System.out.println(empleado.toString());;
    }

    public void dispatchCall() throws InterruptedException {
        try {
            System.out.println("asignar llamada...");
            while (llamadas.size() > 0) {
                for (Empleado empleado : empleados) {
                    for (Llamada llamada : llamadas) {
                        if (!empleado.isAtendiendoLlamda() && !llamada.isAtendida()) {
                            asignarllamda(empleado, llamada);
                            teimpoLlamada = new Timer();
                            teimpoLlamada.schedule(finalizarLlamada(empleado), llamada.getDuracion() * 60000);
                        } else {
//                            System.out.println("empleado no disponible");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getCause().getCause().getMessage());
        }
    }

    @Override
    public void run() {
        try {
            dispatchCall();
        } catch (InterruptedException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TimerTask finalizarLlamada(Empleado empleado) {
        TimerTask eliminar = new TimerTask() {
            @Override
            public void run() {
                empleado.removerLlamada();
                teimpoLlamada.cancel();
            }

        };

        return eliminar;
    }
}
