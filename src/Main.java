public class Main {
    public static void main(String[] args) {
        try {
            GrafoMatriz grafo = new GrafoMatriz();  // Crea una instancia del grafo

            // Cargar ciudades
            grafo.nuevoVertice("Alicante");   // 0 son los indicues
            grafo.nuevoVertice("Barcelona");  // 1
            grafo.nuevoVertice("Cartagena");  // 2
            grafo.nuevoVertice("Murcia");     // 3
            grafo.nuevoVertice("Reus");       // 4

            // Cargar relaciones y pesos
            grafo.nuevoArco("Alicante", "Cartagena", 5);
            grafo.nuevoArco("Alicante", "Murcia", 5);
            grafo.nuevoArco("Cartagena", "Alicante", 3);
            grafo.nuevoArco("Barcelona", "Cartagena", 3);
            grafo.nuevoArco("Barcelona", "Murcia", 6);
            grafo.nuevoArco("Barcelona", "Reus", 3);
            grafo.nuevoArco("Murcia", "Barcelona", 2);
            grafo.nuevoArco("Reus", "Barcelona", 1);

            // Mostrar la matriz de adyacencia con pesos
            grafo.imprimirMatrizConEncabezados();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());// Muestra errores si hay vértices inexistentes
        }
    }
}
