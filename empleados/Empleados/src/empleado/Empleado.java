/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleado;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Armando Barragám
 */

public class Empleado {
    private String codEmpleado;
    private String departamento;
    private String oficio;
    private int salario;
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    public Empleado() {
    }
    public Empleado(String codemp, String depart, String oficio, int salario){
        this.codEmpleado = codemp;
        this.departamento = depart;
        this.oficio = oficio;
        this.salario = salario;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getOficio() {
        return oficio;
    }

    public int getSalario() {
        return salario;
    }
    
    

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    
    
    public static boolean validar_empleado(String emp){
        if (Integer.parseInt(emp) < 0){
            System.out.println("los codigos de empleados nunca deven de ser negativos");
            return false;
        }else if(emp.charAt(0)!= '0'){
            System.out.println("Los codigos de cada empleado se conponen siempre de un cero por delante");
            return false;
        }else if(emp.length() != 3){
            System.out.println("el codigo se compone de solo 3 digitos");
            return false;
        }
        return true;
    }
    public static boolean validador_repeticiones(String codEmp){
        for (int i = 0; i < empleados.size() ; i++) {
            if(codEmp == empleados.get(i).codEmpleado){
                System.out.println("no pueden haber dos codigos de empleado identicos");
                return false;
            }
        }
        return true;
    }
    public static boolean validador_departamento(String depart){
        if("".equals(depart)){
            return true;
        }else if(Integer.parseInt(depart) < 0){
            System.out.println("el depatamento no se compone de digitos negativos");
            return false;
        }else if(depart.length()!= 2){
            System.out.println("el departamento se compone de un codigo de dos digitos");
            return false;
        }
        return true;
    }
    public static boolean validador_oficio(String oficio){
        if("-2".equals(oficio)){
            System.out.println("Es obligatorio tener un oficio para poder pagarlo correctamente");
            return false;
        }else if(!"diseñador".equals(oficio) && !"programador".equals(oficio) && !"analista".equals(oficio)){
            System.out.println("el oficio que ha escrito no entra dentro de nuestra base de datos");
            return false;
        }
        
        return true;
    }
    public static int pago_correspondiente(String oficio){
        int pago = 0;
        if("diseñador".equals(oficio)){
            pago = 1500;
        }else if("programador".equals(oficio)){
            pago = 2000;
        }else if("analista".equals(oficio)){
            pago = 2500;
        }
        return pago;
    }
    
    public String texto() {
        String texto = "Código empleado: " + this.codEmpleado + ", código departamento: " + this.departamento + ", oficio: " + this.oficio + ", salario:" + this.salario; 
        return texto;
    }
    public static Empleado newEmpleado(){
        Scanner sc = new Scanner(System.in);
        String codEmp, depart, oficio = null;
        int opcion, salario = 0;
        System.out.println("---<Creación de los datos del empleado>---\n\n");
        
        do{
            System.out.println("codigo del Emplado (recuerde que solo son 3 digitos y el primero es un 0):");
            codEmp = sc.nextLine();
        }while(!Empleado.validar_empleado(codEmp) && Empleado.validador_repeticiones(codEmp));
        do{
        System.out.println("codigo del Departamento(recuerda que lo puedes dejar en blanco o rellenalo con un limite de 2 digitos):");
        depart = sc.nextLine();
        }while(!Empleado.validador_departamento(depart));
        do{
            System.out.println("codigo de oficio, seleccione las opciones que se le propone");
            System.out.println("<1>Analista");
            System.out.println("<2>Diseñador");
            System.out.println("<3>Programador");
            System.out.println("<4>Elige oficio");
            opcion = sc.nextInt();
            switch (opcion){
                    case 1: oficio ="analista";
                        break;
                    case 2: oficio ="diseñador";
                        break;
                    case 3: oficio ="programador";
                        break;
                    case 4: oficio ="-2";
                        break;
                    default: System.out.println("error");
            }   
        }while (opcion >= 4 && opcion < 0 || !Empleado.validador_oficio(oficio));
        salario = Empleado.pago_correspondiente(oficio);
        return new Empleado(codEmp, depart, oficio, salario);
    }
    
    
    public static void borrar_Empleado(){
        Scanner sc = new Scanner(System.in);
        
    }
    
    
    /**
     * @param args
     * @throws java.lang.Exception     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        // Empleado empleado1 = new Empleado("011", "05", "analista");
        // empleados.add(empleado1);
        int option;
        do{
            System.out.println("Demostración: \n");
            for (int i = 0; i < empleados.size(); i++){
                System.out.println(empleados.get(i).texto());
            }
            System.out.println("----------------------------------------");
            System.out.println("Bien venido administrador, ¿que desea realizar?\n");
            System.out.println("----------------<(Opciones a elegir)>----------------\n\n");
            System.out.println("--<1>--Crear Empleado\n");
            System.out.println("--<2>--Borrar Empleado\n");
            System.out.println("--<3>--Terminar\n");
            System.out.println("<Opción>:");
            option = sc.nextInt();sc.nextLine();
            switch (option){
                    case 1: 
                            empleados.add(Empleado.newEmpleado());
                            System.out.println("se ha creado correctamente el empleado");
                            break;
                    case 2: String codEmp = "";
                            System.out.println("¿Que cliente desea borrar?(dame el codigo dew cliente: \n)");
                            codEmp = sc.nextLine();
                            if (empleados.size()==0){
                                System.out.println("no sepuede borrar ningun empleado porque no hay ninguno existente");
                            }else{
                                for (int i = 0; i < empleados.size(); i++) {
                                    if(empleados.get(i).getCodEmpleado().equals(codEmp)){
                                        empleados.remove(i);
                                    }else{
                                        System.out.println("no hay ningun usuario que tenga el codigo: "+ codEmp);   
                                    }
                                }
                            }
                    case 3: System.out.println("Termino");
                            break;
                    default: System.out.println("error");
                            break;
                }
        }while(option < 3);
        
        }
}
    

