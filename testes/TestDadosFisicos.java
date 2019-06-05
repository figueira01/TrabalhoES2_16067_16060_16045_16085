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
        dadosFisicos = new DadosFisicos(70,178,20,30,23,3,
                22,60,6500,65);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testeDadosFisicos()
    {
        dadosFisicos = new DadosFisicos(70,178,20,30,23,3,
                22,60,6500,65);
    }

    @Test
    void testePeso()
    {
        assertTrue( dadosFisicos.getPeso() >= 1 &&  dadosFisicos.getPeso() <= 300);
    }

    @Test
    void testePesoFalse()
    {
        assertFalse( dadosFisicos.getPeso() < 1 ||  dadosFisicos.getPeso() > 300);
    }

    @Test
    void testeAltura()
    {
        assertTrue( dadosFisicos.getAltura() >= 54 &&  dadosFisicos.getAltura() <= 250);
    }

    @Test
    void testeAlturaFalse()
    {
        assertFalse( dadosFisicos.getAltura() < 54 ||  dadosFisicos.getAltura() > 250);
    }

    @Test
    void testeGorduraCorporal()
    {
        assertTrue( dadosFisicos.getGorduraCorporal() >= 0 &&  dadosFisicos.getGorduraCorporal() <= 100);
    }

    @Test
    void testeGorduraCorporalFalse()
    {
        assertFalse( dadosFisicos.getGorduraCorporal() < 0 ||  dadosFisicos.getGorduraCorporal() > 100);
    }

    @Test
    void testeGorduraVisceral()
    {
        assertTrue( dadosFisicos.getGorduraVisceral() >= 0 &&  dadosFisicos.getGorduraVisceral() <= 50);
    }

    @Test
    void testeGorduraVisceralFalse()
    {
        assertFalse( dadosFisicos.getGorduraVisceral() < 0 ||  dadosFisicos.getGorduraVisceral() > 50);
    }

    @Test
    void testeIdadeMetabolica()
    {
        assertTrue(dadosFisicos.getIdadeMetabolica() >= 0 &&  dadosFisicos.getGorduraVisceral() <= 100);
    }

    @Test
    void testeIdadeMetabolicaFalse()
    {
        assertFalse(dadosFisicos.getIdadeMetabolica()<  0 ||  dadosFisicos.getGorduraVisceral() > 100);
    }

    @Test
    void testeOsso()
    {
        assertTrue(dadosFisicos.getOsso() >= 0 &&  dadosFisicos.getOsso() <= 5);
    }

    @Test
    void testeOssoFalse()
    {
        assertFalse(dadosFisicos.getOsso() < 0 ||  dadosFisicos.getOsso() > 5);
    }

    @Test
    void testeIMC()
    {
        assertTrue(dadosFisicos.getImc()>= 0 &&  dadosFisicos.getImc() <= 50);
    }

    @Test
    void testeIMCFalse()
    {
        assertFalse(dadosFisicos.getImc() < 0 ||  dadosFisicos.getImc() > 50);
    }

    @Test
    void testeMusculo()
    {
        assertTrue(dadosFisicos.getMusculo()>= 0 &&  dadosFisicos.getMusculo() <= 100);
    }

    @Test
    void testeMusculoFalse()
    {
        assertFalse(dadosFisicos.getMusculo() < 0 &&  dadosFisicos.getMusculo() > 100);
    }

    @Test
    void testeMetabolismoBasal()
    {
        assertTrue(dadosFisicos.getMetabolismoBasal()>= 0 &&  dadosFisicos.getMetabolismoBasal() <= 12000);
    }

    @Test
    void testeMetabolismoBasalFalse()
    {
        assertFalse(dadosFisicos.getMetabolismoBasal() < 0 ||  dadosFisicos.getMetabolismoBasal() > 12000);
    }

    @Test
    void testeH2O()
    {
        assertTrue(dadosFisicos.getH20()>= 0 &&  dadosFisicos.getH20() <= 100);
    }

    @Test
    void testeH2OFalse()
    {
        assertFalse(dadosFisicos.getH20() < 0 ||  dadosFisicos.getH20() > 100);
    }
}
