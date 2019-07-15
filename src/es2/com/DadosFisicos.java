package es2.com;


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


    public DadosFisicos(double peso, double altura, double gorduraCorporal, double gorduraVisceral, double idadeMetabolica, double osso, double imc, double musculo, double h20) throws AssertionError {


        assert peso >0 && peso<300 :"Peso nao pode ser menor que 0 ou maior que 300";
        assert altura > 1 && altura < 2.5 : "altura não pode ser menor que 1 ou maior que 2.5";
        assert gorduraCorporal >3 && gorduraCorporal<70 :"gordura corporal nao pode ser menor que 3 ou maior que 70";
        assert gorduraVisceral >0 && gorduraVisceral<50 :"gordura visceral nao pode ser menor que 0 ou maior que 50";
        assert idadeMetabolica >0 && idadeMetabolica<80 : "idade metabolica nao pode ser menor que 0 ou maior que 80";
        assert osso >0 && osso<5 :"osso nao pode ser menor que 0 ou maior que 5";
        assert imc>0 && imc <50: "imc nao pode ser menor que 0 ou maior que 50";
        assert musculo >0 && musculo<100: "musculo nao pode ser menor que 0 ou maior que 100";
        assert h20 >0 && h20<100: "h20 nao pode ser menor que 0 ou maior que 100";


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

    public void setPeso(double peso) throws AssertionError {
        if(peso <=0 || peso >300)
        {
            throw new AssertionError();
        }
        this.peso = peso;

    }

    public double getAltura() {

        return altura;
    }

    public void setAltura(double altura) throws AssertionError {

        if(altura <=1 || altura >2.5)
        {
            throw new AssertionError();
        }
        this.altura = altura;
    }

    public double getGorduraCorporal() {
        return gorduraCorporal;
    }

    public void setGorduraCorporal(double gorduraCorporal) throws AssertionError {

        if(gorduraCorporal <=3 || gorduraCorporal >70)
        {
            throw new AssertionError();
        }
        this.gorduraCorporal = gorduraCorporal;
    }

    public double getGorduraVisceral() {
        return gorduraVisceral;
    }

    public void setGorduraVisceral(double gorduraVisceral) {

        if(gorduraVisceral <=0 || gorduraVisceral >50)
        {
            throw new AssertionError();
        }
        this.gorduraVisceral = gorduraVisceral;
    }

    public double getIdadeMetabolica() {
        return idadeMetabolica;
    }

    public void setIdadeMetabolica(double idadeMetabolica) {
        if(idadeMetabolica <=0 || idadeMetabolica >80)
        {
            throw new AssertionError();
        }
        this.idadeMetabolica = idadeMetabolica;
    }

    public double getOsso() {
        return osso;
    }

    public void setOsso(double osso) {
        if(osso <=0 || osso >5)
        {
            throw new AssertionError();
        }
        this.osso = osso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        if(imc <=0 || imc >50)
        {
            throw new AssertionError();
        }
        this.imc = imc;
    }

    public double getMusculo() {
        return musculo;
    }

    public void setMusculo(double musculo) {
        if(musculo <=0 || musculo >100)
        {
            throw new AssertionError();
        }
        this.musculo = musculo;
    }

    public double getH20() {
        return h20;
    }

    public void setH20(double h20) {
        if(h20 <=0 || h20 >100)
        {
            throw new AssertionError();
        }
        this.h20 = h20;
    }
}
