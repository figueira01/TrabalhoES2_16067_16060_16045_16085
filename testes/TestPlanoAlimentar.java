import es2.com.PlanoAlimentar;
import es2.com.Refeicao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TestPlanoAlimentar {

    private HashMap<String,Double> hashrefeicao;
    private PlanoAlimentar planoAlimentar;

    @BeforeEach
    void setUp(){
        hashrefeicao = new HashMap<>();
        planoAlimentar = new PlanoAlimentar();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testaddRefeicao()
    {
        planoAlimentar.addRefeicao("Pequeno-almoco", LocalDate.now(),hashrefeicao);
        //assertEquals(planoAlimentar.addRefeicao("Pequeno-almoco", LocalDate.now(),hashrefeicao),planoAlimentar.getRefeicao("Pequeno-almoco"));
    }
}