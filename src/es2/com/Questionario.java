package es2.com;

public class Questionario extends Object {

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


    public Questionario(String motivoConsulta, String objectivo, String patologia, String medicacao, String antecedentesFamiliares, String atividadeFisica, String funcaoIntestival, String consumoAgua, double colesterol, double glicemia, double urina, double creatina, double proteina) {
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
}
