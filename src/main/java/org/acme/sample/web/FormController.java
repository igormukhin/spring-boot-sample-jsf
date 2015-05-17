package org.acme.sample.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("formController")
@Scope("request")
public class FormController {
	@Autowired
	private FormBean formBean;
	
	public void submit() {
	    formBean.getSubmittedValues().add(formBean.getField());
	    
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Value submitted."));
	}
	
	public void reset() {
	    formBean.getSubmittedValues().clear();
	    formBean.setField(null);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Form reset."));
	}
	
}
