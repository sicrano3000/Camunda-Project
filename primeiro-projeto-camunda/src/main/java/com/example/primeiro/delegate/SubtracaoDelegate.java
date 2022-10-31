package com.example.primeiro.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SubtracaoDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		var a = (Long) execution.getVariable("a");
		var b = (Long) execution.getVariable("b");
		
		execution.setVariable("resultado", a - b);		
	}

}
