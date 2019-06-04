package es2.com;

public class PlanoAlimentarPrescrito extends Object {

    private String Refeicao;
    private String hora;
    private String comida;
    private double quantidade;


    public PlanoAlimentarPrescrito(String refeicao, String hora, String comida, double quantidade) {
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
