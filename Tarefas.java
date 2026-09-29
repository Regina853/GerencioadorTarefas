public class Tarefas {
    private String descricao;
    private boolean concluida;

    public Tarefas(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public void editarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    @Override
    public String toString() {
        return (concluida ? "[X] " : "[ ] ") + descricao;
    }
    
    
}