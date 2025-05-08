
package com.example;

public class Pilha {
    private String [] elementos;

    private int tamanho;

    public Pilha(int capacidade){

            this.elementos = new String[capacidade];
            this.tamanho = 0;
    }

    public int tamanho(){
        return tamanho;
    }
    
    public boolean estaVazia(){
        return tamanho == 0;
    }
    
    public boolean estaCheia(){
        return tamanho == this.elementos.length;
    }

    public boolean empilhar(String e){

        if(!estaCheia()){
        
            this.elementos[tamanho] = e;
            
            tamanho ++;
            return true;
        }
        return false;
    }

    public String desempilhar(){

        if(!estaVazia()){
        
            tamanho--;
            return this.elementos[tamanho];
        }
        
        return null;
    };

    public String espiar(){

        if(!estaVazia()){
            return this.elementos[tamanho - 1];
        }
        return null;
    };

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(elementos[i]);
        }
    }
}