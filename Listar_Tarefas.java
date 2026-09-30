import java.util.ArrayList;

public class Listar_Tarefas {
    public static void listarTarefas(ArrayList<Tarefas> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("Tarefas cadastradas (" + tarefas.size() + "):");
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefas tarefa = tarefas.get(i);
            System.out.println((i + 1) + " - " + tarefa.getDescricao() + (tarefa.isConcluida() ? " [Concluída]" : ""));
        }
    }
}
