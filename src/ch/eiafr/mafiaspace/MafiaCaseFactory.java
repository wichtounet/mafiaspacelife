package ch.eiafr.mafiaspace;

public class MafiaCaseFactory extends CaseFactory {
    @Override
    public Case createElement(int type) {
        switch(type){
            case 0:
                return new MafiaCase(null, false);
            case 1:
                return new MafiaCase(new Godfather(), false);
            case 2:
                return new MafiaCase(new Cop(), false);
            case 3:
                return new MafiaCase(new Mobster(), false);
            case 4:
                return new MafiaCase(null, true);
            case 5:
                return new MafiaCase(new Mobster(), true);
        }

        return null;
    }
}