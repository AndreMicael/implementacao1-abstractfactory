package abstractfactory.factory;

import abstractfactory.Plataforma;
import abstractfactory.products.Button;
import abstractfactory.products.Checkbox;
import abstractfactory.products.mac.MacButton;
import abstractfactory.products.mac.MacCheckbox;

public class MacFactory implements GUIFactory {
    @Override
    public Plataforma getPlataforma() {
        return Plataforma.MAC;
    }

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
