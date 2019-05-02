package Problems.Thanos;

import Problems.Problema;

import java.util.ArrayList;
import java.util.Random;

public class ThanosNode implements Problema {

    private Char thanos;
    private Char thanosFinal = new Char(999, 0, null);
    public ArrayList<Char> chars;
    private int rodada;
    private ArrayList<String> roteiro;
    private ThanosNode pai;
    public int pesoNo;
    private static ArrayList<CharInfo> charsInfo;
    private static ArrayList<SkillInfo> skillsInfo;
    private String ultimoAtacante;

    public ThanosNode(ThanosNode pai){

        this.pai = pai;
        roteiro = new ArrayList<>();
        chars = new ArrayList<>();
    }

    public ArrayList<Problema> gerarSucessores() {

        ArrayList<Problema> filhos = new ArrayList<>();
        ThanosNode filho;

        for(int x = 0; x < chars.size(); x++){

            filho = (ThanosNode)criaFilho();//gero um filho copia do pai, pordem setando o this como pai

            if(charsInfo.get(filho.chars.get(x).id).nome == filho.ultimoAtacante && chars.size() > 1){

                filho = null;
                continue;
            }

            filho.roteiro.add("RODADA "+filho.rodada);

            filho.ataque(filho.chars.get(x), filho.thanos);//um dos herois ataca o thanos
            filho.ultimoAtacante = charsInfo.get(filho.chars.get(x).id).nome;

            if(filho.thanos.vida <= 0){//se o thanos morreu deixo a vida dele como 0 para a comparacao nao bugar

                filho.roteiro.add("Thanos morreu.\n\n\t\tHEROIS SOBREVIVENTES");
                for(Char c : filho.chars)
                    filho.roteiro.add(charsInfo.get(c.id).nome);

                filho.thanos.vida = 0;
                filhos.add(filho);
                return filhos;//dou continue pq morto nao fala
            }

            filho.ataque(filho.thanos, filho.chars.get(x));//faco o thanos contraatacar

            if(filho.chars.get(x).vida <= 0){//se o heroi morreu removo ele e coloco isso no roteiro

                filho.roteiro.add(charsInfo.get(filho.chars.get(x).id).nome + " morreu.");
                filho.chars.remove(x);
            }

            filho.pesoNo = filho.pesoHeuristica();

            if(filho.chars.size() != 0) {

                filhos.add(filho);//add o filho na lista de filhos se ainda existir herois vivos
            } else {

                filho = null;
                return null;
            }
        }

        return filhos;//retorno os filhos
    }

    public int getPesoHeuristica(){

        return pesoNo;
    }

    public void ataque(Char atacante, Char defensor){

        if(atacante.skills == null){

            defensor.vida -= charsInfo.get(atacante.id).danoBase;
            roteiro.add(charsInfo.get(atacante.id).nome + " atacou " + charsInfo.get(defensor.id).nome + " utilizando seu golpe padrao." +
                    " Vida restante: " + defensor.vida);
            return;
        }


        Skill skill;
        for(int x = 0; x < atacante.skills.size(); x++){

            skill = atacante.skills.get(x);
            if(skill.indicaTurno < rodada){

                defensor.vida -= skillsInfo.get(skill.id).dano;
                skill.indicaTurno += skillsInfo.get(skill.id).cooldown;
                roteiro.add(charsInfo.get(atacante.id).nome + " atacou " + charsInfo.get(defensor.id).nome + " utilizando " + 
                        skillsInfo.get(skill.id).nome + ". Vida restante: " + defensor.vida);

                return;
            }
        }

        defensor.vida -= charsInfo.get(atacante.id).danoBase;
        roteiro.add(charsInfo.get(atacante.id).nome + " atacou " + charsInfo.get(defensor.id).nome + " utilizando seu golpe padrao." +
                " Vida restante: " + defensor.vida);
    }

    @Override
    public boolean equals(Problema problema) {//este equals compara a vida do thanos

        ThanosNode thanosNode = (ThanosNode) problema;

        return (thanosNode.thanos.vida == this.thanos.vida);

    }

    public Problema getFinal() {

        ThanosNode thanosNode = new ThanosNode(null);
        thanosNode.thanos = thanosFinal;

        return thanosNode;
    }

    public Problema criaFilho() {

        ArrayList<Char> chars0 = new ArrayList<>();
        for(Char c : chars)
            chars0.add(c.copy());

        ThanosNode thanosNode = new ThanosNode(this);
        thanosNode.thanos = thanos.copy();
        thanosNode.thanosFinal = this.thanosFinal;
        thanosNode.chars = chars0;
        thanosNode.rodada = this.rodada + 1;
        thanosNode.ultimoAtacante = this.ultimoAtacante;

        return thanosNode;
    }

    public void printaHerois(){

        System.out.println("\t\tHEROIS VIVOS");
        for(Char c : chars){

            System.out.println(charsInfo.get(c.id).nome);
        }
        System.out.println();
    }

    public void printa() {

        if(this.pai == null){

            printaHerois();
        } else {

            for(String s : roteiro)
                System.out.println(s);

            System.out.println();
        }

    }

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

        if(chars == null){

            return Integer.MAX_VALUE;
        }

        if(pai == null)
            return 0;


        int total = 0;

        total = total + (rodada * 2);//somo a rodada

        total = total + (thanos.vida / 10);//somo a vida do thanos / 100

        return total;
    }

    public int tipo() {

        return 0;
    }

    public void geraInicial() {

        charsInfo = new ArrayList<>();
        skillsInfo = new ArrayList<>();
        Random random = new Random();

        charsInfo.add(new CharInfo(0, "Thanos", 2300, 150));
        skillsInfo.add(new SkillInfo(0, "Raio com a Joia do Poder", 300, 12, 12));
        skillsInfo.add(new SkillInfo(1, "Golpe com a Espada do Infinito", 200, 6, 6));

        charsInfo.add(new CharInfo(1, "HawkEye", 150, 15));
        skillsInfo.add(new SkillInfo(2, "Flecha explosiva", 50, 8, 0));

        charsInfo.add(new CharInfo(2, "IronMan", 1000, 60));
        skillsInfo.add(new SkillInfo(3, "Canhao de fotons", 250, 15, 15));
        skillsInfo.add(new SkillInfo(4, "Misseis explosivos", 100, 13, 13));

        charsInfo.add(new CharInfo(3, "CaptainAmerica", 500, 20));
        skillsInfo.add(new SkillInfo(5, "Golpe com escudo", 40, 3, 3));

        charsInfo.add(new CharInfo(4, "Hulk", 1400, 95));
        skillsInfo.add(new SkillInfo(6, "Soco com salto", 150, 4, 4));

        charsInfo.add(new CharInfo(5, "Thor", 1150, 90));
        skillsInfo.add(new SkillInfo(7, "Arremesso rompedor de tormentas", 500, 15, 15));
        skillsInfo.add(new SkillInfo(8, "Salto com trovao", 150, 5, 5));

        charsInfo.add(new CharInfo(6, "DrStrange", 550, 30));
        skillsInfo.add(new SkillInfo(9, "Espada Mistica", 80, 5, 5));
        skillsInfo.add(new SkillInfo(10, "Chamas de Faltine", 90, 12, 12));
        skillsInfo.add(new SkillInfo(11, "Feitico de Vishanti", 200, 20, 20));

        charsInfo.add(new CharInfo(7, "BlackWidow", 150, 10));

        charsInfo.add(new CharInfo(8, "BlackPanther", 800, 30));

        charsInfo.add(new CharInfo(9, "SpiderMan", 400, 15));

        charsInfo.add(new CharInfo(10, "AntMan", 600, 5));
        skillsInfo.add(new SkillInfo(12, "Golias", 150, 5, 5));

        charsInfo.add(new CharInfo(11, "WarMachine", 950, 50));
        skillsInfo.add(new SkillInfo(13, "Bombas Napalm", 140, 7, 7));

        charsInfo.add(new CharInfo(12, "Falcon", 200, 15));

        charsInfo.add(new CharInfo(13, "Vision", 800, 35));
        skillsInfo.add(new SkillInfo(14, "Raio com a Joia da Mente", 200, 8, 8));

        charsInfo.add(new CharInfo(14, "ScarletWitch", 450, 65));
        skillsInfo.add(new SkillInfo(15, "Raio de magia", 250, 6, 6));

        charsInfo.add(new CharInfo(15, "WinterSoldier", 400, 35));

        charsInfo.add(new CharInfo(16, "StarLord", 200, 20));

        charsInfo.add(new CharInfo(17, "Gamora", 180, 20));

        charsInfo.add(new CharInfo(18, "Drax", 340, 22));

        charsInfo.add(new CharInfo(19, "RocketRacoon", 100, 10));
        skillsInfo.add(new SkillInfo(16, "Lanca granadas", 90, 8, 8));

        charsInfo.add(new CharInfo(20, "Groot", 500, 30));

        charsInfo.add(new CharInfo(21, "Nebula", 230, 18));


        ArrayList<Char> todos = new ArrayList<>();
        rodada = 0;

        ArrayList<Skill> skills0 = new ArrayList<>();
        skills0.add(new Skill(0, skillsInfo.get(0).indicaTurno));
        skills0.add(new Skill(1, skillsInfo.get(1).indicaTurno));
        thanos = new Char(0, charsInfo.get(0).vida, skills0);

        ArrayList<Skill> skills1 = new ArrayList<>();
        skills1.add(new Skill(2, skillsInfo.get(2).indicaTurno));
        todos.add(new Char(1, charsInfo.get(1).vida, null));

        ArrayList<Skill> skills2 = new ArrayList<>();
        skills2.add(new Skill(3, skillsInfo.get(3).indicaTurno));
        skills2.add(new Skill(4, skillsInfo.get(4).indicaTurno));
        todos.add(new Char(2, charsInfo.get(2).vida, skills2));

        ArrayList<Skill> skills3 = new ArrayList<>();
        skills3.add(new Skill(5, skillsInfo.get(5).indicaTurno));
        todos.add(new Char(3, charsInfo.get(3).vida, skills3));

        ArrayList<Skill> skills4 = new ArrayList<>();
        skills4.add(new Skill(6, skillsInfo.get(6).indicaTurno));
        todos.add(new Char(4, charsInfo.get(4).vida, skills4));

        ArrayList<Skill> skills5 = new ArrayList<>();
        skills5.add(new Skill(7, skillsInfo.get(7).indicaTurno));
        skills5.add(new Skill(8, skillsInfo.get(8).indicaTurno));
        todos.add(new Char(5, charsInfo.get(5).vida, skills5));

        ArrayList<Skill> skills6 = new ArrayList<>();
        skills6.add(new Skill(9, skillsInfo.get(9).indicaTurno));
        skills6.add(new Skill(10, skillsInfo.get(10).indicaTurno));
        skills6.add(new Skill(11, skillsInfo.get(11).indicaTurno));
        todos.add(new Char(6, charsInfo.get(6).vida, skills6));

        todos.add(new Char(7, charsInfo.get(7).vida, null));
        todos.add(new Char(8, charsInfo.get(8).vida, null));
        todos.add(new Char(9, charsInfo.get(9).vida, null));

        ArrayList<Skill> skills10 =  new ArrayList<>();
        skills10.add(new Skill(12, skillsInfo.get(12).indicaTurno));
        todos.add(new Char(10, charsInfo.get(10).vida, skills10));

        ArrayList<Skill> skills11 = new ArrayList<>();
        skills11.add(new Skill(13, skillsInfo.get(13).indicaTurno));
        todos.add(new Char(11, charsInfo.get(11).vida, skills11));

        todos.add(new Char(12, charsInfo.get(12).vida, null));

        ArrayList<Skill> skills13 = new ArrayList<>();
        skills13.add(new Skill(14, skillsInfo.get(14).indicaTurno));
        todos.add(new Char(13, charsInfo.get(13).vida, skills13));

        ArrayList<Skill> skills14 = new ArrayList<>();
        skills14.add(new Skill(15, skillsInfo.get(15).indicaTurno));
        todos.add(new Char(14, charsInfo.get(14).vida, skills14));

        todos.add(new Char(15, charsInfo.get(15).vida, null));
        todos.add(new Char(16, charsInfo.get(16).vida, null));
        todos.add(new Char(17, charsInfo.get(17).vida, null));
        todos.add(new Char(18, charsInfo.get(18).vida, null));

        ArrayList<Skill> skills19 = new ArrayList<>();
        skills19.add(new Skill(16, skillsInfo.get(16).indicaTurno));
        todos.add(new Char(19, charsInfo.get(19).vida, skills19));

        todos.add(new Char(20, charsInfo.get(20).vida, null));
        todos.add(new Char(21, charsInfo.get(21).vida, null));

        /*for(int x = 0; x < 4; x++){

            int y = random.nextInt(todos.size());

            chars.add(todos.get(y));
            todos.remove(y);

        }*/

        chars.add(todos.get(4));
        chars.add(todos.get(2));
        chars.add(todos.get(3));
        chars.add(todos.get(14));

    }
}
