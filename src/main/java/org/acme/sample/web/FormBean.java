package org.acme.sample.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.acme.sample.jsf.FacesViewScope;
import org.acme.sample.predicateeditor.Criterion;
import org.acme.sample.predicateeditor.Link;
import org.acme.sample.predicateeditor.PredicateEditorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("formBean")
@Scope(FacesViewScope.NAME)
public class FormBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(FormBean.class);

	private static final long serialVersionUID = 1L;
	
    private List<String> submittedValues = new ArrayList<>();
    
	private String field;

    private PredicateEditorModel predicateEditorModel1;

    private PredicateEditorModel predicateEditorModel2;

    public FormBean() {
        predicateEditorModel1 = new PredicateEditorModel();
        predicateEditorModel1.setCriteria(new ArrayList<>(Arrays.asList(
                new Criterion(Link.NOOP, "field1", "=", "3"),
                new Criterion(Link.AND, "field2", "IN", "6; 5")
        )));

        predicateEditorModel2 = new PredicateEditorModel();
        predicateEditorModel2.setCriteria(new ArrayList<>(Arrays.asList(
                new Criterion(Link.NOOP, "field3", "=", "666"),
                new Criterion(Link.OR, "field4", "IN", "333")
        )));
    }

    public PredicateEditorModel getPredicateEditorModel1() {
        return predicateEditorModel1;
    }

    public PredicateEditorModel getPredicateEditorModel2() {
        return predicateEditorModel2;
    }

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
