package ch.eiafr.mafiaspace;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicUI extends JFrame implements WorldObserver {

    private WorldManager wm;
    private ViewPanel gamePanel;
    
    public GraphicUI(WorldManager worldManager)
    {
        super(worldManager.getWorld().getType());
        wm = worldManager;

        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(new Dimension(800,600));
        
        GridBagConstraints gdc = GridBagHelper.createGDC();
        setLayout(new GridBagLayout());
        
        UIListener listener = new UIListener(worldManager,this);
        
        JButton playB   = new JButton(new ImageIcon(getClass().getResource("/res/play.png")));
        JButton pauseB  = new JButton(new ImageIcon(getClass().getResource("/res/pause.png")));
        JButton nStepB  = new JButton(new ImageIcon(getClass().getResource("/res/stepForward.png")));
        
        nStepB.setActionCommand("nstep");
        pauseB.setActionCommand("pause");
        playB.setActionCommand("play");
        pauseB.addActionListener(listener);
        nStepB.addActionListener(listener);
        playB.addActionListener(listener);
        
        wm.getWorld().addObserver(this);
        
        gamePanel = new ViewPanel(worldManager.getWorld());
        
        add(gamePanel,GridBagHelper.modifyGDC(gdc,1,4,100,10,0,0));
        add(playB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,0));
        add(pauseB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,1));
        add(nStepB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,2));
        
        

        this.setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void draw()
    {
        
    }
    
    @Override
    public void worldChanged() {
    }

    @Override
    public void worldEnded() {
        throw new UnsupportedOperationException();
    }
}