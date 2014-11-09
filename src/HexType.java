import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * An enum containing all the types of hexes there are.
 */
public enum HexType {
    WOOD("P", "Puit", Color.BROWN),
    CROPS("V", "Vili", Color.YELLOW),
    SHEEP("L", "Lammas", Color.GREEN),
    ORE("M", "Maak", Color.GRAY),
    CLAY("S", "Savi", Color.ORANGE),
    DESERT("K", "Kõrb", Color.BEIGE),
    SEA("O", "Ookean", Color.BLUE),
    TRADE_WOOD("P2", "2:1 Puit",Color.BLUE.darker().desaturate()),
    TRADE_CROPS("V2", "2:1 Vili", Color.BLUE.darker().desaturate()),
    TRADE_SHEEP("L2", "2:1 Lammas",Color.BLUE.darker().desaturate()),
    TRADE_ORE("M2", "2:1 Maak",Color.BLUE.darker().desaturate()),
    TRADE_CLAY("S2", "2:1 Savi",Color.BLUE.darker().desaturate()),
    TRADE_ANY("?3", "3:1 Kõik",Color.BLUE.darker().desaturate());
    private String display;
    private String name;
    private Paint color;

    HexType(String display, String name, Paint color) {
        this.display = display;
        this.name = name;
        this.color = color;
    }

    public Paint getColor() { return color;}

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
