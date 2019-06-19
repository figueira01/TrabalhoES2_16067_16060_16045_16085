import es2.com.PlanoAlimentar;
import es2.com.Questionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals("Perder peso",questionario.getMotivoConsulta());
    }

    @Test
    void TestObjectivo() {
        questionario.setObjectivo("Perder peso");
        Assertions.assertEquals("Perder peso",questionario.getObjectivo());
    }

    @Test
    void TestPatologia() {
        questionario.setPatologia("Autismo");
        Assertions.assertEquals("Autismo",questionario.getPatologia());
    }

    @Test
    void TestMedicacao() {
        questionario.setMedicacao("Brufen");
        Assertions.assertEquals("Brufen",questionario.getMedicacao());
    }

    @Test
    void TestAntecedentesFamiliares() {
        questionario.setAntecedentesFamiliares("Alzheimer");
        Assertions.assertEquals("Alzheimer",questionario.getAntecedentesFamiliares());
    }

    @Test
    void TestAtividadeFisica() {
        questionario.setAtividadeFisica("Moderado");
        Assertions.assertEquals("Moderado",questionario.getAtividadeFisica());
    }

    @Test
    void TestFuncaoIntestival() {
        questionario.setFuncaoIntestival("Normal");
        Assertions.assertEquals("Normal",questionario.getFuncaoIntestival());
    }

    @Test
    void TestConsumoAgua() {
        questionario.setConsumoAgua("1.5 a 2.0 L");
        Assertions.assertEquals("1.5 a 2.0 L",questionario.getConsumoAgua());
    }

    @Test
    void TestLesao() {
        questionario.setLesao("Queimadura");
        Assertions.assertEquals("Queimadura",questionario.getLesao());
    }

    @Test
    void TestTermico() {
        questionario.setTermico(11);
        Assertions.assertEquals(11,questionario.getTermico());
    }

    @Test
    void TestTermicoBelowZeroOrHigherTwenty() {
        questionario.setTermico(21);
        Assertions.assertTrue(questionario.getTermico() < 0 || questionario.getTermico() > 20);
    }

    @Test
    void TestTermicoBetweenZeroAndTwenty() {
        questionario.setTermico(11);
        Assertions.assertTrue(questionario.getTermico() > 0 && questionario.getTermico() < 20);
    }


    @Test
    void TestColesterol() {
        questionario.setColesterol(11);
        Assertions.assertEquals(11,questionario.getColesterol());
    }

    @Test
    void TestGlicemia() {
        questionario.setGlicemia(11);
        Assertions.assertEquals(11,questionario.getGlicemia());
    }

    @Test
    void TestUrina() {

        questionario.setUrina(11);
        Assertions.assertEquals(11,questionario.getUrina());
    }

    @Test
    void TestCreatina() {
        questionario.setCreatina(11);
        Assertions.assertEquals(11,questionario.getCreatina());
    }

    @Test
    void TestProteina() {
        questionario.setProteina(11);
        Assertions.assertEquals(11,questionario.getProteina());
    }

}
