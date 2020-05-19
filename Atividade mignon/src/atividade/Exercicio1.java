/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade;

/**
 *
 * @author vyvis
 */
public class Exercicio1 {
    public static void main(String[] args) {
                
                //faz a matriz soma na posiçã ij receber  matriz 1 na posição ij + matriz 2 na posição ij e depois imprimi 
                /*a posição soma[i][j] que contem a soma das duas posições me cada matriz
                soma[i][j] = m1[i][j]+m2[i][j];
                System.out.print(soma[i][j]+" ");
            }
            System.out.println();
        }*/
        
        
        int ql = 3;
        int qc = 3;
        
       double matriz2 [][] = new double [ql][qc];
        
       double [][] matriz = {{0.1,0.2,0.1,0.2,0.1},
                             {0.1,0.2,0.3,0.1,0.1},
                             {0.2,0.3,0.1,0.1,0.3},
                             {0.4,0.1,0.1,0.1,0.2},
                             {0.4,0.2,0.2,0.3,0.1}};

//       double [][] matriz = {{0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1},
//                             {0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2},
//                             {0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3},
//                             {0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4},
//                             {0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5}};

       
       
       
        int cgl = gravidadeLinha(matriz, qc, ql);
        
        System.out.println(cgl);
       
    }
    
    public static int gravidadeLinha( double [][] m, int c, int l){
        double menor=0; // recebe a soma de todas as posições para comparar depois
        int rodada=1; // variavel para prender o laço do while
        int cgl=0; //variavel que vai retornar a linha do centro da gravidade
        double pl1=0; // porção linha 1
        double pl2=0; // porção linha 2
        
        // realiza a soma de todas as posições para saber qual o maior maximo, para comparar com o calculo das porções
        for(int i=0; i < l; i++){
            for(int j =0; j < c; j++){
                menor += m[i][j];
            }
        }
        
        //enquanto minha rodada nao for igual ao numero de linhas
        while(rodada < l){
            int ignorada; // recebe a linha a ser "testada"
            int aux2 = l-1; // recebe a qauntidade de linhas - 1
            
            
            // contador para entrar nas linhas
            for(int i =0; i < l; i++){
                
                ignorada = l - rodada; // recebe a quantidade de linhas menos o valor da rodada
                
                    //se a linha percorrida for a linha que está sendo "testada"
                    if(i == ignorada){
                        
                        
                        // contador pra percorrer da quantidade de linhas até a linha ignorada
                        for(int ii = aux2; ii > ignorada; ii--){
                            // percorre as colunas
                            for(int jj = 0; jj < c; jj++){
                            // recebe a soma do numero armazenado na linha e todas as colunas    
                            pl2 += m[ii][jj];
                            }
                        }
                        
                        /*Se a porção 2 for maior que a porção 1 ele faz a troca para que o 
                        valor não seja negativo*/
                        if (pl2 > pl1) {
                            double aux3 = pl2;
                            pl2 = pl1;
                            pl1 = aux3;
                        }
                        
                        // Faz a primeira porçao menos a segunda porçao
                       double aux = pl1 - pl2;
                       
                       // se o resultado da subtração das porções for menor, do que a ultima
                       if(aux < menor){
                           //copia o resultado nela
                           menor = aux;
                           // e significa que a linha testada é o centro da gravidade
                           cgl=ignorada;
                       }
                       pl1=0; //tira o resultado dos ultimos calculos
                       pl2=0;//tira o resultado dos ultimos calculos
                       rodada++; // adciona a rodada
                       /*Obs Léo: esse i-0 é necessário? Pois quando executa esse comando, teoricamente ele sai do laço*/
                       i=0;// e zera o contador das linhas
                        
                    }else{
                        //se a linha não for a linha que será testada, faz a variavel que recebe a soma da primeira porção, receber a soma dela.
                        for(int j = 0; j < c; j++){
                            pl1+=m[i][j];
                        }
                    }
            }  
        }
        
        // retorna a linha que é o centro da gravidade
        return cgl;
    }
    
}
