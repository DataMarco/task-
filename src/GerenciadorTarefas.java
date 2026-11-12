import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class GerenciadorTarefas {
    private final List<Tarefa> tarefas = new ArrayList<>();
    private boolean tituloExistente(String titulo){
        for (Tarefa tarefa1 : tarefas) {
            String titulo1 = tarefa1.getTitulo().trim();
            if (titulo1.equalsIgnoreCase(titulo.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionarTarefa(String titulo, String descricao){
        if (tituloExistente(titulo)) {
            return false;
        } else {
            Tarefa tarefa = new Tarefa(titulo, descricao);
            tarefas.add(tarefa);
            return true;
        }
    }

    public void listarTarefas(){
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa.toString());
        }
    }

    public int contarTarefas(){
        return tarefas.size();
    }

    public boolean concluirTarefa(long id){
        Tarefa tarefaencontrada = compararId(id);
        if (tarefaencontrada != null) {
            if (tarefaencontrada.getStatus() != Status.CONCLUIDA) {
                tarefaencontrada.concluir();
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    public List<Tarefa> buscarNome(String nome){
        List<Tarefa> listaNomes = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            String nometarefa = tarefa.getTitulo().toLowerCase();
            if (nometarefa.contains(nome.toLowerCase())) {
                listaNomes.add(tarefa);
            }
        }
        return listaNomes;
    }

    public List<Tarefa> buscarPorStatus(Status status){
        List<Tarefa> novalista = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == status) {
                novalista.add(tarefa);
            }
        }
        return novalista;
    }

    public Tarefa compararId(long id){
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }

    public boolean alterarStatus(long id, Status novoStatus){
        Tarefa tarefaencontrada = compararId(id);
        if (tarefaencontrada != null) {
            tarefaencontrada.setStatus(novoStatus);
            return true;
        } else {
            return false;
        }
    }

    public boolean removerConcluidas(){
        boolean removida = false;
        Iterator<Tarefa> iterator = tarefas.iterator();
        while (iterator.hasNext()) {
            Tarefa tarefa = iterator.next();
            if (tarefa.getStatus() == Status.CONCLUIDA) {
                iterator.remove();
                removida = true;
            }
        }
        return removida;
    }
    
    public boolean removerTarefa(long id){
        boolean removida = false;
        Iterator<Tarefa> iterator = tarefas.iterator();
        while (iterator.hasNext()) {
            Tarefa tarefa = iterator.next();
            if (tarefa.getId()==id) {
                iterator.remove();
                removida = true;
            }
        }
        if (removida) {
            return true;
        } else {
            return false;
        }
    }
}
