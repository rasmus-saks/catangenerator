/**
 * An enum containing all the types of hexes there are.
 */
public enum HexType {
    WOOD("P", "Puit"),
    CROPS("V", "Vili"),
    SHEEP("L", "Lammas"),
    ORE("M", "Maak"),
    CLAY("S", "Savi"),
    DESERT("K", "Kõrb"),
    SEA("O", "Ookean"),
    TRADE_WOOD("P2", "2:1 Puit"),
    TRADE_CROPS("V2", "2:1 Vili"),
    TRADE_SHEEP("L2", "2:1 Lammas"),
    TRADE_ORE("M2", "2:1 Maak"),
    TRADE_CLAY("S2", "2:1 Savi"),
    TRADE_ANY("?3", "3:1 Kõik");
    private String display;
    private String name;

    HexType(String display, String name) {
        this.display = display;
        this.name = name;
    }

    /**
     * Gets the short name of this HexType, suitable for displaying in a text grid.
     * @return
     */
    public String getDisplay() {
        return display;
    }

    /**
     * Gets a list of hexes there are 3 of each.
     * @return
     */
    public static HexType[] getCommonHexes() {
        return new HexType[] {WOOD, CROPS, SHEEP};
    }

    /**
     * Gets a list of land hexes there are 2 of each.
     * @return
     */
    public static HexType[] getRareHexes() {
        return new HexType[] {ORE, CLAY};
    }

    /**
     * Gets a list of trade hexes that only one of exists on the board.
     * @return
     */
    public static HexType[] getSingleTrades() {
        return new HexType[] {TRADE_CLAY, TRADE_CROPS, TRADE_WOOD, TRADE_SHEEP, TRADE_ORE};
    }

    /**
     * Gets the full name of the hex type.
     * @return
     */
    public String getName() {
        return name;
    }
}
