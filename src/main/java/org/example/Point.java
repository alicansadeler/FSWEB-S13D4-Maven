package org.example;

public class Point {

    private int x;
    private int y;

    public Point(int xA, int yA) {
        this.x = xA;
        this.y = yA;
    }

    public int getX() {
        return x;
    }

    public void setxA(int xA) {
        this.x = xA;
    }

    public int getY() {
        return y;
    }

    public void setyA(int yA) {
        this.y = yA;
    }

    public double distance(int xB, int yB) {
        return Math.sqrt((xB - this.x) * (xB - this.x) + (yB - this.y) * (yB - this.y));
    }

    public double distance() {
        return Math.sqrt((this.x) * (this.x) + (this.y) * (this.y));
    }

// point p; bizim yazdığımız poinst sınıfını temsil eder - p değişken ismidir. 2 instance arası mesafe..
    public double distance(Point p) {
        return distance(p.x, p.y);
    }
}
