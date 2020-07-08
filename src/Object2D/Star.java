/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object2D;

import Object.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Welcome
 */
public class Star {

    private BufferedImage img;
    private java.awt.Point root;
    private int ratio;
    private java.awt.Point A, B, C, D, E, F, G, H, I, J;

    public Star(BufferedImage img, java.awt.Point root, int ratio) {
        this.img = img;
        this.root = root;
        this.ratio = ratio;
        Calculation();
    }

    public BufferedImage getImg() {
        return img;
    }

    public java.awt.Point getRoot() {
        return root;
    }

    public int getRatio() {
        return ratio;
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

    public java.awt.Point getE() {
        return E;
    }

    public java.awt.Point getF() {
        return F;
    }

    public java.awt.Point getG() {
        return G;
    }

    public java.awt.Point getH() {
        return H;
    }

    public java.awt.Point getI() {
        return I;
    }

    public java.awt.Point getJ() {
        return J;
    }

    private void Scale(float scale){
        //scale
        this.A = new Point(this.A.x, this.A.y).Scale(this.root, scale);
        this.B = new Point(this.B.x, this.B.y).Scale(this.root, scale);
        this.C = new Point(this.C.x, this.C.y).Scale(this.root, scale);
        this.D = new Point(this.D.x, this.D.y).Scale(this.root, scale);
        this.E = new Point(this.E.x, this.E.y).Scale(this.root, scale);
        this.F = new Point(this.F.x, this.F.y).Scale(this.root, scale);
        this.G = new Point(this.G.x, this.G.y).Scale(this.root, scale);
        this.H = new Point(this.H.x, this.H.y).Scale(this.root, scale);
        this.I = new Point(this.I.x, this.I.y).Scale(this.root, scale);
        this.J = new Point(this.J.x, this.J.y).Scale(this.root, scale);
    }
    
    private void Shifting(int Sx, int Sy){
        //shifting
        this.A = new Point(this.A.x, this.A.y).Shifting(Sx, Sy);
        this.B = new Point(this.B.x, this.B.y).Shifting(Sx, Sy);
        this.C = new Point(this.C.x, this.C.y).Shifting(Sx, Sy);
        this.D = new Point(this.D.x, this.D.y).Shifting(Sx, Sy);
        this.E = new Point(this.E.x, this.E.y).Shifting(Sx, Sy);
        this.F = new Point(this.F.x, this.F.y).Shifting(Sx, Sy);
        this.G = new Point(this.G.x, this.G.y).Shifting(Sx, Sy);
        this.H = new Point(this.H.x, this.H.y).Shifting(Sx, Sy);
        this.I = new Point(this.I.x, this.I.y).Shifting(Sx, Sy);
        this.J = new Point(this.J.x, this.J.y).Shifting(Sx, Sy);
    }
    
    private void Calculation(){
        //init
        int reverse = -1, x, y;
        Point nRoot, nPoint;

        //get value
        x = this.root.x;
        y = (int) (this.root.y + 0.05 * this.ratio * reverse);
        this.A = new java.awt.Point(x, y);
        
        //convert to Object.Point
        nRoot = new Point(this.root.x, this.root.y);
        nPoint = new Point(this.A.x, this.A.y);
        
        //get value
        this.B = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(72)).getEnd().toJavaPoint();
        this.C = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(144)).getEnd().toJavaPoint();
        this.D = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(216)).getEnd().toJavaPoint();
        this.E = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(288)).getEnd().toJavaPoint();

        //get value
        x = this.root.x;
        y = (int) (this.root.y + 0.0175 * this.ratio * reverse);
        this.F = new java.awt.Point(x, y);
        
        //convert to Object.Point
        nPoint = new Point(this.F.x, this.F.y);
        this.F = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(-36)).getEnd().toJavaPoint();
        this.G = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(36)).getEnd().toJavaPoint();
        this.H = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(108)).getEnd().toJavaPoint();
        this.I = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(180)).getEnd().toJavaPoint();
        this.J = new Line(nRoot, nPoint).Rotate(this.root, Math.toRadians(252)).getEnd().toJavaPoint();
    }
    
    public BufferedImage drawStar(int key) {
        //init
        int reverse = -1;
        Graphics g = this.img.getGraphics();

        //get scale
        float scale;
        scale = (float) (1 + key * 0.045);
        //scale
        Scale(scale);

        //get Sx, Sy
        int Sx, Sy;
        Sx = (int) (key * -0.25 * this.ratio);
        Sy = (int) (key * -0.1 * this.ratio * reverse);
        //shifting with distance Sx, Sy
        Shifting(Sx, Sy);

        //match
        this.img = new Draw2D(this.img).drawLine(this.A, this.G, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.B, this.G, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.B, this.H, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.C, this.H, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.C, this.I, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.D, this.I, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.D, this.J, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.E, this.J, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.E, this.F, Color.yellow);
        this.img = new Draw2D(this.img).drawLine(this.A, this.F, Color.yellow);
        //fill
        int xS[] = new int[10], yS[] = new int[10];
        xS[0] = this.A.x;
        xS[1] = this.G.x;
        xS[2] = this.B.x;
        xS[3] = this.H.x;
        xS[4] = this.C.x;
        xS[5] = this.I.x;
        xS[6] = this.D.x;
        xS[7] = this.J.x;
        xS[8] = this.E.x;
        xS[9] = this.F.x;
        yS[0] = this.A.y;
        yS[1] = this.G.y;
        yS[2] = this.B.y;
        yS[3] = this.H.y;
        yS[4] = this.C.y;
        yS[5] = this.I.y;
        yS[6] = this.D.y;
        yS[7] = this.J.y;
        yS[8] = this.E.y;
        yS[9] = this.F.y;
        g.setColor(Color.yellow);
        g.fillPolygon(xS, yS, 10);
        return this.img;
    }
}
