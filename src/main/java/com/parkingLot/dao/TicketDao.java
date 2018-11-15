package com.parkingLot.dao;

import com.parkingLot.app.Ticket;
import com.parkingLot.db.HsqlDatabase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketDao {

	private static final String INSERT_QUERY = "INSERT INTO TICKET(ID,TIME_IN,TIME_OUT,IS_LOST) VALUES(?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT ID,TIME_IN,TIME_OUT,IS_LOST FROM TICKET";
	private static final String SELECT_LOST_QUERY = "SELECT ID,TIME_IN,TIME_OUT,IS_LOST FROM TICKET WHERE IS_LOST=TRUE";

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
		//	st.setDate(2, (java.sql.Date) ticket.getTimeIn());
			//st.setDate(3, (java.sql.Date) ticket.getTimeOut());
			st.setBoolean(4, ticket.getIs_lost());
			st.execute();




		} catch (SQLException e) {
			logger.fatal("Query Failed : " + INSERT_QUERY, e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}



	public List<Ticket> retrieveAll() {
		List<Ticket> tickets = null;
		try {
			tickets = new ArrayList<Ticket>();
			Statement st = db.conn.createStatement();
			ResultSet rs = st.executeQuery(SELECT_QUERY);
			while (rs.next()) {
				//tickets.add(new Ticket(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getBoolean(4)));

				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return tickets;
	}

	public List<Ticket> retrieveLost() {
		List<Ticket> tickets = new ArrayList<Ticket>();

		try {
			Statement st = db.conn.createStatement();
			ResultSet rs = st.executeQuery(SELECT_LOST_QUERY);
			while (rs.next()) {
				//tickets.add(new Ticket(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getBoolean(4)));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;

	}




	public static void main(String[] args) throws SQLException, ParseException {



		TicketDao dataservice = new TicketDao();

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date.parse("2018-11-11 11:30:00");

		//dataservice.insert(Arrays.asList(new Ticket(0, "New Ticket fasdf1", false)));
	dataservice.insert(Arrays.asList(new Ticket(22, Date.parse("2018-11-11 11:30:00"),Date.parse("2018-11-11 11:30:00"),true)));
	//	dataservice.deleteTodo(1);
		//List<Ticket> tickets = dataservice.retrieveAll();
		List<Ticket> tickets = dataservice.retrieveLost();

		logger.info(tickets);
		dataservice.db.closeConnection();
	}
}
