package N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod;

import N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod.WindowsButtons.WindowButton;

public class WindowsDialog extends Dialog{

    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
