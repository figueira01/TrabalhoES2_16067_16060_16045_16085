import es2.com.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProduto
{
    @BeforeEach
    void setUp()
    {

    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void testeProduto()
    {
    Produto produto = new Produto("IS958","Arroz de frango",205,858,56.6, 8.2,
            7.6,25.2,27.7,0.7,0,0,24.4,
            0.1,1.0,1.5,3.9,1.2,0.0,
            1.0,31,0.016,16,17,0.16,0.7,0.06,0.09,3.8,
            2.3,1.5,0.18,0.18,3.0,11,1.4,361,188,13,88,23,0.6, 0.8);
    }
}
