package ch.eiafr.mafiaspace;

import javax.swing.Icon;

public class Case {
    private Element element;

    public Case(Element element) {
        super();

        this.element = element;
    }

    public Icon getIcon() {
        return element.getIcon();
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element == null ? "Empty" : element.getName();
    }

    public boolean isEmpty(){
        return element == null;
    }
}