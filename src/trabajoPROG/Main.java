package trabajoPROG;

import ficheros.Escritura;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Escritura escritor = new Escritura();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        File fich = new File(".\\fichero.txt");

        escritor.añadirUsuario(usuarios, fich);


    }
}
