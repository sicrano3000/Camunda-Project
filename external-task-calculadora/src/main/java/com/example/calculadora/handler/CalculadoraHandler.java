package com.example.calculadora.handler;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("calculadora")
public class CalculadoraHandler implements ExternalTaskHandler {

	@Override
	public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
		
		var resultado = 0l;
		
		var a = (Long) externalTask.getVariable("a");
		var b = (Long) externalTask.getVariable("b");
		
		var operacao = (String) externalTask.getVariable("operacao");
		
		switch (operacao) {
		case "soma":
			resultado = a + b;
			break;
			
		case "subtracao":
			resultado = a - b;
			break;
			
		case "multiplicacao":
			resultado = a * b;
			break;
			
		case "divisao":
			resultado = a / b;
			break;
		}
		
		var variaveis = Variables.createVariables();
		variaveis.put("resultado", resultado);
		
		externalTaskService.complete(externalTask, variaveis);
		
	}

}
