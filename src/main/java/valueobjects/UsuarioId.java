package valueobjects;

public final class UsuarioId {
    private final String value;

    public UsuarioId(String value) {
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException("IdUsuario inválido");
        this.value = value;
    }

    public String getValue() { return value; }

    @Override
    public String toString() { return value; }
}
