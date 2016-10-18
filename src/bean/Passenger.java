package bean;

import bean.enums.Sex;
import bean.enums.TicketClass;

import java.util.Date;

public class Passenger {
    private String firstName;
    private String lastName;
    private String nationality;
    private String passport;
    private Sex sex;
    private String dateOfBirthday;
    private String flightNumber;
    private TicketClass ticketClass;
    private int flightNumberID;

    public int getFlightNumberID() {
        return flightNumberID;
    }

    public void setFlightNumberID(int flightNumberID) {
        this.flightNumberID = flightNumberID;
    }

    @Override
    public String toString() {
        return "\nPassenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passport='" + passport + '\'' +
                ", sex=" + sex +
                ", dateOfBirthday='" + dateOfBirthday + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", ticketClass=" + ticketClass +
                '}';
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }


}
