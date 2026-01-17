package valueobjects;

/**
 * Value object for prices with basic validation.
 */
public final class Precio {
    private final double value;

    public Precio(double value) {
        if (Double.isNaN(value) || value < 0) throw new IllegalArgumentException("Precio no puede ser negativo o NaN");
        this.value = value;
    }

    public double getValue() { return value; }

    @Override
    public String toString() { return Double.toString(value); }
}
