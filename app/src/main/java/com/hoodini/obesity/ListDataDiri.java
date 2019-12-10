package com.hoodini.obesity;

import java.io.Serializable;

public class ListDataDiri implements Serializable {
    private Long tb, bb, lp;
    private Double kes;
    private String ket;

    public ListDataDiri() { }
    public ListDataDiri( Long bb, String ket, Long lp, Long tb, Double kes){
        this.bb = bb;
        this.ket = ket;
        this.lp = lp;
        this.tb = tb;
        this.kes = kes;
    }


    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public Long getTb() {
        return tb;
    }

    public void setTb(Long tb) {
        this.tb = tb;
    }

    public Long getBb() {
        return bb;
    }

    public void setBb(Long bb) {
        this.bb = bb;
    }

    public Long getLp() {
        return lp;
    }

    public void setLp(Long lp) {
        this.lp = lp;
    }

    public Double getKes() {
        return kes;
    }

    public void setKes(Double kes) {
        this.kes = kes;
    }
}
