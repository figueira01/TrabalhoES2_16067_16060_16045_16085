package es2.com;

import java.util.List;

public class Pessoa {

    private String nome;
    private int idade;
    private String sexo;
    private String profissao;
    private DadosFisicos dadosFisicos;
    private List<List<PlanoAlimentar>> habitosAlimentares;
    private Questionario questionario;
    private double metabolismoBasal = 0;
    private double metabolismoBasalFa = 0;
    private double metabolismoBasalFT = 0;
    private double metabolismoBasalGET = 0;
    private double BMR = 0;

    public Pessoa(String nome, int idade, String sexo, String profissao, DadosFisicos dadosFisicos, List<List<PlanoAlimentar>> planoAtual, Questionario questionario) {
        assert !nome.equals("") :"Nome nao pode ser null nem vazio";
        assert idade > 0 && idade < 100 : "Idade não pode ser menor que  0 e maior que 100";
        assert !sexo.equals(""):"Sexo nao pode ser null nem vazio";
        assert !profissao.equals(""):"profissao nao pode ser null nem vazio";

        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
        this.dadosFisicos = dadosFisicos;
        this.habitosAlimentares = planoAtual;
        this.questionario = questionario;
    }

    public List<List<PlanoAlimentar>> getHabitosAlimentares() {
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
          return metabolismoBasal = (66.5 + (13.8 * dadosFisicos.getPeso()) + (5 * (dadosFisicos.getAltura()*100)) - (6.8 * idade));
        }
        if(sexo.equals("Masculino"))
        {
           return metabolismoBasal = (655.1 + (9.5 * dadosFisicos.getPeso()) + (1.8 * (dadosFisicos.getAltura()*100)) - (4.7 * idade));
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

    public double CalcularTMBComFT() {

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
            return metabolismoBasalFT = metabolismoBasalFa;
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
        if(questionario.getLesao().equals("Nenhuma")){
            return metabolismoBasalGET = metabolismoBasalFT;
        }
        throw new Exception();
    }

    public double CalcularSchofieldEquation() throws Exception {
        if(idade >= 0 && idade < 3)
        {
            if(sexo.equals("Masculino"))
            {
                return BMR = 59.512 * dadosFisicos.getPeso() - 30.4;
            }
            if(sexo.equals("Femenino"))
            {
                return BMR =  58.317 * dadosFisicos.getPeso() - 31.1;
            }
            throw new Exception();
        }
        if(idade >= 3 && idade < 10)
        {
            if(sexo.equals("Masculino"))
            {
                return BMR = 22.706 * dadosFisicos.getPeso() + 504.3;
            }
            if(sexo.equals("Femenino"))
            {
                return BMR =  20.315 * dadosFisicos.getPeso() +  485.9;
            }
            throw new Exception();
        }
        if(idade >= 10 && idade < 18)
        {
            if(sexo.equals("Masculino"))
            {
                return BMR = 17.686 * dadosFisicos.getPeso() +  658.2;
            }
            if(sexo.equals("Femenino"))
            {
                return BMR = 13.384 * dadosFisicos.getPeso() + 692.6;
            }
            throw new Exception();
        }
        if(idade >= 18 && idade < 30)
        {
            if(sexo.equals("Masculino"))
            {
                return BMR = 15.057 * dadosFisicos.getPeso() + 692.2;
            }
            if(sexo.equals("Femenino"))
            {
                return BMR =  14.818 * dadosFisicos.getPeso() + 486.6;
            }
            throw new Exception();
        }
        if(idade >= 30 && idade <= 60)
        {
            if(sexo.equals("Masculino"))
            {
                return BMR = 11.472 * dadosFisicos.getPeso() + 873.1;
            }
            if(sexo.equals("Femenino"))
            {
                return BMR =  8.126 * dadosFisicos.getPeso() + 845.6;
            }
            throw new Exception();
        }
        if(idade > 60)
        {
            if(sexo.equals("Masculino"))
            {
                return BMR = 11.711 * dadosFisicos.getPeso() + 587.7;
            }
            if(sexo.equals("Femenino"))
            {
                return BMR =  9.082 * dadosFisicos.getPeso() + 658.5;
            }
            throw new Exception();
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
        if(nome.isEmpty())
        {
            throw new AssertionError();
        }
        else if(nome.length()>50 || nome.length()<=2)
        {
            throw new AssertionError();
        }this.nome = nome;
    }

    public void setIdade(int idade) {
        if(idade<0 || idade>100)
        {
            throw new AssertionError();
        }
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        if(sexo.isEmpty())
        {
            throw new AssertionError();
        }
        else if(sexo.length()>50 || sexo.length()<=2)
        {
            throw new AssertionError();
        }this.sexo = sexo;
    }

    public void setProfissao(String profissao) {
        if(profissao.isEmpty())
        {
            throw new AssertionError();
        }
        else if(profissao.length()>50 || profissao.length()<=2)
        {
            throw new AssertionError();
        }
        this.profissao = profissao;
    }
}
