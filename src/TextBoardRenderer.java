public class TextBoardRenderer implements BoardRenderer {
    GameBoard hexes;
    @Override
    public void render(GameBoard hexes) {
        this.hexes = hexes;
        //Print out the legend
        System.out.println();
        System.out.println("Legend:");
        String last = "";
        int cols = 3;
        int colw = 25;
        for (int i = 0; i < HexType.values().length; i++) {
            HexType t = HexType.values()[i];
            if (i % cols == 0) {
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
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3, 0)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2, 0)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4, 0)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1, 1)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3, 1)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5, 1)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3, 1)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0, 1)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2, 1)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4, 1)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6, 1)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2, 1)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4, 1)), 2),//wait 13
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(1, 2)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3, 2)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(5, 2)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1, 2)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3, 2)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5, 2)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0, 2)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2, 2)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4, 2)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6, 2)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2, 2)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4, 2)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(1, 3)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3, 3)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(5, 3)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1, 3)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3, 3)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5, 3)), 2), //wait 31
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0, 3)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2, 3)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4, 3)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6, 3)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2, 3)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4, 3)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(1, 4)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3, 4)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(5, 4)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1, 4)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3, 4)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5, 4)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(0, 4)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(2, 4)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(4, 4)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(6, 4)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2, 4)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4, 4)), 2), //wait 48
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(1, 5)), 2),
                HexUtils.getHexNumber(HexUtils.getHexAt(hexes, new Location(3, 5)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(5, 5)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3, 5)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(2, 5)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(4, 5)), 2),
                HexUtils.getHexType(HexUtils.getHexAt(hexes, new Location(3, 6)), 2));
    }

    @Override
    public void regenerated(GameBoard hexes) {

    }

}
