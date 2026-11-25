package financeiro.estruturas;

import java.util.ArrayDeque;
import java.util.Queue;

/* Fila FIFO: mantém lançamentos na ordem em que foram cadastrados. */
public class Fila<T> {
    private final Queue<T> itens = new ArrayDeque<>();
    public void adicionar(T item) { itens.offer(item); }
    public T proximo() { return itens.poll(); }
}
