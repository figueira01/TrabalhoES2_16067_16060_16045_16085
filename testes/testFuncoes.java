import es2.com.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testFuncoes {

    private List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
    private String refeicao = "Pequeno Almoco";
    private boolean bool;
    private Funcoes funcoes;
    private String url = "CSV/PlanoAlimentarAtual.csv";
    private List<List<Produto>> produto = new ArrayList<>();
    private List<List<String>> planoS = new ArrayList<>();
    private Pessoa pessoa;
    private Questionario questionario;
    private DadosFisicos dadosFisicos;
    private PlanoAlimentar planoAlimentar;
    private FileWriter csvWriter;

    @BeforeEach
    void setUp()  {
        bool = true;
        funcoes = new Funcoes();
        funcoes.LerPlanoAlimentar(url,planoAtual);
        funcoes.LerDadosProdutos(produto);
        questionario = new Questionario("aaaa","aaa","aaa","aa","aaa","Sedentario","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        dadosFisicos = new DadosFisicos(70,1.78,5,30,23,3, 22,60,65);
        pessoa = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAtual,questionario);

    }

    @AfterEach
    void tearDown()
    {

    }


    @Test
    public void testLerDadosFisicosNull()  {
        assertThrows(NullPointerException.class,() -> funcoes.LerDadosFisicos(null));
    }

    @Test
    public void testLerDadosFisicos()  {
        List<List<DadosFisicos>> dadosFisicos = new ArrayList<>();
        funcoes.LerDadosFisicos(dadosFisicos);
    }

    @Test
    public void LerDadosProdutosNull()   {
        assertThrows(NullPointerException.class,() -> funcoes.LerDadosProdutos(null));
    }

    @Test
    public void LerDadosProdutos()  {
        List<List<Produto>> dadosProduto = new ArrayList<>();
        funcoes.LerDadosProdutos(dadosProduto);
    }

    @Test
    public void LerPlanoAlimentar()
    {
        funcoes.LerPlanoAlimentar(url,planoAtual);
    }

    @Test
    public void LerPlanoAlimentarString()
    {
        funcoes.LerPlanoAlimentarS(url,planoS);
    }

    @Test
    public void LerPlanoAlimentarStringArrayWrong()
    {
        assertThrows(NullPointerException.class,() -> funcoes.LerPlanoAlimentarS(url,null));
    }

    @Test
    public void LerQuestionario()  {
        List<List<Questionario>> questionario = new ArrayList<>();
        funcoes.LerQuestionario(questionario);
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayEmptyProduto() {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,bool,produto));

    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(113.478,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(12.6,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,bool,produto));

    }

    @Test
    public void CalculationgetAcidoGordosSaturadosForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(12.6,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationgetAcidoGordosSaturadosPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationgetAcidoGordosSaturados(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationEnergiaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(4420.105,funcoes.CalculationEnergia(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals() {
        assertEquals(306.5,funcoes.CalculationEnergia(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEnergiaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationEnergiaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(306.5,funcoes.CalculationEnergia(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEnergiaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEnergiaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationEnergiaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergia(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationEnergiaKjForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaKjForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaKjForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaKjForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaKjForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(18500.03,funcoes.CalculationEnergiaKj(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaKjPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(1281.0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEnergiaKjPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationEnergiaKjPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(1281.0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEnergiaKjPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEnergiaKjPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEnergiaKjPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationEnergiaKjPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEnergiaKj(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationAguaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAgua(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAguaForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAgua(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAguaForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAgua(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAguaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAgua(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAguaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(1365.0115,funcoes.CalculationAgua(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAguaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(98.25,funcoes.CalculationAgua(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAguaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAgua(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAguaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(98.25,funcoes.CalculationAgua(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAguaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAgua(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAguaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAgua(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAguaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAgua(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAguaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAgua(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationProteinaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationProteina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationProteinaForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationProteina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationProteinaForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationProteina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationProteinaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationProteina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationProteinaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(189.91899999999995,funcoes.CalculationProteina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(18.2,funcoes.CalculationProteina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationProteina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(18.2,funcoes.CalculationProteina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationProteina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationProteina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationProteina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationProteina(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationGorduraTotalForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationGorduraTotalForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationGorduraTotalForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationGorduraTotalForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationGorduraTotalForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(292.809,funcoes.CalculationGorduraTotal(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationGorduraTotalPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(23.75,funcoes.CalculationGorduraTotal(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationGorduraTotalPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationGorduraTotalPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(23.75,funcoes.CalculationGorduraTotal(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationGorduraTotalPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationGorduraTotalPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationGorduraTotalPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationGorduraTotalPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationGorduraTotal(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationHCForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationHC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationHCForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationHC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationHCForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationHC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationHCForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationHC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationHCForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(252.10499999999996,funcoes.CalculationHC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationHCPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(3.75,funcoes.CalculationHC(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationHCPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationHC(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationHCPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(3.75,funcoes.CalculationHC(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationHCPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationHC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationHCPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationHC(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationHCPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationHC(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationHCPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationHC(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationMonoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationMono(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMonoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationMono(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMonoForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationMono(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMonoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMono(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMonoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(82.767,funcoes.CalculationMono(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMonoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(3.75,funcoes.CalculationMono(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationMonoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationMono(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationMonoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(3.75,funcoes.CalculationMono(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationMonoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMono(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMonoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMono(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationMonoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMono(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationMonoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMono(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationAcidoOrganicoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoOrganicoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoOrganicoForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoOrganicoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoOrganicoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(2.75,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoOrganicoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(1.6,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoOrganicoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoOrganicoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(1.6,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoOrganicoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoOrganicoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoOrganicoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoOrganicoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoOrganico(planoAtual,"Pequeno almoco",false,produto));
    }


    @Test
    public void CalculationAlcoolForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAlcoolForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAlcoolForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAlcoolForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAlcoolForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(0.0,funcoes.CalculationAlcool(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAlcoolPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.0,funcoes.CalculationAlcool(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAlcoolPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAlcoolForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.0,funcoes.CalculationAlcool(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAlcoolPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAlcoolPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAlcoolPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAlcoolPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAlcool(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationAmidoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAmido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAmidoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAmido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAmidoForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAmido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAmidoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAmido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAmidoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(169.18800000000002,funcoes.CalculationAmido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAmidoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.0,funcoes.CalculationAmido(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAmidoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAmido(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAmidoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.0,funcoes.CalculationAmido(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAmidoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAmido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAmidoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAmido(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAmidoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAmido(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAmidoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAmido(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationOligossacaridoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationOligossacaridoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationOligossacaridoForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationOligossacaridoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationOligossacaridoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(0.15,funcoes.CalculationOligossacarido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationOligossacaridoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.0,funcoes.CalculationOligossacarido(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationOligossacaridoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationOligossacaridoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.0,funcoes.CalculationOligossacarido(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationOligossacaridoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationOligossacaridoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationOligossacaridoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationOligossacaridoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationOligossacarido(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationFibraAlimentarForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFibraAlimentarForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFibraAlimentarForEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFibraAlimentarForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFibraAlimentarForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(14.246,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFibraAlimentarPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFibraAlimentarPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationFibraAlimentarForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFibraAlimentarPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFibraAlimentarPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFibraAlimentarPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationFibraAlimentarPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFibraAlimentar(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(93.199,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(5.7,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(5.7,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoMonoinsaturadoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoMonoinsaturado(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(42.2685,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.8500000000000001,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.8500000000000001,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoGordoPolinsaturadoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoPolinsaturado(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationAcidoGordoTransForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoTransForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoTransEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoTransForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoTransForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(7.381,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoTransPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.9500000000000001,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoGordoTransPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoGordoTransForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.9500000000000001,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoGordoTransPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoGordoTransPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoGordoTransPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoGordoTransPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoGordoTrans(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(23.653000000000002,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.75,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.75,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoLinoleicoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoLinoleico(planoAtual,"Pequeno almoco",false,produto));
    }


    @Test
    public void CalculationAcidoColesterolForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoColesterolForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoColesterolEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoColesterolForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoColesterolForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(1152.0,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoColesterolPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(94.5,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoColesterolPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoColesterolForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(94.5,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoColesterolPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAcidoColesterolPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAcidoColesterolPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAcidoColesterolPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationAcidoColesterol(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationVitAForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitA(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitAForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitA(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitAEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationVitA(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitAForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitA(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitAForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(1945.0,funcoes.CalculationVitA(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitAPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(131.5,funcoes.CalculationVitA(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitAPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationVitA(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitAForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(131.5,funcoes.CalculationVitA(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitAPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitA(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitAPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitA(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitAPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitA(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitAPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitA(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationCarotenoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCarotenoForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCarotenoEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCarotenoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCarotenoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(2059.0,funcoes.CalculationCaroteno(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCarotenoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(14.5,funcoes.CalculationCaroteno(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCarotenoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationCarotenoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(14.5,funcoes.CalculationCaroteno(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCarotenoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCarotenoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCarotenoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationCarotenoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCaroteno(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationVitDForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitD(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitDForEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitD(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitDEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationVitD(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitDForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitD(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitDForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(30.105,funcoes.CalculationVitD(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitDPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.205,funcoes.CalculationVitD(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitDPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationVitD(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitDForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.205,funcoes.CalculationVitD(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitDPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitD(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitDPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitD(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitDPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitD(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitDPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitD(planoAtual,"Pequeno almoco",false,produto));
    }


    @Test
    public void CalculationaTocofecolForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationaTocofecolorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationaTocofecolEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationaTocofecolForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationaTocofecolForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(22.3165,funcoes.CalculationaTocofecol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationaTocofecolrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.415,funcoes.CalculationaTocofecol(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationaTocofecolPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationaTocofecolForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.415,funcoes.CalculationaTocofecol(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationaTocofecolPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationaTocofecolPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationaTocofecolPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationaTocofecolPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationaTocofecol(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationTiaminaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTiaminaorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTiaminaEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTiaminaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTiaminaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(3.4393,funcoes.CalculationTiamina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTiaminarescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.06,funcoes.CalculationTiamina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationTiaminaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationTiaminaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.06,funcoes.CalculationTiamina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationTiaminaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTiaminaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationTiaminaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationTiaminaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTiamina(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationRiboflavinaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationRiboflavinaorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationRiboflavinaEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationRiboflavinaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationRiboflavinaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(2.68055,funcoes.CalculationRiboflavina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationRiboflavinarescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.47000000000000003,funcoes.CalculationRiboflavina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationRiboflavinaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationRiboflavinaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.47000000000000003,funcoes.CalculationRiboflavina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationRiboflavinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationRiboflavinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationRiboflavinaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationRiboflavinaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationRiboflavina(planoAtual,"Pequeno almoco",false,produto));
    }


    @Test
    public void CalculationEquivalenteNiacinaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(75.84600000000002,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinarescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(5.3,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(5.3,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationEquivalenteNiacinaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationEquivalenteNiacina(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationNiacinaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNiacinaorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNiacinaEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNiacinaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNiacinaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(36.404999999999994,funcoes.CalculationNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNiacinarescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(1.05,funcoes.CalculationNiacina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationNiacinaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationNiacinaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(1.05,funcoes.CalculationNiacina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationNiacinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNiacinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationNiacinaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationNiacinaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNiacina(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationTriptofanoForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTriptofanoorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTriptofanoEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTriptofanoForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTriptofanoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(40.22899999999999,funcoes.CalculationTriptofano(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTriptofanorescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(4.25,funcoes.CalculationTriptofano(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationTriptofanoPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationTriptofanoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(4.25,funcoes.CalculationTriptofano(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationTriptofanoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationTriptofanoPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationTriptofanoPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationTriptofanoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationTriptofano(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationVitBForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitB(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitBorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitB(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitBEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationVitB(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitBForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitBForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(2.9583,funcoes.CalculationVitB(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitBrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.08900000000000001,funcoes.CalculationVitB(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitBPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationVitB(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitBForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.08900000000000001,funcoes.CalculationVitB(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitBPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitBPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitBPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitBPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationVitB12ForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitB12orEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitB12EachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitB12ForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitB12ForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(8.0,funcoes.CalculationVitB12(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitB12rescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(1.1500000000000001,funcoes.CalculationVitB12(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitB12PrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitB12ForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(1.1500000000000001,funcoes.CalculationVitB12(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitB12PrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitB12PrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitB12PrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitB12PrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitB12(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationVitCForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitCorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationVitC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitCEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationVitC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitCForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitCForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(67.25,funcoes.CalculationVitC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitCrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.0,funcoes.CalculationVitC(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitCPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationVitC(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitCForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.0,funcoes.CalculationVitC(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitCPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitC(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationVitCPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitC(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationVitCPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitC(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationVitCPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationVitC(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationFolatosForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFolatosorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFolatosEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFolatosForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFolatosForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(323.925,funcoes.CalculationFolatos(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFolatosrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(25.025,funcoes.CalculationFolatos(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFolatosPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationFolatosForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(25.025,funcoes.CalculationFolatos(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFolatosPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFolatosPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFolatosPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationFolatosPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFolatos(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationCinzaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationCinza(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCinzaorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationCinza(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCinzaEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationCinza(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCinzaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCinza(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCinzaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(28.7055,funcoes.CalculationCinza(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCinzarescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(4.46,funcoes.CalculationCinza(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCinzaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationCinza(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationCinzaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(4.46,funcoes.CalculationCinza(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCinzaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCinza(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCinzaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCinza(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCinzaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCinza(planoAtual,"aa",false,produto));
    }

    @Test
    public void CCalculationCinzaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCinza(planoAtual,"Pequeno almoco",false,produto));
    }


    @Test
    public void CalculationNaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationNa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNaorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationNa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNaEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationNa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(5759.4400000000005,funcoes.CalculationNa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNarescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(964.5,funcoes.CalculationNa(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationNaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationNa(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationNaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(964.5,funcoes.CalculationNa(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationNaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationNaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNa(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationNaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNa(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationNaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationNa(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationKForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationK(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationKorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationK(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationKEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationK(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationKForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationK(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationKForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(4247.06,funcoes.CalculationK(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationKrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(143.5,funcoes.CalculationK(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationKPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationK(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationKForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(143.5,funcoes.CalculationK(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationKPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationK(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationKPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationK(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationKPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationK(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationKPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationK(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationCaForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationCa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCaorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationCa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCaEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationCa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCaForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(1417.485,funcoes.CalculationCa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCarescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(676.0,funcoes.CalculationCa(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationCa(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationCaForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(676.0,funcoes.CalculationCa(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCa(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationCaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCa(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationCaPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCa(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationCaPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationCa(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationPForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationP(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationPorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationP(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationPEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationP(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CCalculationPForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationP(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationPForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(2768.975,funcoes.CalculationP(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(410.5,funcoes.CalculationP(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationPPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationP(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationPForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(410.5,funcoes.CalculationP(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationPPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationP(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationPPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationP(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationPPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationP(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationPPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationP(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationMgForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationMg(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMgorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationMg(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMgEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationMg(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMgForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMg(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMgForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(425.745,funcoes.CalculationMg(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMgPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(50.0,funcoes.CalculationMg(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationMgPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationMg(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationMgForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(50.0,funcoes.CalculationMg(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationMgPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMg(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationMgPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMg(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationMgPrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMg(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationMgPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationMg(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void CalculationFeForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationFe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFeorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationFe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFeEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationFe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFeForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFeForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(14.067,funcoes.CalculationFe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFePrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(0.75,funcoes.CalculationFe(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFePrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationFe(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationFeForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(0.75,funcoes.CalculationFe(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFePrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationFePrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFe(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationFePrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFe(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationFePrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationFe(planoAtual,"Pequeno almoco",false,produto));
    }


    @Test
    public void CalculationZeForEachWithArrayEmptyPlanoAlimentar()  {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        assertEquals(0,funcoes.CalculationZe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationZeorEachWithArrayEmptyProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        assertEquals(0,funcoes.CalculationZe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationZeEachWithArrayElementPlanoAlimentar() throws Exception {
        List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
        planoAtual.add(Collections.singletonList(new PlanoAlimentar("pequeno-almoco","ss","Nata não maturada pasteurizada 33% gordura",432.1)));
        assertEquals(0,funcoes.CalculationZe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationZeForEachWithArrayElementProduto()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordura",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationZe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationZeForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoEqualToPlano()  {
        assertEquals(18.393,funcoes.CalculationZe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationZePrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(2.6,funcoes.CalculationZe(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationZePrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationZe(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationZeForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(2.6,funcoes.CalculationZe(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationZePrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoTrueAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationZe(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationZePrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoNotEqualToPlano()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationZe(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationZePrescicaoPrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationZe(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationZePrescicaoFalseButNameFoodNotEqualPlanoAndProdutoAndRefeicaoEquals()  {
        List<List<Produto>> produto = new ArrayList<>();
        produto.add(Collections.singletonList(new Produto("IS065","Nata não maturada pasteurizada 33% gordur",316,1323,61.6,2,33,2.9,3,2.9,0,0,0,0,0,18.5,7.5,0.9,1.1,0.9,97,0.36,360,186,0.28,1.1,0.02,0.16,0.7,0.2,0.5,0.03,0.2,1.7,0.5,37,105,32,62,3,0.1,0.2,0)));
        assertEquals(0,funcoes.CalculationZe(planoAtual,"Pequeno almoco",false,produto));
    }

    @Test
    public void WriteToCsvNull()  {
        assertThrows(NullPointerException.class,() -> funcoes.WriteToCsv(null,null,null));
    }

    @Test
    public void WriteToCsvPlanoAtualNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.WriteToCsv(planoS,null,produto));
    }

    @Test
    public void WriteToCsvProdutoNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.WriteToCsv(planoS,planoAtual,null));
    }

    @Test
    public void WriteToCsvProduto()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.WriteToCsv(planoS,planoAtual,produto));
    }

    @Test
    public void WriteToCsvPrescritoNull()  {
        assertThrows(NullPointerException.class,() -> funcoes.WriteToCsvPrescrito(null,null,null,null));
    }

    @Test
    public void WWriteToCsvPrescritoPlanoAtualNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.WriteToCsvPrescrito(planoS,null,pessoa,produto));
    }

    @Test
    public void WriteToCsvPrescritoProdutoNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.WriteToCsvPrescrito(planoS,planoAtual,pessoa,null));
    }

    @Test
    public void WriteToCsvPrescritoPessoaNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.WriteToCsvPrescrito(planoS,planoAtual,null,produto));
    }

    @Test
    public void csvWriterAppendNull()  {
       assertThrows(NullPointerException.class,() -> funcoes.csvWriterAppend(null,null,null,true,null));
    }

    @Test
    public void csvWriterAppendFileWriterNull()
    {
        assertThrows(NullPointerException.class,() -> funcoes.csvWriterAppend(null,refeicao,planoAtual,true,produto));
    }

    @Test
    public void csvWriterAppendProdutoNull()
    {
        assertThrows(NullPointerException.class,() -> funcoes.csvWriterAppend(csvWriter,refeicao,planoAtual,true,null));
    }

    @Test
    public void csvWriterAppendRefeicaoNull()
    {
        assertThrows(NullPointerException.class,() -> funcoes.csvWriterAppend(csvWriter,null,planoAtual,true,produto));
    }

    @Test
    public void csvWriterAppendPlanoAtualNull()
    {
        assertThrows(NullPointerException.class,() -> funcoes.csvWriterAppend(csvWriter,refeicao,null,true,produto));
    }

    @Test
    public void csvWriterAppend()
    {
        assertThrows(NullPointerException.class,() -> funcoes.csvWriterAppend(csvWriter,refeicao,planoAtual,true,produto));
    }
}
