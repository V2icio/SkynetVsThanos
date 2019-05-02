package Problems;

import java.util.ArrayList;

public interface Problema {

    ArrayList<Problema> gerarSucessores();//DEVE DERIVAR O NO ATUAL (THIS) E RETORNAR UMA SET COM AS POSSIBILIDADES

    boolean equals(Problema problema);//DEVE COMPARAR O NO ATUAL (THIS) COM O NO QUE ESTA VINDO, TRUE PARA IGUAL FALSE PARA DIF

    Problema getFinal();//DEVE RETORNAR O NO OBJETIVO/FINAL

    Problema criaFilho();//DEVE COPIAR AS INFOS DO NO ATUAL PARA O NO QUE VAI RECEBER O RETORNO, SETANDO O ATUAL COMO PAI

    void geraInicial();//DEVE GERAR O ESTADO INICIAL

    void printa();//DEVE PRINTAR O ESTADO

    Problema getPai();//DEVE RETORNAR O PAI DO No ATUAL (THIS)

    Object[] base();//DEVE RETORNAR A BASE HASHAVEL DO PROBLEMA

    Object[] alvo();//DEVE RETORNAR O ALVO PARA SER HASHADO DO PROBLEMA

    int totalPossibilidades();//DEVE RETORNAR O TOTAL DE COMBINACOES DOS ESTADOS

    int pesoHeuristica();//DEVE CALCULAR O PESO DO NO NA HEURISTICA

    int tipo();//0 A* NAO COMPARA ESTADOS, 1 PARA BUSCA CEGA NAO COMPARA ESTADOS, 2 A* COMPARA COM HASH

    int getPesoHeuristica();//DEVE RETORNAR O PESO DA HEURISTICA DO NO

}
