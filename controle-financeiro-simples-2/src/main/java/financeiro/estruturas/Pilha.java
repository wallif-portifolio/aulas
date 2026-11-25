package financeiro.estruturas;

import java.util.ArrayDeque;
import java.util.Deque;

/* Pilha LIFO: guarda o histórico da última ação registrada. */
public class Pilha<T> {
    private final Deque<T> itens = new ArrayDeque<>();
    public void empilhar(T item) { itens.push(item); }
    public T desempilhar() { return itens.isEmpty() ? null : itens.pop(); }
}
