package ch.eiafr.mafiaspace;

public class MafiaCaseFactory extends CaseFactory {
    @Override
    public Case createElement(int type) {
        Case c = null;

        switch(type){
            case 1:
                return new Case(new Godfather());
            case 2:
                return 
        }

        return c;
    }
}