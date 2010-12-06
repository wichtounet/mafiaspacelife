package ch.eiafr.mafiaspace;


import java.awt.Dimension;
import javax.swing.JFrame;

public class GraphicUI extends JFrame implements WorldObserver{

    private World worldManager;
    
    public GraphicUI(World worldManager)
    {
        super("Mafia - Spacelife");
        this.worldManager = worldManager;
        this.setSize(new Dimension(800,600));
        this.setVisible(true);
        
    }
    
    public void draw()
    {
        
    }
    
    @Override
    public void worldChanged() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void worldEnded() {
        throw new UnsupportedOperationException();
    }
    
    public static void main(String[] arg){
        new GraphicUI(null);
    }
}