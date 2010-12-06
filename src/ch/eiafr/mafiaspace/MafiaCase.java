package ch.eiafr.mafiaspace;

import javax.swing.Icon;

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
        throw new UnsupportedOperationException();
    }
}