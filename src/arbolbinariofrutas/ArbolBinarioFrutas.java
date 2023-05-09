/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinariofrutas;

/**
 *
 * @author 0
 */
public class ArbolBinarioFrutas {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        // Insertar frutas en el árbol
        arbol.insertar(new Frutas("Manzana", 2));
        arbol.insertar(new Frutas("Banana", 1));
        arbol.insertar(new Frutas("Naranja", 3));
        arbol.insertar(new Frutas("Pera", 4));
        arbol.insertar(new Frutas("Kiwi", 3));

        // Imprimir el árbol en preorden
        System.out.println("Árbol en preorden:");
        arbol.preOrder();
        System.out.println();

        // Buscar una fruta por nombre
        String nombreBuscado = "Pera";
        Frutas frutaEncontrada = arbol.buscar(nombreBuscado);
        if (frutaEncontrada != null) {
            System.out.println("Fruta encontrada: " + frutaEncontrada.toString());
        } else {
            System.out.println("Fruta no encontrada: " + nombreBuscado);
        }
        System.out.println();

        // Actualizar una fruta
        String nombreActualizar = "Banana";
        Frutas nuevaBanana = new Frutas("Banana", 2);
        boolean actualizacionExitosa = arbol.actualizar(nombreActualizar, nuevaBanana);
        if (actualizacionExitosa) {
            System.out.println("Fruta actualizada: " + nuevaBanana.toString());
        } else {
            System.out.println("No se encontró la fruta para actualizar: " + nombreActualizar);
        }
        System.out.println();

        // Imprimir el árbol en preorden después de la actualización
        System.out.println("Árbol en preorden después de la actualización:");
        arbol.preOrder();
        System.out.println();

        // Eliminar una fruta
        String nombreEliminar = "Naranja";
        boolean eliminacionExitosa = arbol.eliminar(nombreEliminar);
        if (eliminacionExitosa) {
            System.out.println("Fruta eliminada: " + nombreEliminar);
        } else {
            System.out.println("No se encontró la fruta para eliminar: " + nombreEliminar);
        }
        System.out.println();

        // Imprimir el árbol en preorden después de la eliminación
        System.out.println("Árbol en preorden después de la eliminación:");
        arbol.preOrder();
    }
}

