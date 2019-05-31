package es2.com;

import java.time.LocalDate;

public class HabitosAlimentares extends Object {

    private String refeicao;
    private LocalDate time;
    private String comida;
    private int energiaKcal;
    private int energiaKj;
    private double agua;
    private double proteina;
    private double gorduraTotal;
    private double totalHCDisponiveis;
    private double totalHCMonossacaridos;
    private double monoDissacaridos;
    private double acidosOrganicos;
    private double acido;
    private double amido;
    private double oligossacaridos;
    private double acidosGordosSaturados;
    private double acidosGordosMonoInsaturados;
    private double acidosGordosPolinsaturados;
    private double acidosGordosTrans;
    private double acidoLinoleico;
    private double colesterol;
    private double vitaminaATotal;
    private double caroteno;
    private double vitaminaD;
    private double atocoferol;
    private double tiamina;
    private double riboflavina;
    private double equivalentesNiacina;
    private double niacina;
    private double triptofano60;
    private double vitaminaB6;
    private double vitaminaB12;
    private double vitaminaC;
    private double folatos;
    private double cinza;
    private double Na;
    private double K;
    private double Ca;
    private double P;
    private double Mg;
    private double Fe;
    private double Zn;


    public HabitosAlimentares(String refeicao, LocalDate time, String comida, int energiaKcal, int energiaKj, double agua, double proteina, double gorduraTotal, double totalHCDisponiveis, double totalHCMonossacaridos, double monoDissacaridos, double acidosOrganicos, double acido, double amido, double oligossacaridos, double acidosGordosSaturados, double acidosGordosMonoInsaturados, double acidosGordosPolinsaturados, double acidosGordosTrans, double acidoLinoleico, double colesterol, double vitaminaATotal, double caroteno, double vitaminaD, double atocoferol, double tiamina, double riboflavina, double equivalentesNiacina, double niacina, double triptofano60, double vitaminaB6, double vitaminaB12, double vitaminaC, double folatos, double cinza, double na, double k, double ca, double p, double mg, double fe, double zn) {
        this.refeicao = refeicao;
        this.time = time;
        this.comida = comida;
        this.energiaKcal = energiaKcal;
        this.energiaKj = energiaKj;
        this.agua = agua;
        this.proteina = proteina;
        this.gorduraTotal = gorduraTotal;
        this.totalHCDisponiveis = totalHCDisponiveis;
        this.totalHCMonossacaridos = totalHCMonossacaridos;
        this.monoDissacaridos = monoDissacaridos;
        this.acidosOrganicos = acidosOrganicos;
        this.acido = acido;
        this.amido = amido;
        this.oligossacaridos = oligossacaridos;
        this.acidosGordosSaturados = acidosGordosSaturados;
        this.acidosGordosMonoInsaturados = acidosGordosMonoInsaturados;
        this.acidosGordosPolinsaturados = acidosGordosPolinsaturados;
        this.acidosGordosTrans = acidosGordosTrans;
        this.acidoLinoleico = acidoLinoleico;
        this.colesterol = colesterol;
        this.vitaminaATotal = vitaminaATotal;
        this.caroteno = caroteno;
        this.vitaminaD = vitaminaD;
        this.atocoferol = atocoferol;
        this.tiamina = tiamina;
        this.riboflavina = riboflavina;
        this.equivalentesNiacina = equivalentesNiacina;
        this.niacina = niacina;
        this.triptofano60 = triptofano60;
        this.vitaminaB6 = vitaminaB6;
        this.vitaminaB12 = vitaminaB12;
        this.vitaminaC = vitaminaC;
        this.folatos = folatos;
        this.cinza = cinza;
        Na = na;
        K = k;
        Ca = ca;
        P = p;
        Mg = mg;
        Fe = fe;
        Zn = zn;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public int getEnergiaKcal() {
        return energiaKcal;
    }

    public void setEnergiaKcal(int energiaKcal) {
        this.energiaKcal = energiaKcal;
    }

    public int getEnergiaKj() {
        return energiaKj;
    }

    public void setEnergiaKj(int energiaKj) {
        this.energiaKj = energiaKj;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getGorduraTotal() {
        return gorduraTotal;
    }

    public void setGorduraTotal(double gorduraTotal) {
        this.gorduraTotal = gorduraTotal;
    }

    public double getTotalHCDisponiveis() {
        return totalHCDisponiveis;
    }

    public void setTotalHCDisponiveis(double totalHCDisponiveis) {
        this.totalHCDisponiveis = totalHCDisponiveis;
    }

    public double getTotalHCMonossacaridos() {
        return totalHCMonossacaridos;
    }

    public void setTotalHCMonossacaridos(double totalHCMonossacaridos) {
        this.totalHCMonossacaridos = totalHCMonossacaridos;
    }

    public double getMonoDissacaridos() {
        return monoDissacaridos;
    }

    public void setMonoDissacaridos(double monoDissacaridos) {
        this.monoDissacaridos = monoDissacaridos;
    }

    public double getAcidosOrganicos() {
        return acidosOrganicos;
    }

    public void setAcidosOrganicos(double acidosOrganicos) {
        this.acidosOrganicos = acidosOrganicos;
    }

    public double getAcido() {
        return acido;
    }

    public void setAcido(double acido) {
        this.acido = acido;
    }

    public double getAmido() {
        return amido;
    }

    public void setAmido(double amido) {
        this.amido = amido;
    }

    public double getOligossacaridos() {
        return oligossacaridos;
    }

    public void setOligossacaridos(double oligossacaridos) {
        this.oligossacaridos = oligossacaridos;
    }

    public double getAcidosGordosSaturados() {
        return acidosGordosSaturados;
    }

    public void setAcidosGordosSaturados(double acidosGordosSaturados) {
        this.acidosGordosSaturados = acidosGordosSaturados;
    }

    public double getAcidosGordosMonoInsaturados() {
        return acidosGordosMonoInsaturados;
    }

    public void setAcidosGordosMonoInsaturados(double acidosGordosMonoInsaturados) {
        this.acidosGordosMonoInsaturados = acidosGordosMonoInsaturados;
    }

    public double getAcidosGordosPolinsaturados() {
        return acidosGordosPolinsaturados;
    }

    public void setAcidosGordosPolinsaturados(double acidosGordosPolinsaturados) {
        this.acidosGordosPolinsaturados = acidosGordosPolinsaturados;
    }

    public double getAcidosGordosTrans() {
        return acidosGordosTrans;
    }

    public void setAcidosGordosTrans(double acidosGordosTrans) {
        this.acidosGordosTrans = acidosGordosTrans;
    }

    public double getAcidoLinoleico() {
        return acidoLinoleico;
    }

    public void setAcidoLinoleico(double acidoLinoleico) {
        this.acidoLinoleico = acidoLinoleico;
    }

    public double getColesterol() {
        return colesterol;
    }

    public void setColesterol(double colesterol) {
        this.colesterol = colesterol;
    }

    public double getVitaminaATotal() {
        return vitaminaATotal;
    }

    public void setVitaminaATotal(double vitaminaATotal) {
        this.vitaminaATotal = vitaminaATotal;
    }

    public double getCaroteno() {
        return caroteno;
    }

    public void setCaroteno(double caroteno) {
        this.caroteno = caroteno;
    }

    public double getVitaminaD() {
        return vitaminaD;
    }

    public void setVitaminaD(double vitaminaD) {
        this.vitaminaD = vitaminaD;
    }

    public double getAtocoferol() {
        return atocoferol;
    }

    public void setAtocoferol(double atocoferol) {
        this.atocoferol = atocoferol;
    }

    public double getTiamina() {
        return tiamina;
    }

    public void setTiamina(double tiamina) {
        this.tiamina = tiamina;
    }

    public double getRiboflavina() {
        return riboflavina;
    }

    public void setRiboflavina(double riboflavina) {
        this.riboflavina = riboflavina;
    }

    public double getEquivalentesNiacina() {
        return equivalentesNiacina;
    }

    public void setEquivalentesNiacina(double equivalentesNiacina) {
        this.equivalentesNiacina = equivalentesNiacina;
    }

    public double getNiacina() {
        return niacina;
    }

    public void setNiacina(double niacina) {
        this.niacina = niacina;
    }

    public double getTriptofano60() {
        return triptofano60;
    }

    public void setTriptofano60(double triptofano60) {
        this.triptofano60 = triptofano60;
    }

    public double getVitaminaB6() {
        return vitaminaB6;
    }

    public void setVitaminaB6(double vitaminaB6) {
        this.vitaminaB6 = vitaminaB6;
    }

    public double getVitaminaB12() {
        return vitaminaB12;
    }

    public void setVitaminaB12(double vitaminaB12) {
        this.vitaminaB12 = vitaminaB12;
    }

    public double getVitaminaC() {
        return vitaminaC;
    }

    public void setVitaminaC(double vitaminaC) {
        this.vitaminaC = vitaminaC;
    }

    public double getFolatos() {
        return folatos;
    }

    public void setFolatos(double folatos) {
        this.folatos = folatos;
    }

    public double getCinza() {
        return cinza;
    }

    public void setCinza(double cinza) {
        this.cinza = cinza;
    }

    public double getNa() {
        return Na;
    }

    public void setNa(double na) {
        Na = na;
    }

    public double getK() {
        return K;
    }

    public void setK(double k) {
        K = k;
    }

    public double getCa() {
        return Ca;
    }

    public void setCa(double ca) {
        Ca = ca;
    }

    public double getP() {
        return P;
    }

    public void setP(double p) {
        P = p;
    }

    public double getMg() {
        return Mg;
    }

    public void setMg(double mg) {
        Mg = mg;
    }

    public double getFe() {
        return Fe;
    }

    public void setFe(double fe) {
        Fe = fe;
    }

    public double getZn() {
        return Zn;
    }

    public void setZn(double zn) {
        Zn = zn;
    }
}

