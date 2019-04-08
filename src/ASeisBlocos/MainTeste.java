package ASeisBlocos;

public class MainTeste {

    public static void main(String[] args) {

        No no = new No(null);
        no.stackM.add(1);

        No a = new No(null);

        a = a.copy(no);
        a.stackM.add(2);
        System.out.println(no.stackM.size());
    }
}
