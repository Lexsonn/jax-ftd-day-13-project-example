package com.cooksys.ftd.celebrity.news.server;

import java.net.ServerSocket;
import java.sql.Connection;
import java.util.concurrent.ExecutorService;

import com.cooksys.ftd.celebrity.news.dao.ActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserDao;

public class Server implements Runnable {

	private ExecutorService executor;
	private ServerSocket serverSocket;

	private ActorDao actorDao;
	private UserActorDao userActorDao;
	private UserDao userDao;

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
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
