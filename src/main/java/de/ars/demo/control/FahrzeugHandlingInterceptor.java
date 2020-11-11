package de.ars.demo.control;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import de.ars.demo.entity.Fahrzeug;

@FahrzeugHandling
@Interceptor
public class FahrzeugHandlingInterceptor implements Serializable { // für SessionScoped Beans

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		// Suchen nach dem Parameter vom Typ Fahrzeug
		for (Object o : ic.getParameters()) {
			if (o instanceof Fahrzeug) {
				Fahrzeug f = (Fahrzeug) o;
				if (f.getBaujahr() < 1900) {
					throw new IllegalArgumentException("Fahrzeuge mit Baujahr vor 1900 sind nicht zulässig.");
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
