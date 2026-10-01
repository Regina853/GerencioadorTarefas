import java.util.ArrayList;

public class MarcarComoConcluida {
    public static boolean marcarComoConcluida(ArrayList<Tarefas> tarefas, int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            return false;
        }

        tarefas.get(indice).marcarComoConcluida();
        return true;
    }
}
