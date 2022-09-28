package com.epam.rd.autotasks.triangle;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a == null) {throw new IllegalArgumentException();}
        if (b == null) {throw new IllegalArgumentException();}
        if (c == null) {throw new IllegalArgumentException();}
        if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0)
            throw new IllegalArgumentException("Triangle is degenerative");
    }

    public Point getA() {return a;}
    public Point getB() {return b;}
    public Point getC() {return c;}

    public double area() {

        double ABxDistanceSquare = Math.pow(a.getX() - b.getX(), 2);
        double AByDistanceSquare = Math.pow(a.getY() - b.getY(), 2);
        double sideA = Math.sqrt(ABxDistanceSquare + AByDistanceSquare);
        double BCxDistanceSquare = Math.pow(b.getX() - c.getX(), 2);
        double BCyDistanceSquare = Math.pow(b.getY() - c.getY(), 2);
        double sideC = Math.sqrt(BCxDistanceSquare + BCyDistanceSquare);
        double ACxDistanceSquare = Math.pow(a.getX() - c.getX(), 2);
        double ACyDistanceSquare = Math.pow(a.getY() - c.getY(), 2);
        double sideB = Math.sqrt(ACxDistanceSquare + ACyDistanceSquare);

        double aa = sideA;
        double bb = sideB;
        double cc = sideC;
        double pp = (aa+bb+cc)/2;
        double T = Math.sqrt(pp*(pp-aa)*(pp-bb)*(pp-cc));
        return T;
    }

    public Point centroid(){
        double x = (a.getX() + b.getX() + c.getX())/3;
        double y = (a.getY() + b.getY() + c.getY())/3;
        return new Point(x, y);
    }

}
