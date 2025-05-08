package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // GerenciarPedidos gerp = new GerenciarPedidos();
        // gerp.adicionarPedido("#1 Coca-cola, cachorro quente");
        // gerp.adicionarPedido("#2 Água");
        // gerp.adicionarPedido("#3 Hamburger");

        // gerp.imprimirPedidos();
        // gerp.cancelarPedido();
        // gerp.imprimirPedidos();
        // gerp.imprimirPedidosCancelados();
        
        // gerp.cancelarPedido();
        // gerp.imprimirPedidos();
        // gerp.imprimirPedidosCancelados();

        // gerp.atenderPedido();
        // gerp.imprimirPedidos();

        // gerp.restaurarPedido();
        // gerp.imprimirPedidosCancelados();
        // gerp.imprimirPedidos();

        // SISTEMA BIBLIOTECA

        Biblioteca bib = new Biblioteca();

        Map<String,String> livro1 = new HashMap<>();
        livro1.put("id", "1");
        livro1.put("titulo","O Senhor dos Aneis");
        livro1.put("autor","JRR Tolkien");
        livro1.put("editora","Planeta");

        Map<String,String> livro2 = new HashMap<>();
        livro2.put("id", "2");
        livro2.put("titulo", "O Morro dos Ventos Uivantes");
        livro2.put("autor", "Emily Bronte");
        livro2.put("editora", "Planeta");

        Map<String,String> livro3 = new HashMap<>();
        livro3.put("id", "3");
        livro3.put("titulo", "Memorias Postumas");
        livro3.put("autor", "Machado de Assis");

        bib.adicionarLivroFim(livro1);
        bib.adicionarLivroInicio(livro2);
        bib.exibirColecao();

        // bib.removerLivroFim();
        // bib.exibirColecao();

        // bib.removerLivroInicio();
        // bib.exibirColecao();

        bib.adicionarLivroInicio(livro3);
        bib.buscarPorId("1");
        bib.buscarPorId("10");

        bib.exibirColecao();
        bib.exibirReverso();
    }
}

class GerenciarPedidos {

    Pilha pedidosCancelados = new Pilha(20);
    Fila pedidos = new Fila(50);

    void adicionarPedido(String pedido) {
        this.pedidos.enfileirar(pedido);
    }

    void atenderPedido() {
        System.out.println("Atendendo pedido " + this.pedidos.espiar());
        this.pedidos.desenfileirar();

    }

    void cancelarPedido() {
        System.out.println("Cancelando pedido " + this.pedidos.espiar());
        this.pedidosCancelados.empilhar(this.pedidos.espiar());
        this.pedidos.desenfileirar();
    }

    void restaurarPedido() {
        System.out.println(this.pedidosCancelados.espiar() + " RESTAURADO");
        String pedidoRestaurado = this.pedidosCancelados.espiar();
        this.pedidosCancelados.desempilhar();
        this.pedidos.enfileirar(pedidoRestaurado);
    }

    void imprimirPedidos() {
        System.out.println("PEDIDOS PENDENTES:");
        this.pedidos.exibir();
    }

    void imprimirPedidosCancelados() {
        System.out.println("PEDIDOS CANCELADOS: ");
        this.pedidosCancelados.exibir();
    }
}

class Biblioteca {
    ListaDuplamenteLigada<Map<String,String>> livros = new ListaDuplamenteLigada<>();

    void adicionarLivroInicio(Map<String,String> livro) {
        this.livros.adicionarPrimeiro(livro);
    }

    void adicionarLivroFim(Map<String,String> livro) {
        this.livros.adicionar(livro);
    }

    void removerLivroFim() {
        No<Map<String,String>> livroRemovido = this.livros.removerFim();
        System.out.println("Livro removido: " + livroRemovido.elemento.values().toString());
    }

    void removerLivroInicio() {
        No<Map<String,String>> livroRemovido = this.livros.removerInicio();
        System.out.println("Livro removido: " + livroRemovido.elemento.values().toString());
    }

    void exibirColecao() {
        System.out.println("LIVROS NA COLEÇÃO: ");
        this.livros.imprimirLista();
    }

    void exibirReverso() {
        System.out.println("\nLIVROS NA ORDEM REVERSA: ");
        this.livros.reverter();
    }

    void buscarPorId(String id) {
        List<No<Map<String,String>>> livrosLista = this.livros.toList();
        Map<String,String> livroEncontrado = null;

        for (No<Map<String,String>> livro : livrosLista) {
            if(livro.elemento.get("id") == id) {
                livroEncontrado = livro.elemento;
            }
        }

        try {
            System.out.println(livroEncontrado.values().toString());
        } catch(Exception e) {
            System.out.println("\nLivro nao encontrado!\n");
        }

    }

}