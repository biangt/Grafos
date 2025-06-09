public class Vertice {
    String nombre; // Nombre del vértice (ej: "Alicante")
    int numVertice; // Índice o número asociado al vértice

    // Constructor que asigna el nombre y deja el índice sin asignar
    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
    }

    // Devuelve el nombre del vértice
    public String nomVertice() {
        return nombre;
    }

    // Compara este vértice con otro por su nombre
    public boolean equals(Vertice n) {
        return nombre.equals(n.nombre);
    }

    // Asigna el número de vértice (posición en la matriz)
    public void asigVert(int n) {
        numVertice = n;
    }

    // Devuelve una representación legible del vértice
    public String toString() {
        return nombre + " (" + numVertice + ")";
    }
}