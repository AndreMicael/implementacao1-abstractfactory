package abstractfactory.factory;

import abstractfactory.products.Button;
import abstractfactory.products.Checkbox;
import abstractfactory.products.mac.MacButton;
import abstractfactory.products.mac.MacCheckbox;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
