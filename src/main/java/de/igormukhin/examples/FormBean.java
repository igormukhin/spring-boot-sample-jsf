package de.igormukhin.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// This will work with JSF, but Spring will not be able to locate and autowire this bean
//@ManagedBean(name = "formBean")
//@ViewScoped

@Component("formBean")
@Scope(FacesViewScope.NAME)
public class FormBean implements Serializable {

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
