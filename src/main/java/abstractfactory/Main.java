package abstractfactory;

import abstractfactory.factory.GUIFactory;
import abstractfactory.factory.GUIFactoryProvider;

public class Main {
    public static void main(String[] args) {
        try {
            Plataforma plataforma = resolverPlataforma(args);
            GUIFactory factory = GUIFactoryProvider.obterFabrica(plataforma);

            Application app = new Application(factory);
            app.render();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
            System.err.println("Uso: java abstractfactory.Main [windows|mac]");
            System.exit(1);
        }
    }

    private static Plataforma resolverPlataforma(String[] args) {
        if (args.length > 0) {
            return Plataforma.from(args[0]);
        }

        return Plataforma.detectarSistema();
    }
}
