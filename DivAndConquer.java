import java.util.ArrayList;

public class DivAndConquer {
    
    private ArrayList<ArrayList<Point>> CoordMasCercanas;
    private int operaciones;

    public DivAndConquer(){
        CoordMasCercanas = new ArrayList<>();
    }

    public void run(ArrayList<Point> coords) {
        ArrayList<Point> Px = coords;

        int tamaño = Px.size();

        //las subdivisiones
        ArrayList<Point> Lx = new ArrayList<>(Px.subList(0, tamaño / 2));
        ArrayList<Point> Rx = new ArrayList<>(Px.subList(tamaño / 2, tamaño));

        //coordenadas creadas para guardar las coordenadas mas cercanas entre cada division
        Point coordenadaMasCercana1 = new Point();
        Point coordenadaMasCercana2 = new Point();


        //verificar si no se tiene que subdividir mas
        if(Lx.size() > 3){
            run(Lx);
        }else{
            BrutalForce brutalF = new BrutalForce();
            brutalF.run(Lx);
            double distanciaCercana = brutalF.getDistancia();
            //lista temporal creada para guardar las coordenadas cercanas en el ArrayList CoordMasCercanas
            ArrayList<Point> parCoordenadas = new ArrayList<>();
            coordenadaMasCercana1 = brutalF.getCoord1();
            coordenadaMasCercana2 = brutalF.getCoord2();
            parCoordenadas.add(coordenadaMasCercana1);
            parCoordenadas.add(coordenadaMasCercana2);
            CoordMasCercanas.add(parCoordenadas);
        }
        //verificar si no se tiene que subdividir mas
        if(Rx.size() > 3){
            run(Rx); //recursividad
        }else{
            BrutalForce brutalF = new BrutalForce();
            brutalF.run(Lx);
            double distanciaCercana = brutalF.getDistancia();
            //lista temporal creada para guardar las coordenadas cercanas en el ArrayList CoordMasCercanas
            ArrayList<Point> parCoordenadas = new ArrayList<>();
            parCoordenadas.add(coordenadaMasCercana1);
            parCoordenadas.add(coordenadaMasCercana2);
            CoordMasCercanas.add(parCoordenadas);
        }
    }

    public int getOperaciones(){
        return this.operaciones;
    }
}
