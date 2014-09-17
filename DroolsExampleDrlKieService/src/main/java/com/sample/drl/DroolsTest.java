package com.sample.drl;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.drl.pojo.Message;

/**
 * Classe di esempio del framework Drools mediante utilizzando del file drl e la
 * libreria KieServices
 * 
 * @author valerio.martini
 * 
 */
public class DroolsTest {

	public static void main(String[] args) {
		try {
			// load up the knowledge base

			// L'oggetto KieServices è un singleton thread-safe che agisce come
			// un hub dando accesso agli altri
			// servizi forniti da Kie
			KieServices ks = KieServices.Factory.get();

			// L'oggetto KieContainer è un contenitore per tutti i KieBases di
			// un dato KieModule
			KieContainer kContainer = ks.getKieClasspathContainer();

			// L'oggetto KieSession interagisce con il motore di regole
			// Consente all'applicazione di stabilire una conversazione
			// iterativa con il motore di regole.
			// Lo stato della Sessione è mantenuta attiva nelle invocazioni. Il
			// processo di ragionamento può essere attivata più volte per il
			// stesso insieme di dati.
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			// go !
			Message message = new Message();
			message.setMessage("Hello World");
			message.setStatus(Message.HELLO);

			kSession.insert(message);
			kSession.fireAllRules();

			System.out.println("Stampa messaggio dalla classe main "
					+ message.getMessage());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
