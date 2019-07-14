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

        assert (motivoConsulta != null) && !motivoConsulta.equals("") : "Motivo Consulta nao pode ser null";
        assert !(motivoConsulta.length()>100) : "Motivo não pode ter mais de 100 carateres";
        assert (objectivo != null) && !objectivo.equals("") : "Objetivo nao pode ser null";
        assert !(objectivo.length()>100): "Objetivo não pode ter mais de 100 carateres";
        assert (patologia != null) && !patologia.equals("") : "Patologia nao pode ser null";
        assert !(patologia.length()>100): "Patologia não pode ter mais de 100 carateres";
        assert (medicacao != null) && !medicacao.equals("") : "Medicacao nao pode ser null";
        assert !(medicacao.length()>100): "Medicacao não pode ter mais de 100 carateres";
        assert (antecedentesFamiliares != null) && !antecedentesFamiliares.equals("") : "Antecedentes Familiares nao pode ser null";
        assert !(antecedentesFamiliares.length()>100): "Antecedentes não pode ter mais de 100 carateres";
        assert (atividadeFisica != null) && !atividadeFisica.equals("") : "Atividade Fisica nao pode ser null";
        assert !(atividadeFisica.length()>100): "Atividade Fisica não pode ter mais de 100 carateres";
        assert (funcaoIntestival != null) && !funcaoIntestival.equals("") : "Funcao Intestival nao pode ser null";
        assert !(funcaoIntestival.length()>100): "Funcao Intestival não pode ter mais de 100 carateres";
        assert (consumoAgua != null) && !consumoAgua.equals("") : "Consumo de Agua nao pode ser null";
        assert !(consumoAgua.length()>100): "Consumo de Agua não pode ter mais de 100 carateres";
        assert (lesao != null) && !lesao.equals("") : "Lesao nao pode ser null";
        assert !(lesao.length()>100): "Lesao não pode ter mais de 100 carateres";
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

        if ((motivoConsulta != null) && (!motivoConsulta.isEmpty()) && !(motivoConsulta.length()>100))
            this.motivoConsulta = motivoConsulta;
        else throw new AssertionError();
    }

    public String getObjectivo() {
        return objectivo;
    }

    public void setObjectivo(String objectivo) {

        if((objectivo != null) && (!objectivo.isEmpty()) && !(objectivo.length()>100))
            this.objectivo = objectivo;
        else throw new AssertionError();
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {

        if((patologia != null) && !patologia.isEmpty() && !(patologia.length()>100))
            this.patologia = patologia;
        else throw new AssertionError();
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {

        if((medicacao != null) && !medicacao.isEmpty() && !(medicacao.length()>100))
            this.medicacao = medicacao;
        else throw new AssertionError();
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String antecedentesFamiliares) {
        if((antecedentesFamiliares != null) && !antecedentesFamiliares.isEmpty() && !(antecedentesFamiliares.length()>100))
            this.antecedentesFamiliares = antecedentesFamiliares;
        else throw new AssertionError();

    }

    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(String atividadeFisica) {

        if((atividadeFisica != null) &&!atividadeFisica.isEmpty() && !(atividadeFisica.length()>100))
            this.atividadeFisica = atividadeFisica;
        else throw new AssertionError();
    }

    public String getFuncaoIntestival() {
        return funcaoIntestival;
    }

    public void setFuncaoIntestival(String funcaoIntestival) {

        if((funcaoIntestival != null) && !funcaoIntestival.isEmpty() && !(funcaoIntestival.length()>100))
            this.funcaoIntestival = funcaoIntestival;
        else throw new AssertionError();
    }

    public String getConsumoAgua() {
        return consumoAgua;
    }

    public void setConsumoAgua(String consumoAgua) {

        if((consumoAgua != null) && !consumoAgua.isEmpty() && !(consumoAgua.length()>100))
            this.consumoAgua = consumoAgua;
        else throw new AssertionError();
    }

    public double getColesterol() {
        return colesterol;
    }

    public void setColesterol(double colesterol) {

        if(colesterol > 0 && colesterol < 500)
            this.colesterol = colesterol;
        else throw new AssertionError();
    }

    public double getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(double glicemia) {

        if(glicemia > 0 && glicemia < 500)
            this.glicemia = glicemia;
        else throw new AssertionError();
    }

    public double getUrina() {
        return urina;
    }

    public void setUrina(double urina) {

        if(urina > 0 && urina < 500)
            this.urina = urina;
        else throw new AssertionError();
    }

    public double getCreatina() {
        return creatina;
    }

    public void setCreatina(double creatina) {

        if(creatina > 0 && creatina < 500)
            this.creatina = creatina;
        else throw new AssertionError();
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        if(proteina > 0 && proteina < 500)
            this.proteina = proteina;
        else throw new AssertionError();
    }

    public String getLesao() {
        return lesao;
    }

    public void setLesao(String lesao) {

        if((lesao != null) && !lesao.isEmpty() && !(lesao.length()>100))
            this.lesao = lesao;
        else throw new AssertionError();
    }

    public int getTermico() { return termico; }

    public void setTermico(int termico) throws Exception {
        if ((termico >= 38 && termico <= 41) || (termico == 0))
            this.termico = termico;
        else
            throw new Exception();
    }

}
