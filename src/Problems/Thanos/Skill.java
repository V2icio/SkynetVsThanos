package Problems.Thanos;

public class Skill {

    String nome;
    int dano;
    int cooldown;
    int indicaTurno;//indica ateh qual turno a skill estah em cooldown

    public Skill(String nome, int dano, int cooldown, int indicaTurno){

        this.nome = nome;
        this.dano = dano;
        this.cooldown = cooldown;
        this.indicaTurno = indicaTurno;
    }

    public Skill copy(){

        return new Skill(nome, dano, cooldown, indicaTurno);
    }

    @Override
    public String toString(){

        return "";
    }
}
