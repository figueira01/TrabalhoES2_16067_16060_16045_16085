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

        assertEquals(70,p.getCodigo());
        assertEquals(1.7,p.getNome());

    }

    @Test
    void testeSetCodigo() {

        assertThrows(AssertionError.class, () -> {
            produto.setCodigo("");
        });


        assertThrows(AssertionError.class, () -> {
            produto.setCodigo(null);
        });

        produto.setCodigo("IS900");
    }

    @Test
    void testeSetNome() {

        assertThrows(AssertionError.class, () -> {
            produto.setNome("");
        });


        assertThrows(AssertionError.class, () -> {
            produto.setNome(null);
        });

        produto.setNome("Jose");
    }

    @Test
    void testeSetEnergiaKcal() {

        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKcal(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKcal(4000);
        });

        produto.setEnergiaKcal(100);
    }

    @Test
    void testeSetEnergiaKj() {

        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKj(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setEnergiaKj(10000);
        });

        produto.setEnergiaKj(1000);
    }

    @Test
    void testeSetAgua() {

        assertThrows(AssertionError.class, () -> {
            produto.setAgua(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAgua(101);
        });

        produto.setAgua(70);
    }

    @Test
    void testeSetProteina() {

        assertThrows(AssertionError.class, () -> {
            produto.setProteina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setProteina(501);
        });

        produto.setProteina(70);
    }

    @Test
    void testeSetGorduraTotal() {

        assertThrows(AssertionError.class, () -> {
            produto.setGorduraTotal(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setGorduraTotal(501);
        });

        produto.setGorduraTotal(70);
    }

    @Test
    void testeSetTotalHCDisponivel() {

        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCDisponivel(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCDisponivel(501);
        });

        produto.setTotalHCDisponivel(70);
    }

    @Test
    void testeSetTotalHCexpressoEmMonossacaridos() {

        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCexpressoEmMonossacaridos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTotalHCexpressoEmMonossacaridos(501);
        });

        produto.setTotalHCexpressoEmMonossacaridos(70);
    }

    @Test
    void testeSetMonoPlusDissacaridos() {

        assertThrows(AssertionError.class, () -> {
            produto.setMonoPlusDissacaridos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setMonoPlusDissacaridos(501);
        });

        produto.setMonoPlusDissacaridos(70);
    }

    @Test
    void testeSetAcidosOrganicos() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosOrganicos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosOrganicos(501);
        });

        produto.setAcidosOrganicos(70);
    }

    @Test
    void testeSetAlcool() {

        assertThrows(AssertionError.class, () -> {
            produto.setAlcool(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAlcool(501);
        });

        produto.setAlcool(70);
    }

    @Test
    void testeSetAmido() {

        assertThrows(AssertionError.class, () -> {
            produto.setAmido(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAmido(501);
        });

        produto.setAmido(70);
    }

    @Test
    void testeSetOligossacaridos() {

        assertThrows(AssertionError.class, () -> {
            produto.setOligossacaridos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setOligossacaridos(501);
        });

        produto.setOligossacaridos(70);
    }

    @Test
    void testeSetFibraAlimentar() {

        assertThrows(AssertionError.class, () -> {
            produto.setFibraAlimentar(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setFibraAlimentar(501);
        });

        produto.setFibraAlimentar(70);
    }

    @Test
    void testeSetAcidoGordosSaturados() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidoGordosSaturados(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidoGordosSaturados(501);
        });

        produto.setAcidoGordosSaturados(70);
    }

    @Test
    void testeSetAcidosGordosMonoinsaturados() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosMonoinsaturados(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosMonoinsaturados(501);
        });

        produto.setAcidosGordosMonoinsaturados(70);
    }

    @Test
    void testeSetAcidosGordosPolinsaturados() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosPolinsaturados(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosPolinsaturados(501);
        });

        produto.setAcidosGordosPolinsaturados(70);
    }

    @Test
    void testeSetAcidosGordosTrans() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosTrans(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidosGordosTrans(501);
        });

        produto.setAcidosGordosTrans(70);
    }

    @Test
    void testeSetRetonol() {

        assertThrows(AssertionError.class, () -> {
            produto.setRetonol(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setRetonol(501);
        });

        produto.setRetonol(70);
    }

    @Test
    void testeSetAcidoLinoleico() {

        assertThrows(AssertionError.class, () -> {
            produto.setAcidoLinoleico(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setAcidoLinoleico(501);
        });

        produto.setAcidoLinoleico(70);
    }

    @Test
    void testeSetColesterol() {

        assertThrows(AssertionError.class, () -> {
            produto.setColesterol(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setColesterol(1501);
        });

        produto.setColesterol(100);
    }

    @Test
    void testeSetVitATotal() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitATotal(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitATotal(15001);
        });

        produto.setVitATotal(1000);
    }

    @Test
    void testeSetCaroteno() {

        assertThrows(AssertionError.class, () -> {
            produto.setCaroteno(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setCaroteno(50001);
        });

        produto.setCaroteno(1000);
    }

    @Test
    void testeSetVitD() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitD(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitD(501);
        });

        produto.setVitD(100);
    }

    @Test
    void testeSetTocoferol() {

        assertThrows(AssertionError.class, () -> {
            produto.setTocoferol(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTocoferol(501);
        });

        produto.setTocoferol(100);
    }

    @Test
    void testeSetTiamina() {

        assertThrows(AssertionError.class, () -> {
            produto.setTiamina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTiamina(501);
        });

        produto.setTiamina(100);
    }

    @Test
    void testeSetRiboflavina() {

        assertThrows(AssertionError.class, () -> {
            produto.setRiboflavina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setRiboflavina(501);
        });

        produto.setRiboflavina(100);
    }

    @Test
    void testeSetEquivalentesDeNiacina() {

        assertThrows(AssertionError.class, () -> {
            produto.setEquivalentesDeNiacina(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setEquivalentesDeNiacina(501);
        });

        produto.setEquivalentesDeNiacina(100);
    }

    @Test
    void testeSetNiaciana() {

        assertThrows(AssertionError.class, () -> {
            produto.setNiaciana(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setNiaciana(501);
        });

        produto.setNiaciana(100);
    }

    @Test
    void testeSetTriptofano60() {

        assertThrows(AssertionError.class, () -> {
            produto.setTriptofano60(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setTriptofano60(501);
        });

        produto.setTriptofano60(100);
    }

    @Test
    void testeSetVitB6() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitB6(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitB6(501);
        });

        produto.setVitB6(100);
    }

    @Test
    void testeSetVitB12() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitB12(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitB12(501);
        });

        produto.setVitB12(100);
    }

    @Test
    void testeSetVitC() {

        assertThrows(AssertionError.class, () -> {
            produto.setVitC(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setVitC(501);
        });

        produto.setVitC(100);
    }

    @Test
    void testeSetFolatos() {

        assertThrows(AssertionError.class, () -> {
            produto.setFolatos(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setFolatos(4501);
        });

        produto.setFolatos(100);
    }

    @Test
    void testeSetCinza() {

        assertThrows(AssertionError.class, () -> {
            produto.setCinza(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setCinza(501);
        });

        produto.setCinza(100);
    }

    @Test
    void testeSetNa() {

        assertThrows(AssertionError.class, () -> {
            produto.setNa(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setNa(50001);
        });

        produto.setNa(100);
    }

    @Test
    void testeSetK() {

        assertThrows(AssertionError.class, () -> {
            produto.setK(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setK(4901);
        });

        produto.setK(100);
    }

    @Test
    void testeSetCa() {

        assertThrows(AssertionError.class, () -> {
            produto.setCa(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setCa(1501);
        });

        produto.setCa(100);
    }

    @Test
    void testeSetP() {

        assertThrows(AssertionError.class, () -> {
            produto.setP(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setP(50001);
        });

        produto.setP(100);
    }

    @Test
    void testeSetMg() {

        assertThrows(AssertionError.class, () -> {
            produto.setMg(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setMg(1501);
        });

        produto.setMg(100);
    }

    @Test
    void testeSetFe() {

        assertThrows(AssertionError.class, () -> {
            produto.setFe(-1);
        });


        assertThrows(AssertionError.class, () -> {
            produto.setFe(1501);
        });

        produto.setFe(100);
    }

    @Test
    void testeSetZn() {

        assertThrows(AssertionError.class, () -> {
            produto.setZn(-1);
        });

        assertThrows(AssertionError.class, () -> {
            produto.setZn(501);
        });

        produto.setZn(100);
    }

    @Test
    void testeGetCodigo() {

        produto.setCodigo("IS20");
        assertEquals("IS20", produto.getCodigo());

    }

    @Test
    void testeGetNome() {

        produto.setNome("Daniel");
        assertEquals("Daniel", produto.getNome());

    }

    @Test
    void testeGetEnergiaKcal() {

        produto.setEnergiaKcal(300);
        assertEquals(300, produto.getEnergiaKcal());

    }

    @Test
    void testeGetEnergiaKj() {

        produto.setEnergiaKj(1000);
        assertEquals(1000, produto.getEnergiaKj());

    }
    @Test
    void testeGetAgua() {

        produto.setAgua(80);
        assertEquals(80, produto.getAgua());

    }

    @Test
    void testeGetProteina() {

        produto.setProteina(80);
        assertEquals(80, produto.getProteina());

    }

    @Test
    void testeGetGorduraTotal() {

        produto.setGorduraTotal(80);
        assertEquals(80, produto.getGorduraTotal());

    }

    @Test
    void testeGetTotalHCDisponivel() {

        produto.setTotalHCDisponivel(80);
        assertEquals(80, produto.getTotalHCDisponivel());

    }

    @Test
    void testeGetTotalHCexpressoEmMonossacaridos() {

        produto.setTotalHCexpressoEmMonossacaridos(80);
        assertEquals(80, produto.getTotalHCexpressoEmMonossacaridos());

    }

    @Test
    void testeGetMonoPlusDissacaridos() {

        produto.setMonoPlusDissacaridos(80);
        assertEquals(80, produto.getMonoPlusDissacaridos());

    }

    @Test
    void testeGetAcidosOrganicos() {

        produto.setAcidosOrganicos(80);
        assertEquals(80, produto.getAcidosOrganicos());

    }

    @Test
    void testeGetAlcool() {

        produto.setAlcool(80);
        assertEquals(80, produto.getAlcool());

    }

    @Test
    void testeGetAmido() {

        produto.setAmido(80);
        assertEquals(80, produto.getAmido());

    }

    @Test
    void testeGetOligossacaridos() {

        produto.setOligossacaridos(80);
        assertEquals(80, produto.getOligossacaridos());

    }

    @Test
    void testeGetFibraAlimentar() {

        produto.setFibraAlimentar(80);
        assertEquals(80, produto.getFibraAlimentar());

    }

    @Test
    void testeGetAcidoGordosSaturados() {

        produto.setAcidoGordosSaturados(80);
        assertEquals(80, produto.getAcidoGordosSaturados());

    }

    @Test
    void testeGetAcidosGordosMonoinsaturados() {

        produto.setAcidosGordosMonoinsaturados(80);
        assertEquals(80, produto.getAcidosGordosMonoinsaturados());

    }

    @Test
    void testeGetAcidosGordosPolinsaturados() {

        produto.setAcidosGordosPolinsaturados(80);
        assertEquals(80, produto.getAcidosGordosPolinsaturados());

    }

    @Test
    void testeGetAcidosGordosTrans() {

        produto.setAcidosGordosTrans(80);
        assertEquals(80, produto.getAcidosGordosTrans());

    }

    @Test
    void testeGetRetonol() {

        produto.setRetonol(80);
        assertEquals(80, produto.getRetonol());

    }
    @Test
    void testeGetAcidoLinoleico() {

        produto.setAcidoLinoleico(80);
        assertEquals(80, produto.getAcidoLinoleico());

    }

    @Test
    void testeGetColesterol() {

        produto.setColesterol(80);
        assertEquals(80, produto.getColesterol());

    }

    @Test
    void testeGetVitATotal() {

        produto.setVitATotal(80);
        assertEquals(80, produto.getVitATotal());

    }

    @Test
    void testeGetCaroteno() {

        produto.setCaroteno(80);
        assertEquals(80, produto.getCaroteno());

    }

    @Test
    void testeGetVitD() {

        produto.setVitD(80);
        assertEquals(80, produto.getVitD());

    }

    @Test
    void testeGetTocoferol() {

        produto.setTocoferol(80);
        assertEquals(80, produto.getTocoferol());

    }

    @Test
    void testeGetTiamina() {

        produto.setTiamina(80);
        assertEquals(80, produto.getTiamina());

    }

    @Test
    void testeGetRiboflavina() {

        produto.setRiboflavina(80);
        assertEquals(80, produto.getRiboflavina());

    }

    @Test
    void testeGetEquivalentesDeNiacina() {

        produto.setEquivalentesDeNiacina(80);
        assertEquals(80, produto.getEquivalentesDeNiacina());

    }

    @Test
    void testeGetNiaciana() {

        produto.setNiaciana(80);
        assertEquals(80, produto.getNiaciana());

    }
    @Test
    void testeGetTriptofano60() {

        produto.setTriptofano60(80);
        assertEquals(80, produto.getTriptofano60());

    }

    @Test
    void testeGetVitB6() {

        produto.setVitB6(80);
        assertEquals(80, produto.getVitB6());

    }

    @Test
    void testeGetVitC() {

        produto.setVitC(80);
        assertEquals(80, produto.getVitC());

    }

    @Test
    void testeGetFolatos() {

        produto.setFolatos(80);
        assertEquals(80, produto.getFolatos());

    }

    @Test
    void testeGetCinza() {

        produto.setCinza(80);
        assertEquals(80, produto.getCinza());

    }

    @Test
    void testeGetNa() {

        produto.setNa(80);
        assertEquals(80, produto.getNa());

    }

    @Test
    void testeGetK() {

        produto.setK(80);
        assertEquals(80, produto.getK());

    }

    @Test
    void testeGetCa() {

        produto.setCa(80);
        assertEquals(80, produto.getCa());

    }

    @Test
    void testeGetP() {

        produto.setP(80);
        assertEquals(80, produto.getP());

    }

    @Test
    void testeGetMg() {

        produto.setMg(80);
        assertEquals(80, produto.getMg());

    }
    @Test
    void testeGetFe() {

        produto.setFe(80);
        assertEquals(80, produto.getFe());

    }

    @Test
    void testeGetZn() {

        produto.setZn(80);
        assertEquals(80, produto.getZn());

    }
}
