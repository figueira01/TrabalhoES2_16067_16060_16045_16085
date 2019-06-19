package es2.com;

import java.time.LocalDate;
import java.util.HashMap;

public class Refeicao {

    private LocalDate hora;
    private HashMap<String,Double>comida;

    public Refeicao(LocalDate hora, HashMap<String,Double> comida) {

        this.hora = hora;
        this.comida = comida;
    }

    public LocalDate getHora() {
        return hora;
    }

    public HashMap<String, Double> getComida() {
        return comida;
    }
}
