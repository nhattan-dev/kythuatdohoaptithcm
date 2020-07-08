/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object3D;

import Object.Point3D;
import Object2D.Draw2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Welcome
 */
public class Rectangular {

    private Point3D root;
    private int length;
    private int width;
    private int height;
    private BufferedImage img;
    private Point center;
    private Point A, B, C, D, E, F, G, H;

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public Point getD() {
        return D;
    }

    public void setD(Point D) {
        this.D = D;
    }

    public Point getE() {
        return E;
    }

    public void setE(Point E) {
        this.E = E;
    }

    public Point getF() {
        return F;
    }

    public void setF(Point F) {
        this.F = F;
    }

    public Point getG() {
        return G;
    }

    public void setG(Point G) {
        this.G = G;
    }

    public Point getH() {
        return H;
    }

    public void setH(Point H) {
        this.H = H;
    }

    public Rectangular(Point3D root, int lenght, int width, int height, BufferedImage img, Point center) {
        this.root = root;
        this.length = lenght;
        this.width = width;
        this.height = height;
        this.img = img;
        this.center = center;
        Calculation();
    }

    public Point3D getPosition3D(String key) {
        switch (key) {
            case "A":
                return new Point3D(this.root.getX(), this.root.getY(), this.root.getZ());
            case "B":
                return new Point3D(this.root.getX() + this.length, this.root.getY(), 
                        this.root.getZ());
            case "C":
                return new Point3D(this.root.getX() + this.length, this.root.getY(), 
                        this.root.getZ() + this.width);
            case "D":
                return new Point3D(this.root.getX(), this.root.getY(), 
                        this.root.getZ() + this.width);
            case "E":
                return new Point3D(this.root.getX(), this.root.getY() + this.height, 
                        this.root.getZ());
            case "F":
                return new Point3D(this.root.getX(), this.root.getY() + this.height, 
                        this.root.getZ() + this.width);
            case "G":
                return new Point3D(this.root.getX() + this.length, 
                        this.root.getY() + this.height, this.root.getZ() + this.width);
            case "H":
                return new Point3D(this.root.getX(), this.root.getY() + this.height, 
                        this.root.getZ() + this.width);
        }
        return null;
    }

    private void Calculation() {
        int x = this.center.x + this.root.getX() 
                - (int) Math.round(Math.sqrt(2) / 2) * this.root.getZ();
        int y = this.center.y - this.root.getY() 
                + (int) Math.round(Math.sqrt(2) / 2) * this.root.getZ();
        this.A = new Point(x, y);

        x = (int) (this.A.x + this.length);
        y = (int) (this.A.y);
        this.B = new Point(x, y);

        x = (int) Math.round(this.A.x + (this.length - Math.sqrt(2) / 2 * this.width));
        y = (int) Math.round(this.A.y + Math.sqrt(2) / 2 * this.width);
        this.C = new Point(x, y);

        x = (int) Math.round(this.A.x - Math.sqrt(2) / 2 * this.width);
        y = (int) Math.round(this.A.y + Math.sqrt(2) / 2 * this.width);
        this.D = new Point(x, y);

        x = this.A.x;
        y = this.A.y - this.height;
        this.E = new Point(x, y);

        x = this.B.x;
        y = this.B.y - this.height;
        this.F = new Point(x, y);

        x = this.C.x;
        y = this.C.y - this.height;
        this.G = new Point(x, y);

        x = this.D.x;
        y = this.D.y - this.height;
        this.H = new Point(x, y);
    }

    public BufferedImage draw() {
        //init
        Graphics g = this.img.getGraphics();

        //invisible
        this.img = new Draw2D(this.img).Dashed(this.A, this.B, Color.BLACK);
        this.img = new Draw2D(this.img).Dashed(this.A, this.E, Color.BLACK);
        this.img = new Draw2D(this.img).Dashed(this.A, this.D, Color.BLACK);
        
        //visible
        this.img = new Draw2D(this.img).drawLine(this.F, this.E, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.F, this.G, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.F, this.B, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.H, this.E, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.H, this.G, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.H, this.D, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.C, this.G, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.C, this.B, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.C, this.D, Color.BLACK);
        
        //draw point names
        int space = 10;
        g.setColor(Color.RED);
        g.drawString("A", this.A.x + space, this.A.y - space);
        g.drawString("B", this.B.x + space, this.B.y - space);
        g.drawString("C", this.C.x + space, this.C.y + space);
        g.drawString("D", this.D.x - space, this.D.y + space);
        g.drawString("E", this.E.x + space, this.E.y - space);
        g.drawString("F", this.F.x + space, this.F.y - space);
        g.drawString("G", this.G.x - space, this.G.y - space);
        g.drawString("H", this.H.x - space, this.H.y - space);
        
        return this.img;
    }
}
