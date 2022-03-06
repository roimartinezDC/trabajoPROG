package ficheros;

import trabajoPROG.Usuario;

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
            usuarios.add(new Usuario(lista[0], lista[1], Integer.parseInt(lista[2]), Integer.parseInt(lista[3]), lista[4], Integer.parseInt(lista[5])));
        }
        scan.close();
    }

    public void visulizar(ArrayList<Usuario> usuarios, File nomeFicheiro) {
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
}
