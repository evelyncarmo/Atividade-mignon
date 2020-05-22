/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade;

import java.util.Scanner;

/**
 *
 * @author vyvis
 */
public class Exercicio1 {

    public static void main(String[] args) {
        

        int ql = 5; // quantidade de linha
        int qc = 5; // quantidade de coluna

        double matriz2[][] = new double[ql][qc];

        double[][] matriz = {{0.1, 0.2, 0.1, 0.2, 0.1},
        {0.1, 0.2, 0.3, 0.1, 0.1},
        {0.2, 0.3, 0.1, 0.1, 0.3},
        {0.4, 0.1, 0.1, 0.1, 0.2},
        {0.4, 0.2, 0.2, 0.3, 0.1}};
       

        int cgl = gravidadeLinha(matriz, qc, ql);
        int cgc = gravidadeColuna(matriz, qc, ql);
        System.out.println("Centro da gravidade : " + cgl + " " + cgc);
    }

    public static int gravidadeLinha(double[][] m, int c, int l) {
        double menor = 0; // recebe a soma de todas as posições para comparar depois
        int rodada = 1; // variavel para prender o laço do while
        int ignorada = l - rodada; // recebe a linha a ser "testada"

        int cgl = 0; //variavel que vai retornar a linha do centro da gravidade

        // realiza a soma de todas as posições para saber qual o maior maximo, para comparar com o calculo das porções
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                menor += m[i][j];
            }
        }

        //enquanto minha rodada for menor que o numero de linhas
        while (rodada < l) {
            double pl1 = 0; // vai receber a primeira porção 
            double pl2 = 0; // vai receber a segunda porção

            // contador para entrar nas linhas
            for (int i = 0; i < l; i++) {

                //se a linha percorrida for a linha que está sendo "testada"
                if (i == ignorada) {

                    // contador pra percorrer da quantidade de linhas até a linha ignorada
                    for (int ii = l - 1; ii > ignorada; ii--) {
                        for (int j = 0; j < c; j++) {
                            pl2 += m[ii][j];// recebe a soma do numero armazenado na linha e todas as colunas    
                        }
                    }

                    /*Se a porção 2 for maior que a porção 1 ele faz a troca para que o 
                        valor não seja negativo*/
                    if (pl2 > pl1) {
                        double aux = pl2;
                        pl2 = pl1;
                        pl1 = aux;
                    }

                    // Faz o calculo 
                    double aux2 = pl1 - pl2;

                    // se o resultado da subtração das porções for menor, do que a ultima
                    if (aux2 < menor) {
                        menor = aux2;//copia o resultado nela

                        cgl = ignorada;// e significa que a linha testada é o centro da gravidade
                    }

                    pl1 = 0; //tira o resultado dos ultimos calculos
                    pl2 = 0;//tira o resultado dos ultimos calculos
                    rodada++; // adciona a rodada
                    ignorada--;
                    /*Obs Léo: esse i-0 é necessário? Pois quando executa esse comando, teoricamente ele sai do laço*/
                    i = -1;// e zera o contador das linhas

                } else {
                    //se a linha não for a linha que será testada, faz a variavel que recebe a soma da primeira porção, receber a soma dela.
                    for (int j = 0; j < c; j++) {
                        pl1 += m[i][j];
                    }
                }
            }
        }

        // retorna a linha que é o centro da gravidade
        return cgl + 1;
    }

    public static int gravidadeColuna(double[][] m, int c, int l) {
        double menor = 0; // recebe a soma de todas as posições para comparar depois
        int rodada = 1; // variavel para prender o laço do while
        int ignorada = c - rodada; // recebe a linha a ser "testada"

        int cgc = 0; //variavel que vai retornar a linha do centro da gravidade

        // realiza a soma de todas as posições para saber qual o maior maximo, para comparar com o calculo das porções
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                menor += m[i][j];
            }
        }

        //enquanto minha rodada for menor que o numero de colunas
        while (rodada < c) {
            double pl1 = 0; // vai receber a primeira porção 
            double pl2 = 0; // vai receber a segunda porção

            // contador para entrar nas coluna
            for (int i = 0; i < c; i++) {
                //se a coluna percorrida for a coluna que está sendo "testada"
                if (i == ignorada) {
                    // contador pra percorrer da quantidade de linhas até a linha ignorada
                    for (int j = 0; j < l; j++) {
                        for (int ii = c - 1; ii > ignorada; ii--) {
                            pl2 += m[j][ii];// recebe a soma do numero armazenado na linha e todas as colunas    
                        }
                    }

                    /*Se a porção 2 for maior que a porção 1 ele faz a troca para que o 
                        valor não seja negativo*/
                    if (pl2 > pl1) {
                        double aux = pl2;
                        pl2 = pl1;
                        pl1 = aux;
                    }

                    // Faz o calculo 
                    double aux2 = pl1 - pl2;

                    // se o resultado da subtração das porções for menor, do que a ultima
                    if (aux2 < menor) {
                        menor = aux2;//copia o resultado nela

                        cgc = ignorada;// e significa que a linha testada é o centro da gravidade
                    }

                    pl1 = 0; //tira o resultado dos ultimos calculos
                    pl2 = 0;//tira o resultado dos ultimos calculos
                    rodada++; // adciona a rodada
                    ignorada--;
                    /*Obs Léo: esse i-0 é necessário? Pois quando executa esse comando, teoricamente ele sai do laço*/
                    i = -1;// e zera o contador das linhas

                } else { // OK, CORRETO
                    //se a linha não for a coluna que será testada, faz a variavel que recebe a soma da primeira porção, receber a soma dela.
                    for (int j = 0; j < l; j++) {
                        pl1 += m[j][i];
                    }
                }
            }
        }

        // retorna a linha que é o centro da gravidade
        return cgc + 1;
    }

    public static void imprimeMatriz(double[][] m, int l, int c) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println("v[" + i + "]:" + m[i]);
            }
        }
    }
}
