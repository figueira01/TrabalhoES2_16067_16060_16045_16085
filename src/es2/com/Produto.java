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



    public Produto(String codigo, String nome, double energiaKcal, double energiaKj, double agua, double proteina, double gorduraTotal, double totalHCDisponivel, double totalHCexpressoEmMonossacaridos, double monoPlusDissacaridos, double acidosOrganicos, double alcool, double amido, double oligossacaridos, double fibraAlimentar, double acidoGordosSaturados, double acidosGordosMonoinsaturados, double acidosGordosPolinsaturados, double acidosGordosTrans, double acidoLinoleico, double colesterol, double retonol, double vitATotal, double caroteno, double vitD, double tocoferol, double tiamina, double riboflavina, double equivalentesDeNiacina, double niaciana, double triptofano60, double vitB6, double vitB12, double vitC, double folatos, double cinza, double na, double k, double ca, double p, double mg, double fe, double zn) {

        assert !codigo.equals("") && codigo!=null : "Codigo nao pode ser null";
        assert !nome.equals("")  && nome!=null: "Nome nao pode ser null";
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
        assert caroteno > -1 && caroteno < 50000 : "Caroteno não pode ser menor que -1 e maior que 50000";
        assert vitD > -1 && vitD < 500 : "Vitamina D não pode ser menor que -1 e maior que 500";
        assert tocoferol > -1 && tocoferol < 500 : "Tocoferol não pode ser menor que -1 e maior que 500";
        assert tiamina > -1 && tiamina < 500 : "Tiamina não pode ser menor que -1 e maior que 500";
        assert equivalentesDeNiacina > -1 && equivalentesDeNiacina < 500 : "Equivalentes de Niacina não pode ser menor que 0 e maior que 500";
        assert niaciana > -1 && niaciana < 500 : "Niaciana não pode ser menor que 0 e maior que 500";
        assert triptofano60 > -1 && triptofano60 < 500 : "Triptofano60 não pode ser menor que 0 e maior que 500";
        assert vitB6 > -1 && vitB6 < 500 : "Vitamina B6 não pode ser menor que -1 e maior que 500";
        assert vitB12 > -1 && vitB12 < 500 : "Vitamina B12 não pode ser menor que -1 e maior que 500";
        assert vitC > -1 && vitC < 500 : "vitC não pode ser menor que -1 e maior que 500";
        assert folatos > -1 && folatos < 4500 : "Folatos não pode ser menor que 0 e maior que 4500";
        assert cinza > -1 && cinza < 500 : "Cinza não pode ser menor que 0 e maior que 500";
        assert na > -1 && na < 50000 : "Na não pode ser menor que 0 e maior que 50000";
        assert k > -1 && k < 4900 : "k não pode ser menor que 0 e maior que 4900";
        assert ca > -1 && ca < 1500 : "Ca não pode ser menor que 0 e maior que 1500";
        assert p > -1 && p < 50000 : "P não pode ser menor que 0 e maior que 50000";
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

    public void setCodigo(String codigo) {

        if(codigo==null || codigo.isEmpty())
        {
            throw new AssertionError();
        }
        else if(codigo.length()>50 || codigo.length()<=2)
        {
            throw new AssertionError();
        }
        this.codigo = codigo;
    }

    public void setNome(String nome) {

        if(nome==null || nome.isEmpty())
        {
            throw new AssertionError();
        }
        else if(nome.length()>50 || nome.length()<=2)
        {
            throw new AssertionError();
        }
        this.nome = nome;
    }

    public void setEnergiaKcal(double energiaKcal) {

        if(energiaKcal<0 || energiaKcal>2000)
        {
            throw new AssertionError();
        }
        this.energiaKcal = energiaKcal;
    }

    public void setEnergiaKj(double energiaKj) {

        if(energiaKj<0 || energiaKj>4000)
        {
            throw new AssertionError();
        }
        this.energiaKj = energiaKj;
    }

    public void setAgua(double agua) {

        if(agua<0 || agua>100)
        {
            throw new AssertionError();
        }
        this.agua = agua;
    }

    public void setProteina(double proteina) {

        if(proteina<0 || proteina>500)
        {
            throw new AssertionError();
        }
        this.proteina = proteina;
    }

    public void setGorduraTotal(double gorduraTotal) {

        if(gorduraTotal<0 || gorduraTotal>500)
        {
            throw new AssertionError();
        }
        this.gorduraTotal = gorduraTotal;
    }

    public void setTotalHCDisponivel(double totalHCDisponivel) {

        if(totalHCDisponivel<0 || totalHCDisponivel>500)
        {
            throw new AssertionError();
        }
        this.totalHCDisponivel = totalHCDisponivel;
    }

    public void setTotalHCexpressoEmMonossacaridos(double totalHCexpressoEmMonossacaridos) {

        if(totalHCexpressoEmMonossacaridos<0 || totalHCexpressoEmMonossacaridos>500)
        {
            throw new AssertionError();
        }
        this.totalHCexpressoEmMonossacaridos = totalHCexpressoEmMonossacaridos;
    }

    public void setMonoPlusDissacaridos(double monoPlusDissacaridos) {

        if(monoPlusDissacaridos<0 || monoPlusDissacaridos>500)
        {
            throw new AssertionError();
        }
        this.monoPlusDissacaridos = monoPlusDissacaridos;
    }

    public void setAcidosOrganicos(double acidosOrganicos) {

        if(acidosOrganicos<0 || acidosOrganicos>500)
        {
            throw new AssertionError();
        }
        this.acidosOrganicos = acidosOrganicos;
    }

    public void setAlcool(double alcool) {

        if(alcool<0 || alcool>500)
        {
            throw new AssertionError();
        }
        this.alcool = alcool;
    }

    public void setAmido(double amido) {

        if(amido<0 || amido>500)
        {
            throw new AssertionError();
        }
        this.amido = amido;
    }

    public void setOligossacaridos(double oligossacaridos) {

        if(oligossacaridos<0 || oligossacaridos>500)
        {
            throw new AssertionError();
        }
        this.oligossacaridos = oligossacaridos;
    }

    public void setFibraAlimentar(double fibraAlimentar) {

        if(fibraAlimentar<0 || fibraAlimentar>500)
        {
            throw new AssertionError();
        }
        this.fibraAlimentar = fibraAlimentar;
    }

    public void setAcidoGordosSaturados(double acidoGordosSaturados) {

        if(acidoGordosSaturados<0 || acidoGordosSaturados>500)
        {
            throw new AssertionError();
        }
        this.acidoGordosSaturados = acidoGordosSaturados;
    }

    public void setAcidosGordosMonoinsaturados(double acidosGordosMonoinsaturados) {

        if(acidosGordosMonoinsaturados<0 || acidosGordosMonoinsaturados>500)
        {
            throw new AssertionError();
        }
        this.acidosGordosMonoinsaturados = acidosGordosMonoinsaturados;
    }

    public void setAcidosGordosPolinsaturados(double acidosGordosPolinsaturados) {

        if(acidosGordosPolinsaturados<0 || acidosGordosPolinsaturados>500)
        {
            throw new AssertionError();
        }
        this.acidosGordosPolinsaturados = acidosGordosPolinsaturados;
    }

    public void setAcidosGordosTrans(double acidosGordosTrans) {

        if(acidosGordosTrans<0 || acidosGordosTrans>500)
        {
            throw new AssertionError();
        }
        this.acidosGordosTrans = acidosGordosTrans;
    }

    public void setRetonol(double retonol) {

        if(retonol<0 || retonol>500)
        {
            throw new AssertionError();
        }
        this.retonol = retonol;
    }

    public void setAcidoLinoleico(double acidoLinoleico) {

        if(acidoLinoleico<0 || acidoLinoleico>500)
        {
            throw new AssertionError();
        }
        this.acidoLinoleico = acidoLinoleico;
    }

    public void setColesterol(double colesterol) {

        if(colesterol<0 || colesterol>1500)
        {
            throw new AssertionError();
        }
        this.colesterol = colesterol;
    }

    public void setVitATotal(double vitATotal) {

        if(vitATotal<0 || vitATotal>15000)
        {
            throw new AssertionError();
        }
        this.vitATotal = vitATotal;
    }

    public void setCaroteno(double caroteno) {

        if(caroteno<0 || caroteno>50000)
        {
            throw new AssertionError();
        }
        this.caroteno = caroteno;
    }

    public void setVitD(double vitD) {

        if(vitD<0 || vitD>500)
        {
            throw new AssertionError();
        }
        this.vitD = vitD;
    }

    public void setTocoferol(double tocoferol) {

        if(tocoferol<0 || tocoferol>500)
        {
            throw new AssertionError();
        }
        this.tocoferol = tocoferol;
    }

    public void setTiamina(double tiamina) {

        if(tiamina<0 || tiamina>500)
        {
            throw new AssertionError();
        }
        this.tiamina = tiamina;
    }

    public void setRiboflavina(double riboflavina) {

        if(riboflavina<0 || riboflavina>500)
        {
            throw new AssertionError();
        }
        this.riboflavina = riboflavina;
    }

    public void setEquivalentesDeNiacina(double equivalentesDeNiacina) {

        if(equivalentesDeNiacina<0 || equivalentesDeNiacina>500)
        {
            throw new AssertionError();
        }
        this.equivalentesDeNiacina = equivalentesDeNiacina;
    }

    public void setNiaciana(double niaciana) {

        if(niaciana<0 || niaciana>500)
        {
            throw new AssertionError();
        }
        this.niaciana = niaciana;
    }

    public void setTriptofano60(double triptofano60) {

        if(triptofano60<0 || triptofano60>500)
        {
            throw new AssertionError();
        }
        this.triptofano60 = triptofano60;
    }

    public void setVitB6(double vitB6) {

        if(vitB6<0 || vitB6>500)
        {
            throw new AssertionError();
        }
        this.vitB6 = vitB6;
    }

    public void setVitB12(double vitB12) {

        if(vitB12<0 || vitB12>500)
        {
            throw new AssertionError();
        }
        this.vitB12 = vitB12;
    }

    public void setVitC(double vitC) {

        if(vitC<0 || vitC>500)
        {
            throw new AssertionError();
        }
        this.vitC = vitC;
    }

    public void setFolatos(double folatos) {

        if(folatos<0 || folatos>4500)
        {
            throw new AssertionError();
        }
        this.folatos = folatos;
    }

    public void setCinza(double cinza) {

        if(cinza<0 || cinza>500)
        {
            throw new AssertionError();
        }
        this.cinza = cinza;
    }

    public void setNa(double na) {

        if(na<0 || na>50000)
        {
            throw new AssertionError();
        }
        Na = na;
    }

    public void setK(double k) {

        if(k<0 || k>4900)
        {
            throw new AssertionError();
        }
        this.k = k;
    }

    public void setCa(double ca) {

        if(ca<0 || ca>1500)
        {
            throw new AssertionError();
        }
        Ca = ca;
    }

    public void setP(double p) {

        if(p<0 || p>50000)
        {
            throw new AssertionError();
        }
        P = p;
    }

    public void setMg(double mg) {

        if(mg<0 || mg>1500)
        {
            throw new AssertionError();
        }
        Mg = mg;
    }

    public void setFe(double fe) {

        if(fe<0 || fe>1500)
        {
            throw new AssertionError();
        }
        Fe = fe;
    }

    public void setZn(double zn) {

        if(zn<0 || zn>500)
        {
            throw new AssertionError();
        }
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
