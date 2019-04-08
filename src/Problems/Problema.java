package Problems;

import java.util.ArrayList;

public interface Problema {

    ArrayList<Problema> gerarSucessores();//DEVE DERIVAR O NO ATUAL (THIS) E RETORNAR UMA SET COM AS POSSIBILIDADES

    boolean equals(Problema problema);//DEVE COMPARAR O NO ATUAL (THIS) COM O NO QUE ESTÁ VINDO, TRUE PARA IGUAL FALSE PARA DIF

    Problema getFinal();//DEVE RETORNAR O NÓ OBJETIVO/FINAL

    Problema criaFilho();//DEVE COPIAR AS INFOS DO NO ATUAL PARA O NO QUE ESTÁ VINDO, SETANDO O ATUAL COMO PAI

    void geraInicial();//DEVE GERAR O ESTADO INICIAL

    void printa();//DEVE PRINTAR O ESTADO

    Problema getPai();//DEVE RETORNAR O PAI DO NÓ ATUAL (THIS)

    Object[] base();//DEVE RETORNAR A BASE HASHAVEL DO PROBLEMA

    Object[] alvo();//DEVE RETORNAR O ALVO PARA SER HASHADO DO PROBLEMA

    int totalPossibilidades();//DEVE RETORNAR O TOTAL DE COMBINACOES DOS ESTADOS

    int pesoHeuristica();//DEVE RETORNAR O PESO DO NO NA HEURISTICA

}
