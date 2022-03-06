package trabajoPROG;

public class Usuario {
    private String nombre;
    private String dni;
    private int cPost;
    private int fechaN;
    private String correo;
    private int tlf;

    public Usuario() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public int getFechaN() {
        return fechaN;
    }
    public void setFechaN(int fechaN) {
        this.fechaN = fechaN;
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
