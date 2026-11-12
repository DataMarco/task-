import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Tarefa {
    private long id;
    private String titulo;
    private LocalDateTime data;
    private String descricao;
    private Status status;

    private static final AtomicLong idCounter = new AtomicLong(0);
    public Tarefa(String titulo, String descricao){
        this.titulo = titulo;
        this.data = LocalDateTime.now();
        this.id = idCounter.incrementAndGet();
        this.status = Status.PENDENTE;
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
    public long getId(){
        return id;
    }
    public Status getStatus(){
        return status;
    }
    public String getTitulo(){
        return titulo;
    }
    public LocalDateTime getData(){
        return data;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void concluir() {
        this.status = Status.CONCLUIDA;
    }

    @Override
    public String toString() {
        return "ID: " + id +
            " | Título: " + titulo +
            " | Descrição: " + descricao +
            " | Status: " + status +
            " | Criada em: " + data;
    }
}