package Stayfishy;

public class Corydoras_Sterbai extends Animal{
    ControlMethods controlMethods = new ControlMethods();

    public Corydoras_Sterbai(){
        setName(controlMethods.inputString());

        setGender(controlMethods.inputString());


    }
}
