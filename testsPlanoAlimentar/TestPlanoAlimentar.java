import es2.com.DadosFisicos;
import es2.com.PlanoAlimentarAtual;
import es2.com.Pessoa;
import es2.com.Questionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlanoAlimentar {

    private String time;
    private Pessoa p;


    @BeforeEach
    void setUp() {
        DadosFisicos DF = new DadosFisicos(65,175,15, 14,"20", "20", 22.53,60,1744,2.0);
        PlanoAlimentarAtual HA = new PlanoAlimentarAtual();
        Questionario questionario = new Questionario("Rotina","Perder peso","nenhuma","nenhuma","Alzheimer","Ativo","Normal","Mais de 2.0 L","10","10","10","10","10");
        HA.addRefeicao("Pequeno-almoço","Bacon e ovos", "08:30");
        HA.addRefeicao("Meio-manhã","Sandes mista", "10:30");
        HA.addRefeicao("Almoço","Arroz com carne", "13:00");
        HA.addRefeicao("Meio tarde","Sandes mista", "16:30");
        HA.addRefeicao("Jantar","Peixe grelhado com vegetais", "19:30");
        p = new Pessoa("Bruno Miguel",20,"Masculino","Mestre da Programacao",DF,HA,questionario);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstrutorPessoa()
    {
        DadosFisicos DF = new DadosFisicos(65,175,15, 14,"20", "20", 22.53,60,1744,2.0);
        PlanoAlimentarAtual HA = new PlanoAlimentarAtual();
        Questionario questionario = new Questionario("Rotina","Perder peso","nenhuma","nenhuma","Alzheimer","Ativo","Normal","Mais de 2.0 L","10","10","10","10","10");
        HA.addRefeicao("Pequeno-almoço","Bacon e ovos", "08:30");
        HA.addRefeicao("Meio-manhã","Sandes mista", "10:30");
        HA.addRefeicao("Almoço","Arroz com carne", "13:00");
        HA.addRefeicao("Meio tarde","Sandes mista", "16:30");
        HA.addRefeicao("Jantar","Peixe grelhado com vegetais", "19:30");
        p = new Pessoa("Bruno Miguel",20,"Masculino","Mestre da Programacao",DF,HA,questionario);
        Pessoa p = new Pessoa("Bruno Miguel",20,"Masculino","Mestre da Programacao" , DF,HA,questionario);
    }

    @Test
    void testContrutorDadosFisicos()
    {
        DadosFisicos dF = new DadosFisicos(65,1.56,11,12,"hdfhd","osso",11,11,111,11);
    }

    @Test
    void testConstrutorHabitosAlimentares()
    {
        PlanoAlimentarAtual habitosAlimentares = new PlanoAlimentarAtual();
    }

    @Test
    void tesHabitosALimentaresAddRefeicao(){
        PlanoAlimentarAtual HA = new PlanoAlimentarAtual();
        HA.addRefeicao("Pequeno-almoço","Bacon e ovos", "08:30");
        HA.addRefeicao("Meio-manhã","Sandes mista", "10:30");
        HA.addRefeicao("Almoço","Arroz com carne", "13:00");
        HA.addRefeicao("Meio tarde","Sandes mista", "16:30");
        HA.addRefeicao("Jantar","Peixe grelhado com vegetais", "19:30");
    }
    @Test
    void testConstrutorQuestionario()
    {
        Questionario questionario = new Questionario("ter melhor habito alimentar","ganho muscular","nenhuma","nenhuma","Cancer","Muito ativa","Normal","1,5L to 2L","11%","aa","amarelo","5","171g");
    }
}