package com.example;

public class No<T> {
        T elemento;
        No<T> anterior;
        No<T> proximo;
     
        public No(T elemento) {
            this.elemento = elemento;
            this.anterior = null;
            this.proximo = null;
        }
}
