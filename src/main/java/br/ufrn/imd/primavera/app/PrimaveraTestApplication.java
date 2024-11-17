package br.ufrn.imd.primavera.app;

import br.ufrn.imd.primavera.PrimaveraRunner;
import br.ufrn.imd.primavera.autoconfigura.PrimaveraApplication;

@PrimaveraApplication
public class PrimaveraTestApplication {
	public static void main(String[] args) {
		PrimaveraRunner.run(PrimaveraTestApplication.class, args);
	}
}
