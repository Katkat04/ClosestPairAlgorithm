import java.util.ArrayList;
import java.util.List;

public class BrutalForce {
    
    double distanciaCercana;

    public BrutalForce(){

    }

    /**
     * Funcion que implementa el algoritmo BrutalForce aprendido en clase
     * @param coordenadas: lista de coordenadas
     */
    public void run(ArrayList<List<Integer>> coordenadas){
        double distanciaCercana = 183932839;
        int n = coordenadas.size();
        double distance;
        List<Integer> coordenadaMasCercana1 = null, coordenadaMasCercana2 = null;

        for(int i = 0; i <= n-1; i++){
            for(int j = i+1; j <= n-1; j++){
                distance = distance(coordenadas, i, j);
                if(distance < distanciaCercana){
                    coordenadaMasCercana1 = coordenadas.get(i);
                    coordenadaMasCercana2 = coordenadas.get(j);
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

    public double getDistancia(){
        return this.distanciaCercana;
    }
}


