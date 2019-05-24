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
    private String colesterol;
    private String glicemia;
    private String urina;
    private String creatina;
    private String proteina;


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
