import java.util.ArrayList;

public class EditarTarefa {
    public static boolean editarTarefa(ArrayList<Tarefas> tarefas, int indice, String novaDescricao) {
        if (indice < 0 || indice >= tarefas.size()) {
            return false;
        }

        if (novaDescricao == null || novaDescricao.trim().isEmpty()) {
            return false;
        }

        Tarefas tarefa = tarefas.get(indice);
        tarefa.editarDescricao(novaDescricao.trim());
        SalvarTarefas.salvarTarefas(tarefas);
        return true;
    }
}
