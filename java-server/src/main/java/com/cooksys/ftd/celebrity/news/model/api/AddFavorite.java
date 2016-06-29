package com.cooksys.ftd.celebrity.news.model.api;

import com.cooksys.ftd.celebrity.news.model.db.Actor;
import com.cooksys.ftd.celebrity.news.model.db.User;

public class AddFavorite {

	private User user;
	private Actor actor;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
