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
public class Circle extends Shape{
    private Point root;
    private int r;

    public Circle(Point root, int r) {
        this.root = root;
        this.r = r;
    }

}
