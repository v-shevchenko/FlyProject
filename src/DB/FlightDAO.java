package DB;

import bean.Flight;
import bean.enums.FlightStatus;
import bean.enums.FlightType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {


    public static List<Flight> getFlightByStatus(String typeOfFlight) {
        List<Flight> arrivals = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from flight where" +
                    " flight_type = ?");
            preparedStatement.setString(1, typeOfFlight);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String flightType = resultSet.getString("flight_type");
                String flightStatus = resultSet.getString("flight_status");
                String flightNumber = resultSet.getString("flight_number");
                String city = resultSet.getString("city");
                String terminal = resultSet.getString("terminal");
                int gate = resultSet.getInt("gate");
                Timestamp date1 = resultSet.getTimestamp("departure_time");
                Flight flight = new Flight();
                flight.setFlightType(FlightType.valueOf(flightType));
                flight.setFlightStatus(FlightStatus.valueOf(flightStatus));
                flight.setFlightNumber(flightNumber);
                flight.setCity(city);
                flight.setTerminal(terminal);
                flight.setGate(gate);
                flight.setDepartureTime(date1);
                arrivals.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(connection);
        }
        return arrivals;
    }

    public static List<Flight> getFlightPrice(){
        List<Flight> flightPrice = new ArrayList<>();
        Connection connection = null;
        try{
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from flight");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String flightNumber = resultSet.getString("flight_number");
                String city = resultSet.getString("city");
                double priceEconomy = resultSet.getDouble("price_economy");
                double priceBusiness = resultSet.getDouble("price_business");
                Flight flight = new Flight();
                flight.setFlightNumber(flightNumber);
                flight.setCity(city);
                flight.setPriceEconomy(priceEconomy);
                flight.setPriceBusiness(priceBusiness);
                flightPrice.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(connection);
        }
        return flightPrice;
    }

}

