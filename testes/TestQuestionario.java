import es2.com.PlanoAlimentar;
import es2.com.Questionario;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQuestionario {
    //BlackBox Partições

    private Questionario questionario;
    @BeforeEach
    void setUp(){
        questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstrutorQuestionario()
    {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
    }

    @Test
    void TestMotivoConsulta() {
        questionario.setMotivoConsulta("Perder peso");
        assertEquals("Perder peso",questionario.getMotivoConsulta());
    }

    @Test
    void TestObjectivo() {
        questionario.setObjectivo("Perder peso");
        assertEquals("Perder peso",questionario.getObjectivo());
    }

    @Test
    void TestPatologia() {
        questionario.setPatologia("Autismo");
        assertEquals("Autismo",questionario.getPatologia());
    }

    @Test
    void TestMedicacao() {
        questionario.setMedicacao("Brufen");
        assertEquals("Brufen",questionario.getMedicacao());
    }

    @Test
    void TestAntecedentesFamiliares() {
        questionario.setAntecedentesFamiliares("Alzheimer");
        assertEquals("Alzheimer",questionario.getAntecedentesFamiliares());
    }

    @Test
    void TestAtividadeFisica() {
        questionario.setAtividadeFisica("Moderado");
        assertEquals("Moderado",questionario.getAtividadeFisica());
    }

    @Test
    void TestFuncaoIntestival() {
        questionario.setFuncaoIntestival("Normal");
        assertEquals("Normal",questionario.getFuncaoIntestival());
    }

    @Test
    void TestConsumoAgua() {
        questionario.setConsumoAgua("1.5 a 2.0 L");
        assertEquals("1.5 a 2.0 L",questionario.getConsumoAgua());
    }

    @Test
    void TestLesao() {
        questionario.setLesao("Queimadura");
        assertEquals("Queimadura",questionario.getLesao());
    }

    @Test
    void TestTermico() {
        questionario.setTermico(11);
        assertEquals(11,questionario.getTermico());
    }

    @Test
    void TestTermicoBelowZero() {
        questionario.setTermico(-1);
        assertFalse(questionario.getTermico() > 0);
    }

    @Test
    void TestTermicoUpTwenty() {
        questionario.setTermico(21);
        assertFalse(questionario.getTermico() < 20);
    }

    @Test
    void TestColesterolUp240() {
        //
        questionario.setColesterol(0.241);
        assertFalse(questionario.getColesterol() < 0.24);
    }

    @Test
    void TestColesterolBeLow150() {
        //
        questionario.setColesterol(0.149);
        assertFalse(questionario.getColesterol() > 0.150);
    }

    @Test
    void TestColesterolBetween150To240() {
        //
        questionario.setColesterol(0.20);
        assertTrue(questionario.getColesterol() > 0.15 && questionario.getColesterol() < 0.24);
    }

    @Test
    void TestGlicemia() {
        questionario.setGlicemia(11);
        assertEquals(11,questionario.getGlicemia());
    }

    @Test
    void TestUrina() {

        questionario.setUrina(11);
        assertEquals(11,questionario.getUrina());
    }

    @Test
    void TestCreatina() {
        questionario.setCreatina(11);
        assertEquals(11,questionario.getCreatina());
    }

    @Test
    void TestProteina() {
        questionario.setProteina(11);
        assertEquals(11,questionario.getProteina());
    }

}
