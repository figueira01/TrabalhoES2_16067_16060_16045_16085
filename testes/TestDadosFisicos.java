import es2.com.DadosFisicos;
import es2.com.Exceptions.InvalidException;
import es2.com.Pessoa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDadosFisicos
{
    private DadosFisicos dadosFisicos;


    @BeforeEach
    void setUp() throws InvalidException {
        dadosFisicos = new DadosFisicos(70,178,5,30,23,5,
                22,40,76);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testeDadosFisicos() throws InvalidException {

        DadosFisicos dadosFisicos = new DadosFisicos(70,178,5,30,23,3,
                22,60,65);
    }

    @Test
    void testepeso()
    {

        assertEquals(70,dadosFisicos.getPeso());

        dadosFisicos.setPeso(-20);
        assertThrows(InvalidException.class,() -> {dadosFisicos.getPeso();});

        dadosFisicos.setPeso(350);
        assertThrows(InvalidException.class,() -> {dadosFisicos.getPeso();});
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

    @Test
    void testGorduraCorporal()
    {
        assertEquals(5,dadosFisicos.getGorduraCorporal());
    }

    @Test
    void testGorduraCorporalBeLow4()
    {
        dadosFisicos.setGorduraCorporal(3);
        assertFalse(dadosFisicos.getGorduraCorporal() >= 4);
    }

    @Test
    void testGorduraCorporalAbove30()
    {
        dadosFisicos.setGorduraCorporal(31);
        assertFalse(dadosFisicos.getGorduraCorporal() <= 30);
    }

    @Test
    void testGorduraViscular()
    {
        assertEquals(30,dadosFisicos.getGorduraVisceral());
    }

    @Test
    void testGorduraViscularBeLow1()
    {
        dadosFisicos.setGorduraVisceral(0);
        assertFalse(dadosFisicos.getGorduraVisceral() >= 1);
    }

    @Test
    void testGorduraViscularAbove59()
    {
        dadosFisicos.setGorduraVisceral(60);
        assertFalse(dadosFisicos.getGorduraVisceral() <= 59);
    }

    @Test
    void testIdadeMetabolica()
    {
        assertEquals(23,dadosFisicos.getIdadeMetabolica());
    }

    @Test
    void testOsso()
    {
        assertEquals(5,dadosFisicos.getOsso());
    }

    @Test
    void testOssoBeLow5()
    {
        dadosFisicos.setOsso(4);
        assertFalse(dadosFisicos.getOsso() >= 5);
    }

    @Test
    void testOssoAbove15()
    {
        dadosFisicos.setOsso(16);
        assertFalse(dadosFisicos.getOsso() <= 5);
    }

    @Test
    void testIMC()
    {
        assertEquals(22,dadosFisicos.getImc());
    }

    @Test
    void testIMCBeLow15()
    {
        dadosFisicos.setImc(14);
        assertFalse(dadosFisicos.getImc() >=15);
    }

    @Test
    void testIMCAbove45()
    {
        dadosFisicos.setImc(46);
        assertFalse(dadosFisicos.getImc() <=45);
    }

    @Test
    void testMusculo()
    {
        assertEquals(40,dadosFisicos.getMusculo());
    }

    @Test
    void testMusculoAbove50()
    {
        dadosFisicos.setMusculo(51);
        assertFalse(dadosFisicos.getMusculo() <=50);
    }

    @Test
    void testMusculoBeLow20()
    {
        dadosFisicos.setMusculo(19);
        assertFalse(dadosFisicos.getMusculo() >=20);
    }

    @Test
    void testH2O()
    {
        assertEquals(76,dadosFisicos.getH20());
    }

    @Test
    void testH2OBeLOw65()
    {
        dadosFisicos.setH20(64);
        assertFalse(dadosFisicos.getH20() >=65);
    }

    @Test
    void testH2OAbove80()
    {
        dadosFisicos.setH20(81);
        assertFalse(dadosFisicos.getH20() <=80);
    }


}
