package Digitalers.clase23.miColeccion;

import Digitalers.clase8.integrador.excepciones.InsufficientFundsException;

public class Lista<T> {

    private int cantidad;
    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Lista(T valor){
        agregar(valor);
    }

    public Lista(){
        this.cantidad = 0;
    }

    public void agregarDespuesDe(T elemento, int indice) throws InsufficientFundsException {
        if (indice >=cantidad){
            throw new IndexOutOfBoundsException("Indice fuera de los limites.");
        }

        Nodo<T> nuevoElemento = new Nodo<>(elemento);
        Nodo<T> nodo = primero;

        for (int i = 0; i < cantidad; i++){
            if (i == indice) {
                nuevoElemento.setNext(nodo.getNext());
                nodo.setNext(nuevoElemento);
            }
            nodo = nodo.getNext();
        }

    }

    public void agregar(T elemento){
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (cantidad == 0){
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setNext(nuevoNodo);
            ultimo = nuevoNodo;
        }
        cantidad++;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }
}
