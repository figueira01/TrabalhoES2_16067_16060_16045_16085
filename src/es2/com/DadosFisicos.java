package es2.com;

public class DadosFisicos extends Object{

    private double peso;
    private double altura;
    private double gorduraCorporal;
    private double gorduraVisceral;
    private String idadeMetabolica;
    private String osso;
    private double imc;
    private double musculo;
    private double metabolismoBasal;
    private double h20;


    public DadosFisicos(double peso, double altura, double gorduraCorporal, double gorduraVisceral, String idadeMetabolica, String osso, double imc, double musculo, double metabolismoBasal, double h20) {
        this.peso = peso;
        this.altura = altura;
        this.gorduraCorporal = gorduraCorporal;
        this.gorduraVisceral = gorduraVisceral;
        this.idadeMetabolica = idadeMetabolica;
        this.osso = osso;
        this.imc = imc;
        this.musculo = musculo;
        this.metabolismoBasal = metabolismoBasal;
        this.h20 = h20;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getGorduraCorporal() {
        return gorduraCorporal;
    }

    public void setGorduraCorporal(double gorduraCorporal) {
        this.gorduraCorporal = gorduraCorporal;
    }

    public double getGorduraVisceral() {
        return gorduraVisceral;
    }

    public void setGorduraVisceral(double gorduraVisceral) {
        this.gorduraVisceral = gorduraVisceral;
    }

    public String getIdadeMetabolica() {
        return idadeMetabolica;
    }

    public void setIdadeMetabolica(String idadeMetabolica) {
        this.idadeMetabolica = idadeMetabolica;
    }

    public String getOsso() {
        return osso;
    }

    public void setOsso(String osso) {
        this.osso = osso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getMusculo() {
        return musculo;
    }

    public void setMusculo(double musculo) {
        this.musculo = musculo;
    }

    public double getMetabolismoBasal() {
        return metabolismoBasal;
    }

    public void setMetabolismoBasal(double metabolismoBasal) {
        this.metabolismoBasal = metabolismoBasal;
    }

    public double getH20() {
        return h20;
    }

    public void setH20(double h20) {
        this.h20 = h20;
    }
}
