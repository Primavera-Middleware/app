package br.ufrn.imd.primavera.app.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.ufrn.imd.primavera.app.db.DataBase;
import br.ufrn.imd.primavera.app.models.User;
import br.ufrn.imd.primavera.remoting.annotations.BodyParam;
import br.ufrn.imd.primavera.remoting.annotations.Endpoint;
import br.ufrn.imd.primavera.remoting.annotations.Handler;
import br.ufrn.imd.primavera.remoting.annotations.PathParam;
import br.ufrn.imd.primavera.remoting.entities.ResponseWrapper;
import br.ufrn.imd.primavera.remoting.enums.HTTPStatus;
import br.ufrn.imd.primavera.remoting.enums.Verb;

@Handler(basePath = "/user")
public class UserController {
	protected static final Logger logger = LogManager.getLogger();

	private DataBase db = DataBase.getInstance();

	@Endpoint(method = Verb.POST, path = "/create")
	public ResponseWrapper<User> create(@BodyParam User u) {
		return ResponseWrapper.ok(db.save(u));
	}

	@Endpoint(method = Verb.GET, path = "/{id}")
	public ResponseWrapper<User> findById(@PathParam(value = "id") Long id) {
		User u = db.findById(id);
		if (u == null) {
			return ResponseWrapper.status(HTTPStatus.NOT_FOUND, null);
		}

		return ResponseWrapper.ok(u);
	}
}