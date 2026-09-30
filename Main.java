import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" \n---Gestor de tarefas---");
        System.out.println("Digite o número da opção desejada:");
        ArrayList<Tarefas> tarefas = new ArrayList<>();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n1 - Adicionar Tarefas");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Marcar Tarefa como concluída");
            System.out.println("4 - Editar Tarefa");
            System.out.println("5 - Listar Tarefas concluídas");
            System.out.println("6 - Remover Tarefa ");
            System.out.println("7 - Sair");
            System.out.println("-------------------------");
            System.out.print("Digite o numero da opção desejada: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    // Lógica para adicionar tarefa
                    System.out.println("Digite o nome da nova tarefa:");
                    String novaTarefa = scanner.nextLine();

                    if (novaTarefa == null || novaTarefa.trim().isEmpty()) {
                        System.out.println("A tarefa não pode estar vazia.");
                        break;
                    }

                    tarefas.add(new Tarefas(novaTarefa.trim()));
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;

                case 2:
                    // Lógica para listar tarefas
                    Listar_Tarefas.listarTarefas(tarefas);
                    break;

                case 3:
                    // Lógica para marcar tarefa como concluída
                    System.out.println("Digite o número da tarefa a ser marcada como concluída:");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer do scanner
                    if (Marcar_como_Concluida.marcarComoConcluida(tarefas, indice)) {
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    // Lógica para editar tarefa
                    System.out.println("Digite o número da tarefa a ser editada:");
                    int indiceEditar = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer do scanner
                    if (indiceEditar >= 0 && indiceEditar < tarefas.size()) {
                        System.out.println("Digite o novo nome da tarefa:");
                        String novaDescricao = scanner.nextLine();
                        tarefas.get(indiceEditar).editarDescricao(novaDescricao);
                        System.out.println("Tarefa editada com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 5:
                    // Lógica para listar tarefas concluídas
                    System.out.println("Tarefas concluídas:");
                    scanner.nextLine(); // Limpar o buffer do scanner
                    for (Tarefas tarefa : tarefas) {
                        if (tarefa.isConcluida()) {
                            System.out.println("- " + tarefa.getDescricao());
                        }
                    }
                    break;

                case 6:
                    // Lógica para remover tarefa
                    System.out.println("Digite o número da tarefa a ser removida:");
                    int indiceRemover = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer do scanner
                    if (indiceRemover >= 0 && indiceRemover < tarefas.size()) {
                        tarefas.remove(indiceRemover);
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    // Lógica para sair do programa
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}