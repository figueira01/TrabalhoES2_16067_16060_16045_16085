import es2.com.PlanoAlimentar;
import es2.com.Refeicao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TestPlanoAlimentar {

    private PlanoAlimentar planoAlimentar;

    @BeforeEach
    void setUp(){
        planoAlimentar = new PlanoAlimentar("Pequeno-almoco","","leite",200);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPlanoAlimentar()
    {
        PlanoAlimentar planoAlimentar = new PlanoAlimentar("Pequeno-almoco","","leite",200);
    }

    @Test
    void testRefeicao()
    {
        assertEquals("Pequeno-almoco",planoAlimentar.getRefeicao());
    }

    @Test
    void testHora()
    {
        assertEquals("",planoAlimentar.getHora());
    }

    @Test
    void testComida()
    {
        assertEquals("leite",planoAlimentar.getComida());
    }

    @Test
    void testQuantidade()
    {
        assertEquals(200,planoAlimentar.getQuantidade());
    }

    @Test
    void testQuantidadeBeLow0()
    {
        assertFalse(planoAlimentar.getQuantidade() < 0.00);
    }

    @Test
    void testQuantidadeAbove500()
    {
        assertFalse(planoAlimentar.getQuantidade() > 500);
    }

}