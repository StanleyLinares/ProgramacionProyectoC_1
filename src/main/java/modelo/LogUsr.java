package modelo;

public class LogUsr {
    private int id;
    private int idUsr;
    private Object horaLogin;
    private Object horaLogout;

    public LogUsr(int id, int idUsr, Object horaLogin, Object horaLogout) {
        this.id = id;
        this.idUsr = idUsr;
        this.horaLogin = horaLogin;
        this.horaLogout = horaLogout;
    }

    public LogUsr() {
    }

    public LogUsr(int idUsr, Object horaLogin, Object horaLogout) {
        this.idUsr = idUsr;
        this.horaLogin = horaLogin;
        this.horaLogout = horaLogout;
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

    public Object getHoraLogin() {
        return horaLogin;
    }

    public void setHoraLogin(Object horaLogin) {
        this.horaLogin = horaLogin;
    }

    public Object getHoraLogout() {
        return horaLogout;
    }

    public void setHoraLogout(Object horaLogout) {
        this.horaLogout = horaLogout;
    }

    @Override
    public String toString() {
        return "LogUsr{" + "id=" + id + ", idUsr=" + idUsr + ", horaLogin=" + horaLogin + ", horaLogout=" + horaLogout + '}';
    }
    
    
}
