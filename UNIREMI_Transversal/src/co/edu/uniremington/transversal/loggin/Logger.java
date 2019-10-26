package co.edu.uniremington.transversal.loggin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.applicationinsights.TelemetryClient;

@Component
public class Logger {

	@Autowired
	private TelemetryClient cliente;
	
	public void trazarEvento(String traza) {
		cliente.trackEvent(traza);
		

	}
	public void trazarTraza(String traza) {
		cliente.trackTrace(traza);
		

	}
}
