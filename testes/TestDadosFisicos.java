import es2.com.DadosFisicos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDadosFisicos
{
    private DadosFisicos  dadosFisicos;


    @BeforeEach
    void setUp()
    {
        DadosFisicos dadosFisicos = new DadosFisicos(70,178,5,30,23,3,
                22,60,6500,65);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testeDadosFisicos()
    {
        DadosFisicos dadosFisicos = new DadosFisicos(70,178,5,30,23,3,
                22,60,6500,65);
    }

    @Test
    void testepeso()
    {
        System.out.println("aqui!!!");
        assertTrue( dadosFisicos.getPeso() >= 1 &&  dadosFisicos.getPeso() <= 300);
    }
}
