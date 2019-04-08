import java.util.ArrayList;
import java.util.Stack;

public class Testes {

    public static void main(String[] args) {

        Stack<Integer> a = new Stack<>();

        a.add(1);
        a.add(2);
        a.add(3);

        for(int x = a.size()-1; x >=0; x--)

            System.out.println(a.get(x));


    }
}
