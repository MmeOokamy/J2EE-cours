package controller;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class CalculController {
	
	public static String calculer(String formule) {
		
		Evaluator eval = new Evaluator();
		String result;
		try {
			result = eval.evaluate(formule);
			return result;
			
		} catch (EvaluationException e) {
			
			return "Erreur!";
		}
		
		
	}

}
