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
    private Pessoa pessoa;
    private double TMB = 0;

    @BeforeEach
    void setUp()
    {
        dadosFisicos = new DadosFisicos(70,178,5,30,23,3, 22,60,6500,65);
        pessoa = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);

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
        assertEquals("Bruno miguel",pessoa.getNome(),"Errado");
    }

    @Test
    void testIdadeBetween0To90()
    {
        assertTrue(pessoa.getIdade() >= 0 && pessoa.getIdade() <= 90);
    }

    @Test
    void testIdadeBeLow0OrHigh90()
    {
        assertFalse(pessoa.getIdade() < 0 || pessoa.getIdade() > 90);
    }

    @Test
    void testStringSexo()
    {
        assertEquals("Masculino",pessoa.getSexo(),"Errado");
    }

    @Test
    void testStringProfissao()
    {
        assertEquals("Estudante",pessoa.getProfissao(),"Errado");
    }

    @Test
    void testObjectDadosFisicos()
    {
        assertSame(dadosFisicos,pessoa.getDadosFisicos());
    }

    @Test
    void testObjectPlanoAlimentar()
    {
        assertSame(planoAlimentar,pessoa.getHabitosAlimentares());
    }

    @Test
    void testObjectQuestionario()
    {
        assertSame(questionario,pessoa.getQuestionario());
    }

    @Test
    void testCalculoTMB()
    {
       TMB = pessoa.CalcularTMB();
       assertTrue(TMB >= 1541.6 && TMB <= 1542);
    }

}
