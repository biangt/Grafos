public class GrafoMatriz {
    int numVerts;  // Cantidad actual de vértices cargados en el grafo
    static int maxVerts = 20; // Cantidad máxima de vértices permitidos
    Vertice[] verts; // Arreglo que contiene los objetos Vértice
    int[][] matAd; // Matriz de adyacencia que guarda los pesos de las conexiones

    // Constructor sin parámetros que usa el máximo por defecto
    public GrafoMatriz() {
        this(maxVerts); // Llama al otro constructor con valor por defecto
    }

    // Constructor con parámetro para definir el tamaño máximo
    public GrafoMatriz(int mx) {
        matAd = new int[mx][mx]; // Crea matriz de adyacencia
        verts = new Vertice[mx]; // Crea arreglo de vértices
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matAd[i][j] = 0; // Inicializa la matriz con 0 (sin conexión)
            }
        }
        numVerts = 0;  // Inicializa cantidad de vértices cargados en 0
    }

    // Agrega un nuevo vértice al grafo si aún no está presente
    public void nuevoVertice(String nom) {
        if (numVertice(nom) < 0) {                       // Verifica que no exista
            Vertice v = new Vertice(nom);               // Crea nuevo vértice
            v.asigVert(numVerts);                       // Le asigna su número (posición)
            verts[numVerts++] = v;                      // Lo guarda y aumenta el contador
        }
    }

    public int numVertice(String vs) {
        Vertice v = new Vertice(vs);                    // Crea vértice temporal para comparar
        for (int i = 0; i < numVerts; i++) {
            if (verts[i].equals(v)) return i;           // Si coincide, devuelve su índice
        }
        return -1;                                      // No encontrado
    }

    public void nuevoArco(String a, String b, int peso) throws Exception {
        int va = numVertice(a);
        int vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        matAd[va][vb] = peso;
    }

    public void nuevoArco(int va, int vb, int peso) throws Exception {
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        matAd[va][vb] = peso;
    }

    // Verifica si hay conexión entre dos vértices (peso distinto de 0)
    public boolean adyacente(String a, String b) throws Exception {
        int va = numVertice(a);
        int vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        return matAd[va][vb] != 0;
    }

    public boolean adyacente(int va, int vb, int peso) throws Exception {
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        return matAd[va][vb] == peso;
    }

    // Devuelve el número actual de vértices cargados
    public int numeroDeVertices() {
        return numVerts;
    }

    // Devuelve el arreglo de vértices
    public Vertice[] vertices() {
        return verts;
    }

    // Devuelve la matriz de adyacencia completa
    public int[][] matrizAdyacencia() {
        return matAd;
    }

    //para qu se imprima bonito
    public void imprimirMatrizConEncabezados() {
        System.out.println("Matriz de pesos:");
        System.out.printf("%-12s", ""); // espacio para el encabezado
        for (int i = 0; i < numVerts; i++) {
            System.out.printf("%-12s", verts[i].nomVertice());
        }
        System.out.println();

        for (int i = 0; i < numVerts; i++) {
            System.out.printf("%-12s", verts[i].nomVertice());
            for (int j = 0; j < numVerts; j++) {
                String valor = matAd[i][j] == 0 ? "-" : String.valueOf(matAd[i][j]);
                System.out.printf("%-12s", valor);
            }
            System.out.println();
        }
    }
}