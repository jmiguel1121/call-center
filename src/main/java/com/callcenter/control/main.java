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

        Registro reg = new Registro();
        boolean res = false;
        Dispatcher dispacher = new Dispatcher();
        Dispatcher dispacher2 = new Dispatcher();
        Dispatcher dispacher3 = new Dispatcher();

        Empleado emp1 = new Operador("juan");
        Empleado emp2 = new Operador("daniel");
        Empleado emp3 = new Operador("lorena");
        Empleado emp4 = new Operador("sofia");
        Empleado emp5 = new Supervisor("rafael");
        Empleado emp6 = new Director("karen");

        reg.agregarEmpleado(emp1);
        reg.agregarEmpleado(emp2);
        reg.agregarEmpleado(emp3);
        reg.agregarEmpleado(emp4);
        reg.agregarEmpleado(emp5);
        reg.agregarEmpleado(emp6);

        Llamada llamda1 = new Llamada();
        System.out.println("llamda1 :" + llamda1);
        Llamada llamda2 = new Llamada();
        System.out.println("llamda1 :" + llamda2);
        Llamada llamda3 = new Llamada();
        System.out.println("llamda1 :" + llamda3);

        dispacher.setRegistro(reg);
        dispacher.setLlamada(llamda1);
        dispacher.start();
        dispacher2.setRegistro(reg);
        dispacher2.setLlamada(llamda2);
        dispacher2.start();
        dispacher3.setRegistro(reg);
        dispacher3.setLlamada(llamda3);
        dispacher3.start();

    }

}
