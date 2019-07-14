import es2.com.*;
import es2.com.Exceptions.InvalidException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testFuncoes {

    private List<List<PlanoAlimentar>> planoAtual = new ArrayList<>();
    private String refeicao;
    private boolean bool;
    private Funcoes funcoes;
    private String url = "CSV/PlanoAlimentarAtual.csv";
    private List<List<Produto>> produto = new ArrayList<>();
    private List<List<String>> planoS = new ArrayList<>();

    @BeforeEach
    void setUp()
    {

        refeicao = "Pequeno Almoco";
        bool = true;
        funcoes = new Funcoes();
        funcoes.LerPlanoAlimentar(url,planoAtual);
        funcoes.LerDadosProdutos(produto);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    public void testLerDadosFisicosNull()   {
        assertThrows(NullPointerException.class,() -> funcoes.LerDadosFisicos(null));
    }

    @Test
    public void testLerDadosFisicos() throws InvalidException {
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
    public void LerQuestionarioNull()   {
        //assertThrows(NullPointerException.class, () -> funcoes.LerQuestionario(null));

    }

    @Test
    public void LerPlanoAlimentar()
    {
        funcoes.LerPlanoAlimentar(url,planoAtual);
    }

    @Test
    public void LerPlanoAlimentarUrlWrong()
    {
        //assertThrows(FileNotFoundException.class,() -> funcoes.LerPlanoAlimentar("aaaa",planoAtual));
    }

    @Test
    public void LerPlanoAlimentarArrayWrong()
    {
        //assertThrows(NullPointerException.class,() -> funcoes.LerPlanoAlimentar(url,null));
    }

    @Test
    public void LerPlanoAlimentarString()
    {
        funcoes.LerPlanoAlimentarS(url,planoS);
    }

    @Test
    public void LerPlanoAlimentarStringUrlWrong()
    {
        //assertThrows(FileNotFoundException.class,() -> funcoes.LerPlanoAlimentarS("aaaa",planoS));
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
}
