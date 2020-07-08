package Object;

import interFace.Tranformation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Welcome
 */
public class Point implements Tranformation {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void Init(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //rotate this point around the root point
    @Override
    public java.awt.Point Rotate(java.awt.Point root, double alpha) {
        //Shifting this point so that the root point coincides with the center of the coordinates
        java.awt.Point sP = new Point(this.x, this.y).Shifting(-root.x, -root.y);
        
        //Rotate this point an alpha angle
        int nX = (int) Math.round(sP.x * Math.cos(alpha) - sP.y * Math.sin(alpha));
        int nY = (int) Math.round(sP.x * Math.sin(alpha) + sP.y * Math.cos(alpha));
        
        //Shift this point so that the root point match the old coordinates
        java.awt.Point sP2 = new Point(nX, nY).Shifting(root.x, root.y);
        return sP2;
    }

    //shifting this point with distance Sx, Sy
    @Override
    public java.awt.Point Shifting(int Sx, int Sy) {
        int newX = this.x + Sx;
        int newY = this.y + Sy;
        return new java.awt.Point(newX, newY);
    }

    @Override
    public java.awt.Point Symmetry(java.awt.Point root) {
        //Thich nen de, cam hoi!
        return null;
    }
    
    //Scale with center as the root point
    @Override
    public java.awt.Point Scale(java.awt.Point root, float ratio) {
        //init
        int width, height = 0, diagonal, b;
        
        //get width, height
        width = Math.abs(this.x - root.x);
        height = Math.abs(this.y - root.y);
        diagonal = (int) Math.round(Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2)));
        
        //is diagonal
        if (root.x != this.x && root.y != this.y) {
            b = Math.round(ratio * diagonal);
            int nX = Math.round(width * b / diagonal);
            int nY = Math.round(height * b / diagonal);
            if (root.x < this.x) {
                nX += root.x;
            } else {
                nX = root.x - nX;
            }
            if (root.y < this.y) {
                nY += root.y;
            } else {
                nY = root.y - nY;
            }
            return new java.awt.Point(nX, nY);
        } else if (root.x == this.x) { //Oy
            int nX, nY;
            nX = this.x;
            nY = Math.round(height * ratio);
            if (root.y < this.y) {
                nY += root.y;
            } else {
                nY = root.y - nY;
            }
            return new java.awt.Point(nX, nY);
        } else if (root.y == this.y) {   //Ox
            int nX, nY;
            nX = Math.round(width * ratio);
            nY = y;
            if (root.x < this.x) {
                nX += root.x;
            } else {
                nX = root.x - nX;
            }
            return new java.awt.Point(nX, nY);
        }
        return null;
    }
    
    //convert to java.awt.Point
    public java.awt.Point toJavaPoint(){
        return new java.awt.Point(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + this.x + ", y=" + this.y + '}';
    }
}
