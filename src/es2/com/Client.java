package es2.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    private static final String COMMA_DELIMITER = ";";
    private static final String diretoriaDadosFisicos = "C:/estgv/3º/ES2/DadosFisicos.csv";
    private static final String diretoriaProdutos = "C:/estgv/3º/ES2/Produtos.csv";
    private static final List<List<DadosFisicos>> records = new ArrayList<>();
    private static final List<List<Produto>> produtoArrayList = new ArrayList<>();

    public static void main(String [] args)
    {
        Client c = new Client();
        c.convertCSV(diretoriaProdutos,"Produtos");
        //for(int a = 0 ; a < produtoArrayList.size(); a++){
         //   System.out.println(produtoArrayList.get(a));
        //}
        System.out.println(produtoArrayList.get(0).get(0).getNome());
    }

    public void convertCSV(String diretoria,String type)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(diretoria))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                //produtoArrayList.add(Arrays.asList(values));
                if(type == "DadosFisicos"){
                    records.add(Arrays.asList(new DadosFisicos(Double.parseDouble(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),values[4],values[5],Double.parseDouble(values[6]),Double.parseDouble(values[7]),Double.parseDouble(values[8]),Double.parseDouble(values[9]))));
                }
                if(type == "Produtos")
                {
                    produtoArrayList.add(Arrays.asList(new Produto(values[0],values[1],Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]),Double.parseDouble(values[7]),Double.parseDouble(values[8]),Double.parseDouble(values[9]),Double.parseDouble(values[10]),Double.parseDouble(values[11]),Double.parseDouble(values[12]),Double.parseDouble(values[13]),Double.parseDouble(values[14]),Double.parseDouble(values[15]),Double.parseDouble(values[16]),Double.parseDouble(values[17]),Double.parseDouble(values[18]),Double.parseDouble(values[19]),Double.parseDouble(values[20]),Double.parseDouble(values[21]),Double.parseDouble(values[22]),Double.parseDouble(values[23]),Double.parseDouble(values[24]),Double.parseDouble(values[25]),Double.parseDouble(values[26]),Double.parseDouble(values[27]),Double.parseDouble(values[28]),Double.parseDouble(values[29]),Double.parseDouble(values[30]),Double.parseDouble(values[31]),Double.parseDouble(values[32]),Double.parseDouble(values[33]),Double.parseDouble(values[34]),Double.parseDouble(values[35]),Double.parseDouble(values[36]),Double.parseDouble(values[37]),Double.parseDouble(values[38]),Double.parseDouble(values[39]),Double.parseDouble(values[40]),Double.parseDouble(values[41]),Double.parseDouble(values[42]))));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
