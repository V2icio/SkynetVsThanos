import Problems.JogoDosOitoNode;
import Problems.Problema;

public class MainIA {

    public static void main(String[] args) {

        JogoDosOitoNode jogoDosOitoNode = new JogoDosOitoNode(null);
        jogoDosOitoNode.pesoMovimento = 0;

        /*jogoDosOitoNode.matriz[0][0] = 1;
        jogoDosOitoNode.matriz[0][1] = 2;
        jogoDosOitoNode.matriz[0][2] = 3;
        jogoDosOitoNode.matriz[1][0] = 4;
        jogoDosOitoNode.matriz[1][1] = 5;
        jogoDosOitoNode.matriz[1][2] = 6;
        jogoDosOitoNode.matriz[2][0] = 8;
        jogoDosOitoNode.matriz[2][1] = 0;
        jogoDosOitoNode.matriz[2][2] = 7;*/

        /*jogoDosOitoNode.matriz[0][0] = 1;
        jogoDosOitoNode.matriz[0][1] = 2;
        jogoDosOitoNode.matriz[0][2] = 3;
        jogoDosOitoNode.matriz[1][0] = 8;
        jogoDosOitoNode.matriz[1][1] = 0;
        jogoDosOitoNode.matriz[1][2] = 5;
        jogoDosOitoNode.matriz[2][0] = 7;
        jogoDosOitoNode.matriz[2][1] = 6;
        jogoDosOitoNode.matriz[2][2] = 4;*/

        //System.out.println(jogoDosOitoNode.manhattan());


        Problema problema = jogoDosOitoNode;

        Skynet skynet = new Skynet(problema);

        while (!skynet.ver)
            skynet = new Skynet(problema);
    }
}
