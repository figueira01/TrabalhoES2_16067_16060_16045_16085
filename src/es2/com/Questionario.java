package es2.com;

public class Questionario extends Object {

    public String atividadeFisica;

    public Questionario() {
    }

    public void setAtividadeFisica(String atividadeFisica){
        if(atividadeFisica.equals("Sedentario")){
            this.atividadeFisica.equals("Sedentario");
        }
        if(atividadeFisica.equals("Moderadamente ativo")){
            this.atividadeFisica.equals("Moderadamente ativo");
        }
        if(atividadeFisica.equals("Ativo")){
            this.atividadeFisica.equals("Ativo");
        }
        if(atividadeFisica.equals("Muito ativo")){
            this.atividadeFisica.equals("Muito ativo");
        }
    }

}
