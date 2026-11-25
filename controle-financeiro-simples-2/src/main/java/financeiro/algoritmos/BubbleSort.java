package financeiro.algoritmos;

import financeiro.Lancamento;
import java.util.ArrayList;
import java.util.List;

/* Bubble Sort manual para ordenar os lançamentos pelo valor. */
public class BubbleSort {
    public static List<Lancamento> ordenar(List<Lancamento> original) {
        List<Lancamento> dados = new ArrayList<>(original);
        for (int i = 0; i < dados.size() - 1; i++) {
            for (int j = 0; j < dados.size() - 1 - i; j++) {
                if (dados.get(j).getValor() > dados.get(j + 1).getValor()) {
                    Lancamento auxiliar = dados.get(j);
                    dados.set(j, dados.get(j + 1));
                    dados.set(j + 1, auxiliar);
                }
            }
        }
        return dados;
    }
}
