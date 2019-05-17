public class DadosFisicos {

    private double peso;
    private double altura;
    private String gorduraCorporal;
    private String gorduraVisceral;
    private String musculo;
    private String idadeMetabolica;
    private String h2o;
    private String osso;
    private Pessoa p;

    public DadosFisicos(double peso, double altura, String gorduraCorporal, String gorduraVisceral, String musculo, String idadeMetabolica, String h2o, String osso) {
        this.peso = peso;
        this.altura = altura;
        this.gorduraCorporal = gorduraCorporal;
        this.gorduraVisceral = gorduraVisceral;
        this.musculo = musculo;
        this.idadeMetabolica = idadeMetabolica;
        this.h2o = h2o;
        this.osso = osso;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
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

    public String getOsso() {
        return osso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
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

    public void setOsso(String osso) {
        this.osso = osso;
    }

    public double calculateIMC()
    {
        return peso/(altura*altura);
    }

    public double calculateMetabolismoBasal(){

        if(p.getSexo().equals("Masculino"))
        {
            return  66 + ((13.7 * peso) + ( 5 * altura) - (6.8 * p.getIdade()));
        }
        return 1;
    }


}
