public class DadosFisicos {

    private double peso;
    private double altura;
    private double gorduraCorporal;
    private double gorduraVisceral;
    private String idadeMetabolica;
    private String h2o;
    private String osso;
    private Pessoa p;

    public DadosFisicos(double peso, double altura, double gorduraCorporal, double gorduraVisceral,String idadeMetabolica, String h2o, String osso) {
        this.peso = peso;
        this.altura = altura;
        this.gorduraCorporal = gorduraCorporal;
        this.gorduraVisceral = gorduraVisceral;
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

    public double getGorduraCorporal() {return gorduraCorporal; }

    public double getGorduraVisceral() {
        return gorduraVisceral;
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

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setGorduraCorporal(double gorduraCorporal) {
        this.gorduraCorporal = gorduraCorporal;
    }

    public void setGorduraVisceral(double gorduraVisceral) {
        this.gorduraVisceral = gorduraVisceral;
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

    public double calculateMetabolismoBasal(float taxa){

        if(p.getSexo().equals("Masculino"))
        {
            return taxa * (66 + ((13.7 * peso) + ( 5 * altura) - (6.8 * p.getIdade())));
        }
        else if(p.getSexo().equals("Feminino"))
        {
            return taxa * (655 + ((9.6 * peso) + ( 1.8 * altura) - (4.7 * p.getIdade())));
        }
        else
            return 0;
    }

    public double calculateMusculo(){

        return peso-(peso*gorduraCorporal);
    }

    public double calculateWater(){

        if(p.getSexo().equals("Masculino"))
        {
            return 2.447 - 0.09156 * p.getIdade() + (altura*100) + 0.3362 * peso;
        }
        else if(p.getSexo().equals("Feminino"))
        {
            return -2.097 + 0.1069 * (altura*100) + 0.2466 * peso;
        }
        else
            return 0;
    }


}
