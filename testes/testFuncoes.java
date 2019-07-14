import es2.com.*;
import es2.com.Exceptions.InvalidException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        pessoa = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);

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
        assertEquals(18500.03,funcoes.CalculationAgua(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationAguaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(1281.0,funcoes.CalculationAgua(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationAguaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationAgua(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationAguaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(1281.0,funcoes.CalculationAgua(planoAtual,refeicao,false,produto));
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
        assertEquals(18500.03,funcoes.CalculationProteina(planoAtual,refeicao,bool,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoEquals()  {
        assertEquals(1281.0,funcoes.CalculationProteina(planoAtual,refeicao,false,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoFalseButNameFoodEqualPlanoAndProdutoAndRefeicaoNotEquals()  {
        assertEquals(0,funcoes.CalculationProteina(planoAtual,"aa",false,produto));
    }

    @Test
    public void CalculationProteinaPrescicaoForEachWithArrayPlanoAlimentarAndProdutoAndPrescricaoFalseAndNameProdutoEqualToPlano()  {
        assertEquals(1281.0,funcoes.CalculationProteina(planoAtual,refeicao,false,produto));
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
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.csvWriterAppend(null,refeicao,planoAtual,true,produto));
    }

    @Test
    public void csvWriterAppendProdutoNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.csvWriterAppend(csvWriter,refeicao,planoAtual,true,null));
    }

    @Test
    public void csvWriterAppendRefeicaoNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.csvWriterAppend(csvWriter,null,planoAtual,true,produto));
    }

    @Test
    public void csvWriterAppendPlanoAtualNull()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.csvWriterAppend(csvWriter,refeicao,null,true,produto));
    }

    @Test
    public void csvWriterAppend()
    {
        assertThrows(IndexOutOfBoundsException.class,() -> funcoes.csvWriterAppend(csvWriter,refeicao,planoAtual,true,produto));
    }
}
