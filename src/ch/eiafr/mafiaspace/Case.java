package ch.eiafr.mafiaspace;

import javax.swing.Icon;

public class Case {
    private Element element;

    public Case(Element element) {
        super();

        this.setElement(element);
    }

    public Icon getIcon() {
        return null;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}