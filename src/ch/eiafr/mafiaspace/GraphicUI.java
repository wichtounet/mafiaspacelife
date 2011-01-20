package ch.eiafr.mafiaspace;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

/**
 * Main frame of the graphic user interface
 * @author ButtyX
 *
 */
public class GraphicUI extends JFrame implements WorldObserver {

    private WorldManager wm;
    private ViewPanel gamePanel;
    private UIListener listener;
    
    JButton playB;
    JButton pauseB;
    JButton nStepB;
    JSlider speedS;
    JLabel  speedL;
    
    public GraphicUI(WorldManager worldManager)
    {
        super(worldManager.getWorld().getType());
        wm = worldManager;

        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(new Dimension(800,600));
        
        GridBagConstraints gdc = GridBagHelper.createGDC();
        setLayout(new GridBagLayout());
        
        listener = new UIListener(worldManager,this);
        
        playB   = new JButton(new ImageIcon(getClass().getResource("/res/play.png")));
        pauseB  = new JButton(new ImageIcon(getClass().getResource("/res/pause.png")));
        nStepB  = new JButton(new ImageIcon(getClass().getResource("/res/stepForward.png")));
        speedS  = new JSlider(JSlider.VERTICAL,0,100,5);
        speedL  = new JLabel("Speed");
        speedL.setFont(new Font(speedL.getFont().getFontName(),speedL.getFont().getStyle(),15));
        speedL.setHorizontalAlignment(JLabel.CENTER);
        
        speedS.setEnabled(true);
        speedS.setPaintLabels(true);
        speedS.setPaintTicks(true);
        speedS.setPaintLabels(true);
        speedS.setName("speedSlider");
        speedS.setMajorTickSpacing(20);
        speedS.setMinorTickSpacing(10);
        speedS.addChangeListener(listener);
        speedS.setValue(UIListener.SPEED);
        
        nStepB.setActionCommand("nstep");
        pauseB.setActionCommand("pause");
        playB.setActionCommand("play");
        pauseB.addActionListener(listener);
        nStepB.addActionListener(listener);
        playB.addActionListener(listener);
        
        wm.getWorld().addObserver(this);
        
        gamePanel = new ViewPanel(worldManager.getWorld());
        
        add(gamePanel,GridBagHelper.modifyGDC(gdc,1,5,100,10,0,0));
        add(speedL,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,0));
        add(speedS,GridBagHelper.modifyGDC(gdc,1,1,1,10,1,1));
        add(playB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,2));
        add(pauseB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,3));
        add(nStepB,GridBagHelper.modifyGDC(gdc,1,1,1,1,1,4));

        this.setVisible(true);
        setLocationRelativeTo(null);
    }
    
    /**
     * Change the state of the buttons when the game is playing
     * @param state
     */
    public void playing(boolean state)
    {
        if(state)
        {
            playB.setEnabled(false);
            pauseB.setEnabled(true);
            nStepB.setEnabled(false);
        }
        else{
            playB.setEnabled(true);
            pauseB.setEnabled(false);
            nStepB.setEnabled(true);
        }
    }
    
    @Override
    public void worldChanged() {

    }

    @Override
    public void worldEnded() {
        playB.setEnabled(false);
        pauseB.setEnabled(false);
        nStepB.setEnabled(false);
        listener.stop();
        JOptionPane.showInputDialog(null, "Fin du jeu", "Game Over", 0);
    }
}