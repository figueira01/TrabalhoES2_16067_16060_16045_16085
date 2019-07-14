package es2.com;

public class Questionario {

    private String motivoConsulta;
    private String objectivo;
    private String patologia;
    private String medicacao;
    private String antecedentesFamiliares;
    private String atividadeFisica;
    private String funcaoIntestival;
    private String consumoAgua;
    private double colesterol;
    private double glicemia;
    private double urina;
    private double creatina;
    private double proteina;
    private String lesao;
    private int termico;


    public Questionario(String motivoConsulta, String objectivo, String patologia, String medicacao, String antecedentesFamiliares, String atividadeFisica, String funcaoIntestival, String consumoAgua, double colesterol, double glicemia, double urina, double creatina, double proteina, String lesao,int termico)  {

        assert !motivoConsulta.equals("") : "Motivo Consulta nao pode ser null";
        assert !objectivo.equals("") : "Objetivo nao pode ser null";
        assert !patologia.equals("") : "Patologia nao pode ser null";
        assert !medicacao.equals("") : "Medicacao nao pode ser null";
        assert !antecedentesFamiliares.equals("") : "Antecedentes Familiares nao pode ser null";
        assert !atividadeFisica.equals("") : "Atividade Fisica nao pode ser null";
        assert !funcaoIntestival.equals("") : "Funcao Intestival nao pode ser null";
        assert !consumoAgua.equals("") : "Consumo de Agua nao pode ser null";
        assert !lesao.equals("") : "Lesao nao pode ser null";
        assert colesterol > 0 && colesterol < 500 : "Colesterol não pode ser menor que 0 e maior que 500";
        assert glicemia > 0 && glicemia < 500 : "Glicemia não pode ser menor que 0 e maior que 500";
        assert urina > 0 && urina < 500 : "Urina não pode ser menor que 0 e maior que 500";
        assert creatina > 0 && creatina < 500 : "Creatina não pode ser menor que 0 e maior que 500";
        assert proteina > 0 && proteina < 500 : "Proteina não pode ser menor que 0 e maior que 500";
        assert (termico >= 38 && termico <= 41) || (termico == 0) : "Termico não pode ser menor que 38 e maior que 41";

        this.motivoConsulta = motivoConsulta;
        this.objectivo = objectivo;
        this.patologia = patologia;
        this.medicacao = medicacao;
        this.antecedentesFamiliares = antecedentesFamiliares;
        this.atividadeFisica = atividadeFisica;
        this.funcaoIntestival = funcaoIntestival;
        this.consumoAgua = consumoAgua;
        this.colesterol = colesterol;
        this.glicemia = glicemia;
        this.urina = urina;
        this.creatina = creatina;
        this.proteina = proteina;
        this.lesao = lesao;
        this.termico = termico;
    }


    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getObjectivo() {
        return objectivo;
    }

    public void setObjectivo(String objectivo) {
        this.objectivo = objectivo;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(String atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public String getFuncaoIntestival() {
        return funcaoIntestival;
    }

    public void setFuncaoIntestival(String funcaoIntestival) {
        this.funcaoIntestival = funcaoIntestival;
    }

    public String getConsumoAgua() {
        return consumoAgua;
    }

    public void setConsumoAgua(String consumoAgua) {
        this.consumoAgua = consumoAgua;
    }

    public double getColesterol() {
        return colesterol;
    }

    public void setColesterol(double colesterol) {
        this.colesterol = colesterol;
    }

    public double getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(double glicemia) {
        this.glicemia = glicemia;
    }

    public double getUrina() {
        return urina;
    }

    public void setUrina(double urina) {
        this.urina = urina;
    }

    public double getCreatina() {
        return creatina;
    }

    public void setCreatina(double creatina) {
        this.creatina = creatina;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public String getLesao() {
        return lesao;
    }

    public int getTermico() {
        return termico;
    }

    public void setLesao(String lesao) {
        this.lesao = lesao;
    }

    public void setTermico(int termico) throws Exception {
        if ((termico >= 38 && termico <= 41) || (termico == 0))
            this.termico = termico;
        else
            throw new Exception();
    }
}
