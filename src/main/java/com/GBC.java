package com;

import java.awt.*;

public class GBC extends GridBagConstraints {
    public GBC(int gridwidth ,int fill,double weightx) {

        this.gridwidth = gridwidth;
//        this.fill = GridBagConstraints.HORIZONTAL;
        this.fill = fill;
        this.weightx = weightx;
        this.weighty=0.001;
//        this.anchor = GridBagConstraints.NORTH;
    }
}
