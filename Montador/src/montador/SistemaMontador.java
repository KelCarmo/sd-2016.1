/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montador;

import static java.lang.Integer.toBinaryString;
import model.uefs.br.Montador;

/**
 *
 * @author Kelvin
 */
public class SistemaMontador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int valor = -10;
        String linha = "li   $t4,   2";
        //String bin = Integer.toBinaryString(valor);
        String [] array = linha.split("[,]\\s*|\\s+");
        System.out.print(array[2]);
        Montador novo = new Montador();
        novo.lerArquivoPorLinha("raiz.asm");
        
        for(int j = 0; j < novo.getLinhas_text().size(); j++){
        for(int i = 0; i < novo.getLinhas_text().get(j).length; i++){
        
        System.out.print("Linha" + j + ":" +  novo.getLinhas_text().get(j)[i]);
        System.out.print("\n");
        
        }
        }
        
        System.out.print(novo.getLabels());// Imprime os labels
        
        /*for(int j = 0; j < novo.getLinhas().size(); j++){
        for(int i = 0; i < novo.getLinhas().get(j).length; i++){
        
        System.out.print("Linha" + j + ":" +  novo.getLinhas().get(j)[i]);
        System.out.print("\n");
        
        }
        }*/
        
    }
    
}
