package es2.com;

import es2.com.Exceptions.InvalidException;

public class DadosFisicos extends Object{

    private double peso;
    private double altura;
    private double gorduraCorporal;
    private double gorduraVisceral;
    private double idadeMetabolica;
    private double osso;
    private double imc;
    private double musculo;
    private double h20;


    public DadosFisicos(double peso, double altura, double gorduraCorporal, double gorduraVisceral, double idadeMetabolica, double osso, double imc, double musculo, double h20) throws InvalidException {

        if(this.peso<=0 || this.peso >300 || this.altura<1 || this.altura >2.5 || this.gorduraCorporal <3 || this.gorduraCorporal >70 || this.gorduraVisceral <0 ||
                this.gorduraVisceral>50 || this.idadeMetabolica<0 || this.idadeMetabolica>50 || this.osso <0 || this.osso>5 || this.imc <0 ||this.imc>50 || this.musculo <0
                ||this.musculo>100 || this.h20<0|| this.h20>100)
        {
            throw new InvalidException();
        }

        this.peso = peso;
        this.altura = altura;
        this.gorduraCorporal = gorduraCorporal;
        this.gorduraVisceral = gorduraVisceral;
        this.idadeMetabolica = idadeMetabolica;
        this.osso = osso;
        this.imc = imc;
        this.musculo = musculo;
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

    public double getIdadeMetabolica() {
        return idadeMetabolica;
    }

    public void setIdadeMetabolica(double idadeMetabolica) {
        this.idadeMetabolica = idadeMetabolica;
    }

    public double getOsso() {
        return osso;
    }

    public void setOsso(double osso) {
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

    public double getH20() {
        return h20;
    }

    public void setH20(double h20) {
        this.h20 = h20;
    }
}
