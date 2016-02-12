package org.acme.sample.web;

import org.acme.sample.jsf.FacesViewScope;
import org.acme.sample.predicateeditor.Criterion;
import org.acme.sample.predicateeditor.Link;
import org.acme.sample.predicateeditor.PredicateEditorModel;
import org.acme.sample.predicateeditor.PredicateEditorSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@Component("formWithPEBean")
@Scope(FacesViewScope.NAME)
public class FormWithPEBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(FormWithPEBean.class);

	private static final long serialVersionUID = 1L;

    private PredicateEditorModel predicateEditorModel;

    private PredicateEditorModel predicateEditorModel2;

    public FormWithPEBean() {
        predicateEditorModel = new PredicateEditorModel(new PredicateEditorSettings());
        predicateEditorModel.setCriteria(new ArrayList<>(Arrays.asList(
                new Criterion(Link.NOOP, "field1", "=", "3"),
                new Criterion(Link.AND, "field2", "IN", "6; 5")
        )));

        predicateEditorModel2 = new PredicateEditorModel(new PredicateEditorSettings());
        predicateEditorModel2.setCriteria(new ArrayList<>(Arrays.asList(
                new Criterion(Link.NOOP, "field3", "=", "666"),
                new Criterion(Link.OR, "field4", "IN", "333")
        )));
    }


    public PredicateEditorModel getPredicateEditorModel() {
        return predicateEditorModel;
    }

    public void setPredicateEditorModel(PredicateEditorModel predicateEditorModel) {
        this.predicateEditorModel = predicateEditorModel;
    }

    public PredicateEditorModel getPredicateEditorModel2() {
        return predicateEditorModel2;
    }

    public void setPredicateEditorModel2(PredicateEditorModel predicateEditorModel2) {
        this.predicateEditorModel2 = predicateEditorModel2;
    }
}
