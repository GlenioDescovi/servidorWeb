/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva.model;

/**
 *
 * @author maico
 */
public class Assento {

    private int idAssento;//numero do assento
    private boolean IsReserved;
    private Passageiro passageiro;

    public Assento(int idAssento, boolean isReserved, Passageiro passageiro) {
        this.idAssento = idAssento;
        IsReserved = isReserved;
        this.passageiro = passageiro;
    }

    public Assento(int idAssento) {
        this.idAssento = idAssento;
    }

    public Assento() {
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public boolean isReserved() {
        return IsReserved;
    }

    public void setReserved(boolean reserved) {
        IsReserved = reserved;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    @Override
    public String toString() {
        return "\nAssento {" +
                "idAssento=" + idAssento +
                ", IsReserved=" + IsReserved +
                ", passageiro=" + passageiro +
                '}' +"\n";
    }
}

