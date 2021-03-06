package es2.com;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Funcoes {

    private static final String COMMA_DELIMITER = ";";
    String d=";";

    public void LerDadosFisicos(List<List<DadosFisicos>> dadosFisicos)  {

        try (BufferedReader br = new BufferedReader(new FileReader("CSV/DadosFisicos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                dadosFisicos.add(Collections.singletonList(new DadosFisicos(Double.parseDouble(values[0]),Double.parseDouble(values[1]),

                        Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]),
                        Double.parseDouble(values[7]),Double.parseDouble(values[8]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LerDadosProdutos(List<List<Produto>> produtos){

        try (BufferedReader br = new BufferedReader(new FileReader("CSV/Produtos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                produtos.add(Collections.singletonList(new Produto(values[0],values[1],Double.parseDouble(values[2]),Double.parseDouble(values[3]),
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

    public void  LerPlanoAlimentar(String fichPlano,List<List<PlanoAlimentar>> plano){
        try (BufferedReader br = new BufferedReader(new FileReader(fichPlano))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                plano.add(Collections.singletonList(new PlanoAlimentar(values[0],values[1],
                        values[2],Double.parseDouble(values[3]))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LerPlanoAlimentarS(String fichPlano,List<List<String>> plano){

        try (BufferedReader br = new BufferedReader(new FileReader(fichPlano))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                plano.add(Arrays.asList(values[0],values[1],values[2],values[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void LerQuestionario(List<List<Questionario>> questionarios){

        try (BufferedReader br = new BufferedReader(new FileReader("CSV/Questionario.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                questionarios.add(Collections.singletonList(new Questionario(values[0],values[1],
                        values[2],values[3],values[4],values[5],values[6],values[7],Double.parseDouble(values[8])
                        ,Double.parseDouble(values[9]),Double.parseDouble(values[10]),Double.parseDouble(values[11]),
                        Double.parseDouble(values[12]),values[13],Integer.parseInt(values[14]))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double CalculationgetAcidoGordosSaturados(List<List<PlanoAlimentar>> planoAtual, String refeicao, boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidoGordosSaturados())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidoGordosSaturados())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationEnergia(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEnergiaKcal())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEnergiaKcal())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationEnergiaKj(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEnergiaKj())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEnergiaKj())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAgua(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAgua())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAgua())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationProteina(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getProteina())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getProteina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationGorduraTotal(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getGorduraTotal())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getGorduraTotal())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationHC(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTotalHCDisponivel())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTotalHCDisponivel())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationMono(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getMonoPlusDissacaridos())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getMonoPlusDissacaridos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAcidoOrganico(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosOrganicos())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosOrganicos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAlcool(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAlcool())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAlcool())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAmido(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAmido())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAmido())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationOligossacarido(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getOligossacaridos())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getOligossacaridos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationFibraAlimentar(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFibraAlimentar())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFibraAlimentar())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAcidoMonoinsaturado(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosMonoinsaturados())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosMonoinsaturados())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAcidoGordoPolinsaturado(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosPolinsaturados())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosPolinsaturados())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAcidoGordoTrans(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosTrans())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidosGordosTrans())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAcidoLinoleico(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidoLinoleico())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getAcidoLinoleico())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationAcidoColesterol(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getColesterol())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getColesterol())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationVitA(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitATotal())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitATotal())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationCaroteno(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCaroteno())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCaroteno())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationVitD(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitD())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitD())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationaTocofecol(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTocoferol())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTocoferol())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationTiamina(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTiamina())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTiamina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationRiboflavina(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getRiboflavina())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome()) && (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getRiboflavina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationEquivalenteNiacina(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEquivalentesDeNiacina())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getEquivalentesDeNiacina())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationNiacina(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getNiaciana())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getNiaciana())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationTriptofano(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTriptofano60())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getTriptofano60())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationVitB(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitB6())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitB6())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationVitB12(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitB12())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitB12())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationVitC(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitC())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getVitC())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationFolatos(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFolatos())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFolatos())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationCinza(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCinza())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCinza())/100;
                }
            }
        }
        return EnergiaKj;
    }

    public double CalculationNa(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getNa())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getNa())/100;
                }
            }
        }
        return EnergiaKj;
    }
    public double CalculationK(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getK())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getK())/100;
                }
            }
        }
        return EnergiaKj;
    }
    public double CalculationCa(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCa())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getCa())/100;
                }
            }
        }
        return EnergiaKj;
    }
    public double CalculationP(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getP())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getP())/100;
                }
            }
        }
        return EnergiaKj;
    }
    public double CalculationMg(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getMg())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getMg())/100;
                }
            }
        }
        return EnergiaKj;
    }
    public double CalculationFe(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFe())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getFe())/100;
                }
            }
        }
        return EnergiaKj;
    }
    public double CalculationZe(List<List<PlanoAlimentar>> planoAtual,String refeicao,boolean prescrito,List<List<Produto>> produtos)
    {
        double EnergiaKj = 0;

        for(List<PlanoAlimentar> i : planoAtual)
        {
            for(List<Produto> a : produtos)
            {
                if((prescrito) && (i.get(0).getComida().equals(a.get(0).getNome())))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getZn())/100;
                }
                else if(i.get(0).getComida().equals(a.get(0).getNome())&& (i.get(0).getRefeicao().equals(refeicao)))
                {
                    EnergiaKj += (i.get(0).getQuantidade()*a.get(0).getZn())/100;
                }
            }
        }
        return EnergiaKj;
    }


    public void WriteToCsv(List<List<String>> planoAtual,List<List<PlanoAlimentar>> planoAtualP,List<List<Produto>> produtos) throws IOException {
        String refeicao = planoAtual.get(0).get(0);

        FileWriter csvWriter = new FileWriter("PlanoAlimentarAtual.csv");
        csvWriter.append("Refeicao");
        csvWriter.append(d);
        csvWriter.append("Hora");
        csvWriter.append(d);
        csvWriter.append("Comida");
        csvWriter.append(d);
        csvWriter.append("Quantidade");
        csvWriter.append("\n");

        for(List<String> rowData : planoAtual){
            if(refeicao.equals(rowData.get(0)))
            {
                csvWriter.append(String.join(d, rowData));
                csvWriter.append("\n");
            }else
            {
                csvWriter.append("Por Refeicao");
                csvWriterAppend(csvWriter,refeicao,planoAtualP,false, produtos);
                csvWriter.append(String.join(d, rowData));
                csvWriter.append("\n");
                refeicao = rowData.get(0);
            }
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public void WriteToCsvPrescrito(List<List<String>> planoPrescritoS,List<List<PlanoAlimentar>> planoPrescrito,Pessoa pessoa,List<List<Produto>> produtos) throws Exception {
        String refeicao = planoPrescritoS.get(0).get(0);

        FileWriter csvWriter = new FileWriter("PlanoAlimentarPrescrito.csv");
        csvWriter.append("Plano Alimentar Prescrito");
        csvWriter.append("\n \n");
        csvWriter.append("Refeicao");
        csvWriter.append(d);
        csvWriter.append("Hora");
        csvWriter.append(d);
        csvWriter.append("Comida");
        csvWriter.append(d);
        csvWriter.append("Quantidade");
        csvWriter.append("\n");

        for(List<String> rowData : planoPrescritoS){
            csvWriter.append(String.join(d, rowData));
            csvWriter.append("\n");
        }
        csvWriter.append("Total");
        csvWriterAppend(csvWriter,refeicao,planoPrescrito,true, produtos);
        csvWriter.append("Energia");
        csvWriter.append(d);
        csvWriter.append(d);
        csvWriter.append("Metabolismo Basal");
        csvWriter.append(d);
        csvWriter.append("Metabolismo Basal + Fator Atividade");
        csvWriter.append(d);
        csvWriter.append("Metabolismo Basal + Fator Termico");
        csvWriter.append(d);
        csvWriter.append("Metabolismo Basal + Fator Lesao");
        csvWriter.append(d);
        csvWriter.append("Proteina");
        csvWriter.append(d);
        csvWriter.append("Gordura");
        csvWriter.append(d);
        csvWriter.append("Hidratos de Carbonos");
        csvWriter.append(d);
        csvWriter.append("SchofieldEquation");
        csvWriter.append("\n");
        csvWriter.append(d);
        csvWriter.append(d);
        csvWriter.append(Double.toString(pessoa.CalcularTMB()));
        csvWriter.append(d);
        csvWriter.append(Double.toString(pessoa.CalcularTMBComFa()));
        csvWriter.append(d);
        csvWriter.append(Double.toString(pessoa.CalcularTMBComFT()));
        csvWriter.append(d);
        csvWriter.append(Double.toString(pessoa.CalcularGET()));
        csvWriter.append(d);
        csvWriter.append(Double.toString(pessoa.getDadosFisicos().getPeso()*2));
        csvWriter.append(d);
        csvWriter.append(Double.toString(pessoa.getDadosFisicos().getPeso()*1.1));
        csvWriter.append(d);
        csvWriter.append(Double.toString((pessoa.CalcularTMB()-((pessoa.getDadosFisicos().getPeso()*2)*4)-((pessoa.getDadosFisicos().getPeso()*1.1)*4))/4));
        csvWriter.append(d);
        csvWriter.append(Double.toString(pessoa.CalcularSchofieldEquation()));

        csvWriter.flush();
        csvWriter.close();
    }

    public void csvWriterAppend(FileWriter csvWriter,String refeicao,List<List<PlanoAlimentar>> planoPrescrito,boolean atual,List<List<Produto>> produtos) throws IOException {
        csvWriter.append(d);
        csvWriter.append(d);
        csvWriter.append("Energia (kcal)");
        csvWriter.append(d);
        csvWriter.append("Energia (kj)");
        csvWriter.append(d);
        csvWriter.append("Agua");
        csvWriter.append(d);
        csvWriter.append("Proteina");
        csvWriter.append(d);
        csvWriter.append("Gordura total");
        csvWriter.append(d);
        csvWriter.append("Total HC disponiveis");
        csvWriter.append(d);
        csvWriter.append("Mono + dissacaridos");
        csvWriter.append(d);
        csvWriter.append("Acidos organicos");
        csvWriter.append(d);
        csvWriter.append("Alcool");
        csvWriter.append(d);
        csvWriter.append("Amido");
        csvWriter.append(d);
        csvWriter.append("Oligossacaridos");
        csvWriter.append(d);
        csvWriter.append("Fibra alimentar");
        csvWriter.append(d);
        csvWriter.append("Acidos gordos saturados");
        csvWriter.append(d);
        csvWriter.append("Acidos gordos monoinsaturados");
        csvWriter.append(d);
        csvWriter.append("Acidos gordos polinsaturados");
        csvWriter.append(d);
        csvWriter.append("Acidos gordos trans");
        csvWriter.append(d);
        csvWriter.append("Acido linoleico");
        csvWriter.append(d);
        csvWriter.append("Colesterol");
        csvWriter.append(d);
        csvWriter.append("Vit A total");
        csvWriter.append(d);
        csvWriter.append("Caroteno");
        csvWriter.append(d);
        csvWriter.append("vit. D");
        csvWriter.append(d);
        csvWriter.append("a-tocoferol");
        csvWriter.append(d);
        csvWriter.append("Tiamina");
        csvWriter.append(d);
        csvWriter.append("Riboflavina");
        csvWriter.append(d);
        csvWriter.append("Equivalentes de niacina");
        csvWriter.append(d);
        csvWriter.append("Niacina");
        csvWriter.append(d);
        csvWriter.append("Triptofano/60");
        csvWriter.append(d);
        csvWriter.append("vit B6");
        csvWriter.append(d);
        csvWriter.append("Vit. B12");
        csvWriter.append(d);
        csvWriter.append("vit. C");
        csvWriter.append(d);
        csvWriter.append("Folatos");
        csvWriter.append(d);
        csvWriter.append("Cinza");
        csvWriter.append(d);
        csvWriter.append("Na");
        csvWriter.append(d);
        csvWriter.append("K");
        csvWriter.append(d);
        csvWriter.append("Ca");
        csvWriter.append(d);
        csvWriter.append("P");
        csvWriter.append(d);
        csvWriter.append("Mg");
        csvWriter.append(d);
        csvWriter.append("Fe");
        csvWriter.append(d);
        csvWriter.append("Ze");
        csvWriter.append("\n");
        csvWriter.append(d);
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationEnergia(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationEnergiaKj(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAgua(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationProteina(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationGorduraTotal(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationHC(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationMono(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAcidoOrganico(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAlcool(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAmido(planoPrescrito,refeicao,atual, produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationOligossacarido(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationFibraAlimentar(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationgetAcidoGordosSaturados(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAcidoMonoinsaturado(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAcidoGordoPolinsaturado(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAcidoGordoTrans(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAcidoLinoleico(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationAcidoColesterol(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationVitA(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationCaroteno(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationVitD(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationaTocofecol(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationTiamina(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationRiboflavina(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationEquivalenteNiacina(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationNiacina(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationTriptofano(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationVitB(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationVitB12(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationVitC(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationFolatos(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationCinza(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationNa(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationK(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationCa(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationP(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationMg(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationFe(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append(d);
        csvWriter.append(Double.toString(CalculationZe(planoPrescrito,refeicao,atual,produtos)));
        csvWriter.append("\n");
    }
}
