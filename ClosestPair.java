import java.util.*;

public class ClosestPair{

    long elapsedTime;
    int operaciones;
    
    public ClosestPair(){
        operaciones = 0; 
    }

    public void run(int n) {
        ArrayList<Point> coordenadas = crearCoordenadas(n);
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
    public ArrayList<Point> crearCoordenadas(int n){
        Random random = new Random();
        ArrayList<Point> coordenadas = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(i < n/2){
                int x = random.nextInt(50);
                int y = random.nextInt(20);
                coordenadas.add(new Point(x, y));
                continue;
            }
            //rango de 50 hasta 100
            int x = (int)(Math.random()*(50) + 101);
            int y = random.nextInt(20);
            coordenadas.add(new Point(x, y));
        }
        
        return coordenadas;
    }
    
    //Issue #7 -> Improve sorting
    public ArrayList<Point> sorting(ArrayList<Point> coords) {
        Collections.sort(coords);
        return coords;
    }
}
