package es2.com;

public class Pessoa extends Object {

    private String nome;
    private int idade;
    private String sexo;
    private String profissao;
    private DadosFisicos dadosFisicos;
    private PlanoAlimentar habitosAlimentares;
    private Questionario questionario;

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
