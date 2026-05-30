package abstractfactory.factory;

import abstractfactory.Plataforma;
import abstractfactory.products.Button;
import abstractfactory.products.Checkbox;
import abstractfactory.products.windows.WindowsButton;
import abstractfactory.products.windows.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Plataforma getPlataforma() {
        return Plataforma.WINDOWS;
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
