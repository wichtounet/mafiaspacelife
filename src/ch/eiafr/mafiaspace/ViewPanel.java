package ch.eiafr.mafiaspace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class ViewPanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 1545273982467122921L;
    
    private World       world;
     
    
    public ViewPanel(World world)
    {
        this.world = world;
    }
    
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        
        Case[][] cases = world.getCases();
        
        int caseWidth  = (int)(g.getClipBounds().getWidth()/cases[0].length);
        int caseHeight = (int)(g.getClipBounds().getHeight()/cases.length);
        
        

        
        for(int y=0;y<cases.length;y++)
            for(int x=0;x<cases[0].length;x++)
                paintCase(g2d, cases[y][x],x*caseWidth,y*caseHeight,caseWidth,caseHeight);
     
    }
    
    private void paintCase(Graphics2D g2d, Case c, int x, int y, int caseWidth, int caseHeight)
    {
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, caseWidth, caseHeight);
        
        g2d.setColor(Color.BLUE);
        
        g2d.fill(square);
        
        g2d.setColor(Color.BLACK);
        
        g2d.draw(square);
        
        
        if(c.getElement()!=null)g2d.drawString(c.getElement().getName(), x, y);
        
    }
    
    
    

}
