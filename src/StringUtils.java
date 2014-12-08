public class StringUtils {

    /**
     * Center a string with spaces at either side
     * @param s The string
     * @param size The width of the generated string
     * @return The given string {@code s}, centered
     */
    public static String center(String s, int size) {
        return center(s, size, " ");
    }

    /**
     * Center a string with a given padding to the given width
     * @param s The string
     * @param size The width of the generated string
     * @param pad The padding
     * @return The given string centered.
     */
    public static String center(String s, int size, String pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }

    /**
     * Repeats a given string
     * @param s The string to repeat
     * @param n The number of times to repeat the string
     * @return The string {@code s} repeated {@code n} times.
     */
    public static String repeat(String s, int n) {
        String ret = "";
        for (int i = 0; i < n; i++) {
            ret += s;
        }
        return ret;
    }

    /**
     * Inserts spaces before a string in order to make it align with everything else
     * @param s the string that has to be padded from the front
     * @param width the total character width to be returned
     *              (has to always be more or equal to the length of s for desired effect)
     * @return The original string (@code s) with the certain entered character width (@code width)
     */
    public static String frontpadder(String s, int width){
        StringBuilder backstring = new StringBuilder();
        backstring.append(repeat(" ",width-s.length()));
        backstring.append(s);
        return backstring.toString();
    }
}