package reserva.model;

import java.util.ArrayList;

public class Bus {

    private ArrayList<Assento> assentos;

    public Bus() {
        ArrayList<Assento> assentos = new ArrayList<Assento>();
        Assento assento1 = new Assento(1);
        Assento assento2 = new Assento(2);
        Assento assento3 = new Assento(3);
        assentos.add(assento3);
        assentos.add(assento2);
        assentos.add(assento1);
        this.assentos = assentos;
    }

    public ArrayList<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<Assento> assentos) {
        this.assentos = assentos;
    }

    @Override
    public String toString() {
        return "Bus={ " + assentos + '}';
    }

}
