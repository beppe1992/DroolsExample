package com.sample.complexpojo;

import java.io.StringReader;
import java.util.Date;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.audit.WorkingMemoryFileLogger;
import org.drools.compiler.PackageBuilder;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

import com.sample.complexpojo.pojo.DatiContraente;
import com.sample.complexpojo.pojo.InputCalcolaPremio;
import com.sample.complexpojo.pojo.Sconto;


/**
 * Classe di esempio del framework Drools mediante utilizzando Decision Tables in
 * Excel
 * 
 * @author valerio.martini
 * 
 */
@SuppressWarnings("restriction")
public class ApplicantTest {

	public static void main(String[] args) {
		try {

			// load up the rulebase
			RuleBase ruleBase = readDecisionTable();

			// Istanzio un WorkingMemory session per l'oggetto RuleBase precedentemente istanziato
			WorkingMemory workingMemory = ruleBase.newStatefulSession();

			// Questa classe genera un file di log relativo al WorkingMemory
			// session precendentemente istanzionato
			WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger(
					workingMemory);
			logger.setFileName("C:/drools-audit");

			// Istanzio l'oggetto pojo che verrà utilizzato nelle regole
			InputCalcolaPremio input = new InputCalcolaPremio();
			input.setDatiContraente(new DatiContraente());
			input.setSconto(new Sconto());
			input.getDatiContraente().setEtaContraente(40);
			input.getDatiContraente().setNominativo("PIPPO");
			input.getDatiContraente().setTipoCliente("DIPENDENTI");
			input.setNumeroGaranziePolizza(2);

			workingMemory.insert(input);
			workingMemory.fireAllRules();

			System.out.println(input.getSconto().getPercSconto());
			System.out.println(input.getSconto().getTipoSconto());


			logger.writeToDisk();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private static RuleBase readDecisionTable() throws Exception {
		// Questo oggetto gestisce XLS e CSV ed estrae dalle decision tables in esso definite 
		//le regola
		final SpreadsheetCompiler converter = new SpreadsheetCompiler();
		final String drl = converter.compile("/ExampleTableDecision.xls",
				InputType.XLS);
		System.out.println(drl);

		// Questa oggetto compila le regole precedentemente estratte
		PackageBuilder builder = new PackageBuilder();
		builder.addPackageFromDrl(new StringReader(drl));

		// Questa classe contiene l'insieme delle regole compilate
		org.drools.rule.Package pkg = builder.getPackage();

		// Questo oggetto rende attiva una collezione di regole in base al
		// package che gli viene passato.
		// Da un RuleBase possono essere stanziati pi� WorkingMempry Session
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(pkg);
		return ruleBase;
	}

}