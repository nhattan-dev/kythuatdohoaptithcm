/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object3D;

import Object.Point;
import Object.Point3D;
import Object2D.Draw2D;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Welcome
 */
public class SquarePyramid {

    private Point3D root;
    private int height;
    private int width;
    private BufferedImage img;
    private java.awt.Point center;
    private java.awt.Point A, B, C, D, O, S;

    public SquarePyramid(Point3D root, int height, int width, BufferedImage img, java.awt.Point center) {
        this.root = root;
        this.height = height;
        this.width = width;
        this.img = img;
        this.center = center;
        Calculation();
    }

    public java.awt.Point getA() {
        return A;
    }

    public java.awt.Point getB() {
        return B;
    }

    public java.awt.Point getC() {
        return C;
    }

    public java.awt.Point getD() {
        return D;
    }
    
    public BufferedImage draw() {
        //invisible line
        this.img = new Draw2D(this.img).Dashed(this.A, this.C, Color.BLACK);
        this.img = new Draw2D(this.img).Dashed(this.B, this.D, Color.BLACK);
        this.img = new Draw2D(this.img).Dashed(this.O, this.S, Color.BLACK);
        
        //visible line
        this.img = new Draw2D(this.img).drawLine(this.C, this.B, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.C, this.D, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.S, this.B, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.S, this.C, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.S, this.D, Color.BLACK);
        
        //must be checked
        if (this.height < this.width / 2) {
            this.img = new Draw2D(this.img).drawLine(this.A, this.D, Color.BLACK);
            this.img = new Draw2D(this.img).drawLine(this.A, this.S, Color.BLACK);
        } else {
            this.img = new Draw2D(this.img).Dashed(this.A, this.D, Color.BLACK);
            this.img = new Draw2D(this.img).Dashed(this.A, this.S, Color.BLACK);
        }
        
        if (this.height < (this.width * Math.sqrt(2) / 4)) {
            this.img = new Draw2D(this.img).drawLine(this.A, this.B, Color.BLACK);
        } else {
            this.img = new Draw2D(this.img).Dashed(this.A, this.B, Color.BLACK);
        }
        
        return this.img;
    }

    public Point3D getPosition3D(String key) {
        switch (key) {
            case "A":
                return new Point3D(this.root.getX(), this.root.getY(), 
                        this.root.getZ());
            case "B":
                return new Point3D(this.root.getX() + this.width, root.getY(), 
                        this.root.getZ());
            case "C":
                return new Point3D(root.getX() + this.width, this.root.getY(),
                        this.root.getZ() + this.width);
            case "D":
                return new Point3D(this.root.getX(), this.root.getY(), this.root.getZ() + this.width);
            case "O":
                return new Point3D(this.root.getX() + this.width / 2, this.root.getY(),
                        this.root.getZ() + this.width / 2);
            case "S":
                return new Point3D(this.root.getX() + this.width / 2, this.root.getY() + this.height,
                        this.root.getZ() + this.width / 2);
        }
        return null;
    }

    private void Calculation() {
        int reverse = -1;
        int x = center.x + root.getX() - (int) Math.round(Math.sqrt(2) / 2) * root.getZ();
        int y = center.y - root.getY() + (int) Math.round(Math.sqrt(2) / 2) * root.getZ();
        A = new java.awt.Point(x, y);

        x = (int) (A.x + width);
        y = (int) (A.y);
        B = new java.awt.Point(x, y);

        x = (int) Math.round(A.x + (width - Math.sqrt(2) / 2 * width));
        y = (int) Math.round(A.y + Math.sqrt(2) / 2 * width);
        C = new java.awt.Point(x, y);

        x = (int) Math.round(A.x - Math.sqrt(2) / 2 * width);
        y = (int) Math.round(A.y + Math.sqrt(2) / 2 * width);
        D = new java.awt.Point(x, y);

        O = new Point(C.x, C.y).Scale(A, 0.5f);

        S = new java.awt.Point(O.x, O.y + height * reverse);
    }
}
