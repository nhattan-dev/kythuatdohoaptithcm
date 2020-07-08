/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import interFace.Tranformation;
import java.awt.Point;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Welcome
 */
public class Shape<T> implements Tranformation{

    @Override
    public void Init(int x, int y) {
    }

    @Override
    public T Rotate(Point root, double alpha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T Shifting(int Sx, int Sy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T Symmetry(Point root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T Scale(Point root, float ratio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
