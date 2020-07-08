/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object2D;

import java.awt.Color;
import java.awt.Graphics;
import Object.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Welcome
 */
public class Car {

    private java.awt.Point root;
    private BufferedImage img;
    private int ratio;
    private java.awt.Point A, B, C, D, E, F, G, H, I, J, K, L, M, N, A1, B1, C1,
            D1, E1, F1, G1, O1, O2, O3, O4, xP, xT;
    private Line rootLine, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

    public Car(java.awt.Point root, BufferedImage img, int ratio) {
        this.root = root;
        this.img = img;
        this.ratio = ratio;
        Calculation();
    }

    public Line getL1() {
        return l1;
    }

    public Line getL2() {
        return l2;
    }

    public Line getL3() {
        return l3;
    }

    public Line getL4() {
        return l4;
    }

    public Line getL5() {
        return l5;
    }

    public Line getL6() {
        return l6;
    }

    public Line getL7() {
        return l7;
    }

    public Line getL8() {
        return l8;
    }

    public Line getL9() {
        return l9;
    }

    public Line getL10() {
        return l10;
    }

    public java.awt.Point getRoot() {
        return root;
    }

    public BufferedImage getImg() {
        return img;
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

    public java.awt.Point getK() {
        return K;
    }

    public java.awt.Point getL() {
        return L;
    }

    public java.awt.Point getM() {
        return M;
    }

    public java.awt.Point getN() {
        return N;
    }

    public java.awt.Point getA1() {
        return A1;
    }

    public java.awt.Point getB1() {
        return B1;
    }

    public java.awt.Point getC1() {
        return C1;
    }

    public java.awt.Point getD1() {
        return D1;
    }

    public java.awt.Point getE1() {
        return E1;
    }

    public java.awt.Point getF1() {
        return F1;
    }

    public java.awt.Point getG1() {
        return G1;
    }

    public java.awt.Point getO1() {
        return O1;
    }

    public java.awt.Point getO2() {
        return O2;
    }

    public java.awt.Point getO3() {
        return O3;
    }

    public java.awt.Point getO4() {
        return O4;
    }

    public java.awt.Point getxP() {
        return xP;
    }

    public java.awt.Point getxT() {
        return xT;
    }

    private void Calculation() {
        int x = 0, y = 0, reverse = -1;

        x = (int) Math.round(this.root.x - 1 * this.ratio);
        y = (int) Math.round(this.root.y + 0.5 * this.ratio * reverse);
        this.A = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 0.8 * this.ratio);
        y = (int) Math.round(this.root.y + 0.5 * this.ratio * reverse);
        this.B = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.3 * this.ratio);
        y = (int) Math.round(this.root.y);
        this.C = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 2.1 * this.ratio);
        y = (int) Math.round(this.root.y);
        this.D = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 2.2 * this.ratio);
        y = (int) Math.round(this.root.y - 0.15 * this.ratio * reverse);
        this.E = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 2.2 * this.ratio);
        y = (int) Math.round(this.root.y - 0.4 * this.ratio * reverse);
        this.F = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 2.1 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.G = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.8 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.H = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.2 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.I = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 0.7 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.J = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1.3 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.K = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1.4 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.L = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1.6 * this.ratio);
        y = (int) Math.round(this.root.y - 0.6 * this.ratio * reverse);
        this.M = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1.6 * this.ratio);
        y = (int) Math.round(this.root.y);
        this.N = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x);
        y = (int) Math.round(this.root.y + 0.4 * this.ratio * reverse);
        this.O1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x);
        y = (int) Math.round(this.root.y - 0.6 * this.ratio * reverse);
        this.O2 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.O3 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.5 * this.ratio);
        y = (int) Math.round(this.root.y - 0.8 * this.ratio * reverse);
        this.O4 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 0.75 * this.ratio);
        y = (int) Math.round(this.root.y + 0.4 * this.ratio * reverse);
        this.A1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 0.7 * this.ratio);
        y = (int) Math.round(this.root.y + 0.4 * this.ratio * reverse);
        this.B1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.1 * this.ratio);
        y = (int) Math.round(this.root.y);
        this.C1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.1 * this.ratio);
        y = (int) Math.round(this.root.y - 0.6 * this.ratio * reverse);
        this.D1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 0.6 * this.ratio);
        y = (int) Math.round(this.root.y - 0.6 * this.ratio * reverse);
        this.E1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 0.9 * this.ratio);
        y = (int) Math.round(this.root.y - 0.3 * this.ratio * reverse);
        this.F1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 0.9 * this.ratio);
        y = (int) Math.round(this.root.y);
        this.G1 = new java.awt.Point(x, y);

        x = O3.x;
        y = (int) (O3.y + 0.2 * this.ratio * reverse);
        this.xP = new java.awt.Point(x, y);

        x = O4.x;
        y = (int) (O4.y + 0.2 * this.ratio * reverse);
        this.xT = new java.awt.Point(x, y);
    }

    public BufferedImage drawWheels(int key) {
        drawWheel(key, this.xP, this.O3);
        drawWheel(key, this.xT, this.O4);
        return this.img;
    }

    private void drawWheel(int key, java.awt.Point xP, java.awt.Point root) {

        //convert to Object.Point
        Point xPObject = new Point(xP.x, xP.y);
        Point O3Object = new Point(root.x, root.y);
        rootLine = new Line(O3Object, xPObject);

        //calculator line
        l1 = rootLine.Rotate(root, Math.toRadians(0));
        l2 = rootLine.Rotate(root, Math.toRadians(36));
        l3 = rootLine.Rotate(root, Math.toRadians(72));
        l4 = rootLine.Rotate(root, Math.toRadians(108));
        l5 = rootLine.Rotate(root, Math.toRadians(144));
        l6 = rootLine.Rotate(root, Math.toRadians(180));
        l7 = rootLine.Rotate(root, Math.toRadians(216));
        l8 = rootLine.Rotate(root, Math.toRadians(252));
        l9 = rootLine.Rotate(root, Math.toRadians(288));
        l10 = rootLine.Rotate(root, Math.toRadians(324));

        //get value rotate
        int value;
        value = key * -24;

        //rotate
        l1 = l1.Rotate(root, Math.toRadians(value));
        l2 = l2.Rotate(root, Math.toRadians(value));
        l3 = l3.Rotate(root, Math.toRadians(value));
        l4 = l4.Rotate(root, Math.toRadians(value));
        l5 = l5.Rotate(root, Math.toRadians(value));
        l6 = l6.Rotate(root, Math.toRadians(value));
        l7 = l7.Rotate(root, Math.toRadians(value));
        l8 = l8.Rotate(root, Math.toRadians(value));
        l9 = l9.Rotate(root, Math.toRadians(value));
        l10 = l10.Rotate(root, Math.toRadians(value));

        //match
        this.img = new Draw2D(this.img).drawLine(l1.getStart().toJavaPoint(),
                l1.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l2.getStart().toJavaPoint(),
                l2.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l3.getStart().toJavaPoint(),
                l3.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l4.getStart().toJavaPoint(),
                l4.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l5.getStart().toJavaPoint(),
                l5.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l6.getStart().toJavaPoint(),
                l6.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l7.getStart().toJavaPoint(),
                l7.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l8.getStart().toJavaPoint(),
                l8.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l9.getStart().toJavaPoint(),
                l9.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(l10.getStart().toJavaPoint(),
                l10.getEnd().toJavaPoint(), Color.BLACK);
    }

    public BufferedImage draw(int ratio, int key) {
        //init
        Graphics g = this.img.getGraphics();
        int reverse = -1;

        //MATCH
        this.img = new Draw2D(this.img).drawLine(this.A, this.B, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.C, this.B, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.D, this.C, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.D, this.E, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.F, this.E, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.F, this.G, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.H, this.G, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.I, this.J, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.L, this.K, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.L, this.M, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.N, this.M, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.N, this.A, Color.BLACK);
        //FILL
        int axx[] = new int[10], ayx[] = new int[10];
        axx[0] = this.A.x;
        axx[1] = this.B.x;
        axx[2] = this.C.x;
        axx[3] = this.D.x;
        axx[4] = this.E.x;
        axx[5] = this.F.x;
        axx[6] = this.G.x;
        axx[7] = this.L.x;
        axx[8] = this.M.x;
        axx[9] = this.N.x;
        ayx[0] = this.A.y;
        ayx[1] = this.B.y;
        ayx[2] = this.C.y;
        ayx[3] = this.D.y;
        ayx[4] = this.E.y;
        ayx[5] = this.F.y;
        ayx[6] = this.G.y;
        ayx[7] = this.L.y;
        ayx[8] = this.M.y;
        ayx[9] = this.N.y;
        g.setColor(Color.BLUE);
        g.fillPolygon(axx, ayx, 10);

        this.img = new Draw2D(this.img).drawLine(this.A1, this.B1, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.B1, this.C1, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.D1, this.C1, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.D1, this.E1, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.F1, this.E1, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.F1, this.G1, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.A1, this.G1, Color.BLACK);
        //fill
        int axc[] = new int[5], ayc[] = new int[5];
        axc[0] = this.C1.x;
        axc[1] = this.D1.x;
        axc[2] = this.E1.x;
        axc[3] = this.F1.x;
        axc[4] = this.G1.x;
        ayc[0] = this.C1.y;
        ayc[1] = this.D1.y;
        ayc[2] = this.E1.y;
        ayc[3] = this.F1.y;
        ayc[4] = this.G1.y;
        g.setColor(Color.red);
        g.fillPolygon(axc, ayc, 5);

        int axcs[] = new int[5], aycs[] = new int[5];
        axcs[0] = this.A1.x;
        axcs[1] = this.B1.x;
        axcs[2] = this.C1.x;
        axcs[3] = this.G1.x;
        aycs[0] = this.A1.y;
        aycs[1] = this.B1.y;
        aycs[2] = this.C1.y;
        aycs[3] = this.G1.y;
        g.setColor(Color.white);
        g.fillPolygon(axcs, aycs, 4);

        this.img = new Draw2D(this.img).drawLine(this.O1, this.O2, Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(this.G1, this.C1, Color.BLACK);

        this.img = new Draw2D(this.img).drawCircle(this.O3,
                (int) (0.3 * ratio), Color.BLACK, 1);
        this.img = new Draw2D(this.img).drawCircle(this.O3,
                (int) (0.2 * ratio), Color.BLACK, 1);
        this.img = new Draw2D(this.img).drawCircle(this.O3,
                (int) (0.05 * ratio), Color.BLACK, 1);

        g.setColor(Color.black);
        g.fillOval((int) (this.O3.x - 0.3 * ratio),
                (int) (this.O3.y + 0.3 * ratio * reverse),
                (int) (2 * 0.3 * ratio), (int) (2 * 0.3 * ratio));

        g.setColor(Color.white);
        g.fillOval((int) (this.O3.x - 0.2 * ratio),
                (int) (this.O3.y + 0.2 * ratio * reverse),
                (int) (2 * 0.2 * ratio), (int) (2 * 0.2 * ratio));

        g.setColor(Color.black);
        g.fillOval((int) (this.O3.x - 0.05 * ratio),
                (int) (this.O3.y + 0.05 * ratio * reverse),
                (int) (2 * 0.05 * ratio), (int) (2 * 0.05 * ratio));

        this.img = new Draw2D(this.img).drawCircle(this.O4, (int) (0.3 * ratio), Color.BLACK, 1);
        this.img = new Draw2D(this.img).drawCircle(this.O4, (int) (0.2 * ratio), Color.BLACK, 1);
        this.img = new Draw2D(this.img).drawCircle(this.O4, (int) (0.05 * ratio), Color.BLACK, 1);

        g.setColor(Color.black);
        g.fillOval((int) (this.O4.x - 0.3 * ratio),
                (int) (this.O4.y + 0.3 * ratio * reverse),
                (int) (2 * 0.3 * ratio), (int) (2 * 0.3 * ratio));

        g.setColor(Color.white);
        g.fillOval((int) (this.O4.x - 0.2 * ratio),
                (int) (this.O4.y + 0.2 * ratio * reverse),
                (int) (2 * 0.2 * ratio), (int) (2 * 0.2 * ratio));

        g.setColor(Color.black);
        g.fillOval((int) (this.O4.x - 0.05 * ratio),
                (int) (this.O4.y + 0.05 * ratio * reverse),
                (int) (2 * 0.05 * ratio), (int) (2 * 0.05 * ratio));

        drawWheels(key);
        return this.img;
    }
}
