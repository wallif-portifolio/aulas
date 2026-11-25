# Controle Financeiro Simples - Terminal

Projeto introdutório em Java 17+, sem interface gráfica, API ou banco de dados.

## Como executar

Na pasta do projeto, compile:

```bash
javac -encoding UTF-8 -d out src/main/java/financeiro/Lancamento.java src/main/java/financeiro/estruturas/*.java src/main/java/financeiro/algoritmos/*.java src/main/java/financeiro/ServicoFinanceiro.java src/main/java/financeiro/Main.java
```

Depois execute:

```bash
java -cp out financeiro.Main
```

## Uso
- Escolha adicionar receita ou despesa.
- Selecione uma categoria pronta.
- Digite somente o valor.
- Consulte lançamentos e saldo.
- Use a opção 5 para acompanhar a ordenação dos lançamentos pelo algoritmo Merge Sort.

## Estruturas de dados
- **Lista encadeada:** mantém os lançamentos cadastrados.
- **Pilha:** mantém um histórico interno das inclusões (LIFO).
- **Fila:** mantém uma fila interna na ordem de cadastro (FIFO).

## Algoritmos
- **Merge Sort:** usado na opção 5. Divide a lista em partes menores, ordena essas partes e depois intercala os elementos em ordem. Seu tempo de execução é O(n log n) em todos os casos.
- **Bubble Sort:** mantido como implementação de comparação em `algoritmos/BubbleSort.java`. Seu tempo é O(n²) no caso médio e no pior caso, por isso não é o escolhido para a funcionalidade principal.

Os dados são mantidos apenas enquanto o programa está aberto. Ao encerrar, são apagados.
