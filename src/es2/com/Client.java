package es2.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Client {

    private static final String COMMA_DELIMITER = ";";
    private String fichDadosFisicos = "CSV/DadosFisicos.csv";
    private String fichProdutos = "CSV/Produtos.csv";
    private String fichPlanoAtual = "C:/Users/leina/OneDrive/Ambiente de Trabalho/Faculdade/ES2/Trabalho ES2/PlanoAlimentarAtual.csv";
    private String fichPlanoPrescrito = "C:/Users/leina/OneDrive/Ambiente de Trabalho/Faculdade/ES2/Trabalho ES2/PlanoAlimentarPrescrito.csv";
    private String fichaQuestionarios = "CSV/Questionario.csv";
    private static List<List<DadosFisicos>> dadosFisicos = new ArrayList<>();
    private static List<List<Produto>> produtos = new ArrayList<>();
    private static List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
    private static List<List<PlanoAlimentar>> planoPrescrito= new ArrayList<>();
    private static List<List<Questionario>> questionarios = new ArrayList<>();

    public void LerDadosFisicos(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichDadosFisicos))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                dadosFisicos.add(Arrays.asList(new DadosFisicos(Double.parseDouble(values[0]),Double.parseDouble(values[1]),
                        Double.parseDouble(values[2]),Double.parseDouble(values[3]),values[4],values[5],Double.parseDouble(values[6]),
                        Double.parseDouble(values[7]),Double.parseDouble(values[8]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LerDadosProdutos(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichProdutos))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                produtos.add(Arrays.asList(new Produto(values[0],values[1],Double.parseDouble(values[2]),Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]),
                        Double.parseDouble(values[7]),Double.parseDouble(values[8]),Double.parseDouble(values[9]),
                        Double.parseDouble(values[10]),Double.parseDouble(values[11]),Double.parseDouble(values[12]),
                        Double.parseDouble(values[13]),Double.parseDouble(values[14]),Double.parseDouble(values[15]),
                        Double.parseDouble(values[16]),Double.parseDouble(values[17]),Double.parseDouble(values[18]),
                        Double.parseDouble(values[19]),Double.parseDouble(values[20]),Double.parseDouble(values[21]),
                        Double.parseDouble(values[22]),Double.parseDouble(values[23]),Double.parseDouble(values[24]),
                        Double.parseDouble(values[25]),Double.parseDouble(values[26]),Double.parseDouble(values[27]),
                        Double.parseDouble(values[28]),Double.parseDouble(values[29]),Double.parseDouble(values[30]),
                        Double.parseDouble(values[31]),Double.parseDouble(values[32]),Double.parseDouble(values[33]),
                        Double.parseDouble(values[34]),Double.parseDouble(values[35]),Double.parseDouble(values[36]),
                        Double.parseDouble(values[37]),Double.parseDouble(values[38]),Double.parseDouble(values[39]),
                        Double.parseDouble(values[40]),Double.parseDouble(values[41]),Double.parseDouble(values[42]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LerPlanoAlimentarAtual(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichPlanoAtual))) {
            String line;
            PlanoAlimentar pa = new PlanoAlimentar();
            HashMap<String, Double> plano = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                System.out.println(values[0]);
                plano.put(values[2],Double.parseDouble(values[3]));
                System.out.println("plano =" + plano.get("Almoco"));
               // plano.put(values[4],Double.parseDouble(values[5]));
                pa.addRefeicao(values[0],values[1],plano);
                System.out.println("pa =" + pa.getRefeicao("Almoco"));
                planoAtual.add(Arrays.asList(pa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public void LerPlanoAlimentarPrescrito(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichPlanoPrescrito))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                planoPrescrito.add(Arrays.asList(new PlanoAlimentarPrescrito(values[0],values[1],
                        values[2],Double.parseDouble(values[3]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void LerQuestionario(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichaQuestionarios))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                questionarios.add(Arrays.asList(new Questionario(values[0],values[1],
                        values[2],values[3],values[4],values[5],values[6],values[7],Double.parseDouble(values[8])
                        ,Double.parseDouble(values[9]),Double.parseDouble(values[10]),Double.parseDouble(values[11]),
                        Double.parseDouble(values[12]),values[13],Integer.parseInt(values[14]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args)
    {

        Client client = new Client();
        client.LerDadosFisicos();
        client.LerDadosProdutos();
        client.LerQuestionario();
        client.LerPlanoAlimentarAtual();
        for(int i=0;i<planoAtual.size();i++)
        {
            System.out.println("Pequeno Almoço = " + planoAtual.get(i).get(0).getRefeicao("Pequeno Almoco").getComida());
            System.out.println("Meio da Manha 1 = " + planoAtual.get(i).get(0).getRefeicao("Meio da Manha 1").getComida());
            System.out.println("Meio da Manha 2 = " + planoAtual.get(i).get(0).getRefeicao("Meio da Manha 2").getComida());
            System.out.println("Almoco = " + planoAtual.get(i).get(0).getRefeicao("Almoco").getComida());
        }



        //System.out.println("Altura = " + dadosFisicos.get(1).get(0).getAltura());




        /*
        for(int i=0;i<produtos.size();i++)
        {
            System.out.println(produtos.get(i));
        }*/

    }
}
