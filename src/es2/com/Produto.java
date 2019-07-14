package es2.com;

public class Produto {


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

    public Produto(String codigo, String nome, double energiaKcal, double energiaKj, double agua, double proteina, double gorduraTotal, double totalHCDisponivel, double totalHCexpressoEmMonossacaridos, double monoPlusDissacaridos, double acidosOrganicos, double alcool, double amido, double oligossacaridos, double fibraAlimentar, double acidoGordosSaturados, double acidosGordosMonoinsaturados, double acidosGordosPolinsaturados, double acidosGordosTrans, double acidoLinoleico, double colesterol, double retonol,  double vitATotal, double caroteno, double vitD, double tocoferol, double tiamina, double riboflavina, double equivalentesDeNiacina, double niaciana, double triptofano60, double vitB6, double vitB12, double vitC, double folatos, double cinza, double na, double k, double ca, double p, double mg, double fe, double zn) {

        assert !codigo.equals("") : "Codigo nao pode ser null";
        assert !nome.equals("") : "Nome nao pode ser null";
        assert energiaKcal > -1 && energiaKcal < 2000 : "Energia Kcal não pode ser menor que 0 e maior que 2000";
        assert energiaKj > -1 && energiaKj < 4000 : "Energia Kj não pode ser menor que 0 e maior que 4000";
        assert agua > -1 && agua < 100 : "Agua não pode ser menor que 0 e maior que 500";
        assert proteina > -1 && proteina < 500 : "Proteina não pode ser menor que 0 e maior que 500";
        assert gorduraTotal > -1 && gorduraTotal < 500 : "Gordura Total não pode ser menor que 0 e maior que 500";
        assert totalHCDisponivel > -1 && totalHCDisponivel < 500 : "Total HCD Disponivel não pode ser menor que -1 e maior que 500";
        assert totalHCexpressoEmMonossacaridos > -1 && totalHCexpressoEmMonossacaridos < 500 : "Total HC Expressao em Monossacaridos não pode ser menor que -1 e maior que 500";
        assert monoPlusDissacaridos > -1 && monoPlusDissacaridos < 500 : "Monoplus Dissacaridos não pode ser menor que -1 e maior que 500";
        assert alcool > -1 && alcool < 500: "Alcool não pode ser menor que -1 e maior que 5000";
        assert amido > -1 && amido < 500 : "Amido não pode ser menor que -1 e maior que 500";
        assert oligossacaridos > -1 && oligossacaridos < 500 : "Oligossacaridos não pode ser menor que -1 e maior que 500";
        assert fibraAlimentar > -1 && fibraAlimentar < 500 : "Fibra alimentar não pode ser menor que -1 e maior que 500";
        assert acidoGordosSaturados > -1 && acidoGordosSaturados < 500 : "Acido Gordos Saturados não pode ser menor que -1 e maior que 500";
        assert acidosGordosMonoinsaturados > -1 && acidosGordosMonoinsaturados < 500 : "Acidos Gordos Monoinsaturados não pode ser menor que 0 e maior que 500";
        assert acidosGordosPolinsaturados > -1 && acidosGordosPolinsaturados < 500 : "Acidos Gordos Polinsaturados não pode ser menor que 0 e maior que 500";
        assert acidosGordosTrans > -1 && acidosGordosTrans < 500 : "Acidos Gordos Trans não pode ser menor que 0 e maior que 500";
        assert retonol > -1 && retonol < 500 : "Retonol não pode ser menor que -1 e maior que 500";
        assert acidoLinoleico > -1 && acidoLinoleico < 500 : "Acido Linoleico não pode ser menor que 0 e maior que 500";
        assert colesterol > -1 && colesterol < 1500 : "Colesterol não pode ser menor que -1 e maior que 500";
        assert vitATotal > -1 && vitATotal < 15000 : "Vitamina A Total não pode ser menor que -1 e maior que 15000";
        assert caroteno > -1 && caroteno < 40500 : "Caroteno não pode ser menor que -1 e maior que 1000";
        assert vitD > -1 && vitD < 500 : "Vitamina D não pode ser menor que -1 e maior que 500";
        assert tocoferol > -1 && tocoferol < 500 : "Tocoferol não pode ser menor que -1 e maior que 500";
        assert tiamina > -1 && tiamina < 500 : "Tiamina não pode ser menor que -1 e maior que 500";
        assert equivalentesDeNiacina > -1 && equivalentesDeNiacina < 500 : "Equivalentes de Niacina não pode ser menor que 0 e maior que 500";
        assert niaciana > -1 && niaciana < 500 : "Niaciana não pode ser menor que 0 e maior que 500";
        assert triptofano60 > -1 && triptofano60 < 500 : "Triptofano60 não pode ser menor que 0 e maior que 500";
        assert vitB6 > -1 && vitB6 < 500 : "Vitamina B6 não pode ser menor que -1 e maior que 500";
        assert vitB12 > -1 && vitB12 < 500 : "Vitamina B12 não pode ser menor que -1 e maior que 500";
        assert vitC > -1 && vitC < 500 : "vitC não pode ser menor que -1 e maior que 500";
        assert folatos > -1 && folatos < 4500 : "Folatos não pode ser menor que 0 e maior que 2500";
        assert cinza > -1 && cinza < 500 : "Cinza não pode ser menor que 0 e maior que 500";
        assert na > -1 && na < 50000 : "Na não pode ser menor que 0 e maior que 6000";
        assert k > -1 && k < 4900 : "k não pode ser menor que 0 e maior que 1900";
        assert ca > -1 && ca < 1500 : "Ca não pode ser menor que 0 e maior que 1500";
        assert p > -1 && p < 16500 : "P não pode ser menor que 0 e maior que 1500";
        assert mg > -1 && mg < 1500 : "Mg não pode ser menor que 0 e maior que 1500";
        assert fe > -1 && fe < 1500 : "Fe não pode ser menor que 0 e maior que 1500";
        assert zn > -1 && zn < 500 : "Zn não pode ser menor que 0 e maior que 1500";
        
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
