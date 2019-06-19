package es2.com;

import java.time.LocalDate;
import java.util.HashMap;

public class PlanoAlimentar extends Object {

    HashMap<String, Refeicao> Plano = new HashMap<>();

    public void addRefeicao (String refeicao, LocalDate hora, HashMap<String, Double> comida) {
        Plano.put(refeicao , new Refeicao(hora,comida));
    }
    public Refeicao getRefeicao(String refeicao) {
        return Plano.get(refeicao);

    } public HashMap<String, Refeicao> getPlano() {
        return Plano;
    }
}
