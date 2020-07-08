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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Welcome
 */
public class Clockwatcher {

    private java.awt.Point root;
    private BufferedImage img;
    private int ratio;
    private java.awt.Point A, B, C, D, A1, B1, C1, D1, E, F, G, H, I, J, K;
    private Line lH, lM, lS;

    public Clockwatcher() {
    }

    public Clockwatcher(java.awt.Point root, BufferedImage img, int ratio) {
        this.root = root;
        this.img = img;
        this.ratio = ratio;
        Calculation();
    }

    public Line getlH() {
        return lH;
    }

    public Line getlM() {
        return lM;
    }

    public Line getlS() {
        return lS;
    }

    public java.awt.Point getRoot() {
        return root;
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

    public BufferedImage drawHands() {
        //init
        float h, m, s;

        //get time
        h = Float.parseFloat(new SimpleDateFormat("HH").format(new Date()));
        h = h > 12 ? h - 12 : h;
        m = Float.parseFloat(new SimpleDateFormat("mm").format(new Date()));
        s = Float.parseFloat(new SimpleDateFormat("ss").format(new Date()));

        //convert to float
        h = h + m / 60 + s / 3600;
        m = m + s / 60;

        //to radian
        h = h * 360 / 12;
        m = m * 360 / 60;
        s = s * 360 / 60;
        h = (float) Math.toRadians(h);
        m = (float) Math.toRadians(m);
        s = (float) Math.toRadians(s);

        //initialzation
        Point eH = new Point(this.root.x, (int) (this.root.y + 0.8 * this.ratio));
        Point eM = new Point(this.root.x, (int) (this.root.y + 1.3 * this.ratio));
        Point eS = new Point(this.root.x, (int) (this.root.y + 1.8 * this.ratio));

        //rotate
        Point start = new Point(this.root.x, (int) (this.root.y - 0.3 * this.ratio));
        lH = new Line(start, eH).Rotate(root, h + Math.PI);
        lM = new Line(start, eM).Rotate(root, m + Math.PI);
        lS = new Line(start, eS).Rotate(root, s + Math.PI);

        //match
        this.img = new Draw2D(this.img).drawLine(lH.getStart().toJavaPoint(),
                lH.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(lM.getStart().toJavaPoint(),
                lM.getEnd().toJavaPoint(), Color.BLACK);
        this.img = new Draw2D(this.img).drawLine(lS.getStart().toJavaPoint(),
                lS.getEnd().toJavaPoint(), Color.BLACK);

        return this.img;
    }

    public BufferedImage drawPendulum(float alpha) {
        //init
        int reverse = -1;
        float var;
        Graphics g = this.img.getGraphics();

        //rotate
        this.G = new Point(this.G.x, this.G.y).Rotate(this.F, alpha);
        this.H = new Point(this.H.x, this.H.y).Rotate(this.E, alpha);

        //get I point
        var = (float) (Math.sqrt(Math.pow(0.6, 2) - Math.pow(0.05, 2)));
        this.J = new Point((int) this.F.getX(), (int) this.F.getY()).Scale(this.E, 0.5f);
        this.K = new Point((int) this.G.getX(), (int) this.G.getY()).Scale(this.H, 0.5f);
        this.I = new Point(this.K.x, this.K.y).Scale(this.J, (float) (1 + var / 3.3));

        //match
        this.img = new Draw2D(this.img).drawLine(this.E, this.H, Color.LIGHT_GRAY);
        this.img = new Draw2D(this.img).drawLine(this.F, this.G, Color.LIGHT_GRAY);
        this.img = new Draw2D(this.img).drawCircle(this.I,
                (int) Math.round(0.6 * this.ratio), Color.ORANGE, 1);

        //fill
        int xP[] = new int[4], yP[] = new int[4], n = 4;
        xP[0] = this.E.x;
        xP[1] = this.F.x;
        xP[2] = this.G.x;
        xP[3] = this.H.x;
        yP[0] = this.E.y;
        yP[1] = this.F.y;
        yP[2] = this.G.y;
        yP[3] = this.H.y;
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(xP, yP, n);
        g.setColor(Color.ORANGE);
        g.fillOval((int) (this.I.x - 0.6 * this.ratio),
                (int) (this.I.y + 0.6 * this.ratio * reverse),
                (int) (2 * 0.6 * this.ratio),
                (int) (2 * 0.6 * this.ratio));

        return this.img;
    }

    private void Calculation() {
        //init
        int reverse = -1;
        int x, y;

        //get value
        float var = (float) (Math.sqrt(Math.pow(2.2, 2) - Math.pow(1.45, 2)));
        x = (int) Math.round(this.root.x - 1.45 * this.ratio);
        y = (int) Math.round(this.root.y + 3.2 * this.ratio * reverse);
        this.A = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.45 * this.ratio);
        y = (int) Math.round(this.root.y + 3.2 * this.ratio * reverse);
        this.B = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.45 * this.ratio);
        y = (int) Math.round(this.root.y - 7 * ratio * reverse);
        this.C = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1.45 * this.ratio);
        y = (int) Math.round(this.root.y - 7 * this.ratio * reverse);
        this.D = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1.45 * this.ratio);
        y = (int) Math.round(this.root.y + var * this.ratio * reverse);
        this.A1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.45 * this.ratio);
        y = (int) Math.round(this.root.y + var * this.ratio * reverse);
        this.B1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 1.45 * this.ratio);
        y = (int) Math.round(this.root.y - var * this.ratio * reverse);
        this.C1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 1.45 * this.ratio);
        y = (int) Math.round(this.root.y - var * this.ratio * reverse);
        this.D1 = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 0.05 * this.ratio);
        y = (int) Math.round(this.root.y - 2.2 * this.ratio * reverse);
        this.E = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 0.05 * this.ratio);
        y = (int) Math.round(this.root.y - 2.2 * this.ratio * reverse);
        this.F = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x + 0.05 * this.ratio);
        y = (int) Math.round(this.root.y - (2.2 * this.ratio + 3.3 * this.ratio) * reverse);
        this.G = new java.awt.Point(x, y);

        x = (int) Math.round(this.root.x - 0.05 * this.ratio);
        y = (int) Math.round(this.root.y - (2.2 * this.ratio + 3.3 * this.ratio) * reverse);
        this.H = new java.awt.Point(x, y);

    }

    public BufferedImage draw(float alpha) {
        //init
        int reverse = -1;
        Graphics g = this.img.getGraphics();

        float var = (float) (Math.sqrt(Math.pow(2.2, 2) - Math.pow(1.45, 2)));

        //match
        this.img = new Draw2D(this.img).drawLine(this.A, this.A1, Color.DARK_GRAY);
        this.img = new Draw2D(this.img).drawLine(this.B, this.B1, Color.DARK_GRAY);
        this.img = new Draw2D(this.img).drawLine(this.C, this.C1, Color.DARK_GRAY);
        this.img = new Draw2D(this.img).drawLine(this.D, this.D1, Color.DARK_GRAY);
        this.img = new Draw2D(this.img).drawLine(this.A, this.B, Color.DARK_GRAY);
        this.img = new Draw2D(this.img).drawLine(this.C, this.D, Color.DARK_GRAY);
        this.img = new Draw2D(this.img).drawCircle(this.root,
                (int) Math.round(2.2 * this.ratio), Color.CYAN, 1);
        this.img = new Draw2D(this.img).drawCircle(this.root,
                (int) Math.round(0.13 * this.ratio), Color.BLACK, 1);
        var = (int) Math.round(0.13 * this.ratio);

        //fill
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.A.x, this.A.y, (int) (2.9 * this.ratio),
                (int) (this.ratio * 10.2));

        g.setColor(Color.CYAN);
        g.fillOval((int) (this.root.x - 2.2 * this.ratio),
                (int) (this.root.y + 2.2 * this.ratio * reverse),
                (int) (2 * 2.2 * this.ratio),
                (int) (2 * 2.2 * this.ratio));

        g.setColor(Color.BLACK);
        g.fillOval((int) (this.root.x - var), (int) (this.root.y - var),
                (int) (2 * var), (int) (2 * var));

        //draw number
        g.setColor(Color.BLACK);
        g.drawString("XII", this.root.x - 5, (int) (this.root.y
                + (2.2 * this.ratio - 0.38 * this.ratio) * reverse));
        g.drawString("VI", this.root.x - 4,
                (int) (this.root.y - (2.2 * this.ratio - 0.1 * this.ratio) * reverse));
        g.drawString("III", (int) (this.root.x + 2.2 * this.ratio - 0.31 * this.ratio),
                this.root.y + 4);
        g.drawString("IX", (int) (this.root.x - 2.2 * this.ratio + 0.1 * this.ratio),
                this.root.y + 4);
        drawHands();
        drawPendulum(alpha);
        return this.img;
    }
}
