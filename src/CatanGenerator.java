import java.io.*;
import java.util.*;

public class CatanGenerator {
    public static List<Hex> LAND_HEXES = new ArrayList<>();
    public static List<Hex> SEA_HEXES = new ArrayList<>();
    public static List<Number> ALL_NUMBERS = new ArrayList<>();
    public static List<Location> SEA_LOCATIONS = new ArrayList<>();
    public static List<Location> LAND_LOCATIONS = new ArrayList<>();
    public static List<Location> ALL_LOCATIONS = new ArrayList<>();
    public static BoardRenderer renderer = new JFXBoardRenderer();
    private static GameBoard gameBoard;

    /**
     * Regenerates the lists {@link #SEA_HEXES} and {@link #LAND_HEXES}.
     */
    public static void generateDefaultHexes() {
        LAND_HEXES.clear();
        SEA_HEXES.clear();

        //Land hexes
        for (HexType type : HexType.getCommonHexes()) {
            for (int i = 0; i < 4; i++) {
                LAND_HEXES.add(new Hex(new Location(0, 0), type));
            }
        }

        for (HexType type : HexType.getRareHexes()) {
            for (int i = 0; i < 3; i++) {
                LAND_HEXES.add(new Hex(new Location(0, 0), type));
            }
        }

        LAND_HEXES.add(new Hex(new Location(0, 0), HexType.DESERT));

        //Sea hexes
        for (HexType t : HexType.getSingleTrades()) {
            SEA_HEXES.add(new Hex(new Location(0, 0), t));
        }
        for (int i = 0; i < 4; i++) {
            SEA_HEXES.add(new Hex(new Location(0, 0), HexType.TRADE_ANY));
        }
        for (int i = 0; i < 9; i++) {
            SEA_HEXES.add(new Hex(new Location(0, 0), HexType.SEA));
        }


    }

    /**
     * Regenerates the lists {@link #SEA_LOCATIONS} and {@link #LAND_LOCATIONS}.
     */
    public static void generateLocations() {
        SEA_LOCATIONS.clear();
        SEA_LOCATIONS.add(new Location(3, 0));

        SEA_LOCATIONS.add(new Location(2, 1));
        SEA_LOCATIONS.add(new Location(4, 1));

        SEA_LOCATIONS.add(new Location(1, 2));
        SEA_LOCATIONS.add(new Location(5, 2));

        SEA_LOCATIONS.add(new Location(0, 3));
        SEA_LOCATIONS.add(new Location(6, 3));

        SEA_LOCATIONS.add(new Location(0, 5));
        SEA_LOCATIONS.add(new Location(6, 5));

        SEA_LOCATIONS.add(new Location(0, 7));
        SEA_LOCATIONS.add(new Location(6, 7));

        SEA_LOCATIONS.add(new Location(0, 9));
        SEA_LOCATIONS.add(new Location(6, 9));

        SEA_LOCATIONS.add(new Location(1, 10));
        SEA_LOCATIONS.add(new Location(5, 10));

        SEA_LOCATIONS.add(new Location(2, 11));
        SEA_LOCATIONS.add(new Location(4, 11));

        SEA_LOCATIONS.add(new Location(3, 12));


        LAND_LOCATIONS.clear();
        int[] width = {1, 2, 2, 2, 2, 2, 2, 2, 1};
        for (int y = 2; y < 11; y++) {
            for (int x = 3 - width[y - 2]; x < 3 + width[y - 2] + 1; x++) {
                if (x % 2 == y % 2) continue;
                LAND_LOCATIONS.add(new Location(x, y));
            }
        }

        //All locations
        ALL_LOCATIONS.clear();
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 12; y++) {
                if (x % 2 == y % 2) continue;
                ALL_LOCATIONS.add(new Location(x, y));
            }
        }

    }

    /**
     * Regenerates the list {@link #ALL_NUMBERS}. This list contains all possible number plates.
     */
    public static void generateDefaultNumbers() {
        ALL_NUMBERS.clear();
        for (int i = 3; i < 11; i++) {
            ALL_NUMBERS.add(new Number(new Location(0, 0), i));
            ALL_NUMBERS.add(new Number(new Location(0, 0), i));
        }
        ALL_NUMBERS.add(new Number(new Location(0, 0), 2));
        ALL_NUMBERS.add(new Number(new Location(0, 0), 12));
    }

    public static GameBoard regenerate(long seed) {
        generateDefaultHexes();
        generateDefaultNumbers();
        generateLocations();

        Generator gen = new RandomGenerator(seed);
        gameBoard = gen.generateGameBoard();
        if(renderer != null)
            renderer.regenerated(gameBoard);
        return gameBoard;
    }

    public static void saveBoard(File file) throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(gameBoard);
            os.close();
        }
    }

    public static GameBoard loadBoard(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream os = new ObjectInputStream(new FileInputStream(file))) {
            gameBoard = (GameBoard) os.readObject();
            return gameBoard;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------------------");
        System.out.println("|       Katani Asustajate mänguvälja generaator    |");
        System.out.println("|     Autorid: Rasmus Saks ja Al William Tammsaar  |");
        System.out.println("----------------------------------------------------");
        System.out.println();

        //Generate the hexes using the selected generator
        GameBoard board = regenerate(System.currentTimeMillis());
        //Display the generated hexes.
        /*BoardRenderer renderer = new TextBoardRenderer(hexes);*/
        renderer.render(board);
    }
}