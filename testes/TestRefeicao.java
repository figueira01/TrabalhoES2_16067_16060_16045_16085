import es2.com.Questionario;
import es2.com.Refeicao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestRefeicao {

    private HashMap<String,Double> hashrefeicao;
    private Refeicao refeicao;

    @BeforeEach
    void setUp(){
        hashrefeicao = new HashMap<>();
        refeicao = new Refeicao("10:20",hashrefeicao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRefeicao()
    {
        HashMap<String,Double> hashrefeicao = new HashMap<>();
        Refeicao refeicao = new Refeicao("10:20",hashrefeicao);
    }

    @Test
    void testHora()
    {
        assertEquals("10:20",refeicao.getHora());
    }

    @Test
    void testHashMap()
    {
        assertEquals(hashrefeicao,refeicao.getComida());
    }
}
