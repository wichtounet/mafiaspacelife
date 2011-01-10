package ch.eiafr.mafiaspace;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicUI extends JFrame implements WorldObserver {

    private WorldManager wm;
    
    public GraphicUI(WorldManager worldManager)
    {
        super("Mafia - Spacelife");
        wm = worldManager;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(new Dimension(800,600));
        
        GridBagConstraints gdc = GridBagHelper.createGDC();
        setLayout(new GridBagLayout());
        
        UIListener listener = new UIListener(worldManager);
        
        JButton playB   = new JButton(">");
        JButton pauseB  = new JButton("||");
        JButton stopB   = new JButton("[]");
        JButton nStepB  = new JButton("|>");
        
        nStepB.setActionCommand("nstep");
        nStepB.addActionListener(listener);
        
        wm.world.addObserver(this);
        
        add(new ViewPanel(worldManager.world),GridBagHelper.modifyGDC(gdc,1,4,10,10,0,0));
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
        repaint();
    }

    @Override
    public void worldEnded() {
        throw new UnsupportedOperationException();
    }
    
    
}