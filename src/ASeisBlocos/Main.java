package ASeisBlocos;

import java.util.*;

public class Main {

    public static void main(String[] args){

        Random rand = new Random();
        Controller controller = new Controller();

        No noIni = new No(null);

        No aux;

        ArrayList<Integer> ints = new ArrayList<>();

        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);

        for(int x = 6; x > 0; x--){

            int y = rand.nextInt(x);
            noIni.stackM.add(ints.get(y));
            ints.remove(y);
        }

        controller.fila.add(noIni);

        while(true){


            aux = controller.executar(controller.prox());
            if(aux != null){

                controller.conclusao.add(aux);
                controller.concluir(aux);
                int y = controller.conclusao.size();
                No no;
                for(int x = 0; x < y; x++){

                    no = controller.conclusao.pop();
                    no.mostraPilares();
                    System.out.println();

                }
                break;
            }
        }

    }
}
