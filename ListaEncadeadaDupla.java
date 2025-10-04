public class ListaEncadeadaDupla {
    private NoDuplo inicio;
    private NoDuplo fim;

    public ListaEncadeadaDupla() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirNoInicio(int valor) {
        NoDuplo novo = new NoDuplo(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirNoFinal(int valor) {
        NoDuplo novo = new NoDuplo(valor);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void inserirNaPosicao(int pos, int valor) {
        if (pos < 0 || pos > tamanho()) {
            System.out.println("Posição inválida.");
            return;
        }
        if (pos == 0) {
            inserirNoInicio(valor);
            return;
        }
        if (pos == tamanho()) {
            inserirNoFinal(valor);
            return;
        }
        NoDuplo novo = new NoDuplo(valor);
        NoDuplo atual = inicio;
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        novo.anterior = atual.anterior;
        novo.proximo = atual;
        atual.anterior.proximo = novo;
        atual.anterior = novo;
    }

    public void removerNoInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
    }

    public void removerNoFinal() {
        if (fim == null) {
            System.out.println("Lista vazia.");
            return;
        }
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
    }

    public void removerNaPosicao(int pos) {
        if (pos < 0 || pos >= tamanho()) {
            System.out.println("Posição inválida.");
            return;
        }
        if (pos == 0) {
            removerNoInicio();
            return;
        }
        if (pos == tamanho() - 1) {
            removerNoFinal();
            return;
        }
        NoDuplo atual = inicio;
        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }
        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;
    }

    public int tamanho() {
        int count = 0;
        NoDuplo atual = inicio;
        while (atual != null) {
            count++;
            atual = atual.proximo;
        }
        return count;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }
        NoDuplo atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}
