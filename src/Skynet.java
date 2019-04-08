import Problems.Problema;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Skynet {

    Comparator<Problema> c = new Comparator<Problema>() {

        @Override
        public int compare(Problema p1, Problema p2) {

            int result = p1.pesoHeuristica() - p2.pesoHeuristica();

            if(result < 0)
                return -1;
            if(result == 0)
                return 0;
            return 1;

        }
    };

    PriorityQueue<Problema> filaPrio = new PriorityQueue<>(c);

    Problema problema, aux, fim;
    Queue<Problema> fila = new LinkedList<>();
    ArrayList<Problema> solucao = new ArrayList<>();
    int[] hash;
    long hashCode;
    Object[] base;
    public boolean ver;

    public Skynet(Problema problema){ //passa da main qual eh o problema

        LocalTime localTime = java.time.LocalTime.now();

        this.problema = problema;

        hash = new int[problema.totalPossibilidades()];
        base = problema.base();

        for(int x = 0; x < problema.totalPossibilidades(); x++)//inicia a hash
            hash[x] = 0;

        ver = protocolGenisys();

        LocalTime localTime1 = java.time.LocalTime.now();

        long total = Duration.between(localTime, localTime1).toMillis();

        System.out.println("\nTempo de execucao: "+total+" ms");
    }

    public boolean protocolGenisys(){
//-----------------------------------------cria as variaveis necessarias
        problema.geraInicial();//gera o no inicial aleatorio

        problema.printa();
        //System.out.println(Permutation.getPermutationIndex(problema.alvo(), problema.base()));

        filaPrio.add(problema);
        fim = null;
        ArrayList<Problema> sucessores;//array com os sucessores
        boolean check = true;
//-----------------------------------------execucao
        while(check){

            if(filaPrio.isEmpty()){

                System.out.println("\nIMPOSSIVEL DE RESOLVER");
                return false;
            }
            problema = filaPrio.poll();

            sucessores = problema.gerarSucessores();//popula o array com os sucessores do problema

    //-----------------------------------------//roda os sucessores
            for(int x = 0; x < sucessores.size(); x++){

                aux = sucessores.get(x);//um auxiliar recebe um dos sucessores
                hashCode = Permutation.getPermutationIndex(aux.alvo(), base);//gera o hashCode do estado
        //-----------------------------------------verificacoes
                if(hash[(int)hashCode] == 0) {//se nao existir adicionar na lista com todos e verificar se eh o final

                    hash[(int)hashCode] = 1;//muda na hash para dizer que o estado existe
                    if (aux.equals(aux.getFinal())) {

                        check = false;
                        fim = aux;//para saber a partir de qual no montar o caminho de volta
                        break;
                    }
                    filaPrio.add(aux);//add o sucessor

                }
            }

        }
        System.out.println("\nCAMINHO RESPOSTA");

        montaSolucao();

        printaSolucao();

        return true;
    }

    public void montaSolucao(){

        solucao.add(fim);
        do{

            solucao.add(fim.getPai());
            fim = fim.getPai();
        } while (fim.getPai() != null);

    }

    public void printaSolucao(){

        for(int t = solucao.size()-1; t >= 0; t--)
            solucao.get(t).printa();

    }

}
