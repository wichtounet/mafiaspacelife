package ch.eiafr.mafiaspace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIListener implements ActionListener{
    
    private WorldManager wm;
    
    public UIListener(WorldManager wm)
    {
        this.wm = wm;
    }
    
    @Override
    public void actionPerformed(ActionEvent act) {
        if(act.getActionCommand().equals("nstep")){
            wm.nextTurn();
            
        }
    }

}
