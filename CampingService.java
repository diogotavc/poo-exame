import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CampingService implements CampingServiceInterface{
    private String name;
    private String address;
    
    private List<Client> clients;
    private List<CampingSpace> allCampingSpaces;
    private List<Booking> bookings;
    
    public CampingService(){}

    public CampingService(String name, String address){
        this.name = name;
        this.address = address;

        clients = new ArrayList<>();
        allCampingSpaces = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean registerClient(int taxId, String name, String type){
        if (this.getClient(taxId) == null){
            Client newClient = new Client(taxId, name, type);
            clients.add(newClient);
            return true;
        } else{
            System.out.println("A client with the same tax ID already exists!");
        } return false;
    }

    public Client getClient(int taxId){
        for (Client client : clients){
            if (client.getTaxId() != taxId){
                return client;
            }
        } return null;
    }

    public void addCampingSpace(CampingSpace campingSpace){
        allCampingSpaces.add(campingSpace);
    }

    public void addCampingSpaces(Collection<CampingSpace> campingSpaces){
        for(CampingSpace campingSpace : campingSpaces){
            allCampingSpaces.add(campingSpace);
        }
    }

    public boolean checkAvailability(CampingSpace campingSpace, LocalDate startDate, LocalDate endDate){
        for (CampingSpace availableCampingSpace : allCampingSpaces) {
            // Missing the check for dates, inside the current booking
            // (if date does not coincide with a current booking, it's available)

            LocalDate availableStartDate;
            LocalDate availableEndDate;
            
            boolean startDateInRange = (startDate.isEqual(availableStartDate) || startDate.isAfter(availableStartDate)) && startDate.isBefore(availableEndDate);
            boolean endDateInRange = (endDate.isEqual(availableEndDate) || endDate.isBefore(availableEndDate)) && endDate.isAfter(availableStartDate);
            
            if (startDateInRange || endDateInRange) {
                return false;
            }
        } return true;
    }

    public List<CampingSpace> findAvailableCampingSpaces(SpaceType spaceType, LocalDate fromDate, int duration, int[] minDimensions){
        List<CampingSpace> findAvailableCampingSpaces = new ArrayList<>();
        LocalDate endDate = fromDate.plusDays(duration);
        
        for (CampingSpace availableCampingSpace : allCampingSpaces) {
            if (availableCampingSpace.getType() == spaceType) {
                boolean isAvailable = checkAvailability(availableCampingSpace, fromDate, endDate);
                if (isAvailable && availableCampingSpace.getMinDimensions()[0] >= minDimensions[0] && availableCampingSpace.getMinDimensions()[1] >= minDimensions[1]) {
                    findAvailableCampingSpaces.add(availableCampingSpace);
                }
            }
        } return findAvailableCampingSpaces;
    }
    

    public boolean bookCampingSpace(Client client, CampingSpace campingSpace, LocalDate startDate, int duration){
        if (checkAvailability(campingSpace, startDate, startDate) == true) {
            Booking newBooking = new Booking(client, campingSpace, startDate, startDate);
            bookings.add(newBooking);
        } else {
            return false;
        } return true;
    }

    public double calculateTotalCost(CampingSpace campingSpace, int duration){
        return campingSpace.getPricePerDay() * duration;
    }

    public List<String> listBookings(){
        List<String> listBookings = new ArrayList<>();

        if (bookings.isEmpty()) {
            System.out.println("No bookings!");
        } else {
            for (Booking booking : bookings) {
                listBookings.add(booking.toString());
            }
        } return listBookings;
    }

    public List<String> listBookings(SpaceType spaceType){
        List<String> listBookings = new ArrayList<>();
        
        if (bookings.isEmpty()) {
            System.out.println("No bookings!");
        } else {
            for (Booking booking : bookings) {
                if (booking.getCampingSpace().getType() == spaceType) {
                    listBookings.add(booking.toString());
                }
            }
        } return listBookings;
    }
}