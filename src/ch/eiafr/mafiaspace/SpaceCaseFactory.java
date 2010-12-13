package ch.eiafr.mafiaspace;

public class SpaceCaseFactory extends CaseFactory {
    @Override
    public Case createElement(int type) {
        switch (type) {
            case 0:
                return new Case(null);
            case 1:
                return new Case(new Asteroid());
            case 2:
                return new Case(new Planet());
            case 3:
                return new Case(new Blackhole());
            case 4:
                return new Case(new Martian());
            case 5:
                return new Case(new Kryptonian());
        }

        return null;
    }
}