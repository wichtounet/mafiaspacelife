package ch.eiafr.mafiaspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for the User interface
 * 
 * @author Butty Xavier
 *
 */
public class UIListener implements ActionListener{
    
    private WorldManager wm;
    private GraphicUI ui;    
    private boolean running;
    private Thread runningThread;
    
    public UIListener(WorldManager wm,GraphicUI ui)
    {
        this.wm = wm;
        this.ui = ui;
        running = false;
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
                        try {
                                Thread.sleep(500);
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
    

}
