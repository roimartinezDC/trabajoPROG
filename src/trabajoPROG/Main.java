package trabajoPROG;

import ficheros.Escritura;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Escritura escritor = new Escritura();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        File fich = new File(".\\fichero.txt");
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("GESTOR DE USUARIOS \n1.Añadir Novo Usuario  \n2.Amosar Usuarios \n3.Eliminar Usuarios \n4.Buscar por parametro  \n5.Salir"));
            switch (opcion) {

                case 1:
                    escritor.añadirUsuario(usuarios, fich);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }


        } while (opcion < 5);
    }


}

