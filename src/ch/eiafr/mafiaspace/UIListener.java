package ch.eiafr.mafiaspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Listener for the User interface
 * 
 * @author Butty Xavier
 *
 */
public class UIListener implements ActionListener, ChangeListener{
    
    public final static int SPEED = 50;
    
    private WorldManager wm;
    private GraphicUI ui;    
    private boolean running;
    private Thread runningThread;
    private int    speed;
    
    public UIListener(WorldManager wm,GraphicUI ui)
    {
        this.wm = wm;
        this.ui = ui;
        running = false;
        speed   = SPEED;
    }
    
    @Override
    public void actionPerformed(ActionEvent act) {
        if(act.getActionCommand().equals("nstep")){
            wm.nextTurn();          
        }
        else if(act.getActionCommand().equals("play")){
            
            running = true;
            
            // Thread to run the game
            this.runningThread = new Thread() {
                public void run() {
                    while(running){
                        wm.nextTurn();
                        if(wm.isWorldEnded()){
                            running = false;
                        }
                        try {
                                Thread.sleep((1000)/(speed+1));
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                                Thread.currentThread().interrupt();
                        }
                    }
                }
            };
            runningThread.start();
            
            ui.playing(running);
        }
        else if(act.getActionCommand().equals("pause")){
            running = false;
            ui.playing(running);
        }       
    }
    
    public void stop()
    {
       running = false; 
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
        if (e.getSource() instanceof JSlider){
            JSlider source = (JSlider)e.getSource(); 
            if(source.getName().equals("speedSlider"))
              speed = source.getValue();              
          }
        
    }
    

}
