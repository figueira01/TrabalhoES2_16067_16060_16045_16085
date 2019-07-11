package es2.com;

public class PlanoAlimentar extends Object {

    private String refeicao;
    private String hora;
    private String comida;
    private double quantidade;

    public PlanoAlimentar(String refeicao, String hora, String comida, double quantidade) throws Exception {
        this.refeicao = refeicao;
        this.hora = hora;
        this.comida = comida;
        if(quantidade <= 500 && quantidade > 0)
        {
            this.quantidade = quantidade;
        }else
            throw new Exception();
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

    public void setQuantidade(double quantidade) throws Exception {
        if(quantidade <= 500 && quantidade > 0)
        {
            this.quantidade = quantidade;
        }else
            throw new Exception();
    }
}
