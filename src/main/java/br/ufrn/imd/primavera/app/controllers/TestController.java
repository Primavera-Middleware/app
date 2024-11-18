package br.ufrn.imd.primavera.app.controllers;

import br.ufrn.imd.primavera.app.TestConfig;
import br.ufrn.imd.primavera.remoting.annotations.BodyParam;
import br.ufrn.imd.primavera.remoting.annotations.Endpoint;
import br.ufrn.imd.primavera.remoting.annotations.Handler;
import br.ufrn.imd.primavera.remoting.annotations.HeaderParam;
import br.ufrn.imd.primavera.remoting.annotations.PathParam;
import br.ufrn.imd.primavera.remoting.annotations.QueryParam;
import br.ufrn.imd.primavera.remoting.enums.Verb;

@Handler(basePath = "/test")
public class TestController {

	@Endpoint(method = Verb.GET, path = "/t/{id}/{lp}")
	
	public TestConfig test(
			@PathParam(value = "id") String id,
			@PathParam(value = "lp") String lp,
			@QueryParam(value = "v") String v,
			@BodyParam TestConfig t,
			@HeaderParam(value = "Accept-Encoding") String h) {
		System.out.println(id);
		System.out.println(lp);
		System.out.println(v);
		System.out.println(t);
		System.out.println(h);
		return t;
	}
	
@Endpoint(method = Verb.GET, path = "/t2")
	
	public TestConfig test2(
			@QueryParam(value = "v") String v,
			@BodyParam TestConfig t,
			@HeaderParam(value = "Accept-Encoding") String h) {
		System.out.println(v);
		System.out.println(t);
		System.out.println(h);
		return t;
	}
}
