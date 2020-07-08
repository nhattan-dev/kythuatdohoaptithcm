/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object2D;

import Object.Point;
import Object.Shape;

/**
 *
 * @author Welcome
 */
public class Line extends Shape {

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    //scale this line with the root point as the start point
    @Override
    public Line Scale(java.awt.Point root, float ratio) {
        //scale
        java.awt.Point nStart = new Point(this.start.getX(), this.start.getY()).Scale(root, ratio);
        java.awt.Point nEnd = new Point(this.end.getX(), this.end.getY()).Scale(root, ratio);
        
        //convert java.awt.Point to Point(Object)
        Point nS = new Point(nStart.x, nStart.y);
        Point nE = new Point(nEnd.x, nEnd.y);
        return new Line(nS, nE);
    }

    //shifting this line with distance Sx, Sy
    @Override
    public Line Shifting(int Sx, int Sy) {
        //shifting
        java.awt.Point nStart = new Point(this.start.getX(), this.start.getY()).Shifting(Sx, Sy);
        java.awt.Point nEnd = new Point(this.end.getX(), this.end.getY()).Shifting(Sx, Sy);
        
        //convert java.awt.Point to Point(Object)
        Point nS = new Point(nStart.x, nStart.y);
        Point nE = new Point(nEnd.x, nEnd.y);
        return new Line(nS, nE);
    }

    //rotate this line with the root as the start point
    @Override
    public Line Rotate(java.awt.Point root, double alpha) {
        //rotate
        java.awt.Point nEnd = new Point(this.end.getX(), this.end.getY()).Rotate(root, alpha);
        java.awt.Point nStart = new Point(this.start.getX(), this.start.getY()).Rotate(root, alpha);
        
        //convert java.awt.Point to Point(Object)
        Point nS = new Point(nStart.x, nStart.y);
        Point nE = new Point(nEnd.x, nEnd.y);
        return new Line(nS, nE);
    }

    @Override
    public String toString() {
        return "Line{" + "start=" + start + ", end=" + end + '}';
    }

}
