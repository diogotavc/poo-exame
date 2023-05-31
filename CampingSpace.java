import java.util.Objects;

public class CampingSpace {
    private int[] minDimensions;
    private SpaceType type;
    private int pricePerDay;

    public CampingSpace() {
    }

    public CampingSpace(int[] minDimensions, SpaceType type, int pricePerDay) {
        this.minDimensions = minDimensions;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    public int[] getMinDimensions() {
        return this.minDimensions;
    }

    public void setMinDimensions(int[] minDimensions) {
        this.minDimensions = minDimensions;
    }

    public SpaceType getType() {
        return this.type;
    }

    public void setgetType(SpaceType type) {
        this.type = type;
    }

    public int getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public CampingSpace minDimensions(int[] minDimensions){
        setMinDimensions(minDimensions);
        return this;
    }

    public CampingSpace type(SpaceType type){
        setgetType(type);
        return this;
    }

    public CampingSpace pricePerDay(int pricePerDay){
        setPricePerDay(pricePerDay);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CampingSpace)) {
            return false;
        }
        CampingSpace campingSpace = (CampingSpace) o;
        return minDimensions == campingSpace.minDimensions && Objects.equals(type, campingSpace.type) && Objects.equals(pricePerDay, campingSpace.pricePerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minDimensions, type, pricePerDay);
    }

    @Override
    public String toString() {
        return "{" +
            " minDimensions='" + getMinDimensions() + "'" +
            ", type='" + getType() + "'" +
            ", pricePerDay='" + getPricePerDay() + "'" +
            "}";
    }
}
