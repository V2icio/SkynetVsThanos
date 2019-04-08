package Problems.Thanos;

import java.util.ArrayList;

public class Char {

    String nome;
    int vida;
    int danoBase;
    ArrayList<Habilidade> habilidades;
    int peso;//numa escala de 1 a 100

    public Char (String nome, int vida, int danoBase, ArrayList<Habilidade> habilidades, int peso){

        this.nome = nome;
        this.vida = vida;
        this.danoBase = danoBase;
        this.habilidades = habilidades;
        this.peso = peso;
    }

    @Override
    public String toString(){

        return "";
    }
}
