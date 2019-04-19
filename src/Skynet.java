import Problems.Problema;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Skynet {

    PriorityQueue<Problema> filaPrio;
    Problema problema, aux, fim, estadoFinal;
    Queue<Problema> fila;
    ArrayList<Problema> solucao;
    int[] hash;
    int tipo;
    long hashCode;
    Object[] base;
    public boolean ver;
    boolean check;

    public Skynet(Problema problema){ //passa da main qual eh o problema

        LocalTime localTime = java.time.LocalTime.now();

        solucao = new ArrayList<>();

        this.problema = problema;
        base = problema.base();
        estadoFinal = problema.getFinal();
        tipo = problema.tipo();

        check = true;

        if(tipo == 0){

            ver = protocolGenisys0();
        } else if (tipo == 1){

            System.out.println("TENHO Q IMPLEMENTAR");
        } else
            ver = protocolGenisys2();

        if(ver){

            System.out.println("\nCAMINHO RESPOSTA");
            montaSolucao();
            printaSolucao();
        }

        LocalTime localTime1 = java.time.LocalTime.now();
        long total = Duration.between(localTime, localTime1).toMillis();
        System.out.println("\nTempo de execucao: "+total+" ms");
    }

    public boolean protocolGenisys0(){
//-----------------------------------------cria as variaveis necessarias
        filaPrio  = new PriorityQueue<>(Comparator.comparingInt(Problema::pesoHeuristica));

        problema.geraInicial();//gera o no inicial aleatorio

        problema.printa();

        filaPrio.add(problema);
        fim = null;
        ArrayList<Problema> sucessores;//array com os sucessores
//-----------------------------------------execucao
        while(check){

            if(filaPrio.isEmpty()){

                System.out.println("\nIMPOSSIVEL DE DERROTAR O THANOS");
                return false;
            }
            problema = filaPrio.poll();

            sucessores = problema.gerarSucessores();//popula o array com os sucessores do problema

            //-----------------------------------------//roda os sucessores
            for(int x = 0; x < sucessores.size(); x++){

                aux = sucessores.get(x);//um auxiliar recebe um dos sucessores
                //-----------------------------------------verificacoes
                if (aux.equals(estadoFinal)) {

                    check = false;
                    fim = aux;//para saber a partir de qual no montar o caminho de volta
                    break;
                }
                filaPrio.add(aux);//add o sucessor

            }
        }

        return true;
    }

    public boolean protocolGenisys2(){
//-----------------------------------------cria as variaveis necessarias
        hash = new int[problema.totalPossibilidades()];

        for(int x = 0; x < problema.totalPossibilidades(); x++)//inicia a hash
            hash[x] = 0;

        filaPrio  = new PriorityQueue<>(Comparator.comparingInt(Problema::pesoHeuristica));

        problema.geraInicial();//gera o no inicial aleatorio

        problema.printa();

        filaPrio.add(problema);
        fim = null;
        ArrayList<Problema> sucessores;//array com os sucessores
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
                    if (aux.equals(estadoFinal)) {

                        check = false;
                        fim = aux;//para saber a partir de qual no montar o caminho de volta
                        break;
                    }
                    filaPrio.add(aux);//add o sucessor

                }
            }
        }

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
