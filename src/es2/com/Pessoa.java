package es2.com;

public class Pessoa extends Object {

    private String nome;
    private int idade;
    private String sexo;
    private String profissao;
    private DadosFisicos dadosFisicos;
    private PlanoAlimentar habitosAlimentares;
    private Questionario questionario;
    private double metabolismoBasal;
    private double metabolismoBasalFa;

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

    public double CalcularTMB()
    {
        if(sexo.equals("Femenino"))
        {
          return metabolismoBasal = (66.5 + (13.8 * dadosFisicos.getPeso()) + (5 * dadosFisicos.getAltura()) - (6.8 * idade));
        }
        else {
           return metabolismoBasal = (655.1 + (9.5 * dadosFisicos.getPeso()) + (1.8 * dadosFisicos.getAltura()) - (4.7 * idade));
        }
    }

    public double CalcularTMBComFa()
    {
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
        return 0;
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
