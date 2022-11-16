public class TimeManager {

    private double startTime;
    private double endTime;

    public TimeManager(){
    }

    public void start(){
        this.startTime = System.nanoTime();
    }

    public void stop(){
        this.endTime = System.nanoTime();
    }

    public double getTime(){
        return endTime - startTime;
    }
}
