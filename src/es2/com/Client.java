package es2.com;
import java.util.*;

public class Client {


    private static String fichPlanoAtual = "CSV/PlanoAlimentarAtual.csv";
    private static String fichPlanoPrescrito = "CSV/PlanoAlimentarPrescrito.csv";
    private static List<List<DadosFisicos>> dadosFisicos = new ArrayList<>();
    private static List<List<Produto>> produtos = new ArrayList<>();
    private static List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
    private static List<List<String>> planoAtualS = new ArrayList<>();
    private static List<List<String>> planoPrescritoS = new ArrayList<>();
    private static List<List<PlanoAlimentar>> planoPrescrito = new ArrayList<>();
    private static List<List<Questionario>> questionarios = new ArrayList<>();


    public static void main(String [] args) throws Exception {

        Funcoes funcoes = new Funcoes();
        funcoes.LerDadosFisicos(dadosFisicos);
        funcoes.LerDadosProdutos(produtos);
        funcoes.LerQuestionario(questionarios);
        funcoes.LerPlanoAlimentar(fichPlanoAtual,planoAtual);
        funcoes.LerPlanoAlimentar(fichPlanoPrescrito,planoPrescrito);
        funcoes.LerPlanoAlimentarS(fichPlanoAtual,planoAtualS);
        funcoes.LerPlanoAlimentarS(fichPlanoPrescrito,planoPrescritoS);
        Pessoa pessoa = new Pessoa("Eu",22,"Masculino","Estudante",dadosFisicos.get(0).get(0),planoAtual.get(0).get(0),questionarios.get(0).get(0));
        funcoes.WriteToCsv(planoAtualS,planoAtual,produtos);
        funcoes.WriteToCsvPrescrito(planoPrescritoS,planoPrescrito,pessoa,produtos);
    }

}
