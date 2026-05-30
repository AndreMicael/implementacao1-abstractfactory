package abstractfactory.products.mac;

import abstractfactory.products.Button;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Renderizando botao do Mac");
    }
}
