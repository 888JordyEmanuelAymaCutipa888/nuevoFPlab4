
package fplab;

import java.util.*;

public class FpLab {
    public static void main(String[] args) {
        
        String menu;
        
        Scanner sc = new Scanner(System.in);
        
        int indicadordemenu, CPer=0, Cpaq=0;
        
        Persona [] Registro = new Persona[10];
        Paquete [] RegistroP = new Paquete[3];
        
        for (int i = 0; i < Registro.length; i++) {
            Registro[i] = new Persona();
        }
        
        for (int i = 0; i < RegistroP.length; i++) {
            RegistroP[i] = new Paquete();
        }
        
        do{
            System.out.println("1 = REGISTRO DE PERSONAS\n2 = REGISTRO DE PAQUETES"
                    + "\n3 = REGISTRAR ENTREGA DE PAQUETES\n4 = PAQUETES CON MÁS PESO"
                    + "\n5 = PAQUETES CON EL MISMO COSTO\n6 = PAQUETES PENDIENTES"
                    + "\n7 = PERSONA DUEÑA DEL PAQUETE\n8 = PAQUETES AL INGRESAR DNI");
            indicadordemenu = sc.nextInt();
            
            switch (indicadordemenu) {
                case 1:
                    CPer = RegistroPersonas(Registro, CPer);
                    break;
                case 2:
                    Cpaq = RegistroPaquetes(RegistroP,Registro, CPer, Cpaq);
                    break;
                case 3:
                    EntregaDePaquetes(RegistroP);
                    break;
                case 4:
                    KilosMas(RegistroP);
                    break;
                case 5:
                    MismoCosto(RegistroP);
                    break;
                case 6:
                    Pendientes(RegistroP);
                    break;
                case 7:
                    PersonaIdentificador(RegistroP);
                    break;
                case 8:
                    PaquetesDni(RegistroP);
                    break;
                default:
                    break;
            }
            
            System.out.println("\n¿DESEA REGRESAR AL MENÚ? «si» «no»");
            menu = sc.next();
        }
        while(menu.equals("si"));
        
    }
    public static int RegistroPersonas(Persona[] registro, int numper){
        
        Scanner sc = new Scanner(System.in);
        
        String nombre, celular, dni;
        int cantidad=0;
        
        //Cantidad de personas
        System.out.println("\n"+(numper+1)+"° PERSONA\n");
        
        System.out.print("Dni: ");
        dni = sc.next();
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Celular: ");
        celular = sc.next();
        
        
        registro[numper] = new Persona();
        
        registro[numper].setNombre(nombre);
        registro[numper].setDni(dni);
        registro[numper].setCelular(celular);
        numper++;
        return numper;
        
    } 
    
    public static int RegistroPaquetes(Paquete [] registro, Persona[] pre, int per, int paq){
        
        Scanner sc = new Scanner(System.in);
        
        String registrado, dnir, fechaRecepcion, fechaEntrega, direccion, dni,com;
        int identificador, peso, costo, cantidad=0;
        boolean estado, encontrado=false;
        
        Persona dueño = new Persona();
        System.out.println("\n"+(paq+1)+"° PAQUETE \n");
        
        System.out.println("Ingrese DNI de la persona de origen: ");
        dnir = sc.next();
        
        //identifica a la persona
        for (int i = 0; i < (per+1); i++) {
            if(dnir.equals(pre[i].getDni())){
                dueño=pre[i];
                encontrado = true;
                
            }
        }
        
        if(encontrado){
            
            System.out.print("Indentificador: ");
            identificador = sc.nextInt();
            System.out.print("Fecha de Recepcion: ");
            fechaRecepcion = sc.next();
            System.out.print("Fecha de Entrega: ");
            fechaEntrega = sc.next();
            System.out.print("Peso: ");
            peso = sc.nextInt();
            System.out.print("Costo: ");
            costo = sc.nextInt();
            System.out.print("Direccion: ");
            direccion = sc.next();
            System.out.print("Estado: ");
            estado = sc.nextBoolean();
            
            registro[paq] = new Paquete();
            
            registro[paq].setIdentificador(identificador);
            registro[paq].setFechaRecepcion(fechaRecepcion);
            registro[paq].setFechaentrega(fechaEntrega);
            registro[paq].setPeso(peso);
            registro[paq].setCosto(costo);
            registro[paq].setDireccion(direccion);
            registro[paq].setEstado(estado);
            registro[paq].setPersona(dueño);
            paq++; 
        }
        else{
            System.out.println("ESTA PERSONA NO SE ENCUENTRA REGISTRADA");
        }
        return paq;
    } 
    public static void EntregaDePaquetes (Paquete [] registroP){
        
        Scanner sc = new Scanner(System.in);
        int comIdentificador, pacEncontra=0;
        
        System.out.println("¿QUÉ PAQUETE SE HA ENTREGADO? \nINGRESE IDENTIFICADOR: ");
        comIdentificador = sc.nextInt();
        
        for (Paquete registroP1 : registroP) {
            
            if (registroP1.getIdentificador() == comIdentificador) {
                pacEncontra++;
                
                if (registroP1.getEstado() == false) {
                    registroP1.setEstado(true);
                    System.out.println("LA ENTREGA DEL PAQUETE SE HA REGISTRADO");
                    
                } 
                else {
                    System.out.println("EL PAQUETE YA HA SIDO ENTREGADO");
                }
            }
        }
        if(pacEncontra==0){
            System.out.println("NO SE HA ENCONTRADO EL PAQUETE");
        }
    }
    
    public static void KilosMas(Paquete [] registroP){
        
        int kilos;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de kilos");
        kilos = sc.nextInt();
        
        System.out.println("Los paquetes que superan este peso son: ");
        for (int i = 0; i < registroP.length; i++) {
            if(registroP[i].getPeso()>kilos){
                System.out.println("identificador: "+registroP[i].getIdentificador()+
                        " Peso: "+registroP[i].getPeso());
            }
        }
    }
    public static void MismoCosto(Paquete [] registroP){
        
        int costo;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el costo");
        costo = sc.nextInt();
        
        System.out.println("Los paquetes del mismo costo son:");
        
        for (int i = 0; i < registroP.length; i++) {
            
            if(costo == registroP[i].getCosto()){
                System.out.println("identificador: "+registroP[i].getIdentificador()+
                        " costo: "+registroP[i].getCosto());
            }
            
        }
        
    }
    public static void Pendientes(Paquete [] registroP){
        
        
        System.out.println("Los paquetes pendientes son:");
        
        for (int i = 0; i < registroP.length; i++) {
            
            if(!registroP[i].getEstado()){
                System.out.println("identificador: "+registroP[i].getIdentificador()+
                        " Estado : "+registroP[i].getEstado());
            }
        }
        
    }
    
    public static void PersonaIdentificador(Paquete [] registroP){
        
        String identificador;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el identificador ");
        identificador = sc.next();
        
        System.out.println("Este paquete le pertenece a: ");
        
        for (int i = 0; i < registroP.length; i++) {
            if(identificador.equals(registroP[i].getIdentificador())){
                System.out.println(registroP[i].getPersona().getNombre());
            }
        }
    }
    public static void PaquetesDni(Paquete [] registroP){
        
        String dni;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Dni: ");
        dni= sc.next();
        
        System.out.println("Sus paquetes son: ");
        
        for (int i = 0; i < registroP.length; i++) {
            
            if(dni.equals(registroP[i].getPersona().getDni())){
                System.out.println("Identificador: "+registroP[i].getIdentificador());
            }
        }
    }
    
}
