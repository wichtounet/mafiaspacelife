package ch.eiafr.mafiaspace;

public abstract class CaseFactory {
    
    private static final String MAFIA_TYPE = "mafialife";
    private static final String SPACE_TYPE = "spacelife";
    
    public abstract Case createElement(int type);
    
    public static CaseFactory getFactory(String type) {
        if(type.equals(MAFIA_TYPE))
            return new MafiaCaseFactory();
        else if(type.equals(SPACE_TYPE))
            return new SpaceCaseFactory();
        else
            throw new IllegalArgumentException("bad game type");
    }
}