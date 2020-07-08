/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object3D;

import Object2D.Draw2D;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Welcome
 */
public class Draw3D {
    private BufferedImage img;

    public Draw3D(BufferedImage img) {
        this.img = img;
    }
    
    public BufferedImage drawOxyz(int WIDTH, int HEIGHT){
        //draw Ox
        Point startOx = new Point(WIDTH/5*2 - 1, HEIGHT/2 - 1);
        Point endOx = new Point(WIDTH - 1, HEIGHT/2 - 1);
        img = new Draw2D(img).drawLine(startOx, endOx, Color.BLACK);
        //draw Oy
        Point startOy = new Point(WIDTH/5*2 - 1, 0);
        Point endOy = new Point(WIDTH/5*2 - 1, HEIGHT/2 - 1);
        img = new Draw2D(img).drawLine(startOy, endOy, Color.BLACK);
        //draw Oz
        Point startOz = new Point(WIDTH/5*2 - 1, HEIGHT/2 - 1);
        Point endOz = new Point(WIDTH/5*2 - HEIGHT/2 - 1, HEIGHT - 1);
        img = new Draw2D(img).drawLine(startOz, endOz, Color.BLACK);
        return img;
    }
    
}
