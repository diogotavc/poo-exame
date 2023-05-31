import java.time.LocalDate;
import java.util.Objects;

public class Booking {
    private Client client;
    private CampingSpace campingSpace;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking() {
    }

    public Booking(Client client, CampingSpace campingSpace, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.campingSpace = campingSpace;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CampingSpace getCampingSpace() {
        return this.campingSpace;
    }

    public void setCampingSpace(CampingSpace campingSpace) {
        this.campingSpace = campingSpace;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Booking client(Client client) {
        setClient(client);
        return this;
    }

    public Booking campingSpace(CampingSpace campingSpace) {
        setCampingSpace(campingSpace);
        return this;
    }

    public Booking startDate(LocalDate startDate) {
        setStartDate(startDate);
        return this;
    }

    public Booking endDate(LocalDate endDate) {
        setEndDate(endDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(campingSpace, booking.campingSpace) && Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campingSpace, startDate, endDate);
    }

    @Override
    public String toString() {
        return "{" +
            " campingSpace='" + getCampingSpace() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }
}
