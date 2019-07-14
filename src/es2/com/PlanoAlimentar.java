package es2.com;

public class PlanoAlimentar extends Object {

    private String refeicao;
    private String hora;
    private String comida;
    private double quantidade;

    public PlanoAlimentar(String refeicao, String hora, String comida, double quantidade) {

        assert !refeicao.equals("") && refeicao!=null : "Refeicao nao pode ser null";
        assert !hora.equals("") && hora!=null: "Hora nao pode ser null";
        assert !comida.equals("") && comida!=null: "Comida nao pode ser null";
        assert quantidade >=0 && quantidade < 4000 : "Quantidade não pode ser menor que 0 e maior que 4000";

        this.refeicao = refeicao;
        this.hora = hora;
        this.comida = comida;
        this.quantidade = quantidade;
    }


    public String getRefeicao() {

        return refeicao;
    }

    public void setRefeicao(String refeicao) {

        if(refeicao==null || refeicao.isEmpty())
        {
            throw new AssertionError();
        }
        else if(refeicao.length()>100 || refeicao.length()<=2)
        {
            throw new AssertionError();
        }

        this.refeicao = refeicao;
    }

    public String getHora() {

        return hora;
    }

    public void setHora(String hora) {

        if(hora==null || hora.isEmpty())
        {
            throw new AssertionError();
        }
        else if(hora.length()!=5)
        {
            throw new AssertionError();
        }

        this.hora = hora;
    }

    public String getComida() {

        return comida;
    }

    public void setComida(String comida) {

        if(comida==null || comida.isEmpty())
        {
            throw new AssertionError();
        }
        else if(comida.length()>100 || comida.length()<=2)
        {
            throw new AssertionError();
        }

        this.comida = comida;
    }

    public double getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(double quantidade){

        if(quantidade>4000 || quantidade<0)
        {
            throw new AssertionError();
        }

        this.quantidade = quantidade;

    }
}
