package EquipeDeResgate;

public class EquipeDeResgate {
    private String nomeEquipe, especialidade, tempoDeResposta;

    public EquipeDeResgate(String nomeEquipe, String especialidade, String tempoDeResposta) {
        this.nomeEquipe = nomeEquipe;
        this.especialidade = especialidade;
        this.tempoDeResposta = tempoDeResposta;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTempoDeResposta() {
        return tempoDeResposta;
    }

    public void setTempoDeResposta(String tempoDeResposta) {
        this.tempoDeResposta = tempoDeResposta;
    }
    @Override
    public String toString() {
        return "Nome da equipe: " + nomeEquipe +
                "\nEspecialidade: " + especialidade +
                "\nTempo de Resposta: " + tempoDeResposta;
    }

}
