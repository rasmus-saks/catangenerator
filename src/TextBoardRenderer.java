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

    }

}
