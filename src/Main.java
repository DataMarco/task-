public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        gerenciador.adicionarTarefa("Programar", "Aprender POO");
        gerenciador.listarTarefas();
    }
}