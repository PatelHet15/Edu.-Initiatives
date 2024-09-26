package com.esports;

public class gamefactory {
    public Games getInstance(String type){
        if (type.equals("Small"))
            return new candycrash();
        else if (type.equals("Medium"))
            return new Freefire();
        else    
            return new velorant();
    }
}