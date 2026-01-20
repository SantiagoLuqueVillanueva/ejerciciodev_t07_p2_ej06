public class App {
    public static void main(String[] args) throws Exception {
        int[][] num = new int[6][10];
        
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int posMaxX = 0, posMaxY = 0;
        int posMinX = 0, posMinY = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                
                int numeroCandidato;
                boolean repetido;
                
                do {
                    numeroCandidato = (int)(Math.random() * 1000);
                    repetido = false; // Asumimos que es bueno al principio

                    // 1. Revisamos las filas completas anteriores (desde la 0 hasta la i-1)
                    for (int k = 0; k < i; k++) {
                        for (int l = 0; l < 10; l++) {
                            if (num[k][l] == numeroCandidato) {
                                repetido = true; // ¡Lo encontramos repetido!
                            }
                        }
                    }

                    // 2. Revisamos la fila actual (desde la columna 0 hasta la j-1)
                    // Solo revisamos "hacia atrás" en la misma fila
                    for (int l = 0; l < j; l++) {
                        if (num[i][l] == numeroCandidato) {
                            repetido = true; // ¡Lo encontramos repetido!
                        }
                    }

                } while (repetido);

                num[i][j] = numeroCandidato;

                if (num[i][j] > mayor) {
                    mayor = num[i][j];
                    posMaxX = i + 1;
                    posMaxY = j + 1;
                }

                if (num[i][j] < menor) {
                    menor = num[i][j];
                    posMinX = i + 1;
                    posMinY = j + 1;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%5d", num[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.printf("El máximo es %d y está en la fila %d, columna %d.\n", mayor, posMaxX, posMaxY);
        System.out.printf("El mínimo es %d y está en la fila %d, columna %d.", menor, posMinX, posMinY);
    }
}