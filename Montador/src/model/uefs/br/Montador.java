/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.uefs.br;

import java.util.ArrayList;

/**
 *
 * @author Kelvin
 */
public class Montador {
    
    static final String $zero = "00000";
    static final String $at = "00001";
    static final String $v0 = "00010";
    static final String $v1 = "00011";
    static final String $a1 = "00100";
    static final String $a2 = "00101";
    static final String $a3 = "00111";
    static final String $t0 = "01000";
    static final String $t1 = "01001";
    static final String $t2 = "01010";
    static final String $t3 = "01011";
    static final String $t4 = "01100";
    static final String $t5 = "01101";
    static final String $t6 = "01110";
    static final String $t7 = "01111";
    static final String $s0 = "10000";
    static final String $s1 = "10001";
    static final String $s2 = "10010";
    static final String $s3 = "10011";
    static final String $s4 = "10100";
    static final String $s5 = "10101";
    static final String $s6 = "10110";
    static final String $s7 = "10111";
    static final String $t8 = "11000";
    static final String $t9 = "11001";
    static final String $k0 = "11010";
    static final String $k1 = "11011";
    static final String $gp = "11100";
    static final String $sp = "11101";
    static final String $fp = "11110";
    static final String $ra = "11111";
    
   private ArrayList<String> memoria = new ArrayList<String>(); 
   private ArrayList<String> linhas_arq = new ArrayList<String>();
   private ArrayList<String[]> linhas_text = new ArrayList<String[]>();
    private ArrayList<String[]> linhas = new ArrayList<String[]>();
   private ArrayList<Label> labels = new ArrayList<Label>();
   
   
    public ArrayList<String> getMemoria() {
        return memoria;
    }

    public void setMemoria(ArrayList<String> memoria) {
        this.memoria = memoria;
    }

    public ArrayList<String[]> getLinhas_text() {
        return linhas_text;
    }

    public void setLinhas_text(ArrayList<String[]> linhas_text) {
        this.linhas_text = linhas_text;
    }

    public ArrayList<String[]> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<String[]> linhas) {
        this.linhas = linhas;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
    }
  

    
    
    
    
    public void separa(){
        
    }
    
    /**
     * Desconsidera os comentários
     * @param nomeArquivo 
     */
    public void lerArquivoPorLinha(String nomeArquivo){
        
        linhas_arq = ReadWriteArq.ler(nomeArquivo);
        lerText();
        captureLabels();
        
        
        
        /*if(array[0].matches("\\w*\\:{1}")){
        Label novo = new Label(array[0],Integer.toBinaryString(i));
        labels.add(novo);
        }*/
        
    }
    /**
     * 
     */
    private void lerText(){
        boolean contar = false;
        for(int i = 0; i < linhas_arq.size(); i++){
            String[] array = linhas_arq.get(i).split("[,()]\\s*|\\s+");//Retira os espaços e separa por vírgula ou espaço
            if(contar == false){
                linhas.add(array);
            }
            if(contar == true) {
                linhas_text.add(array);
            }
            if(array[0].equals(".text")) contar = true; // Começo a considerar as linhas
        }
    }
    
    private void captureLabels(){
        for(int i = 0; i < linhas_text.size(); i++){
            if(linhas_text.get(i)[0].matches("\\w*\\:{1}")) {//se na linha tiver um label
                if(linhas_text.get(i).length == 1) {// só 1 label e nada depois dele
                    Label novo = new Label(linhas_text.get(i)[0].substring(0,linhas_text.get(i)[0].length() - 1),Integer.toBinaryString(i));
                    labels.add(novo);
                    linhas_text.remove(i);                    
                 //Label novo = new Label(linhas_text.get(i)[0].substring(0,linhas_text.get(i)[0].length() - 1),Integer.toBinaryString(i));   
                }                
            }
        }
        
        /**
         * Retira os labels das linhas onde tem mnemonicos
         */
        for(int i = 0; i < linhas_text.size(); i++){
           String[] array = null;
            int t = 0;
            if(linhas_text.get(i)[0].matches("\\w*\\:{1}")){
                Label novo = new Label(linhas_text.get(i)[0].substring(0,linhas_text.get(i)[0].length() - 1),Integer.toBinaryString(i));
                labels.add(novo);
                array = new String[linhas_text.get(i).length - 1];
                for(int j = 0; j < linhas_text.get(i).length; j++){
                    if(j > 0){                         
                        array[t] = linhas_text.get(i)[j];
                        t++;
                    } 
                }
                linhas_text.set(i, array);
            }
        }
        
    }
    
    public ArrayList<String> getLinhas_arq() {
        return linhas_arq;
    }

    public void setLinhas_arq(ArrayList<String> linhas_arq) {
        this.linhas_arq = linhas_arq;
    }
}
