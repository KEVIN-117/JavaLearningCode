package N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod.WebButtons;

import N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod.Button;

public class HTMLButton implements Button {
    @Override
    public void render(int a, int b) {
        System.out.println("HTMLButton " + a+b);
    }

    @Override
    public void onClick(String f) {
        System.out.println("HTMLButton " + f);
    }
}
