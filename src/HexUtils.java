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
     * @param board The game board
     * @param loc   The location to look for
     * @return The hex which is located at the given location or {@code null} otherwise.
     */
    public static Hex getHexAt(GameBoard board, Location loc) {
        for (Hex h : board.getHexes()) {
            if (h.getLoc().equals(loc))
                return h;
        }
        return null;
    }

    /**
     * Currently unused.
     * Gets the number plate of the hex with front padding.
     * @param hex the hex which contains the number information
     * @param width if the number is not long enough its padded with spaces to be the length of this variable
     * @return the numberplate string with frontpadding.
     */
    public static String getHexNumber(Hex hex,int width) {
        String num = "  ";
        if (hex != null && hex.getNumber() != null) {
            num = StringUtils.frontpadder(String.valueOf(hex.getNumber().getValue()), width);
        }
        return num;
    }
    /**
     * Currently unused.
     * Gets the type of the hex with front padding.
     * @param hex the hex which contains the type information
     * @param width if the type acronym is not long enough its padded with spaces to be the length of this variable
     * @return the type string with frontpadding.
     */
    public static String getHexType(Hex hex,int width) {
        String type = "  ";
        if (hex != null) {
            type = StringUtils.frontpadder(hex.getType().getDisplay(),width);
        }
        return type;
    }
}
