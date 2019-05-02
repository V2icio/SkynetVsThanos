package Problems.Thanos;

public class Skill {

    public int id;
    public int indicaTurno;//indica ateh qual turno a skill estah em cooldown

    public Skill(int id, int indicaTurno){

        this.id = id;
        this.indicaTurno = indicaTurno;
    }

    public Skill copy(){

        return new Skill(id, indicaTurno);
    }
}
