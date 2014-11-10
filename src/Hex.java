/**
 * Represents an element on a hex grid
 */
public class Hex extends Locatable{
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

    public Hex() {
        this(null, null);
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hex hex = (Hex) o;

        if (number != null ? !number.equals(hex.number) : hex.number != null) return false;
        if (type != hex.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}