package valueobjects;

/**
 * Value object for seat identifiers.
 */
public final class IdAsiento {
    private final int value;

    public IdAsiento(int value) {
        if (value < 0) throw new IllegalArgumentException("IdAsiento no puede ser negativo");
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public String toString() { return Integer.toString(value); }
}
