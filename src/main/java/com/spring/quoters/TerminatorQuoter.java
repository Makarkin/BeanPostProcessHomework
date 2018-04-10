package com.spring.quoters;

import com.spring.injection.InjectRandom;

public class TerminatorQuoter implements Quoter {

    @InjectRandom(min=1, max=5)
    private int repeat;

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public void saySmth() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(" I'm terminator");
        }
    }
}

