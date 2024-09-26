package Decorator;

public abstract class Plateform_Decorator implements Plateforms{
    protected Plateforms decoratedONS;

    public Plateform_Decorator(Plateforms decoratedONS){
        this.decoratedONS = decoratedONS;
    }

    public void Online_Plateform(){
        decoratedONS.Online_Plateform();
    }
}