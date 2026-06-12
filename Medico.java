package projeto;

public class Medico extends Pessoa {
    private String especialidade;

    public Medico(String nome, int id, String especialidade) {
        super(nome, id);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String getDadosIdentificacao() {
        return "Médico: Dr(a). " + getNome() + " - Esp: " + especialidade;
    }
}