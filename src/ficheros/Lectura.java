package ficheros;

import libreriaroiyago.Llamar;
import trabajoPROG.Usuario;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lectura {
    Scanner scan;
    public static void vertirFicheroEnArrayList(ArrayList<Usuario> usuarios, File fich) throws FileNotFoundException {
        usuarios.clear();
        Scanner scan = new Scanner(fich);
        String str;
        while (scan.hasNextLine()) {
            str = scan.nextLine();
            String[] lista = str.split(",");
            usuarios.add(new Usuario(lista[0], lista[1], Integer.parseInt(lista[2]), lista[3], lista[4], Integer.parseInt(lista[5])));
        }
        scan.close();
    }

    public void visualizar(ArrayList<Usuario> usuarios, File nomeFicheiro) {
        try {
            Lectura.vertirFicheroEnArrayList(usuarios, nomeFicheiro);
            for (int i = 0; i < usuarios.size(); i++) {

                System.out.println(usuarios.get(i).getNombre());
                System.out.println(usuarios.get(i).getDni());
                System.out.println(usuarios.get(i).getcPost());
                System.out.println(usuarios.get(i).getCorreo());
                System.out.println(usuarios.get(i).getFechaN());
                System.out.println(usuarios.get(i).getTlf());
                System.out.println();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("erro (Ficheiro non atopado)");
        }
    }

    public void buscar(ArrayList<Usuario> usuarios, File nombreFichero) {
        int opcion;
        String nombre=null;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("MENU \n1.Modificar  \n2.Ordenar de mayor a menor  "));
            switch (opcion) {

                case 1:Lectura.modificar(usuarios,nombreFichero,nombre);
                case 2:
                case 3:
                case 4:

                case 5:


            }


        } while (opcion < 5);
    }

    public static void modificar(ArrayList<Usuario> usuarios, File nombreFichero, String nombre) {
        try {
            Lectura.vertirFicheroEnArrayList(usuarios, nombreFichero);
            nombre = Llamar.lerString("Introduzca nombre a modificar");
            boolean encontrado = false;
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getNombre().equals(nombre)) {
                    encontrado = true;
                    int opcion;
                    do {
                        opcion = Llamar.lerInt("MENU \n1.correo \n2.Codigo postal \n3.Telefono");
                        String mod = Llamar.lerString("¿Que elemento desea modificar");
                        switch (opcion) {
                            case 1:String nuevo_Correo=Llamar.lerString("Introduzca el nuevo correo");
                            usuarios.get(i).setCorreo(nuevo_Correo);
                            case 2:int nuevo_CodigoPostal=Llamar.lerInt("Introduzca el nuevo codigo postal");
                            usuarios.get(i).setcPost(nuevo_CodigoPostal);
                            case 3:int nuevo_Telefono=Llamar.lerInt("Introduzca el nuevo telefono");
                                usuarios.get(i).setcPost(nuevo_Telefono);
                        }
                    } while (opcion < 3);
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("error (fichero non encontrado)");
        }
    }
}



