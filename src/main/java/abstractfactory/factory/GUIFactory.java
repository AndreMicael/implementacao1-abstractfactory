package abstractfactory.factory;

import abstractfactory.products.Button;
import abstractfactory.products.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
