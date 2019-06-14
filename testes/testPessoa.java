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

    @BeforeEach
    void setUp()
    {
        //questionario = new Questionario("aaaa","aaa","aaa","aa","aaa","Sedentario");
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
    void testCalculoTMBWithFA()
    {

    }

}
