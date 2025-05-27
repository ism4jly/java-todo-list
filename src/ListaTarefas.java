import java.io.*;
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
            for(int i = 0; i < tarefas.size(); i++){
                System.out.println((i+1) + " - " + tarefas.get(i));
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

    public void salvarComoTexto(String caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
            for (Tarefa t : tarefas) {
                writer.printf("%s;%b\n", t.getDescricao(), t.isConcluida());
            }
            System.out.println("Tarefas salvas em arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public void carregarDeTexto(String caminho) {
        File arquivo = new File(caminho);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    String descricao = partes[0];
                    boolean concluida = Boolean.parseBoolean(partes[1]);

                    Tarefa t = new Tarefa(descricao);
                    if (concluida) t.marcarConcluida();
                    tarefas.add(t);
                }
            }
            System.out.println("Tarefas carregadas do arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar tarefas: " + e.getMessage());
        }
    }
}
