package projeto;

public class Paciente extends Pessoa {
    private String prioridade;

    public Paciente(String nome, int id, String prioridade) {
        super(nome, id);
        this.prioridade = prioridade;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String getDadosIdentificacao() {
        return "Paciente: " + getNome() + " (ID: " + getId() + ") - Prioridade: " + prioridade;
    }
}