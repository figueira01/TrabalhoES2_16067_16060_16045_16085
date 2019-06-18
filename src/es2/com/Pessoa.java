package es2.com;

public class Pessoa extends Object {

    private String nome;
    private int idade;
    private String sexo;
    private String profissao;
    private DadosFisicos dadosFisicos;
    private PlanoAlimentar habitosAlimentares;
    private Questionario questionario;
    private double metabolismoBasal = 0;
    private double metabolismoBasalFa = 0;
    private double metabolismoBasalFT = 0;
    private double metabolismoBasalGET = 0;

    public Pessoa(String nome, int idade, String sexo, String profissao, DadosFisicos dadosFisicos, PlanoAlimentar planoAtual, Questionario questionario) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
        this.dadosFisicos = dadosFisicos;
        this.habitosAlimentares = planoAtual;
        this.questionario = questionario;
    }

    public PlanoAlimentar getHabitosAlimentares() {
        return this.habitosAlimentares;
    }

    public DadosFisicos getDadosFisicos(){
        return this.dadosFisicos;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public double CalcularTMB() throws Exception {
        if(sexo.equals("Femenino"))
        {
          return metabolismoBasal = (66.5 + (13.8 * dadosFisicos.getPeso()) + (5 * dadosFisicos.getAltura()) - (6.8 * idade));
        }
        if(sexo.equals("Masculino"))
        {
           return metabolismoBasal = (655.1 + (9.5 * dadosFisicos.getPeso()) + (1.8 * dadosFisicos.getAltura()) - (4.7 * idade));
        }
        throw new Exception();
    }

    public double CalcularTMBComFa() throws Exception {
        if(questionario.getAtividadeFisica().equals("Sedentario"))
        {
            return metabolismoBasalFa = metabolismoBasal * 1.52;
        }
        if(questionario.getAtividadeFisica().equals("Moderadamente Ativo"))
        {
            return metabolismoBasalFa = metabolismoBasal * 1.76;
        }
        if(questionario.getAtividadeFisica().equals("Muito Ativo"))
        {
            return metabolismoBasalFa = metabolismoBasal * 2.25;
        }
        if(questionario.getAtividadeFisica().equals("Acamado"))
        {
            return metabolismoBasalFa = metabolismoBasal * 1.2;
        }
        if(questionario.getAtividadeFisica().equals("Acamado + movel"))
        {
            return metabolismoBasalFa = metabolismoBasal * 1.25;
        }
        if(questionario.getAtividadeFisica().equals("Deambulando"))
        {
            return metabolismoBasalFa = metabolismoBasal * 1.3;
        }
        throw new Exception();
    }

    public double CalcularTMBComFT() throws Exception {

        if(questionario.getTermico() == 38){
            return metabolismoBasalFT = metabolismoBasalFa * 1.1;
        }
        if(questionario.getTermico() == 39){
            return metabolismoBasalFT = metabolismoBasalFa * 1.2;
        }
        if(questionario.getTermico() == 40){
            return metabolismoBasalFT = metabolismoBasalFa * 1.3;
        }
        if(questionario.getTermico() == 41){
            return metabolismoBasalFT = metabolismoBasalFa * 1.4;
        }
        throw new Exception();
    }

    public double CalcularGET() throws Exception {
        if(questionario.getLesao().equals("Paciente não complicado")){
            return metabolismoBasalGET = metabolismoBasalFT * 1;
        }
        if(questionario.getLesao().equals("Pós operatório oncológico")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.1;
        }
        if(questionario.getLesao().equals("Fratura ossos longos")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.2;
        }
        if(questionario.getLesao().equals("Sepse moderada")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.3;
        }
        if(questionario.getLesao().equals("Peritonite")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.4;
        }
        if(questionario.getLesao().equals("Politrauma em reabilitação")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.5;
        }
        if(questionario.getLesao().equals("Politrauma + Sepse")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.6;
        }
        if(questionario.getLesao().equals("Queimadura 30 a 50")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.7;
        }
        if(questionario.getLesao().equals("Queimadura 50 a 70")){
            return metabolismoBasalGET = metabolismoBasalFT * 1.8;
        }
        if(questionario.getLesao().equals("Queimadura 70 a 90")){
            return metabolismoBasalGET = metabolismoBasalFT * 2;
        }
        throw new Exception();
    }


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
