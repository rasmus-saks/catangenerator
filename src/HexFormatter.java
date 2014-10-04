import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HexFormatter {
    private static Comparator<Locatable> comp = new Comparator<Locatable>() {
        @Override
        public int compare(Locatable h1, Locatable h2) {
            Location l1 = h1.getLoc();
            Location l2 = h2.getLoc();
            if(l1.getY() > l2.getY()) {
                return 1;
            } else if (l1.getY() < l2.getY()) {
                return -1;
            } else {
                if(l1.getX() > l2.getX()) {
                    return 1;
                } else if(l1.getX() < l2.getX()) {
                    return -1;
                }
            }
            return 0;
        }
    };
    private static Comparator<Location> compLoc = new Comparator<Location>() {
        @Override
        public int compare(Location l1, Location l2) {
            if(l1.getY() > l2.getY()) {
                return 1;
            } else if (l1.getY() < l2.getY()) {
                return -1;
            } else {
                if(l1.getX() > l2.getX()) {
                    return 1;
                } else if(l1.getX() < l2.getX()) {
                    return -1;
                }
            }
            return 0;
        }
    };

    private static String getHexDisplayText(Hex h, int width) {
        //Find the number plate of the hex
        String num = "";
        if(h != null && h.getNumber() != null)
            num = String.valueOf(h.getNumber().getValue());

        //Figure out what to display on the grid
        String s = "";
        if(h != null) {
            s = num + h.getType().getDisplay();
            //s = h.getType().getDisplay() + loc.toString();
        }
        //Print out the text centered.
        return StringUtils.center(s, width);
    }
    /**
     * Prints the given list of hexes and the corresponding numbers.
     *
     * BROKEN :(
     * @param hexes List of hexes to display
     */
    public static void displayHexes(List<Hex> hexes) {
        //Sort by Y and then X descendingly
        Collections.sort(hexes, comp);
        Collections.sort(CatanGenerator.ALL_LOCATIONS, compLoc);

        int lastY = -1;
        //Couple of constants
        final int width = 15;
        String emptyHex = StringUtils.repeat(" ", width);
        String halfEmptyHex = StringUtils.repeat(" ", width/2);

        String[] text = new String[7];

        for(int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x ++) {
                Hex h = getHexAt(hexes, new Location(x, y));
                System.out.print(getHexDisplayText(h, width));
            }
            System.out.println();
            for (int x = 0; x < 7; x += 2) {
                Hex h = getHexAt(hexes, new Location(x, y+1));
                System.out.print(getHexDisplayText(h, width));
            }
            System.out.println();
        }

        /*for (Location loc : CatanGenerator.ALL_LOCATIONS) {
            Hex h = getHexAt(hexes, loc);

            //If we started a new line
            if(loc.getY() != lastY) {
                System.out.println(); //End the last line
                if(loc.getX() % 2 == 1) {
                    System.out.print(halfEmptyHex); //Shift every other row to match how hex grid displays
                }
            }




            lastY = loc.getY();
        }*/
    }

    /**
     * Find a hex at the given location
     * @param hexes A list of hexes
     * @param loc The location to look for
     * @return The hex which is located at the given location or {@code null} otherwise.
     */
    private static Hex getHexAt(List<Hex> hexes, Location loc) {
        for (Hex h : hexes) {
            if(h.getLoc().equals(loc))
                return h;
        }
        return null;
    }
}
