package es2.com;

public class Questionario extends Object {

    public String atividadeFisica;

    public Questionario() {
    }

   /* public void setAtividadeFisica(String atividadeFisica){
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
    }*/

   public static class ConsumoAgua
   {
       public String Nivel1oConsumoAgua()
       {
           return "Menos de 0.5L";
       }
       public String Nivel2ConsumoAgua()
       {
           return "0.5L a 1L";
       }
       public String Nivel3ConsumoAgua()
       {
           return "1.5L a 2L";
       }
       public String Nivel4ConsumoAgua()
       {
           return "Mais de 2L";
       }
   }
}
