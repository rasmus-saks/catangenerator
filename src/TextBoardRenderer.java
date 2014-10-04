import java.util.List;

/**
 * Created by Al William "Rezo" Tammsaar on 10/4/2014.
 */
public class TextBoardRenderer extends BoardRenderer{
    List<Hex> hexes;

    public TextBoardRenderer(List<Hex> hexes) {
        this.hexes = hexes;
    }

    public void renderexample() {
        System.out.println();
        System.out.println("                    ____\n" +
                "                   /    \\\n" +
                "              ____/  ?3  \\____\n" +
                "             /    \\      /    \\\n" +
                "        ____/   0  \\____/   0  \\____\n" +
                "       /    \\      /    \\      /    \\\n" +
                "  ____/   0  \\____/   9  \\____/   0  \\____\n" +
                " /    \\      /    \\   M  /    \\      /    \\\n" +
                "/   0  \\____/   4  \\____/   5  \\____/   0  \\\n" +
                "\\      /    \\   L  /    \\   S  /    \\      /\n" +
                " \\____/   4  \\____/   9  \\____/   3  \\____/\n" +
                " /    \\   L  /    \\   V  /    \\   P  /    \\\n" +
                "/   0  \\____/   3  \\____/  10  \\____/  M2  \\\n" +
                "\\      /    \\   V  /    \\   P  /    \\      /\n" +
                " \\____/  12  \\____/   7  \\____/   5  \\____/\n" +
                " /    \\   L  /    \\   M  /    \\   L  /    \\\n" +
                "/  L2  \\____/   5  \\____/   7  \\____/  V2  \\\n" +
                "\\      /    \\   S  /    \\   M  /    \\      /\n" +
                " \\____/   8  \\____/   8  \\____/  10  \\____/\n" +
                " /    \\   V  /    \\   V  /    \\   S  /    \\\n" +
                "/  S2  \\____/   6  \\____/   2  \\____/  ?3  \\\n" +
                "\\      /    \\   P  /    \\   P  /    \\      /\n" +
                " \\____/   0  \\____/      \\____/   0  \\____/\n" +
                "      \\      /    \\   K  /    \\      /\n" +
                "       \\____/  M2  \\____/  P2  \\____/\n" +
                "            \\      /    \\      /\n" +
                "             \\____/   0  \\____/\n" +
                "                  \\      /\n" +
                "                   \\____/\n");
    }

    @Override
    public void render() {
        System.out.printf("                    ____\n" +
                "                   /    \\\n" +
                "              ____/  %s  \\____\n" +
                "             /    \\      /    \\\n" +
                "        ____/  %s  \\____/  %s  \\____\n" +
                "       /    \\      /    \\      /    \\\n" +
                "  ____/  %s  \\____/  %s  \\____/  %s  \\____\n" +
                " /    \\      /    \\  %s  /    \\      /    \\\n" +
                "/  %s  \\____/  %s  \\____/  %s  \\____/  %s  \\\n" +
                "\\      /    \\  %s  /    \\  %s  /    \\      /\n" +
                " \\____/  %s  \\____/  %s  \\____/  %s  \\____/\n" +
                " /    \\  %s  /    \\  %s  /    \\  %s  /    \\\n" +
                "/  %s  \\____/  %s  \\____/  %s  \\____/  %s  \\\n" +
                "\\      /    \\  %s  /    \\  %s  /    \\      /\n" +
                " \\____/  %s  \\____/  %s  \\____/  %s  \\____/\n" +
                " /    \\  %s  /    \\  %s  /    \\  %s  /    \\\n" +
                "/  %s  \\____/  %s  \\____/  %s  \\____/  %s  \\\n" +
                "\\      /    \\  %s  /    \\  %s  /    \\      /\n" +
                " \\____/  %s  \\____/  %s  \\____/  %s  \\____/\n" +
                " /    \\  %s  /    \\  %s  /    \\  %s  /    \\\n" +
                "/  %s  \\____/  %s  \\____/  %s  \\____/  %s  \\\n" +
                "\\      /    \\  %s  /    \\  %s  /    \\      /\n" +
                " \\____/  %s  \\____/  %s  \\____/  %s  \\____/\n" +
                "      \\      /    \\  %s  /    \\      /\n" +
                "       \\____/  %s  \\____/  %s  \\____/\n" +
                "            \\      /    \\      /\n" +
                "             \\____/  %s  \\____/\n" +
                "                  \\      /\n" +
                "                   \\____/\n",
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3,0)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2,0)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4,0)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1,1)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3,1)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5,1)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3,1)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0,1)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2,1)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4,1)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6,1)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2,1)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4,1)),2),//wait 13
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(1,2)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3,2)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(5,2)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1,2)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3,2)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5,2)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0,2)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2,2)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4,2)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6,2)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2,2)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4,2)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(1,3)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3,3)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(5,3)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1,3)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3,3)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5,3)),2), //wait 31
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0,3)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2,3)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4,3)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6,3)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2,3)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4,3)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(1,4)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3,4)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(5,4)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1,4)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3,4)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5,4)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0,4)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2,4)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4,4)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6,4)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2,4)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4,4)),2), //wait 48
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1,5)),2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3,5)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5,5)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3,5)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2,5)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4,5)),2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3,6)),2));
    }

}
