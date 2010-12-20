package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PlanetMartian extends Planet {
	private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/planetMartian.png");

    @Override
    public String getName() {
        return "PlanetMartian";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }
}
