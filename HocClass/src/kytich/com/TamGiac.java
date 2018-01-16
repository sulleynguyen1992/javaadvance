/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com;

import java.text.DecimalFormat;

/**
 *
 * @author sulleynguyen
 */
public class TamGiac {

    int canhA;
    int canhB;
    int canhC;

    public TamGiac() {
        super();
    }

    public TamGiac(int canhA, int canhB, int canhC) {
        this.canhA = canhA;
        this.canhB = canhB;
        this.canhC = canhC;
    }

    public int getCanhA() {
        return canhA;
    }

    public void setCanhA(int canhA) {
        this.canhA = canhA;
    }

    public int getCanhB() {
        return canhB;
    }

    public void setCanhB(int canhB) {
        this.canhB = canhB;
    }

    public int getCanhC() {
        return canhC;
    }

    public void setCanhC(int canhC) {
        this.canhC = canhC;
    }

    @Override
    public String toString() {
        String s = "Canh A: " + this.canhA + "\n"
                + "Canh B: " + this.canhB + "\n"
                + "Canh C: " + this.canhC;
        if(validTamGiac()==false){
        return "Tam giac khong hop le";
        }else{
            DecimalFormat df = new DecimalFormat("#.##");
            return s + "\nChu vi = " + df.format(chuViTamGiac()) +"; Dien tich = " + df.format(dienTichTamGiac());
        }
    }

    private boolean validTamGiac() {
        boolean checkValid = this.canhA > 0 && this.canhB > 0 && this.canhC > 0
                && (this.canhA + this.canhB) > this.canhC
                && (this.canhA + this.canhC) > this.canhB
                && (this.canhB + this.canhC) > this.canhA;

        return checkValid;
    }

    public double chuViTamGiac() {
        return this.canhA + this.canhB + this.canhC;
    }

    public double dienTichTamGiac() {
        double p = chuViTamGiac() / 2;
        double dienTich = Math.sqrt(p * (p - this.canhA) * (p - this.canhB) * (p - this.canhC));
        return dienTich;
    }

}
