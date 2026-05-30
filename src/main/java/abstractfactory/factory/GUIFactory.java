package abstractfactory.factory;

import abstractfactory.Plataforma;
import abstractfactory.products.Button;
import abstractfactory.products.Checkbox;

public interface GUIFactory {
    Plataforma getPlataforma();

    Button createButton();

    Checkbox createCheckbox();
}
