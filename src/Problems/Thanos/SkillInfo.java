package Problems.Thanos;

public class SkillInfo {

    public int id;
    public String nome;
    public int dano;
    public int cooldown;
    public int indicaTurno;//indica ateh qual turno a skill estah em cooldown

    public SkillInfo(int id, String nome, int dano, int cooldown, int indicaTurno){

        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.cooldown = cooldown;
        this.indicaTurno = indicaTurno;
    }

    @Override
    public String toString(){

        return "";
    }
}
