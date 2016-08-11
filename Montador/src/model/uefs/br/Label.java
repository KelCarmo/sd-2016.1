/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.uefs.br;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Kelvin
 */
public class Label {
    
    private String nome;
    private String endereco;
    
    
    public Label(String nome, String endereco){
        this.endereco = endereco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString(){
        //Integer.parseInt(endereco, 2); Transforma binário para decimal       
        return nome + "|" + Integer.parseInt(endereco,2);
    }
    
    
    
    
}
