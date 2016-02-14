package org.acme.sample.predicateeditor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
public class PredicateEditorModel implements Serializable {
    private List<Criterion> criteria = new ArrayList<>();

    private Criterion criterion = new Criterion(Link.NOOP, null, null, null);

    private DualListModel<String> lookupModel;

    private boolean lookupDialogVisible = false;
    
    public PredicateEditorModel() {
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criterion> criteria) {
        this.criteria = criteria;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public DualListModel<String> getLookupModel() {
        return lookupModel;
    }

    public void setLookupModel(DualListModel<String> lookupModel) {
        this.lookupModel = lookupModel;
    }

    public boolean isLookupDialogVisible() {
        return lookupDialogVisible;
    }

    public void setLookupDialogVisible(boolean lookupDialogVisible) {
        this.lookupDialogVisible = lookupDialogVisible;
    }

}
