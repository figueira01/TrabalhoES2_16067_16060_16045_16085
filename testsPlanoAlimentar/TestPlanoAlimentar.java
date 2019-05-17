import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPlanoAlimentar {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstrutorPessoa()
    {
        Pessoa p = new Pessoa("Bruno Miguel",20,"Masculino","Mestre da Informatica");
    }
}