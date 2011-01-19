package ch.eiafr.mafiaspace;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ViewPanel extends JPanel implements WorldObserver{

    /**
     * 
     */
    private static final long serialVersionUID = 1545273982467122921L;
    
    private World       world;
     
    
    public ViewPanel(World world)
    {
        this.world = world;
        this.world.addObserver(this);
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
                
        //g2d.setPaint(new GradientPaint(x,y, Color.white, x+150, y+150, Color.blue));
        g2d.setPaint(Color.white);
        g2d.fill(square);
        
        g2d.setColor(Color.BLACK);
        

        g2d.draw(square);
        
        // Get and print the case icon
        if(c.getIcon()!=null)
        {
            ImageIcon icon = (ImageIcon) c.getIcon();
            Image img = icon.getImage(); 
            Image newimg;
            
            if(caseWidth<caseHeight)
                newimg = img.getScaledInstance(caseWidth, caseWidth,  java.awt.Image.SCALE_SMOOTH);  
            else
                newimg = img.getScaledInstance(caseHeight, caseHeight,  java.awt.Image.SCALE_SMOOTH);   
 
            ImageIcon newIcon = new ImageIcon(newimg); 
            
            int iconPosX = x;
            int iconPosY = y;
            
            if(newIcon.getIconHeight()<caseHeight)iconPosY+=(caseHeight-newIcon.getIconHeight())/2;
            if(newIcon.getIconWidth()<caseWidth)iconPosX+=(caseWidth-newIcon.getIconWidth())/2;
            
            newIcon.paintIcon(null, g2d, iconPosX, iconPosY);  
        }
        
    }

    @Override
    public void worldChanged() {
        repaint(); 
    }

    @Override
    public void worldEnded() {
        // TODO Auto-generated method stub
        
    }
    
    
    

}
