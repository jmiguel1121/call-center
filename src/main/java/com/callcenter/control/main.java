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

/**
 *
 * @author LENOVO
 */
public class main {
    public static void main(String[] args) {

        boolean res = false;
        Dispatcher dispacher = new Dispatcher();
        Empleado emp1 = new Operador("juan");
        Empleado emp2 = new Operador("daniel");
        Empleado emp3 = new Operador("lorena");
        Empleado emp4 = new Operador("sofia");
        Empleado emp5 = new Supervisor("rafael");
        Empleado emp6 = new Director("karen");

        dispacher.agregarEmpleado(emp1);
        dispacher.agregarEmpleado(emp2);
        dispacher.agregarEmpleado(emp3);
        dispacher.agregarEmpleado(emp4);
        dispacher.agregarEmpleado(emp5);
        dispacher.agregarEmpleado(emp6);

        Llamada llamda1 = new Llamada(3);
        Llamada llamda2 = new Llamada(5);
        Llamada llamda3 = new Llamada(2);

        dispacher.agregarLlamada(llamda1);
        dispacher.agregarLlamada(llamda2);
        dispacher.agregarLlamada(llamda3);

        dispacher.start();
    }

}
