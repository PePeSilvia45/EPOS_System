package jrp.epos_ui.classes;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class DragListener extends MouseInputAdapter
{
    //Used to allow the user to drag windows using the mouse
    
    Point location;
    MouseEvent pressed;
 
    @Override
    public void mousePressed(MouseEvent me)
    {
        pressed = me;
    }
 
    @Override
    public void mouseDragged(MouseEvent me)
    {
        Component component = me.getComponent();
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
     }
}