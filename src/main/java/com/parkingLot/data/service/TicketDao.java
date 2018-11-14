package com.parkingLot.data.service;

import com.parkingLot.app.Ticket;
import com.parkingLot.db.HsqlDatabase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketDao {

	private static final String INSERT_QUERY = "INSERT INTO PARKING(ID,TIME_IN,TIME_OUT,IS_LOST) VALUES(?, ?, ?, ?)";

	private static final String DELETE_QUERY = "DELETE FROM PARKING WHERE ID=?";
	PreparedStatement st = null;
	HsqlDatabase db = new HsqlDatabase();

	public static Logger logger = LogManager.getLogger(TicketDao.class);

	public void insert(List<Ticket> tickets) {
		for (Ticket ticket : tickets) {
			insertTicket(ticket);
		}
	}

	private void insertTicket(Ticket ticket) {

		try {
			st = db.conn.prepareStatement(INSERT_QUERY);
			st.setInt(1, ticket.getId());
			st.setString(2, ticket.getTimeIn());
			st.setString(3, ticket.getTimeOut());
			st.setBoolean(4, ticket.getIs_lost());
			st.execute();




		} catch (SQLException e) {
			logger.fatal("Query Failed : " + INSERT_QUERY, e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// Ignore - nothing we can do..
				}
			}
		}
	}

	public void deleteTodo(int id) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(DELETE_QUERY);
			st.setInt(1, id);
			st.execute();
		} catch (SQLException e) {
			logger.fatal("Query Failed : " + DELETE_QUERY, e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// Ignore - nothing we can do..
				}
			}
		}
	}

	public List<Ticket> retrieveAll() throws SQLException {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Statement st = db.conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM PARKING");
		while (rs.next()) {
			tickets.add(new Ticket(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getBoolean(4)));
		}
		st.close();
		return tickets;
	}

	public static void main(String[] args) throws SQLException {

		TicketDao dataservice = new TicketDao();


		String twelve = "twelve";
		//dataservice.insert(Arrays.asList(new Ticket(0, "New Ticket fasdf1", false)));
	dataservice.insert(Arrays.asList(new Ticket(9,"twelve","thirteen",false)));
	//	dataservice.deleteTodo(1);
		List<Ticket> tickets = dataservice.retrieveAll();
		logger.info(tickets);
		dataservice.db.closeConnection();
	}
}
