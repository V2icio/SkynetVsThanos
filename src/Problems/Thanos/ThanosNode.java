package Problems.Thanos;

import Problems.Problema;

import java.util.ArrayList;

public class ThanosNode implements Problema {

    Char thanos, thanosFinal;
    ArrayList<Char> chars;
    int pesoMovimento;


    ThanosNode pai;

    public ThanosNode(){

        thanosFinal = new Char("ThanosFinal", 0, 0, null, 0);
    }

    public ArrayList<Problema> gerarSucessores() {
        return null;
    }

    @Override
    public boolean equals(Problema problema) {//este equals compara a vida do thanos

        ThanosNode thanosNode = (ThanosNode) problema;

        if(thanosNode.thanos.vida == this.thanos.vida)
            return true;

        return false;
    }

    public Problema getFinal() {

        ThanosNode thanosNode = new ThanosNode();
        thanosNode.thanos = thanosFinal;

        return thanosNode;
    }

    public Problema criaFilho() {
        return null;
    }

    public void printa() {}

    public Problema getPai() {

        return pai;
    }

    public Object[] base() {

        return null;
    }

    public Object[] alvo() {

        return null;
    }

    public int totalPossibilidades() {
        return 0;
    }

    public int pesoHeuristica() {

        int total = 0;

        total = total + (2 * pesoMovimento);

        for(Char c : chars){

            if(c.vida > 0)
                total += c.peso;
        }

        total = total - (thanos.vida / 100);

        return total;
    }

    public int tipo() {

        return 0;
    }

    public void geraInicial() {

        ArrayList<Char> todos = new ArrayList<>();

        ArrayList<Habilidade> habilidades0 = new ArrayList<>();
        habilidades0.add(new Habilidade("Raio com a Joia do Poder", 200, 12));
        habilidades0.add(new Habilidade("Raio com todas as Joias", 500, 50));
        habilidades0.add(new Habilidade("Golpe com a Espada do Infinito", 70, 5));

        Char char0 = new Char("Thanos", 2000, 30, habilidades0, 100);
        thanos = char0;


        ArrayList<Habilidade> habilidades1 = new ArrayList<>();
        habilidades1.add(new Habilidade("Flecha explosiva", 50, 8));
        habilidades1.add(new Habilidade("Flecha superexplosiva", 80, 20));

        todos.add(new Char("HawkEye", 90, 15, habilidades1, 35));

        ArrayList<Habilidade> habilidades2 = new ArrayList<>();
        todos.add(new Char("IronMan"));

        ArrayList<Habilidade> habilidades3 = new ArrayList<>();
        todos.add(new Char("CaptainAmerica"));

        ArrayList<Habilidade> habilidades4 = new ArrayList<>();
        todos.add(new Char("Hulk"));

        ArrayList<Habilidade> habilidades5 = new ArrayList<>();
        todos.add(new Char("Thor"));

        ArrayList<Habilidade> habilidades6 = new ArrayList<>();
        todos.add(new Char("BlackWidow"));

        ArrayList<Habilidade> habilidades7 = new ArrayList<>();
        todos.add(new Char("DrStrange"));

        ArrayList<Habilidade> habilidades8 = new ArrayList<>();
        todos.add(new Char("BlackPanther"));

        ArrayList<Habilidade> habilidades9 = new ArrayList<>();
        todos.add(new Char("SpiderMan"));

        ArrayList<Habilidade> habilidades10 = new ArrayList<>();
        todos.add(new Char("AntMan"));

        ArrayList<Habilidade> habilidades11 = new ArrayList<>();
        todos.add(new Char("WarMachine"));

        ArrayList<Habilidade> habilidades12 = new ArrayList<>();
        todos.add(new Char("Falcon"));

        ArrayList<Habilidade> habilidades13 = new ArrayList<>();
        todos.add(new Char("Vision"));

        ArrayList<Habilidade> habilidades14 = new ArrayList<>();
        todos.add(new Char("ScarletWitch"));

        ArrayList<Habilidade> habilidades15 = new ArrayList<>();
        todos.add(new Char("WinterSoldier"));

        ArrayList<Habilidade> habilidades16 = new ArrayList<>();
        todos.add(new Char("Loki"));

        ArrayList<Habilidade> habilidades17 = new ArrayList<>();
        todos.add(new Char("StarLord"));

        ArrayList<Habilidade> habilidades18 = new ArrayList<>();
        todos.add(new Char("Gamora"));

        ArrayList<Habilidade> habilidades19 = new ArrayList<>();
        todos.add(new Char("Drax"));

        ArrayList<Habilidade> habilidades20 = new ArrayList<>();
        todos.add(new Char("RocketRacoon"));

        ArrayList<Habilidade> habilidades21 = new ArrayList<>();
        todos.add(new Char("Groot"));

        ArrayList<Habilidade> habilidades22 = new ArrayList<>();
        todos.add(new Char("Nebula"));

        ArrayList<Habilidade> habilidades23 = new ArrayList<>();
        todos.add(new Char("Heimdall"));

        ArrayList<Habilidade> habilidades24 = new ArrayList<>();
        todos.add(new Char("Shuri"));

        ArrayList<Habilidade> habilidades25 = new ArrayList<>();
        todos.add(new Char("Okoye"));

        ArrayList<Habilidade> habilidades26 = new ArrayList<>();
        todos.add(new Char("MBaku"));

        ArrayList<Habilidade> habilidades27 = new ArrayList<>();
        todos.add(new Char("Wong"));

        ArrayList<Habilidade> habilidades28 = new ArrayList<>();
        todos.add(new Char("Mantis"));

    }
}
