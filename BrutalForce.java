import java.util.ArrayList;

public class BrutalForce {
    
    private Point coordenadaMasCercana1;
    private Point coordenadaMasCercana2;
    private double distanciaCercana;

    public BrutalForce(){

    }

    /**
     * Funcion que implementa el algoritmo BrutalForce aprendido en clase
     * @param coordenadas: lista de coordenadas
     */
    public void run(ArrayList<Point> coordenadas){
        double distanciaCercana = Double.POSITIVE_INFINITY;
        int n = coordenadas.size();
        double distance;

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
    }

    /**
     * Funcion que usa BrutalForce para hallar la distancia dado una lista de coordenadas
     * @param coord: lista de coordenadas
     * @param i
     * @param j
     */
    public double distance(ArrayList<Point> coord, int i , int j){

        int x1 = coord.get(i).getX();
        int y1 = coord.get(i).getY();

        int x2 = coord.get(j).getX();
        int y2 = coord.get(j).getY();

        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return d;
    }

    public double getDistancia(){
        return this.distanciaCercana;
    }

    public Point getCoord1(){
        return this.coordenadaMasCercana1;
    }

    public Point getCoord2(){
        return this.coordenadaMasCercana2;
    }
}


