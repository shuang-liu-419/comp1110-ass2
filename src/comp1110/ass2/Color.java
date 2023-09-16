package comp1110.ass2;

import java.util.Arrays;
import java.util.HashMap;

public enum Color {

    CYAN,
    YELLOW,
    PURPLE,
    RED,
    NONE;

    public static final HashMap<Character, Color> CHARACTER_COLOR_HASH_MAP;

    static {
        CHARACTER_COLOR_HASH_MAP = new HashMap<>(5);
        CHARACTER_COLOR_HASH_MAP.put('c', CYAN);
        CHARACTER_COLOR_HASH_MAP.put('y', YELLOW);
        CHARACTER_COLOR_HASH_MAP.put('p', PURPLE);
        CHARACTER_COLOR_HASH_MAP.put('r', RED);
        CHARACTER_COLOR_HASH_MAP.put('n', NONE);
    }

    /**
     *
     * @param c
     * @return
     */
    public static char toChar(Color c) {
        return c.toString().toLowerCase().charAt(0);
    }

    public static Color toColor(char ch) {
//        for (Color color : Color.values()) {
//            if (color.toString().toLowerCase().charAt(0) == ch) return color;
//        }

        if(!CHARACTER_COLOR_HASH_MAP.containsKey(ch))
            throw new IllegalArgumentException("Color not present!");

        return CHARACTER_COLOR_HASH_MAP.get(ch);
    }

    public static boolean isValidColor(char ch) {
//        return Arrays.stream(Color.values()).anyMatch(c -> c.toString().toLowerCase().charAt(0) == ch);
        return CHARACTER_COLOR_HASH_MAP.containsKey(ch);
    }
}
