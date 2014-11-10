import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A class describing something that can be located on the game board by a {@code Location}.
 */
public class Locatable implements Serializable {
    private Location loc;

    public Locatable() {
        this(null);
    }

    public Locatable(Location loc) {
        this.loc = loc;
    }


    public Location getLoc() {
        return loc;
    }

    /**
     * Sets the location
     * @param loc The location
     */
    public void setLoc(Location loc) {
        this.loc = loc;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
    }
}
