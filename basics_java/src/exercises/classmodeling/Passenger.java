package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class Passenger {

    private String name;
    private String boardingPassId;
    private boolean isCrew;

    public Passenger(String name, String boardingPassId, boolean isCrew) {
        this.name = name;
        this.boardingPassId = boardingPassId;
        this.isCrew = isCrew;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoardingPassId() {
        return boardingPassId;
    }

    public void setBoardingPassId(String boardingPassId) {
        this.boardingPassId = boardingPassId;
    }
}
