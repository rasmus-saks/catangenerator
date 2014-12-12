public class HexUtils {
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
}
