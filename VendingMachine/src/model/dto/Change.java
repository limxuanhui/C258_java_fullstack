package model.dto;
/* Created by limxuanhui on 27/6/22 */

public enum Change {
    QUARTER (0.25),
    DIME(0.10),
    NICKEL(0.05),
    PENNY(0.01);

    private final double v;

    Change(double v) {
        this.v = v;
    }

    public double getV() {
        return v;
    }
}
