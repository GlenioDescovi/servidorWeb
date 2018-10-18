package reserva;

import reserva.log.Log;
import reserva.model.Assento;
import reserva.model.Bus;
import reserva.model.Passageiro;

import java.util.Calendar;

/**
 * Classe que tem a thread que tenta realizar a reserva da poltrona bem como escrever no log se o usuario consegui ou não
 */
public class ReservaAssento implements Runnable {

    private Passageiro passageiro;
    private int idAssento;
    private Bus onibus;
    private String mensagemLog="";

    public ReservaAssento(Passageiro passageiro,int idAssento, Bus onibus){
        this.passageiro = passageiro;
        this.idAssento = idAssento;
        this.onibus = onibus;
    }
    @Override
    public void run() {
        // verificar se o assento esta vago
            synchronized (onibus.getAssentos()){

                if (verificaAssento(onibus,idAssento)){

                    System.out.println(passageiro.getNome() +" "+ idAssento +" CONSEGUIU ...");

                    for (Assento assento: onibus.getAssentos()){
                        if (assento.getIdAssento()==idAssento){
                            assento.setReserved(true);

                            passageiro.setDataAtual(Calendar.getInstance().getTime());
                            assento.setPassageiro(passageiro);
                            System.out.println("reservado para:"+passageiro.getNome() );
                        }
                    }
                    mensagemLog= "NOME: " + passageiro.getNome()+ "\n"
                            + "IP: " + passageiro.getIpRequisicao() +
                            "\n" + "STATUS: CONSEGUIU RESERVAR";

                }else{
                    mensagemLog= "NOME: " + passageiro.getNome()+ "\n"
                            + "IP: " + passageiro.getIpRequisicao() +
                            "\n" + "STATUS: NÃO CONSEGUIU RESERVAR";
                    System.out.println("----->   O "+passageiro.getNome() +" NÃO CONSEGUIU RESERVA");
                }

                Log.addLog(mensagemLog);
        }

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
