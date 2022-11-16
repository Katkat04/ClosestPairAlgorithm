import java.util.*;

public class ClosestPair{
    
    public ClosestPair(){ 
    }

    public void run(int expMax) {
        FileManager fm = new FileManager("pruebas.txt");
        Timer timer = new Timer();
        int i = 5;
        int n = (int) Math.pow(2, i); //para que el n empiece en 2^5
        do{
            double time = 0;
            int comp = 0;
            int j = 0;
            int k = 200;
            while(j < k){
                ArrayList<Point> coordenadas = crearCoordenadas(n);
                coordenadas = sorting(coordenadas);
                DivAndConquer  algoritmo = new DivAndConquer();
                timer.start();
                algoritmo.run(coordenadas);
                timer.stop();
                time += timer.getTime();
                comp += n;
                j++;
            }
            time = time / j;
            comp = comp / j;
            String line = n + " " + time + " " + comp;
            System.out.println(line);
            fm.write(line);
            n = (int) Math.pow(2, i);
                i++;
        }while(n <= Math.pow(2, expMax));
        fm.close();
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
        Collections.sort(coords, new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                return Integer.valueOf(p1.getX()).compareTo(p2.getX());
            }
        });
        return coords;
    }
}
