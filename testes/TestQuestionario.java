import es2.com.Questionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestQuestionario {

    private Questionario questionario;

    @BeforeEach
    void setUp()
    {
        questionario = new Questionario("Perda Peso","Perda Peso","nenhuma","nenhuma","aaa","Sedentario","Normal","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testContrutorQuestionario()
    {
        questionario = new Questionario("aaaa","aaa","aaa","aa","aaa","Sedentario","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
    }

    @Test
    void testMotivoConsulta()
    {
        assertEquals("Perda Peso",questionario.getMotivoConsulta());
    }

    @Test
    void testObjectivo()
    {
        assertEquals("Perda Peso",questionario.getObjectivo());
    }

    @Test
    void testPatologia()
    {
        assertEquals("nenhuma",questionario.getPatologia());
    }

    @Test
    void testMedicacao()
    {
        assertEquals("nenhuma",questionario.getMedicacao());
    }

    @Test
    void testAntecedentesFamiliares()
    {
        assertEquals("aaa",questionario.getAntecedentesFamiliares());
    }

    @Test
    void testAtividadeFisica()
    {
        assertEquals("Sedentario",questionario.getAtividadeFisica());
    }

    @Test
    void testFuncaoIntestival()
    {
        assertEquals("Normal",questionario.getFuncaoIntestival());
    }

    @Test
    void testConsumoDeAgua()
    {

    }

}
