package Problems.Thanos;

public class Skill {

    String nome;
    Integer dano;
    Integer cooldown;
    Integer indicaTurno;//indica ateh qual turno a skill estah em cooldown

    public Skill(String nome, Integer dano, Integer cooldown, Integer indicaTurno){

        this.nome = nome;
        this.dano = dano;
        this.cooldown = cooldown;
        this.indicaTurno = indicaTurno;
    }

    public Skill copy(){

        return new Skill(nome, dano, cooldown, new Integer(indicaTurno.intValue()));
    }

    @Override
    public String toString(){

        return "";
    }
}
