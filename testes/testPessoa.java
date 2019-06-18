import es2.com.DadosFisicos;
import es2.com.Pessoa;
import es2.com.PlanoAlimentar;
import es2.com.Questionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testPessoa {

    private DadosFisicos dadosFisicos;
    private PlanoAlimentar planoAlimentar;
    private Questionario questionario;
    private Pessoa pessoaMasculina;
    private Pessoa pessoaFemenina;
    private Pessoa pessoaNoGenre;
    private double TMB = 0;
    private double TMBFA = 0;
    private double TMBFT = 0;
    private double TMBGET = 0;

    @BeforeEach
    void setUp()
    {
        questionario = new Questionario("aaaa","aaa","aaa","aa","aaa","Sedentario","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
        dadosFisicos = new DadosFisicos(70,178,5,30,23,3, 22,60,6500,65);
        pessoaMasculina = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
        pessoaFemenina = new Pessoa("Bruno miguel",21,"Femenino","Estudante",dadosFisicos,planoAlimentar,questionario);
        pessoaNoGenre = new Pessoa("Bruno miguel",21,"","Estudante",dadosFisicos,planoAlimentar,questionario);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testContrutorPessoa()
    {
        Pessoa pessoa = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
    }

    @Test
    void testStringNome()
    {
        assertEquals("Bruno miguel",pessoaMasculina.getNome(),"Errado");
    }

    @Test
    void testIdadeBetween0To90()
    {
        assertTrue(pessoaMasculina.getIdade() >= 0 && pessoaMasculina.getIdade() <= 90);
    }

    @Test
    void testIdadeBeLow0OrHigh90()
    {
        assertFalse(pessoaMasculina.getIdade() < 0 || pessoaMasculina.getIdade() > 90);
    }

    @Test
    void testStringSexo()
    {
        assertEquals("Masculino",pessoaMasculina.getSexo(),"Errado");
    }

    @Test
    void testStringProfissao()
    {
        assertEquals("Estudante",pessoaMasculina.getProfissao(),"Errado");
    }

    @Test
    void testObjectDadosFisicos()
    {
        assertSame(dadosFisicos,pessoaMasculina.getDadosFisicos());
    }

    @Test
    void testObjectPlanoAlimentar()
    {
        assertSame(planoAlimentar,pessoaMasculina.getHabitosAlimentares());
    }

    @Test
    void testObjectQuestionario()
    {
        assertSame(questionario,pessoaMasculina.getQuestionario());
    }

    @Test
    void testCalculoTMBMen() throws Exception {
       TMB = pessoaMasculina.CalcularTMB();
       assertTrue(TMB >= 1541.6 && TMB <= 1542);
    }
    @Test
    void testCalculoTMBWomen() throws Exception {
        TMB = pessoaFemenina.CalcularTMB();
        assertTrue(TMB >= 1779.7 && TMB <= 1780);
    }

    @Test
    void testCalculoTMBThrow() throws Exception {
        assertThrows(Exception.class,() -> {pessoaNoGenre.CalcularTMB();});
    }

    @Test
    void testCalculoTMBWithFASedentario() throws Exception {

        pessoaMasculina.CalcularTMB();
        TMBFA = pessoaMasculina.CalcularTMBComFa();
        assertEquals(2343.536,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAModeradamenteAtivo() throws Exception {

        Questionario questionarioFAModeradamenteAtivo = new Questionario("aaaa","aaa","aaa","aa","aaa","Moderadamente Ativo","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
        Pessoa pessoaMasculinaFAModeradamenteAtivo = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFAModeradamenteAtivo);
        pessoaMasculinaFAModeradamenteAtivo.CalcularTMB();
        TMBFA = pessoaMasculinaFAModeradamenteAtivo.CalcularTMBComFa();
        assertEquals(2713.5679999999998,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAEmpty() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        assertThrows(Exception.class,() -> {pessoaMasculinaFA.CalcularTMBComFa();});
    }

    @Test
    void testCalculoTMBWithFAMuitoAtivo() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Muito Ativo","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(3469.0499999999997,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAAcamado() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Acamado","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(1850.1599999999999,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAAcamadomovel() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Acamado + movel","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(1927.25,TMBFA);
    }

    @Test
    void testCalculoTMBWithFADeambulando() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",11);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(2004.34,TMBFA);
    }

    @Test
    void testCalculoTMBWithFT38() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2204.774,TMBFT);
    }

    @Test
    void testCalculoTMBWithFT39() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",39);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2405.2079999999996,TMBFT);
    }

    @Test
    void testCalculoTMBWithFT40() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",40);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2605.642,TMBFT);
    }

    @Test
    void testCalculoTMBWithFT41() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",41);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2806.0759999999996,TMBFT);
    }

    @Test
    void testCalculoTMBWithFTEmpty() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",0);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        assertThrows(Exception.class,() -> {pessoaMasculinaFT.CalcularTMBComFT();});
    }

    @Test
    void testCalculoTMBGETEmpty() throws Exception {

        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        assertThrows(Exception.class,() -> {pessoaMasculinaGET.CalcularGET();});
    }

}
