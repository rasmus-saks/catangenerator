/**
 * Represents an element on a hex grid
 */
public class Hex extends Locatable {
    private HexType type;
    private Number number;

    public Hex(Location location, HexType type) {
        this(location, type, null);
    }

    public HexType getType() {
        return type;
    }

    public void setType(HexType type) {
        this.type = type;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Hex(Location loc, HexType type, Number number) {
        super(loc);
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "loc=" + getLoc() +
                ", type=" + type +
                '}';
    }
}