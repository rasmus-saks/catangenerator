import java.util.*;

public class CatanGenerator {
    public static List<Hex> LAND_HEXES = new ArrayList<Hex>();
    public static List<Hex> SEA_HEXES = new ArrayList<Hex>();
    public static List<Number> ALL_NUMBERS = new ArrayList<Number>();
    public static List<Location> SEA_LOCATIONS = new ArrayList<Location>();
    public static List<Location> LAND_LOCATIONS = new ArrayList<Location>();
    public static List<Location> ALL_LOCATIONS = new ArrayList<Location>();

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
        SEA_LOCATIONS.add(new Location(2, 0));
        SEA_LOCATIONS.add(new Location(4, 0));

        SEA_LOCATIONS.add(new Location(0, 1));
        SEA_LOCATIONS.add(new Location(1, 1));
        SEA_LOCATIONS.add(new Location(5, 1));
        SEA_LOCATIONS.add(new Location(6, 1));

        SEA_LOCATIONS.add(new Location(0, 2));
        SEA_LOCATIONS.add(new Location(6, 2));

        SEA_LOCATIONS.add(new Location(0, 3));
        SEA_LOCATIONS.add(new Location(6, 3));

        SEA_LOCATIONS.add(new Location(0, 4));
        SEA_LOCATIONS.add(new Location(6, 4));

        SEA_LOCATIONS.add(new Location(1, 5));
        SEA_LOCATIONS.add(new Location(2, 5));
        SEA_LOCATIONS.add(new Location(4, 5));
        SEA_LOCATIONS.add(new Location(5, 5));

        SEA_LOCATIONS.add(new Location(3, 6));


        LAND_LOCATIONS.clear();
        int[] xs = new int[]{2, 1, 1, 1, 2};
        int[] ln = new int[]{3, 4, 5, 4, 3};
        for (int i = 0; i < xs.length; i++) {
            for (int y = xs[i]; y < xs[i] + ln[i]; y++) {
                LAND_LOCATIONS.add(new Location(i+1, y));
            }
        }

        //All locations
        ALL_LOCATIONS.clear();
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("|       Katani Asustajate mänguvälja generaator    |");
        System.out.println("|     Autorid: Rasmus Saks ja Al William Tammsaar  |");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("Milline mänguväli genereerida?");
        System.out.print("Suvaline(S)/Aus(A):");

        //Print out what kind of board we are going to generate
        System.out.print("Genereerin ");
        Generator gen = new RandomGenerator();
        String type = "s";
        //String type = sc.nextLine();
        //Parse the input given by the user and select a generator
        if (type.equals("s") || type.equals("suvaline")) {
            System.out.print("SUVALISE");
            gen = new RandomGenerator();

        } else if (type.equals("a") || type.equals("aus")) {
            System.out.print("AUSA");
        }
        System.out.println(" mänguvälja.");
        System.out.println();

        //Reset the defaults
        generateDefaultHexes();
        generateDefaultNumbers();
        generateLocations();

        //Generate the hexes using the selected generator
        List<Hex> hexes = gen.generateHexes();
        System.out.println();

        //Print out the legend
        System.out.println("Legend:");
        String last = "";
        int cols = 3;
        int colw = 25;
        for (int i = 0; i < HexType.values().length; i++) {
            HexType t = HexType.values()[i];
            if(i % cols == 0) {
                last = "";
            }
            //If we're not at the start of the line,
            //print spaces to align the text we're going to write.
            if (i % cols != 0) {
                System.out.print(StringUtils.repeat(" ", colw - last.length()));
            }
            //Get the text to display
            String cur = t.getDisplay() + StringUtils.repeat(" ", 2 - t.getDisplay().length()) + ": " + t.getName();
            last = cur;
            System.out.print(cur);
            //If we're at the last column to print, end the line.
            if (i % cols == (cols - 1)) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Number enne tähist näitab numbriketta väärtust ruudul.");

        //Display the generated hexes.
        BoardRenderer renderer = new TextBoardRenderer(hexes);
        renderer.render();
    }
}