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
        dadosFisicos = new DadosFisicos(70,1.7,5,30,23,3, 22,60,65);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testeDadosFisicos() throws InvalidException {

        DadosFisicos dadosFisicos = new DadosFisicos(70,1.78,5,30,23,3,
                22,30,30);
    }

    @Test
    void testeConstrutorDadosFisicos() throws InvalidException {

        DadosFisicos df = new DadosFisicos(70,1.7,5,30,23,3, 22,60,65);

        assertEquals(70,df.getPeso());
        assertEquals(1.7,df.getAltura());
        assertEquals(5,df.getGorduraCorporal());
        assertEquals(30,df.getGorduraVisceral());
        assertEquals(23,df.getIdadeMetabolica());
        assertEquals(3,df.getOsso());
        assertEquals(22,df.getImc());
        assertEquals(60,df.getMusculo());
        assertEquals(65,df.getH20());

    }

    @Test
    void testeSetPeso() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setPeso(301);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setPeso(-1);
        });

        dadosFisicos.setPeso(50);

    }

    @Test
    void testeSetAltura() throws AssertionError {
        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setAltura(3);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setAltura(0);
        });

        dadosFisicos.setAltura(1.80);
    }

    @Test
    void testeSetGorduraCorporal() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setGorduraCorporal(90);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setGorduraCorporal(0);
        });

        dadosFisicos.setGorduraCorporal(6);
    }

    @Test
    void testeSetGorduraVisceral() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setGorduraVisceral(90);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setGorduraVisceral(0);
        });

        dadosFisicos.setGorduraVisceral(6);
    }

    @Test
    void testeSetIdadeMetabolica() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setIdadeMetabolica(100);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setIdadeMetabolica(0);
        });

        dadosFisicos.setIdadeMetabolica(20);
    }

    @Test
    void testeSetOsso() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setOsso(6);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setOsso(-1);
        });

        dadosFisicos.setOsso(4);
    }

    @Test
    void testeSetIMC() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setImc(51);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setImc(-1);
        });

        dadosFisicos.setImc(12);
    }

    @Test
    void testeSetMusculo() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setMusculo(101);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setMusculo(-1);
        });

        dadosFisicos.setMusculo(80);
    }

    @Test
    void testeSetH20() throws AssertionError {

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setH20(101);
        });

        assertThrows(AssertionError.class,() -> {
            dadosFisicos.setH20(-1);
        });

        dadosFisicos.setH20(60);
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
