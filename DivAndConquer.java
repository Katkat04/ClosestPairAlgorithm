import java.util.ArrayList;
import java.util.List;

public class DivAndConquer {
    
    private List<Integer> coordenadaMasCercana1;
    private List<Integer> coordenadaMasCercana2;
    private ArrayList<ArrayList<List<Integer>>> CoordMasCercanas;
    private ArrayList<Double> distanciasCoordMasCercanas;
    private double distanciaCercana;

    public DivAndConquer(){
        CoordMasCercanas = new ArrayList<>();
        distanciasCoordMasCercanas= new ArrayList<>();
    }

    public void run(ArrayList<Point> coords) {

        ArrayList<Point> Px = coords;

        int tamaño = Px.size();
        
        //las subdivisiones
        ArrayList<Point> Lx = new ArrayList<>(Px.subList(0, tamaño / 2));
        ArrayList<Point> Rx = new ArrayList<>(Px.subList(tamaño / 2, tamaño));

        //coordenadas creadas para guardar las coordenadas mas cercanas entre cada division
        coordenadaMasCercana1 = new ArrayList<>();
        coordenadaMasCercana2 = new ArrayList<>();


        //verificar si no se tiene que subdividir mas
        if(Lx.size() > 3){
            run(Lx);
        }else{
            BrutalForce brutalF = new BrutalForce();
            brutalF.run(Lx);
            distanciaCercana = brutalF.getDistancia();
            //lista temporal creada para guardar las coordenadas cercanas en el ArrayList CoordMasCercanas
            ArrayList<List<Integer>> parCoordenadas = new ArrayList<>();
            parCoordenadas.add(coordenadaMasCercana1);
            parCoordenadas.add(coordenadaMasCercana2);
            CoordMasCercanas.add(parCoordenadas);
            distanciasCoordMasCercanas.add(distanciaCercana);
        }
        //verificar si no se tiene que subdividir mas
        if(Rx.size() > 3){
            run(Rx);
        }else{
            BrutalForce brutalF = new BrutalForce();
            brutalF.run(Lx);
            distanciaCercana = brutalF.getDistancia();
            //lista temporal creada para guardar las coordenadas cercanas en el ArrayList CoordMasCercanas
            ArrayList<List<Integer>> parCoordenadas = new ArrayList<>();
            parCoordenadas.add(coordenadaMasCercana1);
            parCoordenadas.add(coordenadaMasCercana2);
            CoordMasCercanas.add(parCoordenadas);
            distanciasCoordMasCercanas.add(distanciaCercana);
        }
    }


}
