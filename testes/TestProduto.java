import es2.com.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestProduto
{
    private Produto produto;

    @BeforeEach
    void setUp()
    {
        produto = new Produto("IS958","Arroz de frango",205,858,56.6, 8.2,
                7.6,25.2,27.7,0.7,0,0,24.4,
                0.1,1.0,1.5,3.9,1.2,0.0,
                1.0,31,0.016,16,17,0.16,0.7,0.06,0.09,3.8,
                2.3,1.5,0.18,0.18,3.0,11,1.4,361,188,13,88,23,0.6, 0.8);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testeProduto()
    {
    produto = new Produto("IS958","Arroz de frango",205,858,56.6, 8.2,
            7.6,25.2,27.7,0.7,0,0,24.4,
            0.1,1.0,1.5,3.9,1.2,0.0,
            1.0,31,0.016,16,17,0.16,0.7,0.06,0.09,3.8,
            2.3,1.5,0.18,0.18,3.0,11,1.4,361,188,13,88,23,0.6, 0.8);
    }

    @Test
    void testeCodigo()
    {
        assertEquals("IS958",produto.getCodigo());
    }


    @Test
    void testeNome()
    {
        assertEquals("Arroz de frango",produto.getNome());
    }


    @Test
    void testeKcal()
    {
        assertTrue(produto.getEnergiaKcal() >= 0 && produto.getEnergiaKcal() <= 1000);
    }

    @Test
    void testeKcalFalse()
    {
        assertFalse(produto.getEnergiaKcal() < 0 || produto.getEnergiaKcal() > 1000);
    }

    @Test
    void testeKj()
    {
        assertTrue(produto.getEnergiaKj() >= 0 && produto.getEnergiaKj() <= 4000);
    }

    @Test
    void testeKjFalse()
    {
        assertFalse(produto.getEnergiaKj() < 0 || produto.getEnergiaKj() > 4000);
    }

    @Test
    void testeAgua()
    {
        assertTrue(produto.getAgua() >= 0 && produto.getAgua() <= 100);
    }

    @Test
    void testeAguaFalse()
    {
        assertFalse(produto.getAgua() < 0 || produto.getAgua() > 100);
    }

    @Test
    void testeProteina()
    {
        assertTrue(produto.getProteina() >= 0 && produto.getProteina() <= 100);
    }

    @Test
    void testeProteinaFalse()
    {
        assertFalse(produto.getProteina() < 0 || produto.getProteina() > 100);
    }

    @Test
    void testeGorduraTotal()
    {
        assertTrue(produto.getGorduraTotal() >= 0 && produto.getGorduraTotal() <= 100);
    }

    @Test
    void testeGorduraTotalFalse()
    {
        assertFalse(produto.getGorduraTotal() < 0 || produto.getGorduraTotal() > 100);
    }

    @Test
    void testeHCDDisponivel()
    {
        assertTrue(produto.getTotalHCDisponivel() >= 0 && produto.getTotalHCDisponivel() <= 100);
    }

    @Test
    void testeHCDDisponivelFalse()
    {
        assertFalse(produto.getTotalHCDisponivel() < 0 || produto.getTotalHCDisponivel() > 100);
    }

    @Test
    void testeHCexpressoEmMonossacaridos()
    {
        assertTrue(produto.getTotalHCexpressoEmMonossacaridos() >= 0 && produto.getTotalHCexpressoEmMonossacaridos() <= 100);
    }

    @Test
    void testeHCexpressoEmMonossacaridosFalse()
    {
        assertFalse(produto.getTotalHCexpressoEmMonossacaridos() < 0 || produto.getTotalHCexpressoEmMonossacaridos() > 100);
    }

    @Test
    void testeMonoPlusDissacaridos()
    {
        assertTrue(produto.getMonoPlusDissacaridos() >= 0 && produto.getMonoPlusDissacaridos() <= 100);
    }

    @Test
    void testeMonoPlusDissacaridosFalse()
    {
        assertFalse(produto.getMonoPlusDissacaridos() < 0 || produto.getMonoPlusDissacaridos() > 100);
    }

    @Test
    void testeAcidosOrganicos()
    {
        assertTrue(produto.getAcidosOrganicos() >= 0 && produto.getAcidosOrganicos() <= 100);
    }

    @Test
    void testeAcidosOrganicosFalse()
    {
        assertFalse(produto.getAcidosOrganicos() < 0 || produto.getAcidosOrganicos() > 100);
    }

    @Test
    void testeAlcool()
    {
        assertTrue(produto.getAlcool() >= 0 && produto.getAlcool() <= 100);
    }

    @Test
    void testeAlcoolFalse()
    {
        assertFalse(produto.getAlcool() > 0 || produto.getAlcool() > 100);
    }

    @Test
    void testeAmido()
    {
        assertTrue(produto.getAmido() >= 0 && produto.getAmido() <= 100);
    }

    @Test
    void testeAmidoFalse()
    {
        assertFalse(produto.getAmido() < 0 || produto.getAmido() > 100);
    }

    @Test
    void testeOligossacaridos()
    {
        assertTrue(produto.getOligossacaridos() >= 0 && produto.getOligossacaridos() <= 100);
    }

    @Test
    void testeOligossacaridosFalse()
    {
        assertFalse(produto.getOligossacaridos() < 0 || produto.getOligossacaridos() > 100);
    }

    @Test
    void testeFibraAlimentar()
    {
        assertTrue(produto.getFibraAlimentar() >= 0 && produto.getFibraAlimentar() <= 100);
    }

    @Test
    void testeFibraAlimentarFalse()
    {
        assertFalse(produto.getFibraAlimentar() < 0 || produto.getFibraAlimentar() > 100);
    }

    @Test
    void testeAcidoGordosSaturados()
    {
        assertTrue(produto.getAcidoGordosSaturados() >= 0 && produto.getAcidoGordosSaturados() <= 100);
    }

    @Test
    void testeAcidoGordosSaturadosFalse()
    {
        assertFalse(produto.getAcidoGordosSaturados() < 0 || produto.getAcidoGordosSaturados() > 100);
    }

    @Test
    void testeAcidosGordosMonoinsaturados()
    {
        assertTrue(produto.getAcidosGordosMonoinsaturados() >= 0 && produto.getAcidosGordosMonoinsaturados() <= 100);
    }

    @Test
    void testeAcidosGordosMonoinsaturadosFalse()
    {
        assertFalse(produto.getAcidosGordosMonoinsaturados() < 0 || produto.getAcidosGordosMonoinsaturados() > 100);
    }

    @Test
    void testeAcidosGordosPolinsaturados()
    {
        assertTrue(produto.getAcidosGordosPolinsaturados() >= 0 && produto.getAcidosGordosPolinsaturados() <= 100);
    }

    @Test
    void testeAcidosGordosPolinsaturadosFalse()
    {
        assertFalse(produto.getAcidosGordosPolinsaturados() < 0 || produto.getAcidosGordosPolinsaturados() > 100);
    }

    @Test
    void testeAcidosGordosTrans()
    {
        assertTrue(produto.getAcidosGordosTrans() >= 0 && produto.getAcidosGordosTrans() <= 100);
    }

    @Test
    void testeAcidosGordosTransFalse()
    {
        assertFalse(produto.getAcidosGordosTrans() < 0 || produto.getAcidosGordosTrans() > 100);
    }

    @Test
    void testeAcidoLinoleico()
    {
        assertTrue(produto.getAcidoLinoleico() >= 0 && produto.getAcidoLinoleico() <= 100);
    }

    @Test
    void testeAcidoLinoleicoFalse()
    {
        assertFalse(produto.getAcidoLinoleico() < 0 || produto.getAcidoLinoleico() > 100);
    }

    @Test
    void testeColesterol()
    {
        assertTrue(produto.getColesterol() >= 0 && produto.getColesterol() <= 100);
    }

    @Test
    void testeColesterolFalse()
    {
        assertFalse(produto.getColesterol() < 0 || produto.getColesterol() > 100);
    }

    @Test
    void testeRetonol()
    {
        assertTrue(produto.getRetonol() >= 0 && produto.getRetonol() <= 100);
    }

    @Test
    void testeRetonolFalse()
    {
        assertFalse(produto.getRetonol() < 0 || produto.getRetonol() > 100);
    }

    @Test
    void testeVitATotal()
    {
        assertTrue(produto.getVitATotal() >= 0 && produto.getVitATotal() <= 100);
    }

    @Test
    void testeVitATotalFalse()
    {
        assertFalse(produto.getVitATotal() < 0 || produto.getVitATotal() > 100);
    }

    @Test
    void testeCaroteno()
    {
        assertTrue(produto.getCaroteno() >= 0 && produto.getCaroteno() <= 100);
    }

    @Test
    void testeCarotenoFalse()
    {
        assertFalse(produto.getCaroteno() < 0 || produto.getCaroteno() > 100);
    }

    @Test
    void testeVitD()
    {
        assertTrue(produto.getVitD() >= 0 && produto.getVitD() <= 100);
    }

    @Test
    void testeVitDFalse()
    {
        assertFalse(produto.getVitD() < 0 || produto.getVitD() > 100);
    }


    @Test
    void testeTocoferol()
    {
        assertTrue(produto.getTocoferol() >= 0 && produto.getTocoferol() <= 100);
    }

    @Test
    void testeTocoferolFalse()
    {
        assertFalse(produto.getTocoferol() < 0 || produto.getTocoferol() > 100);
    }

    @Test
    void testeTiamina()
    {
        assertTrue(produto.getTiamina() >= 0 && produto.getTiamina() <= 100);
    }

    @Test
    void testeTiaminaFalse()
    {
        assertFalse(produto.getTiamina() < 0 || produto.getTiamina() > 100);
    }

    @Test
    void testeRiboflavina()
    {
        assertTrue(produto.getRiboflavina() >= 0 && produto.getRiboflavina() <= 100);
    }

    @Test
    void testeRiboflavinaFalse()
    {
        assertFalse(produto.getRiboflavina() < 0 || produto.getRiboflavina() > 100);
    }

    @Test
    void testeEquivalentesDeNiacina()
    {
        assertTrue(produto.getEquivalentesDeNiacina() >= 0 && produto.getEquivalentesDeNiacina() <= 100);
    }

    @Test
    void testeEquivalentesDeNiacinaFalse()
    {
        assertFalse(produto.getEquivalentesDeNiacina() < 0 || produto.getEquivalentesDeNiacina() > 100);
    }

    @Test
    void testeTriptofano60()
    {
        assertTrue(produto.getTriptofano60() >= 0 && produto.getTriptofano60() <= 100);
    }

    @Test
    void testeTriptofano60False()
    {
        assertFalse(produto.getTriptofano60() < 0 || produto.getTriptofano60() > 100);
    }

    @Test
    void testeVitB6()
    {
        assertTrue(produto.getVitB6() >= 0 && produto.getVitB6() <= 100);
    }

    @Test
    void testeVitB6False()
    {
        assertFalse(produto.getVitB6() < 0 || produto.getVitB6() > 100);
    }

    @Test
    void testeVitB12()
    {
        assertTrue(produto.getVitB12() >= 0 && produto.getVitB12() <= 100);
    }

    @Test
    void testeVitB12False()
    {
        assertFalse(produto.getVitB12() < 0 || produto.getVitB12() > 100);
    }

    @Test
    void testeVitC()
    {
        assertTrue(produto.getVitC() >= 0 && produto.getVitC() <= 100);
    }

    @Test
    void testeVitCFalse()
    {
        assertFalse(produto.getVitC() < 0 || produto.getVitC() > 100);
    }

    @Test
    void testeFolatos()
    {
        assertTrue(produto.getFolatos() >= 0 && produto.getFolatos() <= 100);
    }

    @Test
    void testeFolatosFalse()
    {
        assertFalse(produto.getFolatos() < 0 || produto.getFolatos() > 100);
    }

    @Test
    void testeCinza()
    {
        assertTrue(produto.getCinza() >= 0 && produto.getCinza() <= 100);
    }

    @Test
    void testeCinzaFalse()
    {
        assertFalse(produto.getCinza() < 0 || produto.getCinza() > 100);
    }

    @Test
    void testeNa()
    {
        assertTrue(produto.getNa() >= 0 && produto.getNa() <= 400);
    }

    @Test
    void testeNaFalse()
    {
        assertFalse(produto.getNa() < 0 || produto.getNa() > 400);
    }

    @Test
    void testeK()
    {
        assertTrue(produto.getK() >= 0 && produto.getK() <= 300);
    }

    @Test
    void testeKFalse()
    {
        assertFalse(produto.getK() < 0 || produto.getK() > 400);
    }

    @Test
    void testeCa()
    {
        assertTrue(produto.getCa() >= 0 && produto.getCa() <= 100);
    }

    @Test
    void testeCaFalse()
    {
        assertFalse(produto.getCa() < 0 || produto.getCa() > 100);
    }

    @Test
    void testeP()
    {
        assertTrue(produto.getP() >= 0 && produto.getP() <= 100);
    }

    @Test
    void testePFalse()
    {
        assertFalse(produto.getP() < 0 || produto.getP() > 100);
    }

    @Test
    void testeMg()
    {
        assertTrue(produto.getMg() >= 0 && produto.getMg() <= 100);
    }

    @Test
    void testeMgFalse()
    {
        assertFalse(produto.getMg() < 0 || produto.getMg() > 100);
    }

    @Test
    void testeFe()
    {
        assertTrue(produto.getFe() >= 0 && produto.getFe() <= 100);
    }

    @Test
    void testeFeFalse()
    {
        assertFalse(produto.getFe() < 0 || produto.getFe() > 100);
    }

    @Test
    void testeZn()
    {
        assertTrue(produto.getZn() >= 0 && produto.getZn() <= 100);
    }

    @Test
    void testeZnFalse()
    {
        assertFalse(produto.getZn() < 0 || produto.getZn() > 100);
    }
}
