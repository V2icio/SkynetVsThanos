package ASeisBlocos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Controller {

    public static Queue<No> fila = new LinkedList<>();
    public static Stack<No> conclusao = new Stack<>();
    public static ArrayList<No> todos = new ArrayList<>();
    static No fimE = new No(null);
    static No fimM = new No(null);
    static No fimD = new No(null);

    public Controller(){

        Stack<Integer> a = new Stack<>();
        a.add(6);
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);

        fimD.setStackD(a);
        fimE.setStackE(a);
        fimM.setStackM(a);
    }

    public No executar(No no){

        No aux = new No(no);
        ArrayList<No> filhos = new ArrayList<>();

        if(no.stackE.size() != 0){

            aux = aux.copy(no);
            aux.stackM.add(aux.stackE.pop());
            if(addNovo(aux)){


                filhos.add(aux);
                if(verifica(aux))
                    return aux;
            }

            aux = aux.copy(no);
            aux.stackD.add(aux.stackE.pop());
            if(addNovo(aux)){

                filhos.add(aux);
                if(verifica(aux))
                    return aux;
            }
        }
        if(no.stackM.size() != 0){

            aux = aux.copy(no);
            aux.stackE.add(aux.stackM.pop());
            if(addNovo(aux)){

                filhos.add(aux);
                if(verifica(aux))
                    return aux;
            }

            aux = aux.copy(no);
            aux.stackD.add(aux.stackM.pop());
            if(addNovo(aux)){

                filhos.add(aux);
                if(verifica(aux))
                    return aux;
            }
        }
        if(no.stackD.size() != 0){

            aux = aux.copy(no);
            aux.stackE.add(aux.stackD.pop());
            if(addNovo(aux)){

                filhos.add(aux);
                if(verifica(aux))
                    return aux;
            }

            aux = aux.copy(no);
            aux.stackM.add(aux.stackD.pop());
            if(addNovo(aux)){

                filhos.add(aux);
                if(verifica(aux))
                    return aux;
            }
        }


        fila.addAll(filhos);

        return null;

    }

    public void concluir(No no){

        if(no.pai != null){

            conclusao.add(no.pai);
            concluir(no.pai);
        }
    }

    public boolean verifica(No no){

        return(no.equals(fimD) || no.equals(fimE) || no.equals(fimM));
    }

    public No prox(){

        return fila.poll();
    }

    public boolean addNovo(No no){

        for(No n : todos){

            if(n.equals(no)){

                return false;
            }
        }

        todos.add(no);
        return true;

    }

}
