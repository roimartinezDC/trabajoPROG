package trabajoPROG;

public class Usuario implements Comparable {
    private String nombre;
    private String dni;
    private int cPost;
    private String fechaN;
    private String correo;
    private int tlf;

    public Usuario() {
    }
    public Usuario(String nombre, String dni, int cPost, String fechaN, String correo, int tlf) {
        this.nombre = nombre;
        this.dni = dni;
        this.cPost = cPost;
        this.fechaN = fechaN;
        this.correo = correo;
        this.tlf = tlf;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getcPost() {
        return cPost;
    }
    public void setcPost(int cPost) {
        this.cPost = cPost;
    }

    public String getFechaN() {
        return fechaN;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTlf() {
        return tlf;
    }
    public void setTlf(int tlf) {
        this.tlf = tlf;
    }


    @Override
    public int compareTo(Object o) {
        Usuario us1=(Usuario) o;
        if(this.nombre.compareToIgnoreCase(us1.nombre)>0)
            return 1;
        else if(this.nombre.compareToIgnoreCase(us1.nombre)<0)
            return -1;
        else
            return 0;
    }

    public int compareTo2(Object o){
        Usuario us1=(Usuario) o;
        if(this.fechaN.compareToIgnoreCase(us1.fechaN)>0)
            return 1;
        else if(this.fechaN.compareToIgnoreCase(us1.fechaN)<0)
            return -1;
        else
            return 0;
    }

}

