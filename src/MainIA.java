import Problems.JogoDosOitoNode;
import Problems.Problema;
import Problems.Thanos.ThanosNode;

public class MainIA {

    public static void main(String[] args) {

        JogoDosOitoNode jogoDosOitoNode = new JogoDosOitoNode(null);
        jogoDosOitoNode.pesoMovimento = 0;

        ThanosNode thanosNode = new ThanosNode(null);

        Problema problema0 = jogoDosOitoNode;
        Problema problema1 = thanosNode;

        Skynet skynet = new Skynet(problema1);


    }
}
