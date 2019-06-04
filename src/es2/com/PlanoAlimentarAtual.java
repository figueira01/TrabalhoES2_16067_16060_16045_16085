package es2.com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class PlanoAlimentarAtual extends Object {

    private String Refeicao;
    private String hora;
    private String comida;
    private double quantidade;


    public PlanoAlimentarAtual(String refeicao, String hora, String comida, double quantidade) {
        Refeicao = refeicao;
        this.hora = hora;
        this.comida = comida;
        this.quantidade = quantidade;
    }

    public String getRefeicao() {
        return Refeicao;
    }

    public void setRefeicao(String refeicao) {
        Refeicao = refeicao;
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
