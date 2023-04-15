package N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod;

import N_27_DESIGN_PATTERNS.Creational_Patterns.FactoryMethod.LinuxButtons.LinuxButton;

public class LinuxDialog extends Dialog {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
}
