/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callcenter.control;

/**
 *
 * @author LENOVO
 */
public class Llamada {

    private Integer duracion;
    private boolean atendida;


    public Llamada(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }

    @Override
    public String toString() {
        return "Llamada{" + "duracion=" + duracion + '}';
    }

}
