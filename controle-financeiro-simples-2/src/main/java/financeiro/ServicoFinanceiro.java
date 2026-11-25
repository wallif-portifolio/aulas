package financeiro;

import financeiro.estruturas.ListaEncadeada;
import financeiro.estruturas.Pilha;
import financeiro.estruturas.Fila;
import java.util.List;

public class ServicoFinanceiro {
    private final ListaEncadeada lancamentos = new ListaEncadeada();
    private final Pilha<Lancamento> historico = new Pilha<>();
    private final Fila<Lancamento> filaCadastro = new Fila<>();

    public void adicionar(String tipo, String categoria, double valor) {
        Lancamento novo = new Lancamento(tipo, categoria, valor);
        lancamentos.adicionar(novo);
        historico.empilhar(novo);
        filaCadastro.adicionar(novo);
    }

    public List<Lancamento> listar() { return lancamentos.listar(); }
    public int quantidade() { return lancamentos.tamanho(); }

    public double total(String tipo) {
        double soma = 0;
        for (Lancamento l : lancamentos.listar()) {
            if (l.getTipo().equals(tipo)) soma += l.getValor();
        }
        return soma;
    }
}
