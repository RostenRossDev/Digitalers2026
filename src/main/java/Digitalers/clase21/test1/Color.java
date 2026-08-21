package Digitalers.clase21.test1;

public enum Color {
    AZUL("#345534", "Azul", "Es muy azul"),
    ROJO("#984578", "Rojo", "Es muy rojo"),
    verde("#345534", "Azul", "Es muy azul"),
    Amarillo("#345534", "Azul", "Es muy azul"),
    Purpura("#345534", "Azul", "Es muy azul");

    private String hex;
    private String name;
    private String descripcion;
    private Color(String hex, String name, String descripcion) {
        this.hex=hex;
        this.name=name;
        this.descripcion=descripcion;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

