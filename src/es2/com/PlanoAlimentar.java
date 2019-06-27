package es2.com;

import java.util.HashMap;

public class PlanoAlimentar extends Object {

   private HashMap<String, Refeicao> Plano = new HashMap<>();

    public PlanoAlimentar() {

    }

    public void addRefeicao (String refeicao, String hora, HashMap<String, Double> comida) {
        Plano.put(refeicao , new Refeicao(hora,comida));
    }
    public Refeicao getRefeicao(String refeicao) {
        return Plano.get(refeicao);
    }
}
