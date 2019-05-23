package es2.com;

public class Questionario extends Object {

    public String atividadeFisica;

    public Questionario(String motivoConsulta,String Objectivo)  {
    }
    
    public static class atividadeFisica
    {
        public String atividadeFisicaSedentaria(){
            return "Sedentaria";
        }
        public String atividadeFisicaModeradamenteAtivo(){
            return "Moderadamente Ativo";
        }
        public String atividadeFisicaAtivo(){
            return "Ativo";
        }
        public String atividadeFisicaMuitoAtivo(){
            return "Muito Ativo";
        }
    }

}
