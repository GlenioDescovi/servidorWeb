package reserva.model;

import java.util.Date;

public class Passageiro {

    private String nome;
    private int idPassageiro=0;
    private String ipRequisicao;
    private Date dataAtual;

    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", idPassageiro=" + idPassageiro +
                ", ipRequisicao='" + ipRequisicao + '\'' +
                ", dataAtual=" + dataAtual +
                '}';
    }

    public Passageiro(String nome) {
        this.nome = nome;
        idPassageiro+=1;
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
    public int getIdPassageiro() {
        return idPassageiro;
    }

    public void setIdPassageiro(int idPassageiro) {
        this.idPassageiro = idPassageiro;
    }
}
