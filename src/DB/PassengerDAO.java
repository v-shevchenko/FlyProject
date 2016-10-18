package DB;

import bean.*;
import bean.enums.FlightNumberEnum;
import bean.enums.Sex;
import bean.enums.TicketClass;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {

    public static List<Passenger> getPassengers(){
        List<Passenger> passengerList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from PASSENGER  join FLIGHT  on PASSENGER.FLIGHT_ID  = FLIGHT.ID ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String nationality = resultSet.getString("nationality");
                String passport = resultSet.getString("passport");
                String dob = resultSet.getString("date_of_birthday");
                String ticketClass = resultSet.getString("ticket_class");
                String flightNum = resultSet.getString("flight_number");
                String sex = resultSet.getString("sex");
                Passenger passenger = new Passenger();
                passenger.setFirstName(first_name);
                passenger.setLastName(last_name);
                passenger.setSex(Sex.valueOf(sex));
                passenger.setNationality(nationality);
                passenger.setPassport(passport);
                passenger.setDateOfBirthday(dob);
                passenger.setTicketClass(TicketClass.valueOf(ticketClass));
                passenger.setFlightNumber(flightNum);
                passengerList.add(passenger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return passengerList;
    }

    public static List<Passenger> getSearchPassengers(String firstName){
        List<Passenger> passengerList = new ArrayList<>();
        String request = "select * from PASSENGER  join FLIGHT  on PASSENGER.FLIGHT_ID  = FLIGHT.ID where passenger.first_name = '"+firstName+"' or PASSENGER.LAST_NAME = '"+firstName+"' or PASSENGER.PASSPORT  = '"+firstName+"' or FLIGHT .FLIGHT_NUMBER  = '"+firstName+"' or FLIGHT .CITY   = '"+firstName+"'";
        Connection connection = null;
        try {
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String nationality = resultSet.getString("nationality");
                String passport = resultSet.getString("passport");
                String dob = resultSet.getString("date_of_birthday");
                String ticketClass = resultSet.getString("ticket_class");
                String flightNum = resultSet.getString("flight_number");
                String sex = resultSet.getString("sex");
                Passenger passenger = new Passenger();
                passenger.setFirstName(first_name);
                passenger.setLastName(last_name);
                passenger.setSex(Sex.valueOf(sex));
                passenger.setNationality(nationality);
                passenger.setPassport(passport);
                passenger.setDateOfBirthday(dob);
                passenger.setTicketClass(TicketClass.valueOf(ticketClass));
                passenger.setFlightNumber(flightNum);
                passengerList.add(passenger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return passengerList;
    }

    public static Passenger getAddPassenger(JTextField firstName, JTextField lastName, JTextField nationality, JTextField passport, JComboBox<Sex> sexJComboBox,
                                            JTextField dateOfBirthday, JComboBox<TicketClass> ticketClassJComboBox, int flightNumberID){
        Passenger result = new Passenger();
        result.setFirstName(firstName.getText());
        result.setLastName(lastName.getText());
        result.setSex((Sex) sexJComboBox.getSelectedItem());
        result.setNationality(nationality.getText());
        result.setPassport(passport.getText());
        result.setDateOfBirthday(dateOfBirthday.getText());
        result.setTicketClass((TicketClass) ticketClassJComboBox.getSelectedItem());
        result.setFlightNumberID(flightNumberID);
        return result;
    }



    public static void addPassenger(JTextField firstName, JTextField lastName, JTextField nationality, JTextField passport, JComboBox<Sex> sexJComboBox,
                                    JTextField dateOfBirthday, JComboBox<TicketClass> ticketClassJComboBox, int flightNumberID){
        Passenger addPassenger = getAddPassenger(firstName,lastName,nationality,passport,sexJComboBox,dateOfBirthday,ticketClassJComboBox, flightNumberID);
        String sqlRequest = "insert into passenger (first_name, last_name, nationality, passport, sex, " +
                "date_of_birthday, ticket_class, flight_id) values (?,?,?,?,?,?,?,?)";
        Connection connection = null;
        try {
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setString(1, addPassenger.getFirstName());
            preparedStatement.setString(2, addPassenger.getLastName());
            preparedStatement.setString(3, addPassenger.getNationality());
            preparedStatement.setString(4, addPassenger.getPassport());
            preparedStatement.setString(5, addPassenger.getSex().toString());
            preparedStatement.setString(6, addPassenger.getDateOfBirthday());
            preparedStatement.setString(7, addPassenger.getTicketClass().toString());
            preparedStatement.setInt(8, addPassenger.getFlightNumberID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(connection);
        }
    }
    public static void deletePassenger(TableView<Passenger> passengerTableView){
        Passenger selectedItem = passengerTableView.getSelectionModel().getSelectedItem();
        String sqlRequest = "delete from passenger where first_name = ? and last_name = ? and passport = ?";
        Connection connection = null;
        try {
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setString(1, selectedItem.getFirstName());
            preparedStatement.setString(2, selectedItem.getLastName());
            preparedStatement.setString(3, selectedItem.getPassport());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(connection);
        }
    }


}
