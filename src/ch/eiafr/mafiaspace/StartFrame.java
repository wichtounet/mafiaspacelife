package ch.eiafr.mafiaspace;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Frame loaded at the start of the application to set
 * the game and the wanted user interface
 * 
 * @author Jérémy Singy
 */
public class StartFrame extends JFrame implements ActionListener {
    
    private static String WORLDS_DIRECTORY = "/worlds";
    private static final String[] WORLDS = {
                                              "mafiaworld_actions.txt",
                                              "mafiaworld_gay.txt",
                                              "mafiaworld1.txt",
                                              "mafiaworld2.xml",
                                              "spaceworld1.txt",
                                              "spaceworld_blackhole.txt"
                                           };
    
    private JLabel       lbTitle     = new JLabel("MafiaSpaceLife");
    private JLabel       lbWelcome   = new JLabel("Welcome to MafiaSpaceLife!"); 
    private JLabel       lbChoose    = new JLabel("Choose a world and the way you want to launch it (graphical or console UI).");
    private JList        listWorlds  = new JList(WORLDS);
    private JLabel       lbWorlds    = new JLabel("Worlds:");
    private JScrollPane  scrollList  = new JScrollPane(listWorlds);
    private JLabel       lbUI        = new JLabel("User interface:");
    private ButtonGroup  buttons     = new ButtonGroup();
    private JRadioButton btConsole   = new JRadioButton("Console UI");
    private JRadioButton btGraphical = new JRadioButton("Graphical UI", true);
    private JButton      btLaunch    = new JButton("Launch");
    
    public StartFrame() {
        setTitle("MafiaSpaceLife");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        
        buildUI();
        setVisible(true);
    }
    
    private void buildUI() {
        lbTitle.setFont(lbTitle.getFont().deriveFont(20.f));
        buttons.add(btConsole);
        buttons.add(btGraphical);
        btLaunch.addActionListener(this);
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = GridBagHelper.createGDC();
        gbc.fill = GridBagConstraints.NONE;
        GridBagHelper.modifyGDC(gbc, 3, 1, 1, 1, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(lbTitle, gbc);
        
        GridBagHelper.modifyGDC(gbc, 3, 1, 1, 1, 0, 1);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        add(lbWelcome, gbc);
        
        GridBagHelper.modifyGDC(gbc, 3, 1, 1, 1, 0, 2);
        add(lbChoose, gbc);
        
        GridBagHelper.modifyGDC(gbc, 1, 1, 1, 2, 0, 3);
        add(lbWorlds, gbc);
        
        listWorlds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        GridBagHelper.modifyGDC(gbc, 2, 1, 1, 1, 1, 3);
        
        if(listWorlds.getModel().getSize() > 0)
            listWorlds.setSelectedIndex(0);
        
        add(scrollList, gbc);
        
        GridBagHelper.modifyGDC(gbc, 1, 1, 1, 1, 0, 4);
        add(lbUI, gbc);
        
        GridBagHelper.modifyGDC(gbc, 1, 1, 1, 1, 1, 4);
        add(btConsole, gbc);
        GridBagHelper.modifyGDC(gbc, 1, 1, 1, 1, 2, 4);
        add(btGraphical, gbc);
        
        GridBagHelper.modifyGDC(gbc, 3, 1, 1, 1, 0, 5);
        add(btLaunch, gbc);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        WorldManagerFactory managerFactory = new WorldManagerFactory();
        ReaderFactory       readerFactory  = new ReaderFactory();
        
        Object[] values = listWorlds.getSelectedValues();
        
        if(values.length == 0) {
            JOptionPane.showMessageDialog(this, "Please select an available world",
                                          "No world selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String worldName = (String)values[0];
        
        // Create the world and the world manager from the world file
        try {
            final Reader       worldReader  = readerFactory.createReader(WORLDS_DIRECTORY + "/" + worldName);
            final World        world        = worldReader.readWorld(WORLDS_DIRECTORY + "/" + worldName);
            final WorldManager worldManager = managerFactory.createWorldManager(world.getType());
            
            worldManager.setWorld(world);
            
            // Launch the user interface
            if(btConsole.isSelected()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new ConsoleUI(worldManager);
                    }
                }).start();
            }
            else {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new GraphicUI(worldManager);
                    }
                });
            }
            
            dispose();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Unable to load the file '" + worldName +
                                          "'. Please check the consistency of the file.",
                                          "Error in world file",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }
}
