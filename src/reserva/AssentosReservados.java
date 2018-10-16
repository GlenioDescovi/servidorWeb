package reserva;

import reserva.model.Assento;
import reserva.model.Bus;

public class AssentosReservados implements Runnable {

    private Bus bus;

    public AssentosReservados(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void run() {
        System.out.println("\n    assentos reservados...");
        while (true){
                for(Assento assento : bus.getAssentos()){
                    boolean isPassageiro = assento.getPassageiro()==null ?true: false;
                    System.out.println("     Assento: ["+assento.getIdAssento()+"] Nome: " +(isPassageiro? " --- ": assento.getPassageiro().getNome()) +
                            " Reservado: ["+assento.isReserved()+"]"+ " IP: "+( isPassageiro? " --- ": assento.getPassageiro().getIpRequisicao()) + " Data: "+(isPassageiro? " --- " :assento.getPassageiro().getDataAtual()));
                }
                try {
                    System.out.println("      estou descansando ... ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
            }

        }
    }
}
