package DB;

import bean.Ticket;
import bean.enums.TicketClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public static List<Ticket> getTicketList(){
        List<Ticket> ticketList = new ArrayList<>();
        Connection connection = null;
        try{
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket join flight on ticket.flight_id = flight.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String flightNumber = resultSet.getString("flight_number");
                String city = resultSet.getString("city");
                String ticketClass = resultSet.getString("ticket_class");
                Double price = resultSet.getDouble("price");
                Ticket ticket = new Ticket();
                ticket.setFlightNumber(flightNumber);
                ticket.setCity(city);
                ticket.setTicketClass(TicketClass.valueOf(ticketClass));
                ticket.setPrice(price);
                ticketList.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(connection);
        }
        return ticketList;
    }


}
