package Problems;

import java.util.ArrayList;
import java.util.Random;

public class JogoDosOitoNode implements Problema {

    public int[][] matriz = new int[3][3];
    public int[][] fim = new int[3][3];
    public int pesoMovimento;
    public int pesoNo;

    JogoDosOitoNode pai;

    public JogoDosOitoNode(JogoDosOitoNode pai){

        this.pai = pai;

        fim[0][0] = 1;
        fim[0][1] = 2;
        fim[0][2] = 3;
        fim[1][0] = 8;
        fim[1][1] = 0;
        fim[1][2] = 4;
        fim[2][0] = 7;
        fim[2][1] = 6;
        fim[2][2] = 5;

        /*fim[0][0] = 1;
        fim[0][1] = 2;
        fim[0][2] = 3;
        fim[1][0] = 4;
        fim[1][1] = 5;
        fim[1][2] = 6;
        fim[2][0] = 7;
        fim[2][1] = 8;
        fim[2][2] = 0;*/
    }

    public int tipo(){

        return 2;
    }

    public int getPesoHeuristica(){

        return pesoNo;
    }

    public ArrayList<Problema> gerarSucessores() {

        ArrayList<Problema> filhos = new ArrayList<>();
        JogoDosOitoNode filho;

        int ax, ay;
        ax = 0;
        ay = 0;

        boolean up, down, right, left;
        up = true;
        down = true;
        right = true;
        left = true;

        for(int x = 0; x < 3; x++){

            for(int y = 0; y < 3; y++){

                if(matriz[x][y] == 0){

                    ax = x;
                    ay = y;
                    break;
                }

            }
        }

        if(ax == 0)
            up = false;
        if(ax == 2)
            down = false;
        if(ay == 0)
            left = false;
        if(ay == 2)
            right = false;

        if(up){

            filho = (JogoDosOitoNode)criaFilho();

            filho.matriz[ax][ay] = filho.matriz[ax-1][ay];
            filho.matriz[ax-1][ay] = 0;
            filhos.add(filho);
        }
        if(down){

            filho = (JogoDosOitoNode)criaFilho();

            filho.matriz[ax][ay] = filho.matriz[ax+1][ay];
            filho.matriz[ax+1][ay] = 0;
            filhos.add(filho);
        }
        if(left){

            filho = (JogoDosOitoNode)criaFilho();

            filho.matriz[ax][ay] = filho.matriz[ax][ay-1];
            filho.matriz[ax][ay-1] = 0;
            filhos.add(filho);
        }
        if(right){

            filho = (JogoDosOitoNode)criaFilho();

            filho.matriz[ax][ay] = filho.matriz[ax][ay+1];
            filho.matriz[ax][ay+1] = 0;
            filhos.add(filho);
        }


        return filhos;
    }

    @Override
    public boolean equals(Problema problema) {

        JogoDosOitoNode jogoDosOitoNode = (JogoDosOitoNode) problema;

        for(int x = 0; x < 3; x++){

            for(int y = 0; y < 3; y++){

                if(jogoDosOitoNode.matriz[x][y] != matriz[x][y])
                    return false;
            }
        }

        return true;
    }

    public Problema getFinal() {

        JogoDosOitoNode jogoDosOitoNode = new JogoDosOitoNode(null);
        jogoDosOitoNode.matriz = fim;

        return jogoDosOitoNode;

    }

    public Problema criaFilho() {

        JogoDosOitoNode jogoDosOitoNode = new JogoDosOitoNode(this);
        jogoDosOitoNode.pesoMovimento = this.pesoMovimento++;

        for(int x = 0; x < 3; x++){

            for(int y = 0; y < 3; y++){

                jogoDosOitoNode.matriz[x][y] = matriz[x][y];
            }
        }

        return jogoDosOitoNode;
    }

    public void geraInicial() {

        Random random = new Random();
        int[] aux = new int[9];
        int c = 0;

        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(0);
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);

        for(int x = 9; x > 0; x--, c++){

            int y = random.nextInt(x);
            aux[c] = numeros.get(y);
            numeros.remove(y);
        }
        c = 0;

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++, c++){

                matriz[x][y] = aux[c];
            }
        }
    }

    public void printa(){

        for(int x = 0; x < 3; x++){

            System.out.println();
            for(int y = 0; y < 3; y++){

                System.out.print(matriz[x][y] + "  ");
            }
        }
        System.out.println();
    }

    public Problema getPai(){

        return pai;
    }

    public Object[] base(){

        Integer[] base = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        return base;
    }

    public Object[] alvo(){

        Integer[] alvo = new Integer[9];

        int c = 0;
        for(int x = 0; x < 3; x++){

            for(int y = 0; y < 3; y++, c++){

                alvo[c] = matriz[x][y];
            }
        }

        return alvo;
    }

    public int totalPossibilidades(){

        return 362880;
    }

    public int pesoHeuristica(){

        return pesoMovimento + manhattan();
    }

    public int manhattan(){

        int soma = 0;

        for(int xa = 0; xa < 3; xa++){
            for(int ya = 0; ya < 3; ya++){

                for(int x = 0; x < 3; x++){
                    for(int y = 0; y < 3; y++){

                        if(matriz[xa][ya] == fim[x][y]){

                            soma = soma + Math.abs(xa-x) + Math.abs(ya-y);
                        }
                    }
                }
            }
        }
        return soma;
    }
}
