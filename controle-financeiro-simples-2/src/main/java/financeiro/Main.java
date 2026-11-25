package financeiro;

import java.util.List;
import java.util.Scanner;
import financeiro.algoritmos.MergeSort;

public class Main {
    private static final Scanner entrada = new Scanner(System.in);
    private static final ServicoFinanceiro financeiro = new ServicoFinanceiro();

    public static void main(String[] args) {
        int opcao;
        System.out.println("================================");
        System.out.println("       CONTROLE FINANCEIRO");
        System.out.println("================================");

        do {
            System.out.println("\n1 - Adicionar receita");
            System.out.println("2 - Adicionar despesa");
            System.out.println("3 - Ver lançamentos");
            System.out.println("4 - Ver saldo");
            System.out.println("5 - Ordenar lançamentos (Merge Sort)");
            System.out.println("0 - Sair");
            opcao = lerInteiro("\nEscolha: ");

            switch (opcao) {
                case 1 -> cadastrar("RECEITA");
                case 2 -> cadastrar("DESPESA");
                case 3 -> listar(financeiro.listar());
                case 4 -> mostrarSaldo();
                case 5 -> ordenarLancamentos();
                case 0 -> System.out.println("Programa encerrado!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        entrada.close();
    }

    private static void cadastrar(String tipo) {
        String[] categorias;
        if (tipo.equals("RECEITA")) {
            categorias = new String[]{"Salário", "Renda extra", "Outros"};
            System.out.println("\n--------- RECEITAS ---------");
        } else {
            categorias = new String[]{"Alimentação", "Moradia", "Transporte",
                    "Lazer", "Saúde", "Educação", "Compras", "Outros"};
            System.out.println("\n--------- DESPESAS ---------");
        }

        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + " - " + categorias[i]);
        }

        int escolha = lerInteiro("\nEscolha a categoria: ");
        if (escolha < 1 || escolha > categorias.length) {
            System.out.println("Categoria inválida.");
            return;
        }

        double valor = lerValor("Valor: R$ ");
        if (valor <= 0) {
            System.out.println("O valor precisa ser maior que zero.");
            return;
        }

        financeiro.adicionar(tipo, categorias[escolha - 1], valor);
        System.out.println("\n" + categorias[escolha - 1] + " cadastrado(a) com sucesso!");
    }


    private static void ordenarLancamentos() {
        List<Lancamento> atuais = financeiro.listar();
        if (atuais.isEmpty()) {
            System.out.println("\nNão há lançamentos para ordenar.");
            return;
        }

        MergeSort.Resultado resultado = MergeSort.ordenarComEtapas(atuais);
        System.out.println("\n------ DEMONSTRAÇÃO INTERATIVA: MERGE SORT ------");
        System.out.println("O programa vai dividir a lista em partes menores e depois intercalar em ordem crescente.");
        for (String etapa : resultado.getEtapas()) {
            System.out.println(" > " + etapa);
        }

        System.out.println("\nLançamentos ordenados pelo valor (menor para o maior):");
        listar(resultado.getLancamentos());
        System.out.println("Comparações entre valores: " + resultado.getComparacoes());
        System.out.println("Complexidade de tempo: O(n log n).");
        System.out.println("A ordenação é exibida sem alterar a ordem original dos lançamentos cadastrados.");
    }

    private static void listar(List<Lancamento> lancamentos) {
        System.out.println("\n--------- LANÇAMENTOS ---------");
        if (lancamentos.isEmpty()) {
            System.out.println("Nenhum lançamento cadastrado.");
            return;
        }
        for (Lancamento l : lancamentos) System.out.println(l);
    }

    private static void mostrarSaldo() {
        double receitas = financeiro.total("RECEITA");
        double despesas = financeiro.total("DESPESA");
        System.out.println("\n--------- SEU SALDO ---------");
        System.out.printf("Receitas: R$ %.2f%n", receitas);
        System.out.printf("Despesas: R$ %.2f%n", despesas);
        System.out.printf("Saldo:    R$ %.2f%n", receitas - despesas);
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double lerValor(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(entrada.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido, como 1500 ou 1500,50.");
            }
        }
    }
}
