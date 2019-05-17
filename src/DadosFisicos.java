public class DadosFisicos {

    private float peso;
    private int altura;
    private int imc;
    private String gorduraCorporal;
    private String gorduraVisceral;
    private String musculo;
    private String idadeMetabolica;
    private String h2o;
    private String metabolismoBasal;
    private String osso;
    private Pessoa p;

    public DadosFisicos(float peso, int altura, int imc, String gorduraCorporal, String gorduraVisceral, String musculo, String idadeMetabolica, String h2o, String metabolismoBasal, String osso) {
        this.peso = peso;
        this.altura = altura;
        this.gorduraCorporal = gorduraCorporal;
        this.gorduraVisceral = gorduraVisceral;
        this.musculo = musculo;
        this.idadeMetabolica = idadeMetabolica;
        this.h2o = h2o;
        this.metabolismoBasal = metabolismoBasal;
        this.osso = osso;
    }

    public float getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }

    public int getImc() {
        return imc;
    }

    public String getGorduraCorporal() {
        return gorduraCorporal;
    }

    public String getGorduraVisceral() {
        return gorduraVisceral;
    }

    public String getMusculo() {
        return musculo;
    }

    public String getIdadeMetabolica() {
        return idadeMetabolica;
    }

    public String getH2o() {
        return h2o;
    }

    public String getMetabolismoBasal() {
        return metabolismoBasal;
    }

    public String getOsso() {
        return osso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setImc(int imc) {
        this.imc = imc;
    }

    public void setGorduraCorporal(String gorduraCorporal) {
        this.gorduraCorporal = gorduraCorporal;
    }

    public void setGorduraVisceral(String gorduraVisceral) {
        this.gorduraVisceral = gorduraVisceral;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }

    public void setIdadeMetabolica(String idadeMetabolica) {
        this.idadeMetabolica = idadeMetabolica;
    }

    public void setH2o(String h2o) {
        this.h2o = h2o;
    }

    public void setMetabolismoBasal(String metabolismoBasal) {
        this.metabolismoBasal = metabolismoBasal;
    }

    public void setOsso(String osso) {
        this.osso = osso;
    }
}
