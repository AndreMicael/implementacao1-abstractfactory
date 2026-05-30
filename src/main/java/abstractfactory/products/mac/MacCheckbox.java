package abstractfactory.products.mac;

import abstractfactory.products.Checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox do Mac");
    }
}
