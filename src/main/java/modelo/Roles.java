package modelo;
public class Roles {
    private int id;
    private int idUsr;
    private int rol;

    public Roles() {
    }

    public Roles(int idUsr, int rol) {
        this.idUsr = idUsr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
    
}
