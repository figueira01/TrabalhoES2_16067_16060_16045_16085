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

    private void LerDadosFisicos(){

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

    private void LerDadosProdutos(){

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
    private void LerPlanoAlimentarAtual(){

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

    private void LerPlanoAlimentarAtualS(){

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

    private void LerQuestionario(){

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

    private double CalculationgetAcidoGordosSaturados(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidoGordosSaturados())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationEnergia(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEnergiaKcal())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationEnergiaKj(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEnergiaKj())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAgua(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAgua())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationProteina(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getProteina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationGorduraTotal(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getGorduraTotal())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationHC(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTotalHCDisponivel())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationMono(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getMonoPlusDissacaridos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAcidoOrganico(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosOrganicos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAlcool(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAlcool())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAmido(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAmido())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationOligossacarido(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getOligossacaridos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationFibraAlimentar(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFibraAlimentar())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAcidoMonoinsaturado(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosMonoinsaturados())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAcidoGordoPolinsaturado(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosPolinsaturados())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAcidoGordoTrans(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosTrans())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAcidoLinoleico(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidoLinoleico())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationAcidoColesterol(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getColesterol())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationVitA(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitATotal())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationCaroteno(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCaroteno())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationVitD(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitD())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationaTocofecol(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTocoferol())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationTiamina(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTiamina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationRiboflavina(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome()) && (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getRiboflavina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationEquivalenteNiacina(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEquivalentesDeNiacina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationNiacina(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getNiaciana())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationTriptofano(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTriptofano60())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationVitB(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitB6())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationVitB12(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitB12())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationVitC(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitC())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationFolatos(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFolatos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationCinza(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCinza())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private double CalculationNa(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getNa())/100;
                }
            }
        }
        return EnergiaKj;
    }
    private double CalculationK(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getK())/100;
                }
            }
        }
        return EnergiaKj;
    }
    private double CalculationCa(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCa())/100;
                }
            }
        }
        return EnergiaKj;
    }
    private double CalculationP(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getP())/100;
                }
            }
        }
        return EnergiaKj;
    }
    private double CalculationMg(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getMg())/100;
                }
            }
        }
        return EnergiaKj;
    }
    private double CalculationFe(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFe())/100;
                }
            }
        }
        return EnergiaKj;
    }
    private double CalculationZe(List<List<PlanoAlimentar>> planoAtual,String refeicao)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getZn())/100;
                }
            }
        }
        return EnergiaKj;
    }

    private void WriteToCsv(List<List<String>> planoAtual,List<List<PlanoAlimentar>> planoAtualP) throws IOException {
        String refeicao = planoAtual.get(0).get(0);

        FileWriter csvWriter = new FileWriter("PlanoAlimentarAtual.csv");
        csvWriter.append("Plano Alimentar Atual");
        csvWriter.append("\n");
        csvWriter.append("Refeicao");
        csvWriter.append(",");
        csvWriter.append("Hora");
        csvWriter.append("\n");

        for(List<String> rowData : planoAtual){
            if(refeicao.equals(rowData.get(0)))
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
                csvWriter.append(",");
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationEnergia(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationEnergiaKj(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAgua(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationProteina(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationGorduraTotal(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationHC(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationMono(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAcidoOrganico(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAlcool(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAmido(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationOligossacarido(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationFibraAlimentar(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationgetAcidoGordosSaturados(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAcidoMonoinsaturado(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAcidoGordoPolinsaturado(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAcidoGordoTrans(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAcidoLinoleico(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationAcidoColesterol(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationVitA(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationCaroteno(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationVitD(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationaTocofecol(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationTiamina(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationRiboflavina(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationEquivalenteNiacina(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationNiacina(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationTriptofano(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationVitB(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationVitB12(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationVitC(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationFolatos(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationCinza(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationNa(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationK(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationCa(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationP(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationMg(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationFe(planoAtualP,refeicao)));
                csvWriter.append(",");
                csvWriter.append(Double.toString(CalculationZe(planoAtualP,refeicao)));
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
        client.WriteToCsv(planoAtualS,planoAtual);


        //Pessoa pessoa = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos.get(0).get(0),planoAtual.get(0).get(0),questionarios.get(0).get(0));
        //System.out.println(pessoa.CalcularTMB());
        //System.out.println("Altura = " + dadosFisicos.get(1).get(0).getAltura());
        //System.out.println("Altura = " + questionarios.get(0).get(0).getAtividadeFisica());

        /*double x=0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if(i.get(0).getComida().equals(a.get(0).getNome()))
                {
                    x = (i.get(0).getQuantidade()*a.get(0).getAcidoGordosSaturados())/100;
                    System.out.println(x);

                }

            }
        System.out.println("acidos = "+ x);
*/
    }

}
