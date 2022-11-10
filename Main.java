/*
 *
 * @author jkdiaz
 * Course name: Algoritmos y complejidad IST4310
 * Student name: Katy Díaz Beltrán
 * CIU: 200149846
 * Activity: Closest Pair
 * Date: 04/11/2022
 * Descprition: Este es un algoritmo encargado de encontrar un par de coordenadas cercanas, luego de haber ingresado un dato dado.
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        ClosestPair closestPair = new ClosestPair();
        closestPair.run(20);
    }
}

class ClosestPair{
  
    ArrayList<ArrayList<List<Integer>>> CoordMasCercanas;
    ArrayList<Double> distanciasCoordMasCercanas;
    List<Integer> coordenadaMasCercana1;
    List<Integer> coordenadaMasCercana2;
    long elapsedTime;
    int operaciones;
    
    public ClosestPair(){
       operaciones = 0; 
    }

    public void run(int n) {
        ArrayList<List<Integer>> coordenada = crearCoordenadas(n);
        CoordMasCercanas = new ArrayList<>();
        distanciasCoordMasCercanas= new ArrayList<>();
        divideAndConquer(coordenada);
        String line = n + " "+ operaciones + " " + elapsedTime;
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


    /**
     * Funcion que implementa el algoritmo BrutalForce aprendido en clase
     * @param coordenadas: lista de coordenadas
     */
    public void brutalForce(ArrayList<List<Integer>> coordenadas){
        double distanciaCercana = 183932839;
        int n = coordenadas.size();
        double distance;

        for(int i = 0; i <= n-1; i++){
            for(int j = i+1; j <= n-1; j++){
                distance = distance(coordenadas, i, j);
                if(distance < distanciaCercana){
                    ArrayList<List<Integer>> coordenadaMasCercana1 = coordenadas.get(i);
                    ArrayList<List<Integer>> coordenadaMasCercana2 = coordenadas.get(j);
                    distanciaCercana = distance;
                }
            }
        }
        System.out.print(coordenadaMasCercana1);
        System.out.print("  ");
        System.out.print(coordenadaMasCercana2);
        System.out.print("  ");
        System.out.print(distanciaCercana);
    }

    /**
     * Funcion que usa BrutalForce para hallar la distancia dado una lista de coordenadas
     * @param coord: lista de coordenadas
     * @param i
     * @param j
     */
    public double distance(ArrayList<List<Integer>> coord, int i , int j){

        int x1 = coord.get(i).get(0);
        int y1 = coord.get(i).get(1);

        int x2 = coord.get(j).get(0);
        int y2 = coord.get(j).get(1);

        double d = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return d;
    }
    
     public void divideAndConquer(ArrayList<List<Integer>> coords) {
        long start = System.nanoTime();
        ArrayList<List<Integer>> Lx;
        ArrayList<List<Integer>> Rx;

        ArrayList<List<Integer>> Px;
        Px = sorting(coords);

        int tamaño = Px.size();
        Lx = new ArrayList<>(Px.subList(0, tamaño / 2));
        Rx = new ArrayList<>(Px.subList(tamaño / 2, tamaño));

        //coordenadas creadas para guardar las coordenadas mas cercanas entre cada division
        coordenadaMasCercana1 = new ArrayList<>();
        coordenadaMasCercana2 = new ArrayList<>();


        //verificar si no se tiene que subdividir mas
        if(Lx.size() > 3){
            divideAndConquer(Lx);
        }else{
            brutalForce(Lx);
            //lista temporal creada para guardar las coordenadas cercanas en el ArrayList CoordMasCercanas
            ArrayList<List<Integer>> parCoordenadas = new ArrayList<>();
            parCoordenadas.add(coordenadaMasCercana1);
            parCoordenadas.add(coordenadaMasCercana2);
            CoordMasCercanas.add(parCoordenadas);
            distanciasCoordMasCercanas.add(distanciaCercana);
        }
        //verificar si no se tiene que subdividir mas
        if(Rx.size() > 3){
            divideAndConquer(Rx);
        }else{
            brutalForce(Rx);
            //lista temporal creada para guardar las coordenadas cercanas en el ArrayList CoordMasCercanas
            ArrayList<List<Integer>> parCoordenadas = new ArrayList<>();
            parCoordenadas.add(coordenadaMasCercana1);
            parCoordenadas.add(coordenadaMasCercana2);
            CoordMasCercanas.add(parCoordenadas);
            distanciasCoordMasCercanas.add(distanciaCercana);
        }
        long end = System.nanoTime();
        elapsedTime = end - start;
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

    public int indexDistanciaMasCorta(ArrayList<Double> distancia){
        int i = 0;
        int indexMasCercano = 0;
        double DistanciaMasCercana = distancia.get(0);
        for(double distance: distancia){
            if(distance < DistanciaMasCercana){
                DistanciaMasCercana = distance;
                indexMasCercano = i;
            }
            i++;
        }
        return indexMasCercano;
    }

}
