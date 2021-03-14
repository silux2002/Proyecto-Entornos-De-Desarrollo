
import Apuesta.Apuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.fail;

import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armando Barragám
 */
public class testApuestas {
    @Test public void test1(){
        int insert = 100;
        int disponible;
        System.out.println("text de prueba del metodo apostar (test 1)");
        Apuesta apuestaTest = new Apuesta(200,2,3);
        try {
            apuestaTest.apostar(insert);
        } catch (Exception ex) {
            Logger.getLogger(testApuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
        disponible = apuestaTest.getDinero_disp();
        System.out.println(disponible);
        assertTrue(disponible >= 0);
    }
    @Test public void test2(){
        int insert = -1;
        int disponible;
        System.out.println("text de prueba del metodo apostar (test 2)");
        Apuesta apuestaTest = new Apuesta(200,2,3);
        try {
            apuestaTest.apostar(insert);
        } catch (Exception ex) {
            Logger.getLogger(testApuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
        disponible = apuestaTest.getDinero_disp();
        System.out.println(disponible);
        assertTrue(disponible >= 0);
    }
    @Test public void test3(){
        int insert = 300;
        int disponible;
        System.out.println("text de prueba del metodo apostar (test 3)");
        Apuesta apuestaTest = new Apuesta(200,2,3);
        try {
            apuestaTest.apostar(insert);
        } catch (Exception ex) {
            Logger.getLogger(testApuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
        disponible = apuestaTest.getDinero_disp();
        System.out.println(disponible);
        assertTrue(disponible >= 0);
    }
/* casos de prueva para cobrar */
    
    @Test public void test4(){
        Apuesta apuestaTest = new Apuesta(200,2,3);
        int local = 2;
        int visitantes = 3;
        int dinero_apostado = 20;
        int dineroTrasApostar = 0;
        int dineroSinModificar = apuestaTest.getDinero_disp();
        System.out.println("text de prueba del metodo cobrar_apuesta (test 4)");
        
        try {
            apuestaTest.apostar(dinero_apostado);
            dineroTrasApostar = apuestaTest.getDinero_disp();
            apuestaTest.cobrar_apuesta(local, visitantes);
        } catch (Exception ex) {
            Logger.getLogger(testApuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
        int dineroTrasCobrar = apuestaTest.getDinero_disp();
        System.out.println("sin modificar: " + dineroSinModificar + ", dinero tras apuesta: " + dineroTrasApostar + ", dinero tras cobro: " + dineroTrasCobrar);
        assertTrue(dineroTrasApostar + 10*dinero_apostado == dineroTrasCobrar);
    }
    @Test public void test5(){
        Apuesta apuestaTest = new Apuesta(200,2,3);
        int local = 5;
        int visitantes = 6;
        int dinero_apostado = 20;
        int dineroTrasApostar = 0;
        int dineroSinModificar = apuestaTest.getDinero_disp();
        System.out.println("text de prueba del metodo cobrar_apuesta (test 5)");
        
        try {
            apuestaTest.apostar(dinero_apostado);
            dineroTrasApostar = apuestaTest.getDinero_disp();
            apuestaTest.cobrar_apuesta(local, visitantes);
        } catch (Exception ex) {
            Logger.getLogger(testApuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
        int dineroTrasCobrar = apuestaTest.getDinero_disp();
        System.out.println("sin modificar: " + dineroSinModificar + ", dinero tras apuesta: " + dineroTrasApostar + ", dinero tras cobro: " + dineroTrasCobrar);
        assertTrue(dineroTrasApostar == dineroTrasCobrar);
    }
    @Test public void test6(){
        Apuesta apuestaTest = new Apuesta(200,2,3);
        int local = 2;
        int visitantes = 3;
        int dinero_apostado = 20;
        int dineroTrasApostar = 0;
        int dineroSinModificar = apuestaTest.getDinero_disp();
        System.out.println("text de prueba del metodo cobrar_apuesta (test 6)");
        
        try {
            apuestaTest.apostar(dinero_apostado);
            dineroTrasApostar = apuestaTest.getDinero_disp();
            apuestaTest.cobrar_apuesta(local, visitantes);
        } catch (Exception ex) {
            Logger.getLogger(testApuestas.class.getName()).log(Level.SEVERE, null, ex);
            int dineroTrasCobrar = apuestaTest.getDinero_disp();
            System.out.println("sin modificar: " + dineroSinModificar + ", dinero tras apuesta: " + dineroTrasApostar + ", dinero tras cobro: " + dineroTrasCobrar);
            assertTrue(dineroTrasApostar == dineroTrasCobrar);
        }

    }

    private void assertTrue(boolean par) {
        assert par;
    }

    private void assertFalse(boolean b) {
        assert !b;
    }
}