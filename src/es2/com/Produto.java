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


    public Produto(String codigo, String nome, double energiaKcal, double energiaKj, double agua, double proteina, double gorduraTotal, double totalHCDisponivel, double totalHCexpressoEmMonossacaridos, double monoPlusDissacaridos, double acidosOrganicos, double alcool, double amido, double oligossacaridos, double fibraAlimentar, double acidoGordosSaturados, double acidosGordosMonoinsaturados, double acidosGordosPolinsaturados, double acidosGordosTrans, double acidoLinoleico, double colesterol, double retonol, double vitATotal, double caroteno, double vitD, double tocoferol, double tiamina, double riboflavina, double equivalentesDeNiacina, double niaciana, double triptofano60, double vitB6, double vitB12, double vitC, double folatos, double cinza, double na, double k, double ca, double p, double mg, double fe, double zn) {

        assert codigo != null && codigo != "" : "Codigo nao pode ser null";
        assert nome != null && nome != "" : "Nome nao pode ser null";
        assert energiaKcal >= 0 && energiaKcal < 2000 : "Energia Kcal não pode ser menor que 0 e maior que 2000";
        assert energiaKj >= 0 && energiaKj < 3000 : "Energia Kj não pode ser menor que 0 e maior que 3000";
        assert agua >= 0 && agua < 100 : "Agua não pode ser menor que 0 e maior que 100";
        assert proteina >= 0 && proteina < 100 : "Proteina não pode ser menor que 0 e maior que 100";
        assert gorduraTotal >= 0 && gorduraTotal < 100 : "Gordura Total não pode ser menor que 0 e maior que 100";
        assert totalHCDisponivel >= 0 && totalHCDisponivel < 500 : "Total HCD Disponivel não pode ser menor que 0 e maior que 500";
        assert totalHCexpressoEmMonossacaridos >= 0 && totalHCexpressoEmMonossacaridos < 500 : "Total HC Expressao em Monossacaridos não pode ser menor que 0 e maior que 500";
        assert monoPlusDissacaridos >= 0 && monoPlusDissacaridos < 500 : "Monoplus Dissacaridos não pode ser menor que 0 e maior que 500";
        assert alcool >= 0 && alcool < 500 : "Alcool não pode ser menor que 0 e maior que 500";
        assert amido >= 0 && amido < 500 : "Amido não pode ser menor que 0 e maior que 500";
        assert oligossacaridos >= 0 && oligossacaridos < 500 : "Oligossacaridos não pode ser menor que 0 e maior que 500";
        assert fibraAlimentar >= 0 && fibraAlimentar < 500 : "Fibra alimentar não pode ser menor que 0 e maior que 500";
        assert acidoGordosSaturados >= 0 && acidoGordosSaturados < 500 : "Acido Gordos Saturados não pode ser menor que 0 e maior que 500";
        assert acidosGordosMonoinsaturados >= 0 && acidosGordosMonoinsaturados < 500 : "Acidos Gordos Monoinsaturados não pode ser menor que 0 e maior que 500";
        assert acidosGordosPolinsaturados >= 0 && acidosGordosPolinsaturados < 500 : "Acidos Gordos Polinsaturados não pode ser menor que 0 e maior que 500";
        assert acidosGordosTrans >= 0 && acidosGordosTrans < 500 : "Acidos Gordos Trans não pode ser menor que 0 e maior que 500";
        assert retonol >= 0 && retonol < 500 : "Retonol não pode ser menor que 0 e maior que 500";
        assert acidoLinoleico >= 0 && acidoLinoleico < 500 : "Acido Linoleico não pode ser menor que 0 e maior que 500";
        assert colesterol >= 0 && colesterol < 500 : "Colesterol não pode ser menor que 0 e maior que 500";
        assert vitATotal >= 0 && vitATotal < 500 : "Vitamina A Total não pode ser menor que 0 e maior que 500";
        assert caroteno >= 0 && caroteno < 500 : "Caroteno não pode ser menor que 0 e maior que 500";
        assert vitD >= 0 && vitD < 500 : "Vitamina D não pode ser menor que 0 e maior que 500";
        assert tocoferol >= 0 && tocoferol < 500 : "Tocoferol não pode ser menor que 0 e maior que 500";
        assert tiamina >= 0 && tiamina < 500 : "Tiamina não pode ser menor que 0 e maior que 500";
        assert equivalentesDeNiacina >= 0 && equivalentesDeNiacina < 500 : "Equivalentes de Niacina não pode ser menor que 0 e maior que 500";
        assert niaciana >= 0 && niaciana < 500 : "Niaciana não pode ser menor que 0 e maior que 500";
        assert triptofano60 >= 0 && triptofano60 < 500 : "Triptofano60 não pode ser menor que 0 e maior que 500";
        assert vitB6 >= 0 && vitB6 < 500 : "Vitamina B6 não pode ser menor que 0 e maior que 500";
        assert vitB12 >= 0 && vitB12 < 500 : "Vitamina B12 não pode ser menor que 0 e maior que 500";
        assert vitC >= 0 && vitC < 500 : "Niaciana não pode ser menor que 0 e maior que 500";
        assert folatos >= 0 && folatos < 500 : "Folatos não pode ser menor que 0 e maior que 500";
        assert cinza >= 0 && cinza < 500 : "Cinza não pode ser menor que 0 e maior que 500";
        assert na >= 0 && na < 500 : "Na não pode ser menor que 0 e maior que 500";
        assert k >= 0 && k < 500 : "k não pode ser menor que 0 e maior que 500";
        assert ca >= 0 && ca < 500 : "Ca não pode ser menor que 0 e maior que 500";
        assert p >= 0 && p < 500 : "P não pode ser menor que 0 e maior que 500";
        assert mg >= 0 && mg < 500 : "Mg não pode ser menor que 0 e maior que 500";
        assert fe >= 0 && fe < 500 : "Fe não pode ser menor que 0 e maior que 500";
        assert zn >= 0 && zn < 500 : "Zn não pode ser menor que 0 e maior que 500";

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

    public void setCodigo(String codigo) {

        String c=null;
        if(codigo.isEmpty() || codigo==c)
        {
            throw new AssertionError();
        }
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnergiaKcal(double energiaKcal) {
        this.energiaKcal = energiaKcal;
    }

    public void setEnergiaKj(double energiaKj) {
        this.energiaKj = energiaKj;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public void setGorduraTotal(double gorduraTotal) {
        this.gorduraTotal = gorduraTotal;
    }

    public void setTotalHCDisponivel(double totalHCDisponivel) {
        this.totalHCDisponivel = totalHCDisponivel;
    }

    public void setTotalHCexpressoEmMonossacaridos(double totalHCexpressoEmMonossacaridos) {
        this.totalHCexpressoEmMonossacaridos = totalHCexpressoEmMonossacaridos;
    }

    public void setMonoPlusDissacaridos(double monoPlusDissacaridos) {
        this.monoPlusDissacaridos = monoPlusDissacaridos;
    }

    public void setAcidosOrganicos(double acidosOrganicos) {
        this.acidosOrganicos = acidosOrganicos;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    public void setAmido(double amido) {
        this.amido = amido;
    }

    public void setOligossacaridos(double oligossacaridos) {
        this.oligossacaridos = oligossacaridos;
    }

    public void setFibraAlimentar(double fibraAlimentar) {
        this.fibraAlimentar = fibraAlimentar;
    }

    public void setAcidoGordosSaturados(double acidoGordosSaturados) {
        this.acidoGordosSaturados = acidoGordosSaturados;
    }

    public void setAcidosGordosMonoinsaturados(double acidosGordosMonoinsaturados) {
        this.acidosGordosMonoinsaturados = acidosGordosMonoinsaturados;
    }

    public void setAcidosGordosPolinsaturados(double acidosGordosPolinsaturados) {
        this.acidosGordosPolinsaturados = acidosGordosPolinsaturados;
    }

    public void setAcidosGordosTrans(double acidosGordosTrans) {
        this.acidosGordosTrans = acidosGordosTrans;
    }

    public void setRetonol(double retonol) {
        this.retonol = retonol;
    }

    public void setAcidoLinoleico(double acidoLinoleico) {
        this.acidoLinoleico = acidoLinoleico;
    }

    public void setColesterol(double colesterol) {
        this.colesterol = colesterol;
    }

    public void setVitATotal(double vitATotal) {
        this.vitATotal = vitATotal;
    }

    public void setCaroteno(double caroteno) {
        this.caroteno = caroteno;
    }

    public void setVitD(double vitD) {
        this.vitD = vitD;
    }

    public void setTocoferol(double tocoferol) {
        this.tocoferol = tocoferol;
    }

    public void setTiamina(double tiamina) {
        this.tiamina = tiamina;
    }

    public void setRiboflavina(double riboflavina) {
        this.riboflavina = riboflavina;
    }

    public void setEquivalentesDeNiacina(double equivalentesDeNiacina) {
        this.equivalentesDeNiacina = equivalentesDeNiacina;
    }

    public void setNiaciana(double niaciana) {
        this.niaciana = niaciana;
    }

    public void setTriptofano60(double triptofano60) {
        this.triptofano60 = triptofano60;
    }

    public void setVitB6(double vitB6) {
        this.vitB6 = vitB6;
    }

    public void setVitB12(double vitB12) {
        this.vitB12 = vitB12;
    }

    public void setVitC(double vitC) {
        this.vitC = vitC;
    }

    public void setFolatos(double folatos) {
        this.folatos = folatos;
    }

    public void setCinza(double cinza) {
        this.cinza = cinza;
    }

    public void setNa(double na) {
        Na = na;
    }

    public void setK(double k) {
        this.k = k;
    }

    public void setCa(double ca) {
        Ca = ca;
    }

    public void setP(double p) {
        P = p;
    }

    public void setMg(double mg) {
        Mg = mg;
    }

    public void setFe(double fe) {
        Fe = fe;
    }

    public void setZn(double zn) {
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
