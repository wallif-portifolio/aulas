package financeiro.estruturas;

import java.util.ArrayList;
import java.util.List;
import financeiro.Lancamento;

/* Lista encadeada manual: cada nó aponta para o próximo lançamento. */
public class ListaEncadeada {
    private static class No {
        Lancamento lancamento;
        No proximo;
        No(Lancamento lancamento) { this.lancamento = lancamento; }
    }

    private No inicio;
    private int tamanho;

    public void adicionar(Lancamento lancamento) {
        No novo = new No(lancamento);
        if (inicio == null) inicio = novo;
        else {
            No atual = inicio;
            while (atual.proximo != null) atual = atual.proximo;
            atual.proximo = novo;
        }
        tamanho++;
    }

    public List<Lancamento> listar() {
        List<Lancamento> resultado = new ArrayList<>();
        No atual = inicio;
        while (atual != null) {
            resultado.add(atual.lancamento);
            atual = atual.proximo;
        }
        return resultado;
    }

    public int tamanho() { return tamanho; }
}
