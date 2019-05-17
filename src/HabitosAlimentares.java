import java.time.LocalDate;

public class HabitosAlimentares {

    private String refeicao;
    private String comida;
    private LocalDate time;
    private Pessoa p;

    public HabitosAlimentares(String refeicao, String comida, LocalDate time, Pessoa p) {
        this.refeicao = refeicao;
        this.comida = comida;
        this.time = time;
        this.p = p;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public String getComida() {
        return comida;
    }

    public LocalDate getTime() {
        return time;
    }

    public Pessoa getP() {
        return p;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }
}
