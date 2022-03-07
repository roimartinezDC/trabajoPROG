package trabajoPROG;

public class Usuario {
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
}
