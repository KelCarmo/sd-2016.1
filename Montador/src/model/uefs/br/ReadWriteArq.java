/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.uefs.br;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Kelvin
 */
public class ReadWriteArq {
    
    private String arquivo;
    private static ArrayList<String> linhas_arq = new ArrayList<String>();
    
	public static ArrayList<String> ler(String caminho){
		try{
			String nome = caminho;
			
                    try (BufferedReader br = new BufferedReader(new FileReader(nome))) {
                        while(br.ready()){
                            String linha = br.readLine();
                            //Desconsidera os comentários, junto com as linhas que só tem comentários
                            if(linha.contains("#")) linha = linha.substring(0, linha.indexOf("#"));               
                            
                            if(linha.indexOf("#") != 0 && !linha.isEmpty() && !linha.matches("\\s*")) {
                                
                                if((int)linha.charAt(0) == 32 || (int)linha.charAt(0) == 9) {
                                int i,j = 0;
                                
                                for(i = 0;i < linha.length(); i++){
                                    
                                    if((int)linha.charAt(i)!= 32 && (int)linha.charAt(i)!= 9){
                                        j = i;
                                        i = linha.length();
                                    }
                                }
                                
                                linha = linha.substring(j, linha.length());
                                
                            }
                                
                                linhas_arq.add(linha);
                            }
                            
                        //System.out.println(linha);
                        }
                    }
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
                return linhas_arq;
        }
        
        /*public static void escreve(ArrayList<Token> novo, String nome_arquivo){
           
            try{
			String nome = nome_arquivo;
			
                    try (BufferedWriter br = new BufferedWriter(new FileWriter(nome_arquivo))) {
                            for (Token novo1 : novo) {
                                br.write(novo1.toString());
                                br.newLine();  
                               
                            }
                        
                    }
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
        }*/
}
        
