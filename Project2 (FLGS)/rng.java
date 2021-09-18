// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.

import java.lang.Math;

public class rng{
    public double rngValue;

    public double getRngValue(){
        return rngValue;
    }

    public void setRngValue(){
        this.rngValue = Math.random();
    }

}
