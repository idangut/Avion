import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Duvan
 */
public class Silla {
    private float precio;
    private String codigo;
    private List<Persona> persona;

    public Silla(float precio, String codigo) {
        this.precio = precio;
        this.codigo = codigo;
        this.persona = new ArrayList<>();
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the persona
     */
    public List<Persona> getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }

    
}
