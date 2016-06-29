package com.cooksys.ftd.celebrity.news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cooksys.ftd.celebrity.news.dao.ActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserDao;
import com.cooksys.ftd.celebrity.news.server.Server;

public class Main {
	private static Logger log = LoggerFactory.getLogger(Main.class);

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/sakila";
	private static String username = "root";
	private static String password = "bondstone";

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName(driver); // register jdbc driver class
		ExecutorService executor = Executors.newCachedThreadPool(); // initialize
																	// thread
																	// pool

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			Server server = new Server(); // init server

			server.setExecutor(executor);

			ActorDao actorDao = new ActorDao();
			actorDao.setConn(conn);
			server.setActorDao(actorDao);

			UserActorDao userActorDao = new UserActorDao();
			userActorDao.setConn(conn);
			server.setUserActorDao(userActorDao);

			UserDao userDao = new UserDao();
			userDao.setConn(conn);
			server.setUserDao(userDao);

			Future<?> serverFuture = executor.submit(server); // start server
																// (asynchronously)

			serverFuture.get(); // blocks until server's #run() method is done
								// (aka the server shuts down)

		} catch (SQLException | InterruptedException | ExecutionException e) {
			log.error("An error occurred during server startup. Shutting down after error log.", e);
		} finally {
			executor.shutdown(); // shutdown thread pool (see inside of try
									// block for blocking call)
		}
	}
}
