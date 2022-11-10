

/**
 *
 * @author diazk
 */

public class Main {

    public static void main(String[] args){
        ClosestPair closestPair = new ClosestPair();
        closestPair.run(20);
    }
}

class ClosestPair{
    
    public ClosestPair(){
    }

    public void run(int n) {
        ArrayList<List<Integer>> coords = crearCoordenadas(n);
        brutalForce(coords);
    }
    
    /**
     * Funcion que crea el dataset a utilizar
     * @param n: numero que indica cuantas coordenadas serán creadas
     */
    public ArrayList<List<Integer>> crearCoordenadas(int n){
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


}
