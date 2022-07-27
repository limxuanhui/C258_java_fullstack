package dto.enums;
/* Created by limxuanhui on 27/7/22 */

public enum MPAARating {
    TERRIBLE(1),
    BAD(2),
    MEDIOCRE(3),
    GOOD(4),
    EXCELLENT(5);

    public final int ratingValue;

    private MPAARating(int i) {
        this.ratingValue = i;
    }
}
