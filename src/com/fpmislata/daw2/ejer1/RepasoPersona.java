/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.ejer1;

import com.fpmislata.daw2.ejer1.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author alumno
 */
public class RepasoPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map<String, Persona> mapPersonas = new HashMap<String, Persona>();  //Declaramos el Map de personas, similar a una lista pero una un valor indice

        List<Persona> lista = new ArrayList<Persona>(); //Declaramos una arrayList de personas

        Scanner sc = new Scanner(System.in);

        int seleccionMenu = -1;

        while (seleccionMenu != 0) {

            System.out.println("MENU");
            System.out.println("1- Insertar Persona por Consola");
            System.out.println("2- Ver número Personas");
            System.out.println("3- Ver todas las personas");
            System.out.println("4- Buscar persona por DNI");
            System.out.println("5- Buscar persona por MAP con DNI");
            System.out.println("6- Ver todas las personas usando MAP");
            System.out.println("");
            System.out.println("0- Salir");

            seleccionMenu = sc.nextInt();

            if (seleccionMenu == 1) {   // Insertar Persona por Consola

                insertarConsolaPersonas(lista, mapPersonas);

            } else if (seleccionMenu == 2) { // Ver número Personas

                imprimirNumeroDePersonas(lista);

            } else if (seleccionMenu == 3) {    // Ver todas las personas

                imprimirListaPersonas(lista);

            } else if (seleccionMenu == 4) {    // Buscar persona por DNI

                Scanner scb = new Scanner(System.in);

                System.out.println("Dime el DNI a buscar: ");
                String dniBuscar = scb.next();
                buscarPersonasDNI(lista, dniBuscar);

            } else if (seleccionMenu == 5) {  // Buscar persona por MAP con DNI

                Scanner scbm = new Scanner(System.in);

                System.out.println("Dime el DNI a buscar: ");
                String dniBuscar = scbm.next();
                buscarPersonasMapDNI(mapPersonas, dniBuscar);

            } else if (seleccionMenu == 6) { //Ver todas las personas usando MAP
                
                imprimirListaPersonasMap(mapPersonas);
                
            } else if (seleccionMenu == 0) {    //Salir

                break;
            }
        }

        /*      Persona persona1 = new Persona("12345678A", "Mikel", "Night", Sexo.HOMBRE);
         Persona persona2 = new Persona("87654321B", "Adrian", "Nuñez", Sexo.MUJER);
         Persona persona3 = new Persona("18273645C", "Cara", "Col", Sexo.HERMAFRODITA);

         lista.add(persona1);
         lista.add(persona2);
         lista.add(persona3);*/

    }

    //Insertar una persona nueva por consola
    
    private static void insertarConsolaPersonas(List<Persona> personas, Map<String, Persona> mapPersonas) {

        Persona p = new Persona();

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el DNI: ");
        String suDni = sc.next();
        p.setDni(suDni);

        System.out.println("Cual es tu nombre: ");
        String suNombre = sc.next();
        p.setNombre(suNombre);

        System.out.println("Cual es tu apellido: ");
        String suApellido = sc.next();
        p.setApellido(suApellido);

        System.out.println("¿Cual es tu sexo?");
        System.out.println("1- Macho");
        System.out.println("2- Hembra");

        Scanner sex = new Scanner(System.in);

        int seleccionSexo = sex.nextInt();

        Sexo suSexo = null;

        if (seleccionSexo == 1) {

            suSexo = p.getSexo().HOMBRE;

        } else if (seleccionSexo == 2) {

            suSexo = p.getSexo().MUJER;
        } else {

            suSexo = p.getSexo().HERMAFRODITA;
        }

        p.setSexo(suSexo);

        mapPersonas.put(suDni, p);  //Insertamos un map, indicando el Objeto y un indici (DNI)
        personas.add(p);    //añadimos a la lista
    }

    //Imprimir todo la lista de las personas que hay en el arrayList
    
    private static void imprimirListaPersonas(List<Persona> personas) {

        System.out.println("########### LISTA ############");

        for (Persona p : personas) {

            System.out.println("Nombre Completo: " + p.getNombreCompleto());

        }

        System.out.println("##############################");

        System.out.println("");
    }
    
    //Imprimir todas las personas con MAP
    
    private static void imprimirListaPersonasMap(Map<String, Persona> mapPersonas) {
    
        //Declaramos un Set de tipo String para los DNIs y le pasamos el mapPersonas asignandole el set
        
        Set<String> setDnis=mapPersonas.keySet();   
        
        System.out.println("########### LISTA ############");
            
            for(String dni : setDnis){  //recorregmos por el dni el setPersonas
                
                Persona p = mapPersonas.get(dni);   //Creamos una persona asignandole el get DNI
                
                System.out.println("Nombre Completo: " + p.getNombreCompleto());    //Imprimimos el nombre completo
            }       

        System.out.println("##############################");

        System.out.println("");
    }

    //Imprimir el numero de personas que hay en el arrayList
    
    private static void imprimirNumeroDePersonas(List<Persona> personas) {

        System.out.println("El numero de personas de la lista son: " + personas.size());
        System.out.println("");
    }

    //Buscar personas por el DNI que le pasamos por consola
    
    private static void buscarPersonasDNI(List<Persona> personas, String dnibuscar) {

        System.out.println("########### LISTA ############");

        for (Persona p : personas) {

            if (p.getDni().equalsIgnoreCase(dnibuscar)) {
                System.out.println("Nombre Completo: " + p.getNombreCompleto());
            }
        }

        System.out.println("##############################");

        System.out.println("");
    }

    //Buscar las personas con MAP pasandole el DNI
    
    private static void buscarPersonasMapDNI(Map<String, Persona> mapPersonas, String dnibuscar) {

        System.out.println("########### LISTA ############");

        Persona p = mapPersonas.get(dnibuscar);

        System.out.println("Nombre Completo: " + p.getNombreCompleto());

        System.out.println("##############################");

        System.out.println("");
    }
}
