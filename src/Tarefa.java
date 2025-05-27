public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao, boolean concluida) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void marcarConcluida(){
        this.concluida = true;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return (concluida ? "[x] " : "[ ] ") + descricao;
    }
}