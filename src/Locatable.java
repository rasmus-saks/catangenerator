/**
 * A class describing something that can be located on the game board by a {@code Location}.
 */
public class Locatable {
    private Location loc;

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
}
