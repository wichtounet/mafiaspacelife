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
     * @param gdc         The GridBagConstraints to modify
     * @param width       new width  to set
     * @param height      new height to set
     * @param weightx     new weight in x to set
     * @param weighty     new weight in y to set
     * @param x           new position in x to set
     * @param y           new position in y to set
     * 
     * @return GridBagConstraints the GridBagConstraints with the new values;
     */
    public static GridBagConstraints modifyGDC(GridBagConstraints gdc, int width, int height, int weightx, int weighty, int x, int y){
      gdc = new GridBagConstraints();
      gdc.gridheight      = height;
      gdc.gridwidth       = width;
      gdc.weightx         = weightx;
      gdc.weighty         = weighty;
      gdc.gridx           = x;
      gdc.gridy           = y;
      gdc.fill            = GridBagConstraints.BOTH;
      return gdc;
    }

}
