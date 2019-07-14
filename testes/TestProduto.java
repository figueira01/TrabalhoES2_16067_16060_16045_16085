import es2.com.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestProduto {
    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto("IS958", "Arroz de frango", 205, 858, 56.6, 8.2,
                7.6, 25.2, 27.7, 0.7, 0, 0, 24.4,
                0.1, 1.0, 1.5, 3.9, 1.2, 0.0,
                1.0, 31, 0.016, 16, 17, 0.16, 0.7, 0.06, 0.09, 3.8,
                2.3, 1.5, 0.18, 0.18, 3.0, 11, 1.4, 361, 188, 13, 88, 23, 0.6, 0.8);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testeConstrutorProduto() {
        Produto p = new Produto("IS958", "Arroz de frango", 205, 858, 56.6, 8.2,
                7.6, 25.2, 27.7, 0.7, 0, 0, 24.4,
                0.1, 1.0, 1.5, 3.9, 1.2, 0.0,
                1.0, 31, 0.016, 16, 17, 0.16, 0.7, 0.06, 0.09, 3.8,
                2.3, 1.5, 0.18, 0.18, 3.0, 11, 1.4, 361, 188, 13, 88, 23, 0.6, 0.8);

        assertEquals("IS958",p.getCodigo());
        assertEquals("Arroz de frango",p.getNome());
        assertEquals(205,p.getEnergiaKcal());
        assertEquals(858,p.getEnergiaKj());
        assertEquals(56.6,p.getAgua());
        assertEquals(8.2,p.getProteina());
        assertEquals(7.6,p.getGorduraTotal());
        assertEquals(25.2,p.getTotalHCDisponivel());
        assertEquals(27.7,p.getTotalHCexpressoEmMonossacaridos());
        assertEquals(0.7,p.getMonoPlusDissacaridos());
        assertEquals(0,p.getAcidosOrganicos());
        assertEquals(0,p.getAlcool());
        assertEquals(24.4,p.getAmido());
        assertEquals(0.1,p.getOligossacaridos());
        assertEquals(1.0,p.getFibraAlimentar());
        assertEquals(1.5,p.getAcidoGordosSaturados());
        assertEquals(3.9,p.getAcidosGordosMonoinsaturados());
        assertEquals(1.2,p.getAcidosGordosPolinsaturados());
        assertEquals(0.0,p.getAcidosGordosTrans());
        assertEquals(1.0,p.getAcidoLinoleico());
        assertEquals(31,p.getColesterol());
        assertEquals(0.016,p.getRetonol());
        assertEquals(16,p.getVitATotal());
        assertEquals(17,p.getCaroteno());
        assertEquals(0.16,p.getVitD());
        assertEquals(0.7,p.getTocoferol());
        assertEquals(0.06,p.getTiamina());
        assertEquals(0.09,p.getRiboflavina());
        assertEquals(3.8,p.getEquivalentesDeNiacina());
        assertEquals(2.3,p.getNiaciana());
        assertEquals(1.5,p.getTriptofano60());
        assertEquals(0.18,p.getVitB6());
        assertEquals(0.18,p.getVitB12());
        assertEquals(3.0,p.getVitC());
        assertEquals(11,p.getFolatos());
        assertEquals(1.4,p.getCinza());
        assertEquals(361,p.getNa());
        assertEquals(188,p.getK());
        assertEquals(13,p.getCa());
        assertEquals(88,p.getP());
        assertEquals(23,p.getMg());
        assertEquals(0.6,p.getFe());
        assertEquals(0.8,p.getZn());
    }

    @Test
    void testeCodigo() {

        assertThrows(AssertionError.class, () -> {//CODIGO EMPTY
            produto.setCodigo("");
        });


        assertThrows(AssertionError.class, () -> {// CODIGO NULL
            produto.setCodigo(null);
        });

        assertThrows(AssertionError.class, () -> {//MIN CARACTER
            produto.setCodigo("S");
        });

        assertThrows(AssertionError.class, () -> {// MAX CARACTER
            produto.setCodigo("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });

        produto.setCodigo("IS20");
        assertEquals("IS20", produto.getCodigo());
    }

    @Test
    void testeNome() {

        assertThrows(AssertionError.class, () -> {
            produto.setNome("");
        });


        assertThrows(AssertionError.class, () -> {
            produto.setNome(null);
        });

        assertThrows(AssertionError.class, () -> {//MIN CARACTER
            produto.setNome("S");
        });

        assertThrows(AssertionError.class, () -> {// MAX CARACTER
            produto.setNome("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        });

        produto.setNome("Joao");
        assertEquals("Joao", produto.getNome());
    }

    @Test
    void testeEnergiaKcal() {

        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKcal(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKcal(4000);
        });

        produto.setEnergiaKcal(300);
        assertEquals(300, produto.getEnergiaKcal());
    }

    @Test
    void testeEnergiaKj() {

        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKj(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKj(10000);
        });

        produto.setEnergiaKj(1000);
        assertEquals(1000, produto.getEnergiaKj());
    }

    @Test
    void testeAgua() {

        assertThrows(AssertionError.class, () -> {
            produto.setAgua(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAgua(101);
        });

        produto.setAgua(80);
        assertEquals(80, produto.getAgua());
    }

    @Test
    void testeProteina() {

        assertThrows(AssertionError.class, () -> {
            produto.setProteina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setProteina(501);
        });

        produto.setProteina(80);
        assertEquals(80, produto.getProteina());
    }

    @Test
    void testeGetZn() {

        produto.setZn(80);
        assertEquals(80, produto.getZn());

    }
    @Test
    void testeGorduraTotal() {

        assertThrows(AssertionError.class, () -> {
            produto.setGorduraTotal(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setGorduraTotal(501);
        });

        produto.setGorduraTotal(80);
        assertEquals(80, produto.getGorduraTotal());
    }

    @Test
    void testeTotalHCDisponivel() {

        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCDisponivel(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCDisponivel(501);
        });

        produto.setTotalHCDisponivel(80);
        assertEquals(80, produto.getTotalHCDisponivel());
    }

    @Test
    void testeTotalHCexpressoEmMonossacaridos() {

        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCexpressoEmMonossacaridos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCexpressoEmMonossacaridos(501);
        });

        produto.setTotalHCexpressoEmMonossacaridos(80);
        assertEquals(80, produto.getTotalHCexpressoEmMonossacaridos());
    }

    @Test
    void testeMonoPlusDissacaridos() {

        assertThrows(AssertionError.class, () -> {
            produto.setMonoPlusDissacaridos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setMonoPlusDissacaridos(501);
        });

        produto.setMonoPlusDissacaridos(80);
        assertEquals(80, produto.getMonoPlusDissacaridos());
    }

    @Test
    void testeAcidosOrganicos() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosOrganicos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosOrganicos(501);
        });

        produto.setAcidosOrganicos(80);
        assertEquals(80, produto.getAcidosOrganicos());
    }

    @Test
    void testeAlcool() {

        assertThrows(AssertionError.class, () -> {
            produto.setAlcool(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAlcool(501);
        });

        produto.setAlcool(70);
        assertEquals(70, produto.getAlcool());
    }

    @Test
    void testeAmido() {

        assertThrows(AssertionError.class, () -> {
            produto.setAmido(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAmido(501);
        });

        produto.setAmido(70);
        assertEquals(70, produto.getAmido());
    }

    @Test
    void testeOligossacaridos() {

        assertThrows(AssertionError.class, () -> {
            produto.setOligossacaridos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setOligossacaridos(501);
        });

        produto.setOligossacaridos(70);
        assertEquals(70, produto.getOligossacaridos());
    }

    @Test
    void testeFibraAlimentar() {

        assertThrows(AssertionError.class, () -> {
            produto.setFibraAlimentar(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setFibraAlimentar(501);
        });

        produto.setFibraAlimentar(70);
        assertEquals(70, produto.getFibraAlimentar());
    }

    @Test
    void testeAcidoGordosSaturados() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidoGordosSaturados(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidoGordosSaturados(501);
        });

        produto.setAcidoGordosSaturados(70);
        assertEquals(70, produto.getAcidoGordosSaturados());
    }

    @Test
    void testeAcidosGordosMonoinsaturados() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosMonoinsaturados(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosMonoinsaturados(501);
        });

        produto.setAcidosGordosMonoinsaturados(70);
        assertEquals(70, produto.getAcidosGordosMonoinsaturados());
    }

    @Test
    void testeAcidosGordosPolinsaturados() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosPolinsaturados(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosPolinsaturados(501);
        });

        produto.setAcidosGordosPolinsaturados(70);
        assertEquals(70, produto.getAcidosGordosPolinsaturados());
    }

    @Test
    void testeAcidosGordosTrans() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosTrans(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosTrans(501);
        });

        produto.setAcidosGordosTrans(70);
        assertEquals(70, produto.getAcidosGordosTrans());
    }

    @Test
    void testeRetonol() {

        assertThrows(AssertionError.class, () -> {
            produto.setRetonol(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setRetonol(501);
        });

        produto.setRetonol(70);
        assertEquals(70, produto.getRetonol());
    }

    @Test
    void testeAcidoLinoleico() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidoLinoleico(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidoLinoleico(501);
        });

        produto.setAcidoLinoleico(70);
        assertEquals(70, produto.getAcidoLinoleico());
    }

    @Test
    void testeColesterol() {

        assertThrows(AssertionError.class, () -> {
            produto.setColesterol(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setColesterol(1501);
        });

        produto.setColesterol(100);
        assertEquals(100, produto.getColesterol());
    }

    @Test
    void testeVitATotal() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitATotal(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitATotal(15001);
        });

        produto.setVitATotal(1000);
        assertEquals(1000, produto.getVitATotal());
    }

    @Test
    void testeCaroteno() {

        assertThrows(AssertionError.class, () -> {
            produto.setCaroteno(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setCaroteno(50001);
        });

        produto.setCaroteno(1000);
        assertEquals(1000, produto.getCaroteno());
    }

    @Test
    void testeVitD() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitD(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitD(501);
        });

        produto.setVitD(100);
        assertEquals(100, produto.getVitD());
    }

    @Test
    void testeTocoferol() {

        assertThrows(AssertionError.class, () -> {
            produto.setTocoferol(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTocoferol(501);
        });

        produto.setTocoferol(100);
        assertEquals(100, produto.getTocoferol());
    }

    @Test
    void testeTiamina() {

        assertThrows(AssertionError.class, () -> {
            produto.setTiamina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTiamina(501);
        });

        produto.setTiamina(100);
        assertEquals(100, produto.getTiamina());
    }

    @Test
    void testeRiboflavina() {

        assertThrows(AssertionError.class, () -> {
            produto.setRiboflavina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setRiboflavina(501);
        });

        produto.setRiboflavina(100);
        assertEquals(100, produto.getRiboflavina());
    }

    @Test
    void testeEquivalentesDeNiacina() {

        assertThrows(AssertionError.class, () -> {
            produto.setEquivalentesDeNiacina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setEquivalentesDeNiacina(501);
        });

        produto.setEquivalentesDeNiacina(100);
        assertEquals(100, produto.getEquivalentesDeNiacina());
    }

    @Test
    void testeNiaciana() {

        assertThrows(AssertionError.class, () -> {
            produto.setNiaciana(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setNiaciana(501);
        });

        produto.setNiaciana(100);
        assertEquals(100, produto.getNiaciana());
    }

    @Test
    void testeTriptofano60() {

        assertThrows(AssertionError.class, () -> {
            produto.setTriptofano60(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTriptofano60(501);
        });

        produto.setTriptofano60(100);
        assertEquals(100, produto.getTriptofano60());
    }

    @Test
    void testeVitB6() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitB6(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitB6(501);
        });

        produto.setVitB6(100);
        assertEquals(100, produto.getVitB6());
    }

    @Test
    void testeVitB12() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitB12(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitB12(501);
        });

        produto.setVitB12(100);
        assertEquals(100, produto.getVitB12());
    }

    @Test
    void testeVitC() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitC(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitC(501);
        });

        produto.setVitC(100);
        assertEquals(100, produto.getVitC());
    }

    @Test
    void testeFolatos() {

        assertThrows(AssertionError.class, () -> {
            produto.setFolatos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setFolatos(4501);
        });

        produto.setFolatos(100);
        assertEquals(100, produto.getFolatos());
    }

    @Test
    void testeCinza() {

        assertThrows(AssertionError.class, () -> {
            produto.setCinza(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setCinza(501);
        });

        produto.setCinza(100);
        assertEquals(100, produto.getCinza());
    }

    @Test
    void testeNa() {

        assertThrows(AssertionError.class, () -> {
            produto.setNa(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setNa(50001);
        });

        produto.setNa(100);
        assertEquals(100, produto.getNa());
    }

    @Test
    void testeK() {

        assertThrows(AssertionError.class, () -> {
            produto.setK(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setK(4901);
        });

        produto.setK(100);
        assertEquals(100, produto.getK());
    }

    @Test
    void testeCa() {

        assertThrows(AssertionError.class, () -> {
            produto.setCa(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setCa(1501);
        });

        produto.setCa(100);
        assertEquals(100, produto.getCa());
    }


    @Test
    void testeP() {

        assertThrows(AssertionError.class, () -> {
            produto.setP(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setP(50001);
        });

        produto.setP(100);
        assertEquals(100, produto.getP());
    }

    @Test
    void testeMg() {

        assertThrows(AssertionError.class, () -> {
            produto.setMg(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setMg(1501);
        });

        produto.setMg(100);
        assertEquals(100, produto.getMg());
    }

    @Test
    void testeFe() {

        assertThrows(AssertionError.class, () -> {
            produto.setFe(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setFe(1501);
        });

        produto.setFe(100);
        assertEquals(100, produto.getFe());
    }

    @Test
    void testeZn() {

        assertThrows(AssertionError.class, () -> {
            produto.setZn(-1);
        });

        assertThrows(AssertionError.class, () -> {
            produto.setZn(501);
        });

        produto.setZn(100);
        assertEquals(100, produto.getZn());
    }




}
