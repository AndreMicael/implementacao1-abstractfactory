package abstractfactory.factory;

import abstractfactory.Plataforma;

public final class GUIFactoryProvider {

    private GUIFactoryProvider() {
    }

    public static GUIFactory obterFabrica(Plataforma plataforma) {
        return switch (plataforma) {
            case WINDOWS -> new WindowsFactory();
            case MAC -> new MacFactory();
        };
    }
}
