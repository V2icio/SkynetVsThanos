package Problems.Thanos;

import java.util.ArrayList;

public class Char {

    String nome;
    public Integer vida;
    Integer danoBase;
    ArrayList<Skill> skills;
    int peso;//numa escala de 1 a 100

    public Char (String nome, Integer vida, Integer danoBase, ArrayList<Skill> skills, Integer peso){

        this.nome = nome;
        this.vida = vida;
        this.danoBase = danoBase;
        this.skills = skills;
        this.peso = peso;
    }

    public Char copy(){

        ArrayList<Skill> arrayList = new ArrayList<>();

        for(Skill s : skills)
            arrayList.add(s.copy());

        return new Char(nome, new Integer(vida.intValue()), new Integer(danoBase.intValue()), arrayList, peso);
    }

    public String getNome(){

        return nome;
    }

    @Override
    public String toString(){

        return "";
    }
}
