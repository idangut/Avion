import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Duvan
 */
public class Avion {
    protected List<Silla> silla;
    public Avion() {
        silla = new ArrayList<>();
    }

    /**
     * @return the silla
     */
    public List<Silla> getSilla() {
        return silla;
    }

    /**
     * @param silla the silla to set
     */
    public void setSilla(List<Silla> silla) {
        this.silla = silla;
    }
}
