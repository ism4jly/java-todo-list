import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- TO-DO LIST ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    lista.adicionarTarefa(descricao);
                    break;
                case 2:
                    lista.listarTarefas();
                    break;
                case 3:
                    System.out.print("Digite o índice da tarefa a concluir: ");
                    int i = scanner.nextInt();
                    lista.marcarConcluida(i - 1);
                    break;
                case 4:
                    System.out.print("Digite o índice da tarefa a remover: ");
                    int j = scanner.nextInt();
                    lista.removerTarefa(j - 1);
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
