package bean;

import bean.enums.FlightStatus;
import bean.enums.FlightType;

import java.sql.Timestamp;
import java.util.Date;

public class Flight {
    private String flightNumber;
    private FlightStatus flightStatus;
    private FlightType flightType;
    private Timestamp departureTime;
    private String city;
    private String terminal;
    private int gate;
    private double priceEconomy;
    private double priceBusiness;

    public double getPriceEconomy() {
        return priceEconomy;
    }

    public void setPriceEconomy(double priceEconomy) {
        this.priceEconomy = priceEconomy;
    }

    public double getPriceBusiness() {
        return priceBusiness;
    }

    public void setPriceBusiness(double priceBusiness) {
        this.priceBusiness = priceBusiness;
    }

    @Override
    public String toString() {
        return "\nFlight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", flightStatus=" + flightStatus +
                ", flightType=" + flightType +
                ", departureTime=" + departureTime +
                ", city='" + city + '\'' +
                ", terminal='" + terminal + '\'' +
                ", gate=" + gate +
                ", priceEconomy=" + priceEconomy +
                ", priceBusiness=" + priceBusiness +
                '}';
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }
}
