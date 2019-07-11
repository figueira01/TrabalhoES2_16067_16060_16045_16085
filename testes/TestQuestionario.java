import es2.com.Questionario;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQuestionario {

    private Questionario questionario;

    @BeforeEach
    void setUp() throws Exception {
        questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstrutorQuestionario() throws Exception {
        Questionario questionario = new Questionario("","","","","","","","",1,1,1, 1,1,"", 0);
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
    void TestTermico() throws Exception {
        questionario.setTermico(39);
        assertEquals(39,questionario.getTermico());
    }

    @Test
    void TestTermicoBelow38() {
        assertThrows(Exception.class,() -> questionario.setTermico(-1));
    }

    @Test
    void TestTermicoUp41() {
        assertThrows(Exception.class,() -> questionario.setTermico(42));
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
    void TestGlicemiaBeLow70() {
        questionario.setGlicemia(0.07);
        assertFalse(questionario.getGlicemia() > 0.07);
    }

    @Test
    void TestGlicemiaBetween70To200() {
        questionario.setGlicemia(0.10);
        assertTrue(questionario.getGlicemia() > 0.07 && questionario.getGlicemia() < 0.2);
    }

    @Test
    void TestGlicemiaAbove200() {
        questionario.setGlicemia(0.21);
        assertFalse( questionario.getGlicemia() < 0.2);
    }

    @Test
    void TestUrina() {

        questionario.setUrina(11);
        assertEquals(11,questionario.getUrina());
    }

    @Test
    void TestCreatinaBeLow70() {
        questionario.setCreatina(0.6);
        assertFalse(questionario.getCreatina() > 0.7);
    }

    @Test
    void TestCreatinaAbove130() {
        questionario.setCreatina(1.4);
        assertFalse(questionario.getCreatina() < 1.3);
    }

    @Test
    void TestCreatina() {
        questionario.setCreatina(0.8);
        assertTrue(questionario.getCreatina() > 0.7 && questionario.getCreatina() < 1.3);
    }

    @Test
    void TestProteina() {
        questionario.setProteina(11);
        assertEquals(11,questionario.getProteina());
    }

}
