package tec.bd.app.domain;

public class Profesor implements Entity {
    //
    private Integer id;
    private String nombre;
    private String apellido;
    private String ciudad;


    @Override
    public Integer getId() {
        return this.id;
    }
}
