import es2.com.PlanoAlimentar;
import es2.com.Questionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQuestionario {
    //BlackBox Partições

    
    @BeforeEach
    void setUp(){
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
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setMotivoConsulta("Perder peso");
        Assertions.assertEquals("Perder peso",questionario.getMotivoConsulta());
    }

    @Test
    void TestObjectivo() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setObjectivo("Perder peso");
        Assertions.assertEquals("Perder peso",questionario.getObjectivo());
    }

    @Test
    void TestPatologia() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setPatologia("Autismo");
        Assertions.assertEquals("Autismo",questionario.getPatologia());
    }

    @Test
    void TestMedicacao() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setMedicacao("Brufen");
        Assertions.assertEquals("Brufen",questionario.getMedicacao());
    }

    @Test
    void TestAntecedentesFamiliares() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setAntecedentesFamiliares("Alzheimer");
        Assertions.assertEquals("Alzheimer",questionario.getAntecedentesFamiliares());
    }

    @Test
    void TestAtividadeFisica() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setAtividadeFisica("Moderado");
        Assertions.assertEquals("Moderado",questionario.getAtividadeFisica());
    }

    @Test
    void TestFuncaoIntestival() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setFuncaoIntestival("Normal");
        Assertions.assertEquals("Normal",questionario.getFuncaoIntestival());
    }

    @Test
    void TestConsumoAgua() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setConsumoAgua("1.5 a 2.0 L");
        Assertions.assertEquals("1.5 a 2.0 L",questionario.getConsumoAgua());
    }

    @Test
    void TestLesao() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setLesao("Queimadura");
        Assertions.assertEquals("Queimadura",questionario.getLesao());
    }

    @Test
    void TestTermico() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setTermico(11);
        Assertions.assertEquals(11,questionario.getTermico());
    }

    @Test
    void TestTermicoBelowZeroOrHigherTwenty() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setTermico(-1);
        Assertions.assertTrue(questionario.getTermico() < 0 || questionario.getTermico() > 20);
        questionario.setTermico(21);
        Assertions.assertTrue(questionario.getTermico() < 0 || questionario.getTermico() > 20);
    }

    @Test
    void TestTermicoBetweenZeroAndTwenty() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setTermico(1);
        Assertions.assertTrue(questionario.getTermico() > 0 && questionario.getTermico() < 20);
        questionario.setTermico(11);
        Assertions.assertTrue(questionario.getTermico() > 0 && questionario.getTermico() < 20);
    }


    @Test
    void TestColesterol() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setColesterol(11);
        Assertions.assertEquals(11,questionario.getColesterol());
    }

    @Test
    void TestGlicemia() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setGlicemia(11);
        Assertions.assertEquals(11,questionario.getGlicemia());
    }

    @Test
    void TestUrina() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setUrina(11);
        Assertions.assertEquals(11,questionario.getUrina());
    }

    @Test
    void TestCreatina() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setCreatina(11);
        Assertions.assertEquals(11,questionario.getCreatina());
    }

    @Test
    void TestProteina() {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 1);
        questionario.setProteina(11);
        Assertions.assertEquals(11,questionario.getProteina());
    }

}
