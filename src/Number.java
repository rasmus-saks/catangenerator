public class Number extends Locatable {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
}
