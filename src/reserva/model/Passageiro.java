package reserva.model;

import java.util.Date;

public class Passageiro {

    private String nome;
    private Date dataAtual;
    private String ipRequisicao;
    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", dataAtual=" + dataAtual +
                '}';
    }

    public Passageiro(String nome) {
        this.nome = nome;
    }

    public Passageiro(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIpRequisicao() {
        return ipRequisicao;
    }

    public void setIpRequisicao(String ipRequisicao) {
        this.ipRequisicao = ipRequisicao;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

}
