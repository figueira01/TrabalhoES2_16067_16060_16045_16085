package es2.com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class HabitosAlimentares extends Object { 

    private HashMap<HashMap<String,String>, String>  Refeicoes = new HashMap<>();

    public HabitosAlimentares() {
    }

    public HashMap<HashMap<String,String>,String> getRefeicao() {
        return this.Refeicoes;
    }

    public void addRefeicao(String refeicao, String comida, String time) {
        HashMap <String,String> ref = new HashMap<>();
        ref.put(refeicao,comida);
        Refeicoes.put(ref,time);
    }
}
