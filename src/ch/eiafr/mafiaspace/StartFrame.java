package ch.eiafr.mafiaspace;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class StartFrame extends JFrame {
    
    public static String WORLDS_DIRECTORY = "levels";
    
    private JLabel lbTitle           = new JLabel("MafiaSpaceLife");
    private JLabel lbWelcome         = new JLabel("Welcome to MafiaSpaceLife!"); 
    private JLabel lbChoose          = new JLabel("Choose a world and the way you want to launch it (graphical or console UI).");
    private JList  listWorlds        = new JList(getWorldFiles());
    private JScrollPane scrollList   = new JScrollPane(listWorlds);
    private JRadioButton btConsole   = new JRadioButton("Console UI", true);
    private JRadioButton btGraphical = new JRadioButton("Graphical UI");
    private ButtonGroup buttons      = new ButtonGroup();
    private JButton btLaunch         = new JButton("Launch");
    
    public StartFrame() {
        setSize(640, 480);
        setTitle("MafiaSpaceLife");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildUI();
        setVisible(true);
        setResizable(false);
    }
    
    private void buildUI() {
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = GridBagHelper.createGDC();
        gbc.fill = GridBagConstraints.NONE;
        GridBagHelper.modifyGDC(gbc, 2, 1, 1, 1, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(lbTitle, gbc);
        
        GridBagHelper.modifyGDC(gbc, 2, 1, 1, 1, 0, 1);
        gbc.anchor = GridBagConstraints.WEST;
        add(lbWelcome, gbc);
        
        GridBagHelper.modifyGDC(gbc, 2, 1, 1, 1, 0, 2);
        add(lbChoose, gbc);
        
        listWorlds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        GridBagHelper.modifyGDC(gbc, 2, 1, 1, 1, 0, 3);
        add(scrollList, gbc);
        
        buttons.add(btConsole);
        buttons.add(btGraphical);
        
        GridBagHelper.modifyGDC(gbc, 1, 1, 1, 1, 0, 4);
        add(btConsole, gbc);
        GridBagHelper.modifyGDC(gbc, 1, 1, 1, 1, 1, 4);
        add(btGraphical, gbc);
        
        GridBagHelper.modifyGDC(gbc, 2, 1, 1, 1, 1, 5);
        add(btLaunch, gbc);
    }
    
    private File[] getWorldFiles() {
        File directory = new File(WORLDS_DIRECTORY);
        return directory.listFiles();
    }
}
