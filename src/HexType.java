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
    SEA("O", "Ookean", Color.color(17.0 / 255, 73.0 / 255, 186.0 / 255)),
    TRADE_WOOD("P2", "2:1\nPuit", Constants.TRADEHEX_COLOR),
    TRADE_CROPS("V2", "2:1\nVili", Constants.TRADEHEX_COLOR),
    TRADE_SHEEP("L2", "2:1\nLammas", Constants.TRADEHEX_COLOR),
    TRADE_ORE("M2", "2:1\nMaak", Constants.TRADEHEX_COLOR),
    TRADE_CLAY("S2", "2:1\nSavi", Constants.TRADEHEX_COLOR),
    TRADE_ANY("?3", "3:1\nKõik", Constants.TRADEHEX_COLOR);
    private String display;
    private String name;
    private Paint color;

    HexType(String display, String name, Paint color) {
        this.display = display;
        this.name = name;
        this.color = color;
    }

    public Paint getColor() {
        return color;
    }

    /**
     * Gets the short name of this HexType, suitable for displaying in a text grid.
     *
     * @return
     */
    public String getDisplay() {
        return display;
    }

    /**
     * Gets a list of hexes there are 3 of each.
     *
     * @return
     */
    public static HexType[] getCommonHexes() {
        return new HexType[]{WOOD, CROPS, SHEEP};
    }

    /**
     * Gets a list of land hexes there are 2 of each.
     *
     * @return
     */
    public static HexType[] getRareHexes() {
        return new HexType[]{ORE, CLAY};
    }

    /**
     * Gets a list of trade hexes that only one of exists on the board.
     *
     * @return
     */
    public static HexType[] getSingleTrades() {
        return new HexType[]{TRADE_CLAY, TRADE_CROPS, TRADE_WOOD, TRADE_SHEEP, TRADE_ORE};
    }

    /**
     * Gets the full name of the hex type.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    private static class Constants {
        public static final Color TRADEHEX_COLOR = Color.color(51.0 / 255, 128.0 / 255, 255.0 / 255d);
    }
}
