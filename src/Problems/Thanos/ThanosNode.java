package Problems.Thanos;

import Problems.Problema;

import java.util.ArrayList;

public class ThanosNode implements Problema {

    public ArrayList<Problema> gerarSucessores() {
        return null;
    }

    @Override
    public boolean equals(Problema problema) {
        return false;
    }

    public Problema getFinal() {
        return null;
    }

    public Problema criaFilho() {
        return null;
    }

    public void printa() {

    }

    public Problema getPai() {
        return null;
    }

    public Object[] base() {
        return new Object[0];
    }

    public Object[] alvo() {
        return new Object[0];
    }

    public int totalPossibilidades() {
        return 0;
    }

    public int pesoHeuristica() {
        return 0;
    }

    public int tipo() {
        return 0;
    }

    public void geraInicial() {

        ArrayList<Habilidade> habilidades0 = new ArrayList<>();
        Habilidade habilidade00 = new Habilidade("Raio com a Joia do Poder", 200, 12);
        Habilidade habilidade01 = new Habilidade("Raio com todas as Joias", 500, 50);
        Habilidade habilidade02 = new Habilidade("Golpe com a Espada do Infinito", 70, 5);
        habilidades0.add(habilidade00);
        habilidades0.add(habilidade01);
        habilidades0.add(habilidade02);

        Char char0 = new Char("Thanos", 2000, 30, habilidades0, 100);


        ArrayList<Habilidade> habilidades1 = new ArrayList<>();
        Habilidade habilidade10 = new Habilidade("Flecha explosiva", 50, 8);
        Habilidade habilidade11 = new Habilidade("Flecha superexplosiva", 80, 20);
        habilidades1.add(habilidade10);
        habilidades1.add(habilidade11);

        Char char1 = new Char("HawkEye", 90, 15, habilidades1, 4);


        Char char2 = new Char("IronMan");


        Char char3 = new Char("CaptainAmerica");


        Char char4 = new Char("Hulk");


        Char char5 = new Char("Thor");


        Char char6 = new Char("BlackWidow");


        Char char7 = new Char("DrStrange");


        Char char8 = new Char("BlackPanther");


        Char char9 = new Char("SpiderMan");


        Char char10 = new Char("AntMan");


        Char char11 = new Char("WarMachine");


        Char char12 = new Char("Falcon");


        Char char13 = new Char("Vision");


        Char char14 = new Char("ScarletWitch");


        Char char15 = new Char("WinterSoldier");


        Char char16 = new Char("Loki");


        Char char17 = new Char("StarLord");


        Char char18 = new Char("Gamora");


        Char char19 = new Char("Drax");


        Char char20 = new Char("RocketRacoon");


        Char char21 = new Char("Groot");


        Char char22 = new Char("Mantis");


        Char char23 = new Char("Nebula");


        Char char24 = new Char("Heimdall");


        Char char25 = new Char("Shuri");


        Char char26 = new Char("Okoye");


        Char char27 = new Char("MBaku");


        Char char28 = new Char("Wong");


    }
}
