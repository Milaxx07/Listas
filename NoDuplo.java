public class NoDuplo {
    int valor;
    NoDuplo anterior;
    NoDuplo proximo;

    public NoDuplo(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}
