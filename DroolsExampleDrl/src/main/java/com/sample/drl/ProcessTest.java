package com.sample.drl;

import java.util.Date;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import com.sample.drl.pojo.InputDomande;

/**
 * This is a sample file to launch a process.
 */
public class ProcessTest {

	@SuppressWarnings({ "restriction", "deprecation" })
	public static void main(String[] args) {
		try {

			// load up the rulebase
			KnowledgeBase kbase = readKnowledgeBase();

			// L'oggetto StatefulKnowledgeSession consente di interagire a
			// runtime con il motore di regole
			// La sessione è mantenuta attiva nelle invocazioni.
			StatefulKnowledgeSession ksession = kbase
					.newStatefulKnowledgeSession();

			// Istanzio l'oggetto pojo che verrà utilizzato nelle regole
			InputDomande input = new InputDomande();
			input.setAge(26);
			input.setGender("HIGH");
			input.setRispostaAccettate("1");
			input.setDataAttivazioneDomanda(new Date());

			ksession.insert(input);
			ksession.fireAllRules();

			System.out.println(input.getRisposta());

			input = new InputDomande();
			input.setAge(13);
			input.setGender("LOW");
			input.setRispostaAccettate("2");
			input.setDataAttivazioneDomanda(new Date());

			ksession.insert(input);
			ksession.fireAllRules();

			System.out.println(input.getRisposta());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	@SuppressWarnings({ "restriction", "deprecation" })
	private static KnowledgeBase readKnowledgeBase() throws Exception {

		// L'oggetto KnowledgeBuilder è incaricato di recuperare il file di
		// origine, (.drl, .bpmn2 o un file xls)
		// e trasformarlo in un oggetto KnowledgePackage di regole
		// che l'oggetto KnowledgeBase può utilizzare.
		// KnowledgeBuilder utilizza un enumeratore TipoRisorsa che definisce il
		// tipo di risorsa che è stato chiesto di recuperare.
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();

		kbuilder.add(ResourceFactory.newClassPathResource("Regole.drl"),
				ResourceType.DRL);
		
		// L'oggetto KnowledgeBuilderErrors contiene una collezione di tipi di
		// errore.
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}

		// Questo oggetto contiene le regole ma non dati di runtime.
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}
}