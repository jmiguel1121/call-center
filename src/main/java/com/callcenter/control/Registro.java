/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callcenter.control;

import com.callcenter.Director;
import com.callcenter.Empleado;
import com.callcenter.Operador;
import com.callcenter.Supervisor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Registro {

    private List<Llamada> llamadas;
    private List<Empleado> directores;
    private List<Empleado> operadores;
    private List<Empleado> supervisores;

    public Registro() {
        this.llamadas = new ArrayList();
        this.directores = new ArrayList();
        this.supervisores = new ArrayList();
        this.operadores = new ArrayList();

    }

    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    public List<Empleado> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Empleado> directores) {
        this.directores = directores;
    }

    public List<Empleado> getOperadores() {
        return operadores;
    }

    public void setOperadores(List<Empleado> operadores) {
        this.operadores = operadores;
    }

    public List<Empleado> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(List<Empleado> supervisores) {
        this.supervisores = supervisores;
    }

    /**
     *
     * @param llamada
     */
    public void agregarLlamada(Llamada llamada) {
        llamada.setAtendida(true);
        llamadas.add(llamada);
    }

    /**
     * agrega el empleado segun a la lista que corresponda del tipo de empleado
     *
     * @param empleado
     */
    public void agregarEmpleado(Empleado empleado) {
        if (empleado instanceof Operador) {
            operadores.add(empleado);
        } else if (empleado instanceof Supervisor) {
            supervisores.add(empleado);
        } else if (empleado instanceof Director) {
            directores.add(empleado);
        }
    }

    /**
     * remueve el empleado segun a la lista que corresponda del tipo de empleado
     *
     * @param empleado
     */
    public void removerEmpleado(Empleado empleado) {
        if (empleado instanceof Operador) {
            operadores.remove(empleado);
        } else if (empleado instanceof Supervisor) {
            supervisores.remove(empleado);
        } else if (empleado instanceof Director) {
            directores.remove(empleado);
        }
    }

    public void limpiarLladas(Llamada llamada) {
        llamadas.remove(llamada);
    }

}
