package abstractfactory.products.windows;

import abstractfactory.products.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox do Windows");
    }
}
