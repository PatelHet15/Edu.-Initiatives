package Decorator;

public class Electronics extends Plateform_Decorator {

    public Electronics(Plateforms decoratedONS) {
        super(decoratedONS);
    }

    @Override
    public void Online_Plateform() {
        decoratedONS.Online_Plateform();
        setElectronics(decoratedONS);
    }

    private void setElectronics(Plateforms decoratedONS) {
        System.out.println("For electronics");
    }
}
