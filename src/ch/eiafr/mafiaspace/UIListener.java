package ch.eiafr.mafiaspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIListener implements ActionListener{
    
    private WorldManager wm;
    private GraphicUI ui;    
    private boolean running;
    private Thread t;
    
    public UIListener(WorldManager wm,GraphicUI ui)
    {
        this.wm = wm;
        running = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent act) {
        if(act.getActionCommand().equals("nstep")){
            wm.nextTurn();          
        }
        else if(act.getActionCommand().equals("play")){
            running = true;
            this.t = new Thread() {
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
            t.start();
        }
        else if(act.getActionCommand().equals("pause")){
            running = false;
        }
    }
    

}
