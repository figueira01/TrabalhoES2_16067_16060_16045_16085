import es2.com.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TestPlanoAlimentar {

    private LocalDate time;
    private Pessoa p;

    @BeforeEach
    void setUp() {
        p = new Pessoa("Bruno Miguel",20,"Masculino","Mestre da Programcao");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstrutorPessoa()
    {
        Pessoa p = new Pessoa("Bruno Miguel",20,"Masculino","Mestre da Programacao");
    }

    @Test
    void testContrutorDadosFisicos()
    {
        DadosFisicos dF = new DadosFisicos(65,1.56,11,12,"hdfhd","osso",11,11,111,11);
    }

    @Test
    void testConstrutorHabitosAlimentares()
    {
        HabitosAlimentares habitosAlimentares = new HabitosAlimentares("Almoco","arroz, Carne",time,p);
    }

    @Test
    void testConstrutorQuestionario()
    {
        Questionario questionario = new Questionario("ter melhor habito alimentar","ganho muscular","nenhuma","nenhuma","Cancer","Muito ativa","Normal","1,5L to 2L","11%","aa","amarelo","5","171g");
    }
    @Test
    void testContrutorProduto()
    {
        Produto p = new Produto("IS021","Leite Vaca Esterilizado gordo",1111,111,111,111,111,1,1,1,1,11,1,1,1,1,1,1,11,1,1,1,1,11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
    }
}