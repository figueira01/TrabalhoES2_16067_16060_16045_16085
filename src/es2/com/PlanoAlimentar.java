package es2.com;

import java.time.LocalDate;
import java.util.HashMap;

public class PlanoAlimentar extends Object {

    private String refeicao;
    private String hora;
    private String comida;
    private double quantidade;

    public PlanoAlimentar(String refeicao, String hora, String comida, double quantidade) {
        this.refeicao = refeicao;
        this.hora = hora;
        this.comida = comida;
        this.quantidade = quantidade;
    }


    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
