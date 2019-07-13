import es2.com.Client;
import es2.com.Funcoes;
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
    private boolean bool;
    private Funcoes funcoes;
    private String url = "CSV/PlanoAlimentarAtual.csv";

    @BeforeEach
    void setUp()
    {
        planoAtual = new ArrayList<>();
        refeicao = "pequeno almoco";
        bool = true;
        funcoes = new Funcoes();
        //funcoes.LerPlanoAlimentar(url,);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    public void CalculationgetAcidoGordosSaturadosV()
    {
        //funcoes.CalculationgetAcidoGordosSaturados()
    }
}
