/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callcenter.control;

import com.callcenter.Empleado;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Dispatcher extends Thread {

    private Llamada llamada;
    private Timer teimpoLlamada;
    private Registro registro;

    public Dispatcher() {
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Llamada getLlamada() {
        return llamada;
    }

    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }

    /**
     * asigna la llamda al empleado que se encuentra disponible
     */
    public void asignarllamda(Empleado empleado, Llamada llamada) {
        empleado.resicibirLlamada(llamada);
        System.out.println("se asigno....");
        System.out.println(empleado.toString());;
    }

    /**
     * inicializa el bucle para encontrar empleado disponovle e asignar la
     * allamada inciando los operarios despues supervisores y al final
     * direstores
     *
     * @throws InterruptedException
     */
    public void dispatchCall() throws InterruptedException {
        try {
            System.out.println("asignar llamada...");
            while (!llamada.isAtendida()) {
                for (Empleado empleado : registro.getOperadores()) {
                    if (!empleado.isAtendiendoLlamda() && !llamada.isAtendida()) {
                        asignarllamda(empleado, llamada);
                        registro.agregarLlamada(llamada);
                        teimpoLlamada = new Timer();
                        teimpoLlamada.schedule(
                                finalizarLlamada(empleado),
                                llamada.getDuracion()
                        );
                        break;
                    }
                }
                if (!llamada.isAtendida()) {
                    for (Empleado empleado : registro.getSupervisores()) {
                        if (!empleado.isAtendiendoLlamda() && !llamada.isAtendida()) {
                            asignarllamda(empleado, llamada);
                            registro.agregarLlamada(llamada);
                            teimpoLlamada = new Timer();
                            teimpoLlamada.schedule(
                                    finalizarLlamada(empleado),
                                    llamada.getDuracion()
                            );
                            break;
                        }
                    }
                } else if (!llamada.isAtendida()) {
                    for (Empleado empleado : registro.getDirectores()) {
                        if (!empleado.isAtendiendoLlamda() && !llamada.isAtendida()) {
                            asignarllamda(empleado, llamada);
                            registro.agregarLlamada(llamada);
                            teimpoLlamada = new Timer();
                            teimpoLlamada.schedule(
                                    finalizarLlamada(empleado),
                                    llamada.getDuracion()
                            );
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getCause().getCause().getMessage());
        }
    }

    /**
     * inicializa el hilo
     */
    @Override
    public void run() {
        try {
            dispatchCall();
        } catch (InterruptedException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * finaliza la llamda y la remueve del empleado al culminar del tiempo de la
     * llamda
     *
     * @param empleado
     * @return
     */
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
