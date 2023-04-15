package N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod;

import N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod.WebButtons.HTMLButton;

public class WebDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
