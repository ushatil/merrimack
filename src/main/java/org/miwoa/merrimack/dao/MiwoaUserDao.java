package org.miwoa.merrimack.dao;

import org.miwoa.merrimack.model.MiwoaUser;

import com.googlecode.objectify.ObjectifyService;

public class MiwoaUserDao {
	
	public MiwoaUserDao() {
		ObjectifyService.register(MiwoaUser.class);
	}
	
	public MiwoaUser findUser(String email) {
		return ObjectifyService.ofy().load().type(MiwoaUser.class).filter("email", email).first().now();
	}
	
	public Long createUser(MiwoaUser user) {
		if (findUser(user.getEmail()) != null) {
			throw new RuntimeException ("username taken");
		}
		return ObjectifyService.ofy().save().entity(user).now().getId();
	}
}
