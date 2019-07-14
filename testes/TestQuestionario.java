import es2.com.Questionario;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQuestionario {

    private Questionario questionario;

    @BeforeEach
    void setUp() throws Exception {
        questionario = new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                100, 100, 100, 100, 100, "Nenhuma", 39);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstrutorQuestionario() throws Exception {
        assertEquals("Procura de ajuda profissional", questionario.getMotivoConsulta());
        assertEquals("Perder Peso", questionario.getObjectivo());
        assertEquals("Autismo", questionario.getPatologia());
        assertEquals("Brufen", questionario.getMedicacao());
        assertEquals("Alzheimer", questionario.getAntecedentesFamiliares());
        assertEquals("Moderada", questionario.getAtividadeFisica());
        assertEquals("Normal", questionario.getFuncaoIntestival());
        assertEquals("1L", questionario.getConsumoAgua());
        assertEquals(100, questionario.getColesterol());
        assertEquals(100, questionario.getGlicemia());
        assertEquals(100, questionario.getUrina());
        assertEquals(100, questionario.getCreatina());
        assertEquals(100, questionario.getProteina());
        assertEquals("Nenhuma", questionario.getLesao());
        assertEquals(39, questionario.getTermico());

        assertThrows(AssertionError.class, () -> {
            new Questionario("", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });

        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    -1, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, -1, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, 100, -1, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, 100, 100, -1, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, 100, 100, 100, -1, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, 100, 100, 100, 100, "", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 1);
        });
        //--------------------------------------
        assertThrows(AssertionError.class, () -> {
            new Questionario(null, "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });

        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", null, "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", null,
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    null, "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", null, "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", null, "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", null, "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", null,
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, 100, 100, 100, 100, null, 39);
        });
        //--------------------------------------
        assertThrows(AssertionError.class, () -> {
            new Questionario("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });

        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS",
                    "Brufen", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "Alzheimer", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "Moderada", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "Moderada", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "1L",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS",
                    100, 100, 100, 100, 100, "Nenhuma", 39);
        });
        assertThrows(AssertionError.class, () -> {
            new Questionario("Procura de ajuda profissional", "Perder Peso", "Autismo",
                    "Brufen", "Alzheimer", "Moderada", "Normal", "1L",
                    100, 100, 100, 100, 100, "ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", 39);
        });
    }
    @Test
    void TestSetMotivoConsultaSucess() {
        questionario.setMotivoConsulta("Perder peso");
        assertEquals("Perder peso", questionario.getMotivoConsulta());
    }

    @Test
    void TestSetMotivoConsultaFailEmpty() {

        assertThrows(AssertionError.class, () -> {
            questionario.setMotivoConsulta("");
        });
    }
    @Test
    void TestSetMotivoConsultaFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setMotivoConsulta(null);
        });
    }

    @Test
    void TestSetMotivoConsultaFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setMotivoConsulta("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }
    @Test
    void TestSetObjectivoSucess() {
        questionario.setObjectivo("Perder peso");
        assertEquals("Perder peso",questionario.getObjectivo());
    }

    @Test
    void TestSetObjectivoFailEmpty() {

        assertThrows(AssertionError.class,() -> {
            questionario.setObjectivo("");
        });
    }
    @Test
    void TestSetObjetivoFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setObjectivo(null);
        });
    }

    @Test
    void TestSetObjetivoFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setObjectivo("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestSetPatologiaSucess() {
        questionario.setPatologia("Autismo");
        assertEquals("Autismo",questionario.getPatologia());
    }

    @Test
    void TestSetPatologiaFailEmpty() {

        assertThrows(AssertionError.class,() -> {
            questionario.setPatologia("");
        });
    }
    @Test
    void TestSetPatologiaFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setPatologia(null);
        });
    }

    @Test
    void TestSetPatologiaFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setPatologia("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestSetMedicacaoSucess() {
        questionario.setMedicacao("Brufen");
        assertEquals("Brufen",questionario.getMedicacao());
    }

    @Test
    void TestSetMedicacaoFailEmpty() {

        assertThrows(AssertionError.class,() -> {
            questionario.setMedicacao("");
        });
    }
    @Test
    void TestSetMedicacaoFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setMedicacao(null);
        });
    }

    @Test
    void TestSetMedicacaoFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setMedicacao("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestSetAntecedentesFamiliaresSucess() {
        questionario.setAntecedentesFamiliares("Alzheimer");
        assertEquals("Alzheimer",questionario.getAntecedentesFamiliares());
    }

    @Test
    void TestSetAntecedentesFamiliaresFailEmpty() {
        assertThrows(AssertionError.class,() -> {
            questionario.setAntecedentesFamiliares("");
        });
    }

    @Test
    void TestSetAntecedentesFamiliaresFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setAntecedentesFamiliares(null);
        });
    }

    @Test
    void TestSetAntecedentesFamiliaresFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setAntecedentesFamiliares("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestSetAtividadeFisicaSucess() {
        questionario.setAtividadeFisica("Moderado");
        assertEquals("Moderado",questionario.getAtividadeFisica());
    }

    @Test
    void TestSetAtividadeFisicaFailEmpty() {
        assertThrows(AssertionError.class,() -> {
            questionario.setAtividadeFisica("");
        });
    }

    @Test
    void TestSetAtividadeFisicaFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setAtividadeFisica(null);
        });
    }

    @Test
    void TestSetAtividadeFisicaFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setObjectivo("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestSetFuncaoIntestivalSucess() {
        questionario.setFuncaoIntestival("Normal");
        assertEquals("Normal",questionario.getFuncaoIntestival());
    }

    @Test
    void TestSetFuncaoIntestivalFailEmpty() {
        assertThrows(AssertionError.class,() -> {
            questionario.setFuncaoIntestival("");
        });
    }
    @Test
    void TestSetFuncaoIntestinalFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setFuncaoIntestival(null);
        });
    }

    @Test
    void TestSetFuncaoIntestinalFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setFuncaoIntestival("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestSetConsumoAguaSucess() {
        questionario.setConsumoAgua("1.5 a 2.0 L");
        assertEquals("1.5 a 2.0 L",questionario.getConsumoAgua());
    }
    @Test
    void TestSetConsumoAguaFailEmpty() {
        assertThrows(AssertionError.class,() -> {
            questionario.setConsumoAgua("");
        });
    }

    @Test
    void TestSetConsumoAguaFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setConsumoAgua(null);
        });
    }

    @Test
    void TestSetConsumoAguaFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setConsumoAgua("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestSetLesaoSucess() {
        questionario.setLesao("Queimadura");
        assertEquals("Queimadura",questionario.getLesao());
    }

    @Test
    void TestSetLesaoFailEmpty() {
        assertThrows(AssertionError.class,() -> {
            questionario.setLesao("");
        });
    }

    @Test
    void TestSetLesaoFailNull() {

        assertThrows(AssertionError.class, () -> {
            questionario.setLesao(null);
        });
    }

    @Test
    void TestSetLesaoFailMaxChar()
    {
        assertThrows(AssertionError .class, () ->
        {// MAX CARACTER
            questionario.setLesao("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });
    }

    @Test
    void TestTermicoBetween38and41() throws Exception {
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
    void TestColesterolUp500() {

        assertThrows(AssertionError.class,() -> {
            questionario.setColesterol(501);
        });
    }

    @Test
    void TestColesterolBeLow0() {
        assertThrows(AssertionError.class,() -> {
            questionario.setColesterol(-1);
        });
    }

    @Test
    void TestColesterolBetween0and500() {
        //
        questionario.setColesterol(100);
        assertEquals(100,questionario.getColesterol());
    }

    @Test
    void TestGlicemiaBeLow0() {
        assertThrows(AssertionError.class,() -> {
            questionario.setGlicemia(-1);
        });
    }

    @Test
    void TestGlicemiaBetween0and500() {
        questionario.setGlicemia(100);
        assertEquals(100,questionario.getGlicemia());
    }

    @Test
    void TestGlicemiaAbove500() {
        assertThrows(AssertionError.class,() -> {
            questionario.setGlicemia(501);
        });
    }

    @Test
    void TestUrinaBelow0() {
        assertThrows(AssertionError.class,() -> {
            questionario.setUrina(-1);
        });
    }
    @Test
    void TestUrinaAbove500() {
        assertThrows(AssertionError.class,() -> {
            questionario.setUrina(501);
        });
    }

    @Test
    void TestUrinaBetween0and500() {
        questionario.setUrina(100);
        assertEquals(100, questionario.getUrina());
    }
    @Test
    void TestCreatinaBeLow0() {
        assertThrows(AssertionError.class,() -> {
            questionario.setCreatina(-1);
        });
    }

    @Test
    void TestCreatinaAbove500() {
        assertThrows(AssertionError.class,() -> {
            questionario.setCreatina(501);
        });
    }

    @Test
    void TestCreatinaBetween0and500() {
        questionario.setCreatina(100);
        assertEquals(100, questionario.getCreatina());
    }


    @Test
    void TestProteinaBelow0() {
        assertThrows(AssertionError.class,() -> {
            questionario.setProteina(0);
        });
    }

    @Test
    void TestProteinaAbove500() {
        assertThrows(AssertionError.class,() -> {
            questionario.setProteina(501);
        });
    }
    @Test
    void TestProteinaBetween0and500() {
        questionario.setProteina(100);
        assertEquals(100, questionario.getProteina());
    }
}
