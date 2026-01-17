package valueobjects;

public final class Email {
    private final String value;

    public Email(String value) {
        if (value == null || !value.contains("@") || value.trim().length() < 3) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.value = value;
    }

    public String getValue() { return value; }

    @Override
    public String toString() { return value; }
}
