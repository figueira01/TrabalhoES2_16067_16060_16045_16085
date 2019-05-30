package es2.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    private static DadosFisicos dF;
    private static final String COMMA_DELIMITER = ";";

    public static void main(String [] args)
    {
        List<List<String>> records = new ArrayList<>();
        List<List<DadosFisicos>> ListDados = new ArrayList<List<DadosFisicos>>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/estgv/3º/ES2/DadosFisicos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
               // ListDados.add(new DadosFisicos(Double.parseDouble(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),values[4],values[5],Double.parseDouble(values[6]),Double.parseDouble(values[7]),Double.parseDouble(values[8]),Double.parseDouble(values[9])));
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(records.get(0).get(2));


        /*for(int i=0;i<records.size();i++)
        {
            System.out.println(records.get(i));
        }*/

    }
}
