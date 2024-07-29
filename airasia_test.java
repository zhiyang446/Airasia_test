import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Filght {
    private String filghtNumber;
    private String departuraAirport;
    private String arrivalAirport;
    private Date departureDate;
    private Date arrivalDate;
    private ArrayList<Seat> seats;

    public Filght(String filghtNumber, String departuraAirport, String arrivalAirport, Date departureDate, Date arrivalDate, ArrayList<Seat> seats) {
        this.filghtNumber = filghtNumber;
        this.departuraAirport = departuraAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seats = seats;
    }

    public ArrayList<Seat> findAvailableSeats() {
        ArrayList<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
}

public class Seat {
    private String seatNumber;
    private String seatClass;
    private boolean isAvailable;
    private double price;
    private Flight flight;

    public Seat(String seatNumber, String seatClass, boolean isAvailable, double price, Flight flight) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isAvailable = isAvailable;
        this.price = price;
        this.flight = flight;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

public class Passenger {
    private String passengerID;
    private String name;
    private String email;
    private String phoneNumber;
    private String region;
    private Date dateOfBrith;
    private ArrayList<Reservation> reservations;

    public Passenger(String passengerID, String name, String email, String phoneNumber,String region,Date dateOfBrith) {
        this.passengerID = passengerID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.dateOfBrith = dateOfBrith;
        this.reservations = new ArrayList<>();
    }

    public Reservation createReservation(Flight flight, Seat seat) {
        String reservationID = generateRandomString(8);
        Reservation reservation = new Reservation(reservationID, this, seat, flight, new Date());
        reservations.add(reservation);
        return reservation;
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}

public class Reservation {
    private String reservationID;
    private Passenger passenger;
    private Seat seat;
    private Flight flight;
    private Date reservationDate;

    public Reservation(String reservationID, Passenger passenger, Seat seat, Flight flight, Date reservationDate) {
        this.reservationID = reservationID;
        this.passenger = passenger;
        this.seat = seat;
        this.flight = flight;
        this.reservationDate = reservationDate;
    }
}