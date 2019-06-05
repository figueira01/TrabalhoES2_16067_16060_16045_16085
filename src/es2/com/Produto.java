package es2.com;

public class Produto extends Object{

    private String codigo;
    private String nome;
    private double energiaKcal;
    private double energiaKj;
    private double agua;
    private double proteina;
    private double gorduraTotal;
    private double totalHCDisponivel;
    private double totalHCexpressoEmMonossacaridos;
    private double monoPlusDissacaridos;
    private double acidosOrganicos;
    private double alcool;
    private double amido;
    private double oligossacaridos;
    private double fibraAlimentar;
    private double acidoGordosSaturados;
    private double acidosGordosMonoinsaturados;
    private double acidosGordosPolinsaturados;
    private double acidosGordosTrans;
    private double retonol;
    private double acidoLinoleico;
    private double colesterol;
    private double vitATotal;
    private double caroteno;
    private double vitD;
    private double tocoferol;
    private double tiamina;
    private double riboflavina;
    private double equivalentesDeNiacina;
    private double niaciana;
    private double triptofano60;
    private double vitB6;
    private double vitB12;
    private double vitC;
    private double folatos;
    private double cinza;
    private double Na;
    private double k;
    private double Ca;
    private double P;
    private double Mg;
    private double Fe;
    private double Zn;

    public Produto(String codigo, String nome, double energiaKcal, double energiaKj, double agua, double proteina, double gorduraTotal, double totalHCDisponivel, double totalHCexpressoEmMonossacaridos, double monoPlusDissacaridos, double acidosOrganicos, double alcool, double amido, double oligossacaridos, double fibraAlimentar, double acidoGordosSaturados, double acidosGordosMonoinsaturados, double acidosGordosPolinsaturados, double acidosGordosTrans, double retonol, double acidoLinoleico, double colesterol, double vitATotal, double caroteno, double vitD, double tocoferol, double tiamina, double riboflavina, double equivalentesDeNiacina, double niaciana, double triptofano60, double vitB6, double vitB12, double vitC, double folatos, double cinza, double na, double k, double ca, double p, double mg, double fe, double zn) {
        this.codigo = codigo;
        this.nome = nome;
        this.energiaKcal = energiaKcal;
        this.energiaKj = energiaKj;
        this.agua = agua;
        this.proteina = proteina;
        this.gorduraTotal = gorduraTotal;
        this.totalHCDisponivel = totalHCDisponivel;
        this.totalHCexpressoEmMonossacaridos = totalHCexpressoEmMonossacaridos;
        this.monoPlusDissacaridos = monoPlusDissacaridos;
        this.acidosOrganicos = acidosOrganicos;
        this.alcool = alcool;
        this.amido = amido;
        this.oligossacaridos = oligossacaridos;
        this.fibraAlimentar = fibraAlimentar;
        this.acidoGordosSaturados = acidoGordosSaturados;
        this.acidosGordosMonoinsaturados = acidosGordosMonoinsaturados;
        this.acidosGordosPolinsaturados = acidosGordosPolinsaturados;
        this.acidosGordosTrans = acidosGordosTrans;
        this.retonol = retonol;
        this.acidoLinoleico = acidoLinoleico;
        this.colesterol = colesterol;
        this.vitATotal = vitATotal;
        this.caroteno = caroteno;
        this.vitD = vitD;
        this.tocoferol = tocoferol;
        this.tiamina = tiamina;
        this.riboflavina = riboflavina;
        this.equivalentesDeNiacina = equivalentesDeNiacina;
        this.niaciana = niaciana;
        this.triptofano60 = triptofano60;
        this.vitB6 = vitB6;
        this.vitB12 = vitB12;
        this.vitC = vitC;
        this.folatos = folatos;
        this.cinza = cinza;
        Na = na;
        this.k = k;
        Ca = ca;
        P = p;
        Mg = mg;
        Fe = fe;
        Zn = zn;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getEnergiaKcal() {
        return energiaKcal;
    }

    public double getEnergiaKj() {
        return energiaKj;
    }

    public double getAgua() {
        return agua;
    }

    public double getProteina() {
        return proteina;
    }

    public double getGorduraTotal() {
        return gorduraTotal;
    }

    public double getTotalHCDisponivel() {
        return totalHCDisponivel;
    }

    public double getTotalHCexpressoEmMonossacaridos() {
        return totalHCexpressoEmMonossacaridos;
    }

    public double getMonoPlusDissacaridos() {
        return monoPlusDissacaridos;
    }

    public double getAcidosOrganicos() {
        return acidosOrganicos;
    }

    public double getAlcool() {
        return alcool;
    }

    public double getAmido() {
        return amido;
    }

    public double getOligossacaridos() {
        return oligossacaridos;
    }

    public double getFibraAlimentar() {
        return fibraAlimentar;
    }

    public double getAcidoGordosSaturados() {
        return acidoGordosSaturados;
    }

    public double getAcidosGordosMonoinsaturados() {
        return acidosGordosMonoinsaturados;
    }

    public double getAcidosGordosPolinsaturados() {
        return acidosGordosPolinsaturados;
    }

    public double getAcidosGordosTrans() {
        return acidosGordosTrans;
    }

    public double getRetonol() {
        return retonol;
    }

    public double getAcidoLinoleico() {
        return acidoLinoleico;
    }

    public double getColesterol() {
        return colesterol;
    }

    public double getVitATotal() {
        return vitATotal;
    }

    public double getCaroteno() {
        return caroteno;
    }

    public double getVitD() {
        return vitD;
    }

    public double getTocoferol() {
        return tocoferol;
    }

    public double getTiamina() {
        return tiamina;
    }

    public double getRiboflavina() {
        return riboflavina;
    }

    public double getEquivalentesDeNiacina() {
        return equivalentesDeNiacina;
    }

    public double getNiaciana() {
        return niaciana;
    }

    public double getTriptofano60() {
        return triptofano60;
    }

    public double getVitB6() {
        return vitB6;
    }

    public double getVitB12() {
        return vitB12;
    }

    public double getVitC() {
        return vitC;
    }

    public double getFolatos() {
        return folatos;
    }

    public double getCinza() {
        return cinza;
    }

    public double getNa() {
        return Na;
    }

    public double getK() {
        return k;
    }

    public double getCa() {
        return Ca;
    }

    public double getP() {
        return P;
    }

    public double getMg() {
        return Mg;
    }

    public double getFe() {
        return Fe;
    }

    public double getZn() {
        return Zn;
    }
}
