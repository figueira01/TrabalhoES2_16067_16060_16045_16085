package es2.com;

import java.util.HashMap;

public class Refeicao {

    private String hora;
    private HashMap<String,Double>comida;

    public Refeicao( String hora, HashMap<String,Double> comida) {

        this.hora = hora;
        this.comida = comida;
    }

}
