package valueobjects;

/**
 * Value object for report complexity with basic validation.
 */
public final class Complejidad {
    private final int value;

    public Complejidad(int value) {
        if (value < 0) throw new IllegalArgumentException("Complejidad no puede ser negativa");
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public String toString() { return Integer.toString(value); }
}
