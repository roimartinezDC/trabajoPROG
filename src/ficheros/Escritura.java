package ficheros;

import libreriaroiyago.Llamar;
import trabajoPROG.Usuario;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Escritura {
    PrintWriter pw;
    FileWriter fw;
    public void añadirUsuario(ArrayList<Usuario> usuarios, File fich) throws IOException {
        try {
            Lectura.vertirFicheroEnArrayList(usuarios, fich);

            String nombre = Llamar.lerString("Nombre:");
            String dni = pedirDNI();
            int cPostal = pedircPostal();
            String fNac = pedirFNac();
            String correo = pedirCorreo();
            int tlf = pedirTlf();

            usuarios.add(new Usuario(nombre, dni, cPostal, fNac, correo, tlf));

            fw = new FileWriter(fich, true);
            pw = new PrintWriter(fw);
            for (int i = 0; i < usuarios.size(); i++) {
                pw.println(usuarios.get(i).getNombre()+","+usuarios.get(i).getDni()+","+usuarios.get(i).getcPost()+","+usuarios.get(i).getFechaN()+","+usuarios.get(i).getCorreo()+","+usuarios.get(i).getTlf());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("error1.1: "+ex.toString());
        } finally {
            fw.close();
            pw.close();
        }
    }
    private int pedirTlf() {
        String tlf = null;
        while (tlf == null) {
            try {
                tlf = String.valueOf(Llamar.lerString("Nº de teléfono (opcional) \nPulsar enter para omitir"));
                int ntlf = Integer.parseInt(tlf);
                if (tlf.length() == 9) {
                    if (tlf.startsWith("6") || tlf.startsWith("9")) {
                    } else {
                        System.out.println("Formato del nª de teléfono erróneo");
                        tlf = null;
                    }
                } else {
                    System.out.println("Tamaño del nº de teléfono incorrecto");
                    tlf = null;
                }
            } catch (NumberFormatException ex) {
                if (tlf.equals("")) {
                    tlf = "0";
                    break;
                }else {
                    System.out.println("Formato incorrecto");
                    tlf=null;
                }
            }

        }
        return Integer.parseInt(tlf);
    }
    private String pedirCorreo() {
        String correo = null;
        while (correo == null) {
            correo = Llamar.lerString("Correo electrónico:");
            if (correo.contains("@")) {
                //validar que no tiene más de 1 "@"
                int contA = 0;
                for (int i = 0; i < correo.length(); i++) {
                    if (correo.charAt(i) == '@') {
                        contA++;
                    }
                }
                if (contA == 1) {
                    // continuación de las validaciones
                    String[] lista = correo.split("@");
                    //validar que el dominio no tiene más de un punto
                    int contP = 0;
                    for (int i = 0; i < lista[1].length(); i++) {
                        if (lista[1].charAt(i) == '.') {
                            contP++;
                        }
                    }
                    if (contP == 1) {
                        //continuacion de las validaciones
                        String[] dominio = lista[1].split("\\.");
                        //validar el tipo
                        if (dominio[1].equals("es") || dominio[1].equals("com") || dominio[1].equals("org")) {
                        }else {
                            System.out.println("Tipo del dominio erróneo");
                            correo = null;
                        }
                    } else {
                        System.out.println("Formato del dominio incorrecto");
                        correo = null;
                    }
                } else {
                    System.out.println("Formato del correo incorrecto");
                    correo = null;
                }
            }else {
                System.out.println("Formato del correo incorrecto");
                correo = null;
            }
        }
        return correo;
    }
    private String pedirFNac() {
        int mes = 0;
        while (mes == 0) {
            try {
                mes = Llamar.lerInt("Fecha de nacimiento\nMes:");
                if (mes < 1 || mes > 12) {
                    System.out.println("Mes inválido");
                    mes = 0;
                }
            } catch (NumberFormatException ex) {
                System.out.println("El formato debe ser numérico");
                mes = 0;
            }
        }
        int anho = 0;
        while (anho == 0) {
            try {
                anho = Llamar.lerInt("Fecha de nacimiento\nAño:");
                if (anho < 1910 || anho > 2050) {
                    System.out.println("Año fuera del límite permitido");
                    anho = 0;
                }
            } catch (NumberFormatException ex) {
                System.out.println("El formato debe de ser numérico");
                anho = 0;
            }
        }
        int dia = 0;
        while (dia == 0) {
            try {
                dia = Llamar.lerInt("Fecha de nacimiento\nDía:");
                switch (mes) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dia < 1 || dia > 31) {
                            System.out.println("Día incorrecto");
                            dia = 0;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (dia < 1 || dia > 30) {
                            System.out.println("Día incorrecto");
                            dia = 0;
                        }
                        break;
                    case 2:
                        if ((anho % 4)==0 && (anho % 100)!=0) {
                            if (dia < 1 || dia > 29) {
                                System.out.println("Día incorrecto");
                                dia = 0;
                            }
                        } else {
                            if ((anho % 100)==0 && (anho % 400)==0) {
                                if (dia < 1 || dia > 29) {
                                    System.out.println("Día incorrecto");
                                    dia = 0;
                                }
                            } else {
                                if (dia < 1 || dia > 28) {
                                    System.out.println("Día incorrecto");
                                    dia = 0;
                                }
                            }
                        }
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("El formato debe de ser numérico");
            }
        }

        String fecha = dia+"/"+mes+"/"+anho;
        return fecha;
    }
    private int pedircPostal() {
        int cPostal = 0;
        while (cPostal == 0) {
            try {
                cPostal = Llamar.lerInt("Código Postal:");
                if (String.valueOf(cPostal).length() != 5) {
                    System.out.println("Tamaño del c.postal incorrecto");
                    cPostal = 0;
                }
            } catch (NumberFormatException nfex) {
                System.out.println("Formato del c.postal erróneo");
                cPostal = 0;
            }
        }
        return cPostal;
    }
    private String pedirDNI() {
        String dni = null;
        while (dni == null) {
            dni = Llamar.lerString("DNI:");
            if (dni.length() == 9) {
                String numerosStr = dni.substring(0, 8);
                String letra = dni.substring(8);
                int numeros;
                try {
                    numeros = Integer.parseInt(numerosStr);
                    if (Character.isLetter(letra.charAt(0))) {
                        letra = letra.toUpperCase();
                        int resto = numeros % 23;
                        switch (resto) {
                            case 0:
                                if (!letra.equals("T")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 1:
                                if (!letra.equals("R")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 2:
                                if (!letra.equals("W")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 3:
                                if (!letra.equals("A")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 4:
                                if (!letra.equals("G")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 5:
                                if (!letra.equals("M")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 6:
                                if (!letra.equals("Y")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 7:
                                if (!letra.equals("F")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 8:
                                if (!letra.equals("P")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 9:
                                if (!letra.equals("D")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 10:
                                if (!letra.equals("X")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 11:
                                if (!letra.equals("B")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 12:
                                if (!letra.equals("N")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 13:
                                if (!letra.equals("J")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 14:
                                if (!letra.equals("Z")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 15:
                                if (!letra.equals("S")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 16:
                                if (!letra.equals("Q")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 17:
                                if (!letra.equals("V")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 18:
                                if (!letra.equals("H")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 19:
                                if (!letra.equals("L")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 20:
                                if (!letra.equals("C")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 21:
                                if (!letra.equals("K")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            case 22:
                                if (!letra.equals("E")) {
                                    System.out.println("El DNI introducido es falso");
                                    dni = null;
                                }
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Formato del DNI incorrecto");
                        dni = null;
                    }
                } catch (NumberFormatException nfex) {
                    System.out.println("Formato del DNI incorrecto");
                    dni = null;
                }
            } else {
                System.out.println("Tamaño del DNI erróneo");
                dni = null;
            }
        }
        return dni;
    }

    public static void eliminar(ArrayList<Usuario> usuarios, File nombreFichero) {
        try {
            Lectura.vertirFicheroEnArrayList(usuarios, nombreFichero);
            String nom = Llamar.lerString("¿Que elemento desea eliminar?");
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getNombre().equals(nom)) {
                    usuarios.remove(i);
                    i = i - 1;
                } else {
                    System.out.println("este elemento no existe ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fichero no encontrado" + e.toString());
        }
    }


        public static void modificar(ArrayList<Usuario> usuarios, File nombreFichero) {
            try {
                Lectura.vertirFicheroEnArrayList(usuarios, nombreFichero);
                String nombre = Llamar.lerString("Introduzca nombre a modificar");
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
                    }else {
                        JOptionPane.showMessageDialog(null,"No se encuentra el nombre");
                    }


                }
            } catch (FileNotFoundException e) {
                System.out.println("error (fichero no encontrado)"+e.toString());
            }
        }

    }
