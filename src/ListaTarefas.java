import java.util.ArrayList;

public class ListaTarefas {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(String descricao){
        tarefas.add(new Tarefa(descricao));
    }

    public void listarTarefas(){
        if(tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for(int i = 1; i < tarefas.size(); i++){
                System.out.println(i + " - " + tarefas.get(i));
            }
        }
    }

    public void marcarConcluida(int indice){
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarConcluida();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
