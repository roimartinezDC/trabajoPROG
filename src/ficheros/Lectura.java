package ficheros;

import libreriaroiyago.Llamar;
import trabajoPROG.Usuario;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lectura {

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
            System.out.println("erro (Ficheiro non atopado)"+ ex.toString());
        }
    }

    public void buscar(ArrayList<Usuario> usuarios, File nombreFichero) throws FileNotFoundException {
        vertirFicheroEnArrayList(usuarios, nombreFichero);
        String DNI= Llamar.lerString("DNI a buscar");
        boolean encontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(DNI)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado == true) {
            int opcion;
            opcion = Integer.parseInt(JOptionPane.showInputDialog("MENU \n1. Modificar  \n2. Eliminar \n3. Atrás"));
            switch (opcion) {
                case 1:Escritura.modificar(usuarios,nombreFichero,DNI);
                    break;
                case 2: Escritura.eliminar(usuarios, nombreFichero,DNI);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Usuario no encontrado");
        }

    }


}



