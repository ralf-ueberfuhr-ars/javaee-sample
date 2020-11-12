package de.ars.demo.control;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.Validator;

import de.ars.demo.entity.Fahrzeug;

@FahrzeugHandling
@Interceptor
public class FahrzeugHandlingInterceptor implements Serializable { // für SessionScoped Beans

	private static final long serialVersionUID = 1L;

	@Inject
	private Validator validator;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		// Suchen nach dem Parameter vom Typ Fahrzeug
		for (Object o : ic.getParameters()) {
			if (o instanceof Fahrzeug) {
				Fahrzeug f = (Fahrzeug) o;
				if(!validator.validate(f).isEmpty()) {
					throw new IllegalArgumentException("Nicht valides Fahrzeug");
				} else {
					System.out.printf("Fahrzeug mit Baujahr %d an Methoden '%s' übergeben.%n", f.getBaujahr(),
							ic.getMethod().getName());
				}
			}
		}

		// Aufruf der Original-Methode
		return ic.proceed();

	}

}
