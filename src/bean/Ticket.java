package bean;


import bean.enums.TicketClass;

public class Ticket {
    private TicketClass ticketClass;
    private Double price;
    private String flightNumber;
    private String city;

    @Override
    public String toString() {
        return "\nTicket{" +
                "ticketClass=" + ticketClass +
                ", price=" + price +
                ", flightNumber='" + flightNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
