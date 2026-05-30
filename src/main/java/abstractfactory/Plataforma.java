package abstractfactory;

public enum Plataforma {
    WINDOWS("windows", "Windows"),
    MAC("mac", "Mac");

    private final String codigo;
    private final String nome;

    Plataforma(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static Plataforma from(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("Plataforma nao informada.");
        }

        for (Plataforma plataforma : values()) {
            if (plataforma.codigo.equalsIgnoreCase(valor.trim())
                    || plataforma.nome.equalsIgnoreCase(valor.trim())) {
                return plataforma;
            }
        }

        throw new IllegalArgumentException(
                "Plataforma invalida: '" + valor + "'. Use: windows ou mac."
        );
    }

    public static Plataforma detectarSistema() {
        String os = System.getProperty("os.name", "").toLowerCase();

        if (os.contains("mac") || os.contains("darwin")) {
            return MAC;
        }

        return WINDOWS;
    }
}
