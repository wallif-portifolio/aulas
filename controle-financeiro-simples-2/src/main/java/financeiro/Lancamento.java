package financeiro;

import java.time.LocalDate;

public class Lancamento {
    private static int proximoId = 1;
    private final int id;
    private final String tipo;
    private final String categoria;
    private final double valor;
    private final LocalDate data;

    public Lancamento(String tipo, String categoria, double valor) {
        this.id = proximoId++;
        this.tipo = tipo;
        this.categoria = categoria;
        this.valor = valor;
        this.data = LocalDate.now();
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getCategoria() { return categoria; }
    public double getValor() { return valor; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return String.format("#%d | %-8s | %-18s | R$ %8.2f | %s",
                id, tipo, categoria, valor, data);
    }
}
