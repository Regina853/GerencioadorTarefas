import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarefas> tarefas = SalvarTarefas.carregarTarefas();
        int opcao = 0;

        System.out.println("\n--- Gestor de tarefas ---");

        while (opcao != 7) {
            System.out.println("\n1 - Adicionar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Marcar Tarefa como concluída");
            System.out.println("4 - Editar Tarefa");
            System.out.println("5 - Listar Tarefas concluídas");
            System.out.println("6 - Remover Tarefa");
            System.out.println("7 - Sair");
            System.out.println("-------------------------");
            System.out.print("Digite o número da opção desejada: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da nova tarefa:");
                    String novaTarefa = scanner.nextLine();

                    if (novaTarefa == null || novaTarefa.trim().isEmpty()) {
                        System.out.println("A tarefa não pode estar vazia.");
                        break;
                    }

                    tarefas.add(new Tarefas(novaTarefa.trim()));
                    SalvarTarefas.salvarTarefas(tarefas);
                    System.out.println("Tarefa adicionada e salva com sucesso!");
                    break;

                case 2:
                    ListarTarefas.listarTarefas(tarefas);
                    break;

                case 3:
                    System.out.println("Digite o número da tarefa a ser marcada como concluída:");
                    int indice = lerIndice(scanner);
                    if (MarcarComoConcluida.marcarComoConcluida(tarefas, indice)) {
                        SalvarTarefas.salvarTarefas(tarefas);
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da tarefa a ser editada:");
                    int indiceEditar = lerIndice(scanner);
                    System.out.println("Digite o novo nome da tarefa:");
                    String novaDescricao = scanner.nextLine();

                    if (EditarTarefa.editarTarefa(tarefas, indiceEditar, novaDescricao)) {
                        System.out.println("Tarefa editada e salva com sucesso!");
                    } else {
                        System.out.println("Índice inválido ou descrição vazia.");
                    }
                    break;

                case 5:
                    System.out.println("Tarefas concluídas:");
                    boolean encontrou = false;
                    for (Tarefas tarefa : tarefas) {
                        if (tarefa.isConcluida()) {
                            System.out.println("- " + tarefa.getDescricao());
                            encontrou = true;
                        }
                    }
                    if (!encontrou) {
                        System.out.println("Nenhuma tarefa concluída.");
                    }
                    break;

                case 6:
                    System.out.println("Digite o número da tarefa a ser removida:");
                    int indiceRemover = lerIndice(scanner);
                    if (indiceRemover >= 0 && indiceRemover < tarefas.size()) {
                        tarefas.remove(indiceRemover);
                        SalvarTarefas.salvarTarefas(tarefas);
                        System.out.println("Tarefa removida e salva com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static int lerIndice(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Número inválido. Tente novamente:");
                scanner.nextLine();
                continue;
            }

            int indice = scanner.nextInt();
            scanner.nextLine();
            return indice - 1;
        }
    }
}