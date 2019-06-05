import es2.com.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class TestPlanoAlimentar {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstrutorPlanoAlimentar()
    {
        PlanoAlimentar plano = new PlanoAlimentar();
    }


    @Test
    void testPlanoAlimentarAddRefeicao(){
        PlanoAlimentar plano = new PlanoAlimentar();
        HashMap<String,Double> comida = new HashMap<>();
        comida.put("Pão",100.0);
        comida.put("Queijo",10.0);
        comida.put("Leite",120.0);
        plano.addRefeicao("Pequeno-almoço","06:25", comida);
        Refeicao ref = new Refeicao("06:25",comida);
        Assertions.assertEquals(ref.getHora() , plano.getRefeicao("Pequeno-almoço").getHora());
        Assertions.assertEquals(ref.getComida() , plano.getRefeicao("Pequeno-almoço").getComida());
    }

}