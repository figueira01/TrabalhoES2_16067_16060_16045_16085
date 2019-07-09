package es2.com;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    private static final String COMMA_DELIMITER = ";";
    private String fichDadosFisicos = "CSV/DadosFisicos.csv";
    private String fichProdutos = "CSV/Produtos.csv";
    private String fichPlanoAtual = "CSV/PlanoAlimentarAtual.csv";
    private String fichPlanoPrescrito = "CSV/PlanoAlimentarPrescrito.csv";
    private String fichaQuestionarios = "CSV/Questionario.csv";
    private static List<List<DadosFisicos>> dadosFisicos = new ArrayList<>();
    private static List<List<Produto>> produtos = new ArrayList<>();
    private static List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
    private static List<List<String>> planoAtualS = new ArrayList<>();
    private static List<List<PlanoAlimentar>> planoPrescrito = new ArrayList<>();
    private static List<List<Questionario>> questionarios = new ArrayList<>();

    public void LerDadosFisicos(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichDadosFisicos))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                dadosFisicos.add(Arrays.asList(new DadosFisicos(Double.parseDouble(values[0]),Double.parseDouble(values[1]),
                        Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]),
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

    /*public void LerPlanoAlimentarPrescrito(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichPlanoPescrito))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                planoPescrito.add(Arrays.asList(new PlanoAlimentar(values[0],values[1],
                        values[2],Double.parseDouble(values[3]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public void LerPlanoAlimentarAtual(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichPlanoAtual))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                planoAtual.add(Arrays.asList(new PlanoAlimentar(values[0],values[1],
                        values[2],Double.parseDouble(values[3]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LerPlanoAlimentarAtualS(){

        try (BufferedReader br = new BufferedReader(new FileReader(fichPlanoAtual))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                planoAtualS.add(Arrays.asList(values[0],values[1],values[2],values[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public void WriteToCsv(List<List<String>> planoAtual) throws IOException {
        String refeicao = planoAtual.get(0).get(0);

        FileWriter csvWriter = new FileWriter("new.csv");
        csvWriter.append("Plano Alimentar Atual");
        csvWriter.append("\n");
        csvWriter.append("Refeicao");
        csvWriter.append(",");
        csvWriter.append("Hora");
        csvWriter.append("\n");

        for(List<String> rowData : planoAtual){
            System.out.println("valor: " + rowData.get(0));
            if(refeicao.equals(rowData.get(0)) || refeicao.equals(""))
            {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }else
            {
                csvWriter.append("Por Refeicao");
                csvWriter.append(",");
                csvWriter.append(",");
                csvWriter.append("Energia (kcal)");
                csvWriter.append(",");
                csvWriter.append("Energia (kj)");
                csvWriter.append(",");
                csvWriter.append("Agua");
                csvWriter.append(",");
                csvWriter.append("Proteina");
                csvWriter.append(",");
                csvWriter.append("Gordura total");
                csvWriter.append(",");
                csvWriter.append("Total HC disponíveis");
                csvWriter.append(",");
                csvWriter.append("Mono + dissacáridos");
                csvWriter.append(",");
                csvWriter.append("Ácidos orgânicos");
                csvWriter.append(",");
                csvWriter.append("Álcool");
                csvWriter.append(",");
                csvWriter.append("Amido");
                csvWriter.append(",");
                csvWriter.append("Oligossacáridos");
                csvWriter.append(",");
                csvWriter.append("Fibra alimentar");
                csvWriter.append(",");
                csvWriter.append("Ácidos gordos saturados");
                csvWriter.append(",");
                csvWriter.append("Ácidos gordos monoinsaturados");
                csvWriter.append(",");
                csvWriter.append("Ácidos gordos polinsaturados");
                csvWriter.append(",");
                csvWriter.append("Ácidos gordos trans");
                csvWriter.append(",");
                csvWriter.append("Ácido linoleico");
                csvWriter.append(",");
                csvWriter.append("Colesterol");
                csvWriter.append(",");
                csvWriter.append("Vit A total");
                csvWriter.append(",");
                csvWriter.append("Caroteno");
                csvWriter.append(",");
                csvWriter.append("vit. D");
                csvWriter.append(",");
                csvWriter.append("a-tocoferol");
                csvWriter.append(",");
                csvWriter.append("Tiamina");
                csvWriter.append(",");
                csvWriter.append("Riboflavina");
                csvWriter.append(",");
                csvWriter.append("Equivalentes de niacina");
                csvWriter.append(",");
                csvWriter.append("Niacina");
                csvWriter.append(",");
                csvWriter.append("Triptofano/60");
                csvWriter.append(",");
                csvWriter.append("vit B6");
                csvWriter.append(",");
                csvWriter.append("Vit. B12");
                csvWriter.append(",");
                csvWriter.append("vit. C");
                csvWriter.append(",");
                csvWriter.append("Folatos");
                csvWriter.append(",");
                csvWriter.append("Cinza");
                csvWriter.append(",");
                csvWriter.append("Na");
                csvWriter.append(",");
                csvWriter.append("K");
                csvWriter.append(",");
                csvWriter.append("Ca");
                csvWriter.append(",");
                csvWriter.append("P");
                csvWriter.append(",");
                csvWriter.append("Mg");
                csvWriter.append(",");
                csvWriter.append("Fe");
                csvWriter.append(",");
                csvWriter.append("Ze");
                csvWriter.append("\n");
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
                refeicao = rowData.get(0);
            }


        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static void main(String [] args) throws IOException {

        Client client = new Client();
        client.LerDadosFisicos();
        client.LerDadosProdutos();
        client.LerQuestionario();
        client.LerPlanoAlimentarAtual();
        client.LerPlanoAlimentarAtualS();
        client.WriteToCsv(planoAtualS);


        //Pessoa pessoa = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos.get(0).get(0),planoAtual.get(0).get(0),questionarios.get(0).get(0));
        //System.out.println(pessoa.CalcularTMB());
        //System.out.println("Altura = " + dadosFisicos.get(1).get(0).getAltura());
        //System.out.println("Altura = " + questionarios.get(0).get(0).getAtividadeFisica());

        double x=0;

        for(int i=0;i<planoAtual.size();i++)
        {
            for(int j=0;j<produtos.size();j++)
            {

                if(planoAtual.get(i).get(0).getComida().equals(produtos.get(j).get(0).getNome()))
                {
                     x = (planoAtual.get(i).get(0).getQuantidade()*produtos.get(j).get(0).getAcidoGordosSaturados())/100;
                    System.out.println(x);
                }

            }
            //System.out.println("ze = "+planoAtual.get(i).get(0).getRefeicao());
            //System.out.println(planoAtual.get(i).get(0).getRefeicao());
        }
        System.out.println("acidos = "+ x);

    }

}
