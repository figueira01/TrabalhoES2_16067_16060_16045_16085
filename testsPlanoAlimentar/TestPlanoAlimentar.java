import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
        Pessoa p = new Pessoa("Bruno Miguel",20,"Masculino","Mestre da Programcao");
    }

    @Test
    void testContrutorDadosFisicos()
    {
        DadosFisicos dF = new DadosFisicos(65,1.76,0.15,0.10,"35%","21");
    }

    @Test
    void testConstrutorHabitosAlimentares()
    {
        HabitosAlimentares habitosAlimentares = new HabitosAlimentares("Almoco","arroz, Carne",time,p);
    }
}