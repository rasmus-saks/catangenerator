import java.util.List;

public class HexUtils {
    /**
     * Gets a String describing the given hex padded to the given width. The text will be centered in the String, surrounded by spaces.
     *
     * @param h     The hex to describe
     * @param width The width to pad the text to
     * @return A textual representation of the hex (e.g. 12V or ?3) centered in a string of the given width, padded with spaces on both sides.<p/>
     * A width of 7 with a Clay Hex with number 12 would yield the String "  12S  "
     */
    public static String getHexDisplayText(Hex h, int width) {
        //Find the number plate of the hex
        String num = "";
        if (h != null && h.getNumber() != null)
            num = String.valueOf(h.getNumber().getValue());

        //Figure out what to display on the grid
        String s = "";
        if (h != null) {
            s = num + h.getType().getDisplay();
            //s = h.getType().getDisplay() + loc.toString();
        }
        //Print out the text centered.
        return StringUtils.center(s, width);
    }

    /**
     * Find a hex at the given location
     *
     * @param hexes A list of hexes
     * @param loc   The location to look for
     * @return The hex which is located at the given location or {@code null} otherwise.
     */
    public static Hex getHexAt(List<Hex> hexes, Location loc) {
        for (Hex h : hexes) {
            if (h.getLoc().equals(loc))
                return h;
        }
        return null;
    }

    public static String getHexNumber(Hex hex,int width) {
        //Find the number plate of the hex
        String num = "  ";
        if (hex != null && hex.getNumber() != null) {
            num = StringUtils.frontpadder(String.valueOf(hex.getNumber().getValue()), 2);
        }
        return num;
    }
    public static String getHexType(Hex hex,int width) {
        //Figure out what to display on the grid
        String type = "  ";
        if (hex != null) {
            type = StringUtils.frontpadder(hex.getType().getDisplay(),2);
            //s = h.getType().getDisplay() + loc.toString();
        }
        return type;
    }
}
