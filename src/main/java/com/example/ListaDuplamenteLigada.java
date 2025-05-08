package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListaDuplamenteLigada<T> {
    private No<T> inicio;
    private No<T> fim;
 
    public ListaDuplamenteLigada() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionar(T dado) {
        No<T> novoNo = new No<>(dado);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void adicionarPrimeiro(T dado) {
        No<T> novoNo = new No<>(dado);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
      
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
     }
    
     public void remover(T dado) {
        if (inicio == null) return;
     
        No<T> atual = inicio;
        while (atual != null) {
            if (atual.elemento.equals(dado)) {
                if (atual == inicio) {
                    inicio = atual.proximo;
                    if (inicio != null) inicio.anterior = null;
                } 
                    else if (atual == fim) {
                    fim = atual.anterior;
                    if (fim != null) fim.proximo = null;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                return;
            }
            atual = atual.proximo;
        }
     }

     public No<T> removerInicio() {
        if(inicio == null) return null;
        
        No<T> removido = inicio;

        inicio = inicio.proximo;
        if(inicio != null) inicio.anterior = null;

        return removido;
     }

     public No<T> removerFim() {

        No<T> removido = fim;

        fim = fim.anterior;
        if(fim != null) fim.proximo = null;

        return removido;
     }

     public boolean contem(T dado) {
        No<T> atual = inicio;
        while (atual != null) {
            if (atual.elemento.equals(dado)) return true;
            atual = atual.proximo;
        }
        return false;
     }

     public void imprimirLista() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.elemento + "\n");
            atual = atual.proximo;
        }
     }

     public void reverter() {
        No<T> atual = fim;
        while(atual != null) {
            System.out.println(atual.elemento + "\n");
            atual = atual.anterior;
        }
    }
     
    public List<No<T>> toList() {
        List<No<T>> lista = new ArrayList<>();
        No<T> atual = inicio;
        while (atual != null) {
            lista.add(atual);
            atual = atual.proximo;
        }

        return lista;
    }
 }
