public class Tarefas {
    private String descricao;
    private boolean concluida;

    public Tarefas(String descricao) {
        setDescricao(descricao);
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode estar vazia.");
        }
        this.descricao = descricao.trim();
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public void editarDescricao(String novaDescricao) {
        setDescricao(novaDescricao);
    }

    @Override
    public String toString() {
        return (concluida ? "[X] " : "[ ] ") + descricao;
    }
}