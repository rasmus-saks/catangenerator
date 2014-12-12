import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Number extends Locatable implements Serializable {
    private int value;

    public int getValue() {
        return value;
    }

    public Number(Location loc, int value) {
        super(loc);
        this.value = value;
    }


    @Override
    public String toString() {
        return "Number{" +
                "loc=" + getLoc() +
                ", value=" + value +
                '}';
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return value == number.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
