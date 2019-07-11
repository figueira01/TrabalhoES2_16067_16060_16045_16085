import es2.com.PlanoAlimentar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TestPlanoAlimentar {

    private PlanoAlimentar planoAlimentar;

    @BeforeEach
    void setUp() throws Exception {
        planoAlimentar = new PlanoAlimentar("Pequeno-almoco","","leite",200);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPlanoAlimentar() throws Exception {
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
    void testQuantidadeBeLow0() {
        assertThrows(Exception.class,() -> {planoAlimentar.setQuantidade(-1);});
    }

    @Test
    void testQuantidadeAbove500()
    {
        assertThrows(Exception.class,() -> {planoAlimentar.setQuantidade(500.1);});
    }

}