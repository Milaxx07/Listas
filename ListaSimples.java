public class ListaSimples {
    private No inicio;

    public ListaSimples() {
        this.inicio = null;
    }

    public void inserirNoInicio(int valor) {
        No novoNo = new No(valor);
        novoNo.proximo = inicio;
        inicio = novoNo;
    }

    public void inserirNoFinal(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = novoNo;
            return;
        }
        No atual = inicio;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void inserirNaPosicao(int pos, int valor) {
        if (pos < 0 || pos > tamanho()) {
            System.out.println("Posição inválida");
            return;
        }
        if (pos == 0) {
            inserirNoInicio(valor);
            return;
        }
        No novoNo = new No(valor);
        No atual = inicio;
        for (int i = 0; i < pos - 1; i++) {
            atual = atual.proximo;
        }
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }

    public void removerNoInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }
        inicio = inicio.proximo;
    }

    public void removerNoFinal() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }
        if (inicio.proximo == null) {
            inicio = null;
            return;
        }
        No atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = null;
    }

    public void removerNaPosicao(int pos) {
        if (pos < 0 || pos >= tamanho()) {
            System.out.println("Posição inválida");
            return;
        }
        if (pos == 0) {
            removerNoInicio();
            return;
        }
        No atual = inicio;
        for (int i = 0; i < pos - 1; i++) {
            atual = atual.proximo;
        }
        atual.proximo = atual.proximo.proximo;
    }

    public int tamanho() {
        int count = 0;
        No atual = inicio;
        while (atual != null) {
            count++;
            atual = atual.proximo;
        }
        return count;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia");
            return;
        }
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}
