package ASeisBlocos;

import java.util.Stack;

public class No {

    Stack<Integer> stackD;
    Stack<Integer> stackM;
    Stack<Integer> stackE;
    No pai;

    public No(No pai){

        stackD = new Stack<>();
        stackM = new Stack<>();
        stackE = new Stack<>();
        this.pai = pai;
    }

    public Stack<Integer> getStackD() {
        return stackD;
    }

    public void setStackD(Stack<Integer> stackD) {
        this.stackD = stackD;
    }

    public Stack<Integer> getStackM() {
        return stackM;
    }

    public void setStackM(Stack<Integer> stackM) {
        this.stackM = stackM;
    }

    public Stack<Integer> getStackE() {
        return stackE;
    }

    public void setStackE(Stack<Integer> stackE) {
        this.stackE = stackE;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    @Override
    public boolean equals(Object no0){

        No no = (No) no0;

        if(no.stackE.size() == this.stackE.size()){

            for(int x = 0; x < no.stackE.size(); x++){

                if(!(no.stackE.elementAt(x).equals(this.stackE.elementAt(x))))
                    return false;

            }
        } else
            return false;

        if(no.stackM.size() == this.stackM.size()){

            for(int x = 0; x < no.stackM.size(); x++){

                if(!(no.stackM.elementAt(x).equals(this.stackM.elementAt(x))))
                    return false;

            }
        } else
            return false;

        if(no.stackD.size() == this.stackD.size()){

            for(int x = 0; x < no.stackD.size(); x++){

                if(!(no.stackD.elementAt(x).equals(this.stackD.elementAt(x))))
                    return false;

            }
        } else
            return false;

        return true;
    }

    public No copy(No no){

        No newNo = new No(no);

        newNo.stackM.addAll(no.stackM);
        newNo.stackE.addAll(no.stackE);
        newNo.stackD.addAll(no.stackD);

        return newNo;
    }

    public void mostraPilares(){

        for(int x = 5; x >= 0; x--){

            if(stackE.size() >= x + 1)
                System.out.print(stackE.get(x));

            if(stackM.size() >= x + 1)
                System.out.print("\t"+stackM.get(x));
            else
                System.out.print("\t");

            if(stackD.size() >= x + 1)
                System.out.println("\t"+stackD.get(x));
            else
                System.out.println("\t");
        }

        System.out.println("E\tM\tD");
    }

}
