package tec.bd.app.domain;

public class Profesor implements Entity {
    //
    private int id;
    private String nombre;
    private String apellido;
    private int sueldo;
    private String deparamento;
    private String cuidad;


    public Profesor(int id, String nombre, String apellido, int sueldo, String deparamento, String cuidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.deparamento = deparamento;
        this.cuidad = cuidad;
    }

    public Integer getId() {
        return id;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getDeparamento() {
        return deparamento;
    }

    public void setDeparamento(String deparamento) {
        this.deparamento = deparamento;
    }

}
