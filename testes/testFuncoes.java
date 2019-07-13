import es2.com.Client;
import es2.com.PlanoAlimentar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testFuncoes {

    private List<List<PlanoAlimentar>> planoAtual;
    private String refeicao;
    boolean bool;
    private Client client;

    @BeforeEach
    void setUp()
    {
        planoAtual = new ArrayList<>();
        refeicao = "pequeno almoco";
        bool = true;
        client = new Client();
        //client.LerPlanoAlimentar("CSV/PlanoAlimentarPrescrito.csv",planoAtual);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    public void CalculationgetAcidoGordosSaturadosV()
    {

        //double a = client.CalculationAcidoColesterol(planoAtual,refeicao,false);
        //System.out.println(a);
        //assertEquals(12.999,client.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,bool));
    }
}
