/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscabinariacep;

import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Lucas Lima
 */
 
public class Main {
    
    public static int c=0;
 
    /**
     * Main cria o RandomAccessFile, chama a função BuscaBinaria e recebe o valor long onde o cep digitado foi encontrado, e print seus dados;
     * @param args 
     */
    public static void main(String[] args) 
    {
        try{
         /*  
        * Instanciando objeto "RandomAccessFile" 
        * 
        * Para instanciar um objeto desta classe deve-se passar 2 parametros, 
        * o primeiro uma referencia a um objeto da classe "File" que será o  
        * arquivo a ser manipulado, e o segundo é uma string que varia entre 
        * "r" e "rw", usa-se o "r" (read) para abrir o arquivo somente como 
        * leitura, não sendo possível sua alteração, ou então o "rw" (read/write) 
        * para abrir o arquivo com permissão para modificações. 
        * Neste caso, deve-se instanciar o objeto como "rw" para poder escrever 
        * o conteudo desejado nele 
        * 
        */
        RandomAccessFile f = new RandomAccessFile("CepOrdenadoMenor.dat", "r");
        Endereco e = new Endereco();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o cep que você quer procurar:");
        String cep = ler.nextLine();
        long primeiro = 0;
        long ultimo = (f.length()/300)-1;
       
        long resultado = buscaBinariaRecursiva(f, primeiro, ultimo, cep);
        f.seek(resultado*300);
        while( f.getFilePointer() < f.length() ) // para Detectar EOF
        {
            e.leEndereco(f);
            System.out.println(e.getLogradouro());
            System.out.println(e.getBairro());
            System.out.println(e.getCidade());
            System.out.println(e.getEstado());
            System.out.println(e.getSigla());
            System.out.println("Foram feitas " + c + " buscas!");
            break;
        }
        f.close();
        }catch(Exception e){
            System.out.println("Foi encontrado algum erro, verifique se digitou o cep corretamente.");
        }
    }
    
    /**
     * Função que realiza a buscabinaria recursiva, verificando através do cep e retorna o long de onde o registro foi encontrado
     * @param dados é o cep_ordenado
     * @param esq é a primeira posição
     * @param dir é a ultima posicao de registro
     * @param cep é o cep que quer procurar
     * @return
     * @throws Exception 
     */
private static long buscaBinariaRecursiva(RandomAccessFile dados, long esq, long dir, String cep) throws Exception {
                c++;
                long meio = (esq + dir)/ 2;
                Endereco teste = new Endereco();
                dados.seek((meio)*300);
                teste.leEndereco(dados);
                String cepLinhaAtual = teste.getCep() ;
                
		if (esq > dir)
			return -1;
		else if(cepLinhaAtual.equals(cep))
			return meio;
		else if ((Long.parseLong(cepLinhaAtual)) < (Long.parseLong(cep))){
			return buscaBinariaRecursiva(dados, meio+1, dir, cep);
                }
		else
			return buscaBinariaRecursiva(dados, esq, meio-1, cep);
                }
}