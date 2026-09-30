import java.util.ArrayList;


public class Listar_Tarefas {
    public static void listarTarefas(ArrayList<Tarefas> tarefas) {
        System.out.println("Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefas tarefa = tarefas.get(i);
            System.out.println((i + 1) + " - " + tarefa.getDescricao() + (tarefa.isConcluida() ? " [Concluída]" : ""));
        }
    }
    
    

    
}
