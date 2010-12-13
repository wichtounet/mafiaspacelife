package ch.eiafr.mafiaspace;

import java.util.Scanner;

public class ConsoleUI implements WorldObserver {
    private final WorldManager worldManager;

    public ConsoleUI(WorldManager worldManager) {
        super();

        this.worldManager = worldManager;

        System.out.println("The game started !");

        displayWorld(worldManager.getWorld());

        Scanner scanner = new Scanner(System.in);

        while(true){
            String command = scanner.nextLine();

            if("next".equals(command)){
                System.out.println("Next turn -->");
                worldManager.nextTurn();
            }
        }
    }

    @Override
    public void worldChanged() {
        displayWorld(worldManager.getWorld());
    }

    @Override
    public void worldEnded() {
        System.out.println("The game is over !");
        System.out.println("Hope you liked'it !");
    }

    private static void displayWorld(World world) {
        StringBuilder formatBuilder = new StringBuilder(100);

        formatBuilder.append(" | ");

        for(int i = 0; i < world.getCases().length; i++){
            formatBuilder.append("%10s | ");
        }

        formatBuilder.append('\n');

        for(int i = 0; i < world.getCases()[0].length; i++){
            System.out.printf(formatBuilder.toString(), world.getCases()[i]);
        }
    }
}