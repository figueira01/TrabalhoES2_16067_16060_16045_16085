import es2.com.DadosFisicos;
import es2.com.Exceptions.InvalidException;
import es2.com.Pessoa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDadosFisicos {
    private DadosFisicos dadosFisicos;


    @BeforeEach
    void setUp() throws InvalidException {
        dadosFisicos = new DadosFisicos(70, 1.7, 5, 30, 23, 3, 22, 60, 65);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testeConstrutorDadosFisicos() throws AssertionError {

        DadosFisicos df = new DadosFisicos(70, 1.7, 5, 30, 23, 3, 22, 60, 65);

        assertEquals(70, df.getPeso());
        assertEquals(1.7, df.getAltura());
        assertEquals(5, df.getGorduraCorporal());
        assertEquals(30, df.getGorduraVisceral());
        assertEquals(23, df.getIdadeMetabolica());
        assertEquals(3, df.getOsso());
        assertEquals(22, df.getImc());
        assertEquals(60, df.getMusculo());
        assertEquals(65, df.getH20());

        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(400, 1.7, 5, 30, 23, 3, 22, 60, 65);
        });

        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(-1, 1.7, 5, 30, 23, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, -2, 5, 30, 23, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 3.7, 5, 30, 23, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, -5, 30, 23, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 150, 30, 23, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, -1, 23, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 100, 23, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 120, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 0, 3, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, -1, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, 10, 22, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, 3, 101, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, 3, -2, 60, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, 3, 20, 150, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, 3, 20, -4, 65);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, 3, 20, 80, -2);
        });
        assertThrows(AssertionError.class, () -> {
            new DadosFisicos(80, 1.7, 20, 5, 20, 3, 20, 80, 160);
        });


    }

    @Test
    void testePeso() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setPeso(301);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setPeso(-1);
        });

        dadosFisicos.setPeso(50);
        assertEquals(50, dadosFisicos.getPeso());

    }

    @Test
    void testeAltura() throws AssertionError {
        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setAltura(3);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setAltura(0);
        });

        dadosFisicos.setAltura(1.80);
        assertEquals(1.80, dadosFisicos.getAltura());
    }

    @Test
    void testeGorduraCorporal() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setGorduraCorporal(90);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setGorduraCorporal(0);
        });

        dadosFisicos.setGorduraCorporal(6);
        assertEquals(6, dadosFisicos.getGorduraCorporal());
    }

    @Test
    void testeGorduraVisceral() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setGorduraVisceral(90);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setGorduraVisceral(0);
        });

        dadosFisicos.setGorduraVisceral(6);
        assertEquals(6, dadosFisicos.getGorduraVisceral());
    }

    @Test
    void testeIdadeMetabolica() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setIdadeMetabolica(100);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setIdadeMetabolica(0);
        });

        dadosFisicos.setIdadeMetabolica(20);
        assertEquals(20, dadosFisicos.getIdadeMetabolica());
    }

    @Test
    void testeOsso() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setOsso(6);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setOsso(-1);
        });

        dadosFisicos.setOsso(4);
        assertEquals(4, dadosFisicos.getOsso());
    }

    @Test
    void testeIMC() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setImc(51);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setImc(-1);
        });

        dadosFisicos.setImc(12);
        assertEquals(12, dadosFisicos.getImc());
    }

    @Test
    void testeMusculo() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setMusculo(101);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setMusculo(-1);
        });

        dadosFisicos.setMusculo(80);
        assertEquals(80, dadosFisicos.getMusculo());
    }

    @Test
    void testeH20() throws AssertionError {

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setH20(101);
        });

        assertThrows(AssertionError.class, () -> {
            dadosFisicos.setH20(-1);
        });

        dadosFisicos.setH20(60);
        assertEquals(60, dadosFisicos.getH20());
    }
}

