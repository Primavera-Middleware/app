package br.ufrn.imd.primavera.app.db;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.ufrn.imd.primavera.app.models.User;

public class DataBase {
	private List<User> users;

	private static DataBase instance;

	private DataBase() {
		this.users = new ArrayList<>();
	}

	public static synchronized DataBase getInstance() {
		if (instance == null) {
			instance = new DataBase();
		}

		return instance;
	}

	public User save(User u) {
		u.setId(UUID.randomUUID().getLeastSignificantBits());
		users.add(u);

		return u;
	}

	public User findById(Long id) {
		for (User u : users) {
			if (u.getId().equals(id))
				return u;
		}
		return null;
	}
}
