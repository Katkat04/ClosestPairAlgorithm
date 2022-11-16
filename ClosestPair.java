import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ClosestPair{

    
    ArrayList<List<Integer>> coordenadas;
    long elapsedTime;
    int operaciones;
    
    public ClosestPair(){
        operaciones = 0; 
    }

    public void run(int n) {
        coordenadas = crearCoordenadas(n);
        coordenadas = sorting(coordenadas);
        DivAndConquer  algoritmo = new DivAndConquer();
        algoritmo.run(coordenadas);
        String line = n + " "+ elapsedTime + " " + operaciones;
        System.out.println(line);
    }
    
    /**
     * Funcion que crea el dataset a utilizar
     * @param n: numero que indica cuantas coordenadas serán creadas
     */
    public ArrayList<List<Integer>> crearCoordenadas(int n){
        Random random = new Random();
        ArrayList<List<Integer>> coordenadas = new ArrayList<>();
        int limitSuperior = n/2;
        for(int i = 0; i <= n/2; i++){
            int xnum = random.nextInt(limitSuperior);
            int y = random.nextInt(1000);
            coordenadas.add(Arrays.asList(xnum, y));
        }
        for(int i = n/2 + 1; i < n; i++){
            int xnum = (int)(Math.random()*(n - limitSuperior) + limitSuperior);
            int y = random.nextInt(1000);
            coordenadas.add(Arrays.asList(xnum, y));
        }
        return coordenadas;
    }
    
    public ArrayList<List<Integer>> sorting(ArrayList<List<Integer>> coords) {
        ArrayList<List<Integer>> coordenadasOrganizadas = new ArrayList<>();

        for(List<Integer> coord: coords) {
            if (coordenadasOrganizadas.isEmpty()) {
                coordenadasOrganizadas.add(coord);
            } else {
                int k = 1;
                int tamaño = coordenadasOrganizadas.size();
                List<Integer> coordBefore = coordenadasOrganizadas.get((tamaño - k));
                //verficar con x
                while (coordBefore.get(0) >= coord.get(0)) {
                    k++;
                    //en caso de que sea igual x, verfica con y
                    if (coordBefore.get(0).equals(coord.get(0))) {
                        if (coordBefore.get(1) > coord.get(1)) {
                            coordBefore = coordenadasOrganizadas.get((tamaño - k + 1));
                        } else {
                            k--;
                            break;
                        }
                    }
                    //en caso de que la nueva coordenada tenga que estar en la primera posicion
                    if (tamaño == k - 1) {
                        break;
                    }
                    //en caso de que el x de la coordenada anterior sea mayor al que esta en ejecucion
                    if (coordBefore.get(0) > coord.get(0)) {
                        coordBefore = coordenadasOrganizadas.get((tamaño - k));
                    }
                }
                coordenadasOrganizadas.add(tamaño - k + 1, coord);
            }
        }
        return coordenadasOrganizadas;
    }
}
