package Problems.Thanos;

public class Skill {

    String nome;
    int dano;
    int cooldown;

    public Skill(String nome, int dano, int cooldown){

        this.nome = nome;
        this.dano = dano;
        this.cooldown = cooldown;
    }

    public Skill copy(){

        return new Skill(nome, dano, cooldown);
    }

    @Override
    public String toString(){

        return "";
    }
}
