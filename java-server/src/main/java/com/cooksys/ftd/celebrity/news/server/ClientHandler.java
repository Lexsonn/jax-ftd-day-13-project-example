package com.cooksys.ftd.celebrity.news.server;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.cooksys.ftd.celebrity.news.dao.ActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserDao;

public class ClientHandler implements Runnable {

	private BufferedReader reader;
	private PrintWriter writer;

	private ActorDao actorDao;
	private UserActorDao userActorDao;
	private UserDao userDao;

	@Override
	public void run() {
		// read commands and data from the client
		// then send back a Response<T> object
		// rinse and repeat
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public ActorDao getActorDao() {
		return actorDao;
	}

	public void setActorDao(ActorDao actorDao) {
		this.actorDao = actorDao;
	}

	public UserActorDao getUserActorDao() {
		return userActorDao;
	}

	public void setUserActorDao(UserActorDao userActorDao) {
		this.userActorDao = userActorDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
