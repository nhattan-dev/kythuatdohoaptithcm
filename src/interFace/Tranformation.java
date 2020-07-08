/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interFace;

import java.awt.Point;

/**
 *
 * @author Welcome
 */
public interface Tranformation<T> {
    void Init(int x, int y);
    //rorate this point around the root point an alpha angle
    T Rotate(Point root, double alpha);
    //Scale with center as the root point
    T Scale(Point root, float ratio);
    //shifting this point with distance Sx, Sy
    T Shifting(int Sx, int Sy);
    //Symetry this point through the root point 
    T Symmetry(Point root);
}
