import es2.com.DadosFisicos;
import es2.com.Pessoa;
import es2.com.PlanoAlimentar;
import es2.com.Questionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 class testPessoa {

     private DadosFisicos dadosFisicos;
     private List<List<PlanoAlimentar>> planoAlimentar;
     private Questionario questionario;
     private Pessoa pessoaMasculina;
     private Pessoa pessoaFemenina;
     private Pessoa pessoaNoGenre;
     private double TMB = 0;
     private double TMBFA = 0;
     private double TMBFT = 0;
     private double TMBGET = 0;

     @BeforeEach
     void setUp() throws Exception {
         questionario = new Questionario("aaaa", "aaa", "aaa", "aa", "aaa", "Sedentario", "aa", "aaa", 0.111, 0.11, 0.111, 0.11, 0.111, "aa", 38);
         dadosFisicos = new DadosFisicos(70, 1.78, 5, 30, 23, 3, 22, 60, 65);
         pessoaMasculina = new Pessoa("Bruno miguel", 21, "Masculino", "Estudante", dadosFisicos, planoAlimentar, questionario);
         pessoaFemenina = new Pessoa("Bruno miguel", 21, "Femenino", "Estudante", dadosFisicos, planoAlimentar, questionario);
     }

     @AfterEach
     void tearDown() {

     }

     @Test
     void testContrutorPessoa() {
         Pessoa pessoa = new Pessoa("Bruno miguel", 21, "Masculino", "Estudante", dadosFisicos, planoAlimentar, questionario);
         assertThrows(AssertionError.class, () -> new Pessoa("", 21, "Masculino", "Estudante", dadosFisicos, planoAlimentar, questionario));
         assertThrows(AssertionError.class, () -> new Pessoa("aaa", 0, "Masculino", "Estudante", dadosFisicos, planoAlimentar, questionario));
         assertThrows(AssertionError.class, () -> new Pessoa("aaa", 21, "", "Estudante", dadosFisicos, planoAlimentar, questionario));
         assertThrows(AssertionError.class, () -> new Pessoa("aaaa", 21, "Masculino", "", dadosFisicos, planoAlimentar, questionario));


     }

     @Test
     void testSetNome() {
         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setNome(""));


         assertThrows(NullPointerException.class, () ->
                 pessoaFemenina.setNome(null));

         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setNome("S"));

         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setNome("ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS")
         );

         pessoaFemenina.setNome("Bruno");
         assertEquals("Bruno", pessoaFemenina.getNome());
     }

     @Test
     void testSetSexo() {
         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setSexo(""));


         assertThrows(NullPointerException.class, () ->
                 pessoaFemenina.setSexo(null));

         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setSexo("G"));

         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setSexo("GREATTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT")
         );

         pessoaFemenina.setSexo("Masculino");
         assertEquals("Masculino", pessoaFemenina.getSexo());
     }

     @Test
     void testSetProfissao() {
         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setProfissao(""));


         assertThrows(NullPointerException.class, () ->
                 pessoaFemenina.setProfissao(null));

         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setProfissao("i"));

         assertThrows(AssertionError.class, () ->
                 pessoaFemenina.setProfissao("Informaticooooooooooooooooooooooooooooooooooooooooooooooo")
         );

         pessoaFemenina.setProfissao("Estudante");
         assertEquals("Estudante", pessoaFemenina.getProfissao());
     }

     @Test
     public void testSetIdade() {

         assertThrows(AssertionError.class, () -> pessoaFemenina.setIdade(-1));
        assertThrows(AssertionError .class, () -> pessoaFemenina.setIdade(4000));
        pessoaFemenina.setIdade(10);
        assertEquals(10,pessoaFemenina.getIdade());
 }

    @Test
    void testObjectDadosFisicos()
    {
        assertSame(dadosFisicos,pessoaMasculina.getDadosFisicos());
    }

    @Test
    void testObjectPlanoAlimentar()
    {
        assertSame(planoAlimentar,pessoaMasculina.getHabitosAlimentares());
    }

    @Test
    void testObjectQuestionario()
    {
        assertSame(questionario,pessoaMasculina.getQuestionario());
    }

    @Test
    void testCalculoTMBMen() throws Exception {
       TMB = pessoaMasculina.CalcularTMB();
       assertEquals(1541.8,TMB);
    }
    @Test
    void testCalculoTMBWomen() throws Exception {
        TMB = pessoaFemenina.CalcularTMB();
        assertEquals(1779.7,TMB);
    }

    @Test
    void testCalculoTMBThrow()  {
        assertThrows(Exception.class,() -> pessoaNoGenre.CalcularTMB());
    }

    @Test
    void testCalculoTMBWithFASedentario() throws Exception {
        pessoaMasculina.CalcularTMB();
        TMBFA = pessoaMasculina.CalcularTMBComFa();
        assertEquals(2343.536,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAModeradamenteAtivo() throws Exception {

        Questionario questionarioFAModeradamenteAtivo = new Questionario("aaaa","aaa","aaa","aa","aaa","Moderadamente Ativo","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFAModeradamenteAtivo = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFAModeradamenteAtivo);
        pessoaMasculinaFAModeradamenteAtivo.CalcularTMB();
        TMBFA = pessoaMasculinaFAModeradamenteAtivo.CalcularTMBComFa();
        assertEquals(2713.5679999999998,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAEmpty() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Nenhuma","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        assertThrows(Exception.class, pessoaMasculinaFA::CalcularTMBComFa);
    }

    @Test
    void testCalculoTMBWithFAMuitoAtivo() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Muito Ativo","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(3469.0499999999997,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAAcamado() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Acamado","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(1850.1599999999999,TMBFA);
    }

    @Test
    void testCalculoTMBWithFAAcamadomovel() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Acamado + movel","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(1927.25,TMBFA);
    }

    @Test
    void testCalculoTMBWithFADeambulando() throws Exception {

        Questionario questionarioFA = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFA = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFA);
        pessoaMasculinaFA.CalcularTMB();
        TMBFA = pessoaMasculinaFA.CalcularTMBComFa();
        assertEquals(2004.34,TMBFA);
    }

    @Test
    void testCalculoTMBWithFT38() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",38);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2204.774,TMBFT);
    }

    @Test
    void testCalculoTMBWithFT39() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",39);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2405.2079999999996,TMBFT);
    }

    @Test
    void testCalculoTMBWithFT40() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",40);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2605.642,TMBFT);
    }

    @Test
    void testCalculoTMBWithFT41() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",41);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2806.0759999999996,TMBFT);
    }

    @Test
    void testCalculoTMBWithFT0() throws Exception {

        Questionario questionarioFT = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"aa",0);
        Pessoa pessoaMasculinaFT = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioFT);
        pessoaMasculinaFT.CalcularTMB();
        pessoaMasculinaFT.CalcularTMBComFa();
        TMBFT = pessoaMasculinaFT.CalcularTMBComFT();
        assertEquals(2004.34,TMBFT);
    }


    @Test
    void testCalculoGETPacientenaocomplicado() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Paciente não complicado",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(2806.0759999999996,TMBGET);
    }

    @Test
    void testCalculoGETPosoperatoriooncologico() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Pós operatório oncológico",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(3086.6836,TMBGET);
    }

    @Test
    void testCalculoGETFraturaossoslongos() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Fratura ossos longos",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(3367.291199999999,TMBGET);
    }

    @Test
    void testCalculoGETSepsemoderada() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Sepse moderada",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(3647.8987999999995,TMBGET);
    }

    @Test
    void testCalculoGETPeritonite() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Peritonite",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(3928.5063999999993,TMBGET);
    }

    @Test
    void testCalculoGETPolitraumaemreabilitacao() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Politrauma em reabilitação",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(4209.114,TMBGET);
    }

    @Test
    void testCalculoGETPolitraumaSepse() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Politrauma + Sepse",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(4489.7216,TMBGET);
    }

    @Test
    void testCalculoGETQueimadura30a50() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Queimadura 30 a 50",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(4770.329199999999,TMBGET);
    }

    @Test
    void testCalculoGETQueimadura50a70() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Queimadura 50 a 70",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(5050.9367999999995,TMBGET);
    }

    @Test
    void testCalculoGETQueimadura70a90() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Queimadura 70 a 90",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(5612.151999999999,TMBGET);
    }

    @Test
    void testCalculoNehumaLesao() throws Exception {
        Questionario questionarioGET = new Questionario("aaaa","aaa","aaa","aa","aaa","Deambulando","aa","aaa",0.111,0.11,0.111,0.11,0.111,"Nenhuma",41);
        Pessoa pessoaMasculinaGET = new Pessoa("Bruno miguel",21,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionarioGET);
        pessoaMasculinaGET.CalcularTMB();
        pessoaMasculinaGET.CalcularTMBComFa();
        pessoaMasculinaGET.CalcularTMBComFT();
        TMBGET = pessoaMasculinaGET.CalcularGET();
        assertEquals(2806.0759999999996,TMBGET);
    }


    @Test
    void testCalculoSchofieldEquationNoGenro()
    {
        assertThrows(Exception.class,() -> pessoaNoGenre.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationUnder3AndMen() throws Exception {
        pessoaMasculina = new Pessoa("Bruno miguel",1,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(4135.4400000000005,pessoaMasculina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationUnder3AndWomen() throws Exception {
        pessoaFemenina = new Pessoa("Bruno miguel",2,"Femenino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(4051.09,pessoaFemenina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween3And10AndMen() throws Exception
    {
        pessoaMasculina = new Pessoa("Bruno miguel",4,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(2093.7200000000003,pessoaMasculina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween3And10AndWomen() throws Exception
    {
        pessoaFemenina = new Pessoa("Bruno miguel",4,"Femenino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1907.9500000000003,pessoaFemenina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween10And18AndWomen() throws Exception
    {
        pessoaFemenina = new Pessoa("Bruno miguel",12,"Femenino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1629.48,pessoaFemenina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween10And18AndMen() throws Exception
    {
        pessoaMasculina = new Pessoa("Bruno miguel",12,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1896.22,pessoaMasculina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween18And30AndMen() throws Exception
    {
        pessoaMasculina = new Pessoa("Bruno miguel",23,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1746.19,pessoaMasculina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween18And30AndWomen() throws Exception
    {
        pessoaFemenina = new Pessoa("Bruno miguel",23,"Femenino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1523.8600000000001,pessoaFemenina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween30And60AndMen() throws Exception
    {
        pessoaMasculina = new Pessoa("Bruno miguel",45,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1676.1399999999999,pessoaMasculina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationBetween30And60AndWomen() throws Exception
    {
        pessoaFemenina = new Pessoa("Bruno miguel",34,"Femenino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1414.42,pessoaFemenina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationUp60AndMen() throws Exception
    {
        pessoaMasculina = new Pessoa("Bruno miguel",81,"Masculino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1407.47,pessoaMasculina.CalcularSchofieldEquation());
    }

    @Test
    void testCalculoSchofieldEquationUp60Women() throws Exception
    {
        pessoaFemenina = new Pessoa("Bruno miguel",71,"Femenino","Estudante",dadosFisicos,planoAlimentar,questionario);
        assertEquals(1294.24,pessoaFemenina.CalcularSchofieldEquation());
    }
}
