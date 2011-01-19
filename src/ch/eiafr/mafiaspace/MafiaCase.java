package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MafiaCase extends Case {
    private final boolean casino;

    public MafiaCase(Element element, boolean casino) {
        super(element);

        this.casino = casino;
    }

    public boolean isCasino() {
        return casino;
    }

    @Override
    public Icon getIcon() {

        if(isCasino())
        {
            if(getElement()==null)return new ImageIcon(getClass().getResource("/res/casino.png"));
            return new ImageIcon(getClass().getResource("/res/mobster_casino.png"));
        }
        if(getElement()==null)return null;
        return getElement().getIcon();
    }
}