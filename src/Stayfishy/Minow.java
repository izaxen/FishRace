package Stayfishy;

public class Minow extends Animal {
    ControlMethods controlMethods = new ControlMethods();

    public Minow() {
        System.out.println(ControlMethods.enterName);
        setName(controlMethods.inputString());
        System.out.println("Insert gender");
        setGender(controlMethods.inputString());

    }


}
