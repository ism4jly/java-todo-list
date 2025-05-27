public class Main {
    public static void main(String[] args) {

        Tarefa tarefa1 = new Tarefa("estudar java", false);

        System.out.println("Descrição: " + tarefa1.getDescricao());
        tarefa1.marcarConcluida();
        System.out.println("Concluida? " + tarefa1.isConcluida());
        System.out.println("toString: " + tarefa1);

    }
}