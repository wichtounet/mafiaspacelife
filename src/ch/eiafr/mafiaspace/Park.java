package ch.eiafr.mafiaspace;

public class Park {
    private final Element element;
    private int time;
    private final int flag;

    Park(Element element, int time, int flag) {
        super();

        this.element = element;
        this.time = time;
        this.flag = flag;
    }

    public Element getElement() {
        return element;
    }

    public int getTime() {
        return time;
    }

    public int getFlag() {
        return flag;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
