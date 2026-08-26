package Digitalers.clase23.miColeccion;

import Digitalers.clase21.test1.Auto;

public class Nodo<T> {
    private T valor;
    private Nodo<T> next;

    public Nodo (T obj){
        this.valor = obj;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
}
