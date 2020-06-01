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
public abstract class Empleado {

    protected String nombre;
    protected boolean atendiendoLlamda;
    protected Llamada llamada;

	/**
	 * cambio feature1
	 */
    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    /**
     * asigna la llamda al empleado
     *
     * @param llamada
     * @return
     */
    public abstract boolean resicibirLlamada(Llamada llamada);

    public abstract void removerLlamada();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAtendiendoLlamda() {
        return atendiendoLlamda;
    }

    public void setAtendiendoLlamda(boolean atendiendoLlamda) {
        this.atendiendoLlamda = atendiendoLlamda;
    }


    public Llamada getLlamada() {
        return llamada;
    }

    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", atendiendoLlamda=" + atendiendoLlamda + ", llamada=" + llamada + '}';
    }

}
