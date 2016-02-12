package org.acme.sample.web;

import org.acme.sample.jsf.FacesViewScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component("formBean")
@Scope(FacesViewScope.NAME)
public class FormBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(FormBean.class);

	private static final long serialVersionUID = 1L;
	
    private List<String> submittedValues = new ArrayList<>();
    
	private String field;

    public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

    public List<String> getSubmittedValues() {
        return submittedValues;
    }

    public void setSubmittedValues(List<String> submittedValues) {
        this.submittedValues = submittedValues;
    }

}
