package ch.eiafr.mafiaspace;

import java.awt.GridBagConstraints;

/**
 * Helper to manage easily a GridBagConstraint
 * 
 * @author Butty Xavier
 *
 */
public class GridBagHelper {

    /**
     * Method to create a default GridBagConstraints
     * 
     * @return GridBagConstraints with default value;
     */
    public static GridBagConstraints createGDC(){
        GridBagConstraints gdc = new GridBagConstraints();
        gdc.gridheight      = 1;
        gdc.gridwidth       = 1;
        gdc.fill            = GridBagConstraints.BOTH;
        gdc.weightx         = 1;
        gdc.weighty         = 1;
        gdc.gridx           = 0;
        gdc.gridy           = 0;

        return gdc;
    }

    /**
     * Method to modify a GridBagConstraints
     * 
     * @param gbc         The GridBagConstraints to modify
     * @param width       new width  to set
     * @param height      new height to set
     * @param weightx     new weight in x to set
     * @param weighty     new weight in y to set
     * @param x           new position in x to set
     * @param y           new position in y to set
     * 
     * @return GridBagConstraints the GridBagConstraints with the new values;
     */
    public static GridBagConstraints modifyGDC(GridBagConstraints gbc, int width, int height, int weightx, int weighty, int x, int y){
        gbc.gridwidth       = width;
        gbc.gridheight      = height;
        gbc.weightx         = weightx;
        gbc.weighty         = weighty;
        gbc.gridx           = x;
        gbc.gridy           = y;

        return gbc;
    }

}
