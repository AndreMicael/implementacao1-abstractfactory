package abstractfactory.products.windows;

import abstractfactory.products.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Renderizando botao do Windows");
    }
}
