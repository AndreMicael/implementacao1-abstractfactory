package abstractfactory;

import abstractfactory.factory.GUIFactory;
import abstractfactory.factory.MacFactory;
import abstractfactory.factory.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        String os = "Windows"; // pode trocar para "Mac"

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.render();
    }
}
