public class Point implements Comparable<Point> {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if(this.x < p.x) return -1;
        return 1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
