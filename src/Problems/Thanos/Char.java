package Problems.Thanos;

import java.util.ArrayList;

public class Char {

    public int id;
    public int vida;
    public ArrayList<Skill> skills;

    public Char(int id, int vida, ArrayList<Skill> skills){

        this.id = id;
        this.vida = vida;
        this.skills = skills;
    }

    public Char copy(){

        ArrayList<Skill> skills0 = new ArrayList<>();

        if(skills == null){

            skills0 = null;
        } else {

            for(Skill s : skills)
                skills0.add(s.copy());
        }

        return new Char(id, vida, skills0);
    }

}
