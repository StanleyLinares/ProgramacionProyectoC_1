package modelo;
public class Usuarios {
    private int id;
    private String nombre;
    private String apellidos;
    private String contrasena;
    private String usuarioGenerado;

    public Usuarios() {
    }

    public Usuarios(int id) {
        this.id = id;
    }

    public Usuarios(int id, String nombre, String apellidos, String contrasena, String usuarioGenerado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.usuarioGenerado = usuarioGenerado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuarioGenerado() {
        return usuarioGenerado;
    }

    public void setUsuarioGenerado(String usuarioGenerado) {
        this.usuarioGenerado = usuarioGenerado;
    }

    
    
    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contrasena=" + contrasena + ", usuarioGenerado=" + usuarioGenerado + '}';
    }
    
}