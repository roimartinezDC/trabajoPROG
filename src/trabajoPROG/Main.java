package trabajoPROG;

import ficheros.Escritura;
import ficheros.Lectura;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Escritura escritor = new Escritura();
        Lectura lector=new Lectura();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        File fich = new File(".\\fichero.txt");
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("GESTOR DE USUARIOS \n1. Añadir Nuevo Usuario  \n2. Mostrar Usuarios \n3. Buscar Usuario  \n4. Salir"));
            } catch (NumberFormatException ex) {
                System.out.println("error6: "+ex.toString());
            }
            switch (opcion) {
                case 1:
                    escritor.añadirUsuario(usuarios, fich);
                    break;
                case 2:
                    lector.visualizar(usuarios, fich);
                    break;
                case 3:lector.buscar(usuarios,fich);
                    break;
                case 4:
                    break;
            }


        } while (opcion < 4);
    }


}

