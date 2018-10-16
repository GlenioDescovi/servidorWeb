package reserva;

import reserva.model.Assento;
import reserva.model.Bus;
import reserva.model.Passageiro;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Calendar;

public class ReservaAssento implements Runnable {

    private Passageiro passageiro;
    private int idAssento;
    private Bus onibus;

    public ReservaAssento(Passageiro passageiro,int idAssento, Bus onibus){
        this.passageiro = passageiro;
        this.idAssento = idAssento;
        this.onibus = onibus;
    }
    @Override
    public void run() {
        // verificar se o assento esta vago
            synchronized (onibus.getAssentos()){

                System.out.println(passageiro.getNome() +" "+ idAssento);
                if (verificaAssento(onibus,idAssento)){
                    System.out.println("   CONSEGUIU ...");
                    for (Assento assento: onibus.getAssentos()){
                        if (assento.getIdAssento()==idAssento){
                            assento.setReserved(true);
                            try {
                                passageiro.setIpRequisicao(Inet4Address.getLocalHost().getHostAddress());
                                passageiro.setDataAtual(Calendar.getInstance().getTime());
                            } catch (UnknownHostException e) {
                                e.printStackTrace();
                            }
                            assento.setPassageiro(passageiro);
                            System.out.println("reservado para:"+passageiro.getNome() );
                        }
                    }
                }else{
                    System.out.println("   NAO CONSEGUIU ");
                }
                try {
                    System.out.println("assentos:"+onibus.getAssentos());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                    onibus.getAssentos().notifyAll();
        }
        System.out.println("                                                                  area critica sendo usada ....");

    }

    /**
     * verifica se o assento recebido por parametro esta vago
     * @param onibus onibus com os assentos
     * @param id assento que vai ser verificado se esta vago
     * @return
     */
    public boolean verificaAssento(Bus onibus,int id){

        for (Assento assento: onibus.getAssentos()){
            if (assento.getIdAssento()==id){
                if (assento.isReserved()){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
