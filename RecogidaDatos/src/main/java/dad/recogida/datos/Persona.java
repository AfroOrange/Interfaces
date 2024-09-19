package dad.recogida.datos;

// Bean --> nombre dado a este tipo de clases donde solo tenemos getter y setter
public class Persona {

    // si eliges 'private transient' no se transcribirá el dato en el json
    private String nombre;
    private String apellidos;
    private Integer edad = null; // El tipo Integer se puede inicializara a 'null'

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
