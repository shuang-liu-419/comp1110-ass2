package comp1110.ass2;

public enum Rotate {
    N(0),
    E(270),
    S(180),
    W(90);

    // value of the angle in the form of an int (primitive Integer)
    public final int value;

    /**
     * Constructor: creates a new instance of the Rotate class
     *
     * @param rotate
     */
    Rotate(int rotate) {
        this.value = rotate;
    }

    /**
     * Convert value in degrees into a cardinal direction
     *
     * @param value in degrees must be non-negative, can be over 360
     * @return new cardinal direction if angle divisible by 90, else null
     */
    public static Rotate getAngleFromValue(int value) {
        assert value >= 0;
        value = value % 360;
        for (Rotate direction : Rotate.values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        return null;
    }

    /**
     * Adds this angle to another angle
     * @param other the other angle
     * @return new angle that is the sum of both
     */
    public Rotate add(Rotate other) {
        return getAngleFromValue(this.value + other.value);
    }




}