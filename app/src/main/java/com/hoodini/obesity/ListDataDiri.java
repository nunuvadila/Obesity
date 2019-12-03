package com.hoodini.obesity;

import java.io.Serializable;

public class ListDataDiri implements Serializable {
    private String Tb, Bb, Lp;
    private String Ket;
    public ListDataDiri(String tb, String bb, String lp, String ket){
        this.Tb = tb;
        this.Bb = bb;
        this.Lp = lp;
        this.Ket = ket;
    }
    public String getTb(){
        return Tb;
    }
    public String getBb(){
        return Bb;
    }
    public String getLp(){
        return Lp;
    }
    public String getKet() {
        return Ket;
    }

}
