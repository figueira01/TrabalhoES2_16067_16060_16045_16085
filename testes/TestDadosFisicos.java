import es2.com.DadosFisicos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDadosFisicos
{
    private DadosFisicos dadosFisicos;


    @BeforeEach
    void setUp()
    {
        dadosFisicos = new DadosFisicos(70,178,5,30,23,3,
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
        assertTrue( dadosFisicos.getPeso() >= 1 &&  dadosFisicos.getPeso() <= 300);
    }

    @Test
    void testepesoBeLow1()
    {
        dadosFisicos.setPeso(-1);
        assertFalse( dadosFisicos.getPeso() >= 1);
    }

    @Test
    void testepesoUp300()
    {
        dadosFisicos.setPeso(301);
        assertFalse( dadosFisicos.getPeso() <= 300);
    }

    @Test
    void testeAltura()
    {
        assertEquals(178,dadosFisicos.getAltura());
    }
    @Test
    void testeAlturaBeLow45()
    {
        dadosFisicos.setAltura(44);
        assertFalse(dadosFisicos.getAltura() >= 45);
    }
    @Test
    void testeAlturaAbove270()
    {
        dadosFisicos.setAltura(271);
        assertFalse(dadosFisicos.getAltura() <= 270);
    }

}
