/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callcenter;

import com.callcenter.control.Llamada;

/**
 *
 * @author LENOVO
 */
public class Supervisor extends Empleado {

    public Supervisor(String nombre) {
        super(nombre);
    }

    /**
     * asigna la llamda al empleado
     *
     * @param llamada
     * @return
     */
    @Override
    public boolean resicibirLlamada(Llamada llamada) {
        if (llamada != null) {
            llamada.setAtendida(true);
            this.llamada = llamada;
            this.atendiendoLlamda = true;
            return true;

        }
        return false;
    }

    @Override
    public void removerLlamada() {
        System.out.println(" se removio llmada terminada");
        this.llamada = null;
    }
}
