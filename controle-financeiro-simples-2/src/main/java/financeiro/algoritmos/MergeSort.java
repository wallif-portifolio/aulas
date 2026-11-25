package financeiro.algoritmos;

import financeiro.Lancamento;
import java.util.ArrayList;
import java.util.List;

/**
 * Merge Sort manual para ordenar lançamentos pelo valor.
 * Complexidade: O(n log n) em melhor, médio e pior caso.
 */
public class MergeSort {

    public static class Resultado {
        private final List<Lancamento> lancamentos;
        private final long comparacoes;
        private final List<String> etapas;

        public Resultado(List<Lancamento> lancamentos, long comparacoes, List<String> etapas) {
            this.lancamentos = lancamentos;
            this.comparacoes = comparacoes;
            this.etapas = etapas;
        }

        public List<Lancamento> getLancamentos() { return lancamentos; }
        public long getComparacoes() { return comparacoes; }
        public List<String> getEtapas() { return etapas; }
    }

    public static Resultado ordenarComEtapas(List<Lancamento> original) {
        List<Lancamento> dados = new ArrayList<>(original);
        List<String> etapas = new ArrayList<>();
        long[] comparacoes = {0};

        if (dados.isEmpty()) {
            etapas.add("Não há lançamentos para ordenar.");
            return new Resultado(dados, 0, etapas);
        }

        etapas.add("Início: " + resumir(dados));
        ordenar(dados, 0, dados.size() - 1, comparacoes, etapas);
        etapas.add("Resultado final: " + resumir(dados));

        return new Resultado(dados, comparacoes[0], etapas);
    }

    private static void ordenar(List<Lancamento> dados, int inicio, int fim,
                                 long[] comparacoes, List<String> etapas) {
        if (inicio >= fim) return;

        int meio = inicio + (fim - inicio) / 2;
        etapas.add("Dividindo posições " + inicio + " a " + fim
                + " em [" + inicio + ".." + meio + "] e ["
                + (meio + 1) + ".." + fim + "].");

        ordenar(dados, inicio, meio, comparacoes, etapas);
        ordenar(dados, meio + 1, fim, comparacoes, etapas);
        intercalar(dados, inicio, meio, fim, comparacoes, etapas);
    }

    private static void intercalar(List<Lancamento> dados, int inicio, int meio, int fim,
                                   long[] comparacoes, List<String> etapas) {
        List<Lancamento> esquerda = new ArrayList<>(dados.subList(inicio, meio + 1));
        List<Lancamento> direita = new ArrayList<>(dados.subList(meio + 1, fim + 1));

        int i = 0, j = 0, k = inicio;

        while (i < esquerda.size() && j < direita.size()) {
            comparacoes[0]++;
            if (esquerda.get(i).getValor() <= direita.get(j).getValor()) {
                dados.set(k++, esquerda.get(i++));
            } else {
                dados.set(k++, direita.get(j++));
            }
        }

        while (i < esquerda.size()) dados.set(k++, esquerda.get(i++));
        while (j < direita.size()) dados.set(k++, direita.get(j++));

        etapas.add("Intercalando posições " + inicio + " a " + fim
                + " em ordem crescente: " + resumir(dados.subList(inicio, fim + 1)));
    }

    private static String resumir(List<Lancamento> dados) {
        List<String> valores = new ArrayList<>();
        for (Lancamento l : dados) {
            valores.add("R$ " + String.format("%.2f", l.getValor()));
        }
        return valores.toString();
    }
}
