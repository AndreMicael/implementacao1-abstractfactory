package abstractfactory;

import abstractfactory.factory.GUIFactory;
import abstractfactory.products.Button;
import abstractfactory.products.Checkbox;

public class Application {
    private final Plataforma plataforma;
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        plataforma = factory.getPlataforma();
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        System.out.println("Interface " + plataforma.getNome() + ":");
        button.paint();
        checkbox.paint();
    }
}
