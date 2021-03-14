/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.fail;

import org.junit.Test;
import empleado.Empleado;
/**
 *
 * @author Armando Barragán
 */

public class Empleadosest {
    
    public Empleadosest() {
    }
//Test del validador de los codigos de empelados
    
    @Test public void codigo_empleadoTest1(){
        String codEmp = "-100";
        assertFalse(Empleado.validar_empleado(codEmp));
    }
    @Test public void codigo_empleadoTest2(){
        String codEmp = "-1";
        assertFalse(Empleado.validar_empleado(codEmp));
    }
    @Test public void codigo_empleadoTest3(){
        String codEmp = "099";
        assertTrue(Empleado.validar_empleado(codEmp));
    }
    @Test public void codigo_empleadoTest4(){
        String codEmp = "000";
        assertTrue(Empleado.validar_empleado(codEmp));
    }
    @Test public void codigo_empleadoTest5(){
        String codEmp = "100";
        assertFalse(Empleado.validar_empleado(codEmp));
    }
    @Test public void codigo_empleadoTest6(){
        String codEmp = "999";
        assertFalse(Empleado.validar_empleado(codEmp));
    }
    
//Test del validador del codigo del departameno
    
    @Test public void codigo_departamentoTest1(){
        String depart = "-99";
        assertFalse(Empleado.validador_departamento(depart));
    }
    @Test public void codigo_departamentoTest2(){
        String depart = "-1";
        assertFalse(Empleado.validador_departamento(depart));
    }
    @Test public void codigo_departamentoTest3(){
        String depart = "99";
        assertTrue(Empleado.validador_departamento(depart));
    }
    @Test public void codigo_departamentoTest4(){
        String depart = "00";
        assertTrue(Empleado.validador_departamento(depart));
    }
    @Test public void codigo_departamentoTest5(){
        String depart = "100";
        assertFalse(Empleado.validador_departamento(depart));
    }
    @Test public void codigo_departamentoTest6(){
        String depart = "999";
        assertFalse(Empleado.validador_departamento(depart));
    }
    @Test public void codigo_departamentoTest7(){
        String depart = "";
        assertTrue(Empleado.validador_departamento(depart));
    }
    
    //Test del validador de oficio incluyendo la función pago

    @Test public void codigo_oficioDiseñadorTest1(){
        String oficio = "diseñador";
        int salario;
        salario=Empleado.pago_correspondiente(oficio);
        assertTrue(Empleado.validador_oficio(oficio) && salario == 1500 );
    }
    @Test public void codigo_oficioProgramadorTest2(){
        String oficio = "programador";
        int salario;
        salario=Empleado.pago_correspondiente(oficio);
        assertTrue(Empleado.validador_oficio(oficio) && salario == 2000 );
    }
    @Test public void codigo_oficioAnalistaTest3(){
        String oficio = "analista";
        int salario;
        salario=Empleado.pago_correspondiente(oficio);
        assertTrue(Empleado.validador_oficio(oficio) && salario == 2500 );
    }
    @Test public void codigo_oficioEligeOficioTest4(){
        String oficio = "-2";
        assertFalse(Empleado.validador_oficio(oficio));
    }
    @Test public void codigo_oficioTest5(){
        String oficio = "";
        assertFalse(Empleado.validador_oficio(oficio));
    }
    
    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    private void assertTrue(boolean par) {
        assert par;
    }

    private void assertFalse(boolean b) {
        assert !b;
    }
}
