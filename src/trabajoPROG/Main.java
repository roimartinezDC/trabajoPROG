package trabajoPROG;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        File fich = new File(".\\fichero.txt");
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("GESTOR DE USUARIOS \n1.Añadir Novo Usuario  \n2.Amosar Usuarios \n3.Eliminar Usuarios \n4.Buscar por parametro  "));
            switch (opcion) {

                case 1:
                case 2:
                case 3:
                case 4:

                case 5:


            }


        } while (opcion < 5);
    }


}

