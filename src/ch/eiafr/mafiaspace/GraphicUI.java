package ch.eiafr.mafiaspace;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicUI extends JFrame implements WorldObserver {

    private WorldManager worldManager;
    
    public GraphicUI(WorldManager worldManager)
    {
        super("Mafia - Spacelife");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.worldManager = worldManager;
        
        this.setSize(new Dimension(800,600));
        
        GridBagConstraints gdc = GridBagHelper.createGDC();
        setLayout(new GridBagLayout());
        
        JButton playB   = new JButton(">");
        JButton pauseB  = new JButton("||");
        JButton stopB   = new JButton("[]");
        JButton nStepB  = new JButton("|>");
        
        
        add(new ViewPanel(worldManager.getWorld()),GridBagHelper.modifyGDC(gdc,1,4,10,10,0,0));
        add(playB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,0));
        add(pauseB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,1));
        add(stopB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,2));
        add(nStepB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,3));
        
        

        this.setVisible(true);
        setLocationRelativeTo(null);
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
}