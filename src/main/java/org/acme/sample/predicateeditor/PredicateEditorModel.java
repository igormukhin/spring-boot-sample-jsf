package org.acme.sample.predicateeditor;

import org.primefaces.model.DualListModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
public class PredicateEditorModel implements Serializable {
    private List<Criterion> criteria = new ArrayList<>();

    private Criterion criterion = new Criterion(Link.NOOP, null, null, null);

    private DualListModel<String> lookupModel;

    private boolean lookupDialogVisible = false;

    private PredicateEditorSettings settings;

    public PredicateEditorModel(PredicateEditorSettings settings) {
        this.settings = settings;
    }

    public PredicateEditorSettings getSettings() {
        return settings;
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

    public void removeCriterion(Criterion toDelete) {
        List<Criterion> criteria = getCriteria();

        criteria.remove(toDelete);

        if (criteria.isEmpty()) {
            addCriterionAfter(null, Link.NOOP.name());
        }

    }

    public void addCriterionAfter(Criterion after, String operationId) {
        Criterion criterion = new Criterion(Link.valueOf(operationId), "field1", "IN", "");

        List<Criterion> criteria = getCriteria();
        int afterIndex = criteria.indexOf(after) + 1;
        criteria.add(afterIndex, criterion);
    }

    public List<String> getFields() {
        return settings.getFields();
    }

    public List<String> getOperations(Criterion criterion) {
        return settings.getOperations(criterion.getField());
    }

    public void openLookup(Criterion criterion) {
        setCriterion(criterion);
        setLookupDialogVisible(true);

        List<String> current = PredicateEditorUtils.inputTextToStringList(criterion.getValue());
        List<String> source = settings.getLookupOptions(criterion);
        List<String> target = new ArrayList(source);
        target.retainAll(current);
        source.removeAll(target);

        DualListModel<String> lkModel = new DualListModel<>(source, target);

        setLookupModel(lkModel);
    }

    public void selectLookupValues() {
        getCriterion().setValue(PredicateEditorUtils.stringListToInputText(getLookupModel().getTarget()));
        setLookupDialogVisible(false);
    }

    public boolean hasLookupValues(Criterion criterion) {
        return settings.hasLookupValues(criterion);
    }

    public void lookupDialogClosed() {
        setLookupDialogVisible(false);
    }

}
