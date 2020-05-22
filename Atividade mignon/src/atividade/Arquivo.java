/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade;

//pacote do proprio java que implementam o metodo de leitura e criação de arquivos
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author Evelyn Carmo
 */
public class Arquivo {

    public static String lerArquivo(String caminho) {
        // Cria uma variavel para receber o nome do arquivo
        String conteudo = "";

        try {
            // Cria um leitor de arquivos que recebe o caminho como paramentro setter
            FileReader arq = new FileReader(caminho);

            //Faz um carregador de arquivos para ler o arquivo arq do caminho
            BufferedReader lerarq = new BufferedReader(arq);

            // recebe cada linha do arquivo
            String linha = "";

            try {
                //Vai ler a primeira linha do arquivo
                linha = lerarq.readLine();

                //Enquanto as linhas nao acabarem
                while (linha != null) {
                    conteudo += linha + "\r\n";
                    linha = lerarq.readLine();
                }
                //fecha o arquivo apos finalizar
                arq.close();

            } catch (IOException ex) {
                conteudo = "Erro não foi possivel ler o arquivo!";
            }
        } catch (IOException ex) {
            conteudo = "Erro: Arquivo não encontrado";
        }

        if (conteudo.contains("Erro")) {
            return "";
        } else {
            return conteudo;
        }

    }

    public static boolean escreverArquivo(String caminho, String texto) {
        try {
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static int[] criarVetor(String caminho) {
            // Cria uma variavel para receber o conteudo arquivo
            String conteudo = "";

            try {
                // Cria um leitor de arquivos que recebe o caminho como paramentro setter
                FileReader arq = new FileReader(caminho);

                //Faz um carregador de arquivos para ler o arquivo arq do caminho
                BufferedReader lerarq = new BufferedReader(arq);

                // recebe cada linha do arquivo
                String linha = "";

                try {
                    //Vai ler a primeira linha do arquivo
                    linha = lerarq.readLine();

                    //Enquanto as linhas nao acabarem
                    while (linha != null) {
                        conteudo += linha + "\r\n";
                        linha = lerarq.readLine();
                    }
                    //fecha o arquivo apos finalizar
                    arq.close();

                } catch (IOException ex) {
                    conteudo = "Erro não foi possivel ler o arquivo!";
                }
            } catch (IOException ex) {
                conteudo = "Erro: Arquivo não encontrado";
            }
            // fim da leitura do arquivo
            
            //cria um vetor em string pra receber o conteudo (cada palavra numa posição diferente)
            String[] arquivo = (conteudo.split(","));
            int[] vetor = new int[arquivo.length]; // cria um vetor com o mesmo tamanho do outro vetor que contem a mensagem

            for (int i = 0; i < arquivo.length; i++) {
                vetor[i] = Integer.parseInt(arquivo[i].trim());    // coloca cada palavra numa posição do novo vetor porém no formato de numero
            }
            
            return vetor; // retorna o vetor em int
    }
    
    public static double[] criarMatriz(String caminho) {
            // Cria uma variavel para receber o conteudo arquivo
            String conteudo = "";

            try {
                // Cria um leitor de arquivos que recebe o caminho como paramentro setter
                FileReader arq = new FileReader(caminho);

                //Faz um carregador de arquivos para ler o arquivo arq do caminho
                BufferedReader lerarq = new BufferedReader(arq);

                // recebe cada linha do arquivo
                String linha = "";

                try {
                    //Vai ler a primeira linha do arquivo
                    linha = lerarq.readLine();

                    //Enquanto as linhas nao acabarem
                    while (linha != null) {
                        conteudo += linha + "\r\n";
                        linha = lerarq.readLine();
                    }
                    //fecha o arquivo apos finalizar
                    arq.close();

                } catch (IOException ex) {
                    conteudo = "Erro não foi possivel ler o arquivo!";
                }
            } catch (IOException ex) {
                conteudo = "Erro: Arquivo não encontrado";
            }
            // fim da leitura do arquivo
            
            //cria um vetor em string pra receber o conteudo (cada palavra numa posição diferente)
            String[] arquivo = (conteudo.split(","));
            double[] vetor = new double[arquivo.length]; // cria um vetor com o mesmo tamanho do outro vetor que contem a mensagem

            for (int i = 0; i < arquivo.length; i++) {
                vetor[i] = Integer.parseInt(arquivo[i].trim());    // coloca cada palavra numa posição do novo vetor porém no formato de numero
            }
            
            return vetor; // retorna o vetor em int
    }
}



