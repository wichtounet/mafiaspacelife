package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PlanetKryptonian extends Planet {
	private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/planetKryptonian.png");

    @Override
    public String getName() {
        return "PlanetKryptonian";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }
}
