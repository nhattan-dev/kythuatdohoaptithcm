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
public class Rect extends Shape {

    private java.awt.Point rootS;
    private java.awt.Point rootE;

    public Rect(java.awt.Point rootS, java.awt.Point rootE) {
        this.rootS = rootS;
        this.rootE = rootE;
    }

    public java.awt.Point getRootS() {
        return rootS;
    }

    public void setRootS(java.awt.Point rootS) {
        this.rootS = rootS;
    }

    public java.awt.Point getRootE() {
        return rootE;
    }

    public void setRootE(java.awt.Point rootE) {
        this.rootE = rootE;
    }

    //shifting this point with distance Sx, Sy
    @Override
    public Rect Shifting(int Sx, int Sy) {
        //shifting
        java.awt.Point nRootS = new Point(this.rootS.x, this.rootS.y).Shifting(Sx, Sy);
        java.awt.Point nRootE = new Point(this.rootE.x, this.rootE.y).Shifting(Sx, Sy);
        return new Rect(nRootS, nRootE);
    }

}
