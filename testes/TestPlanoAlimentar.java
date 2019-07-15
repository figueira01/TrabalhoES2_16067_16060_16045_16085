import es2.com.PlanoAlimentar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TestPlanoAlimentar {

    private PlanoAlimentar planoAlimentar;

    @BeforeEach
    void setUp() throws Exception {
        planoAlimentar = new PlanoAlimentar("Pequeno-almoco","10:00","leite",200);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPlanoAlimentar()  {
        PlanoAlimentar planoAlimentar = new PlanoAlimentar("Pequeno-almoco","10:00","leite",200);

        assertEquals("Pequeno-almoco",planoAlimentar.getRefeicao());
        assertEquals("10:00",planoAlimentar.getHora());
        assertEquals("leite",planoAlimentar.getComida());
        assertEquals(200,planoAlimentar.getQuantidade());

        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("","10:00","leite",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar(null,"10:00","leite",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("a","10:00","leite",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss","10:00","leite",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","","leite",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco",null,"leite",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","10:0000","leite",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","10:00","",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","10:00",null,200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","10:00","l",200);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","10:00","leiteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",200);
        });

        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","10:00","leite",-1);
        });
        assertThrows(AssertionError.class, () -> {
            new PlanoAlimentar("Pequeno-almoco","10:00","leite",4001);
        });


    }

    @Test
    void testRefeicao()
    {
        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setRefeicao("");
        });

        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setRefeicao(null);
        });

        assertThrows(AssertionError.class, () -> {//MIN CARACTER
            planoAlimentar.setRefeicao("S");
        });

        assertThrows(AssertionError.class, () -> {// MAX CARACTER
            planoAlimentar.setRefeicao("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });

        planoAlimentar.setRefeicao("Ceia");
        assertEquals("Ceia",planoAlimentar.getRefeicao());
    }

    @Test
    void testHora()
    {
        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setHora("");
        });


        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setHora(null);
        });

        assertThrows(AssertionError.class, () -> {//MIN CARACTER
            planoAlimentar.setHora("20:00000");
        });

        planoAlimentar.setHora("22:00");
        assertEquals("22:00",planoAlimentar.getHora());
    }

    @Test
    void testComida()
    {

        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setComida("");
        });

        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setComida(null);
        });

        assertThrows(AssertionError.class, () -> {//MIN CARACTER
            planoAlimentar.setComida("f");
        });
        assertThrows(AssertionError.class, () -> {//MAXCARACTER
            planoAlimentar.setComida("feijoesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        });

        planoAlimentar.setComida("Feijoes");
        assertEquals("Feijoes",planoAlimentar.getComida());
    }

    @Test
    void testQuantidade()
    {
        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setQuantidade(-1);
        });

        assertThrows(AssertionError.class, () -> {
            planoAlimentar.setQuantidade(4001);
        });

        planoAlimentar.setQuantidade(2000);
        assertEquals(2000,planoAlimentar.getQuantidade());
    }



}