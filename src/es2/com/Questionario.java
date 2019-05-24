package es2.com;

public class Questionario extends Object {

    public String motivoConsulta;
    public String objectivo;
    public String patologia;
    public String medicacao;
    public String antecedentesFamiliares;
    public String atividadeFisica;
    public String funcaoIntestival;
    public String consumoAgua;
    public String colesterol;
    public String glicemia;
    public String urina;
    public String creatina;
    public String proteina;


    public Questionario(String motivoConsulta, String objectivo, String patologia, String medicacao, String antecedentesFamiliares, String atividadeFisica, String funcaoIntestival, String consumoAgua, String colesterol, String glicemia, String urina, String creatina, String proteina) {
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
}
