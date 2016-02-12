package org.acme.sample.jsf.predicateeditor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
public class PredicateEditorModel implements Serializable {
    private List<Criterion> criteria = new ArrayList<>();

    private Criterion criterion = new Criterion(null, null, null);

    private String lookupDialogValue = "";

    private boolean lookupDialogVisible = false;

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

    public String getLookupDialogValue() {
        return lookupDialogValue;
    }

    public void setLookupDialogValue(String lookupDialogValue) {
        this.lookupDialogValue = lookupDialogValue;
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
            addCriterionAfter(null);
        }

    }

    public void addCriterionAfter(Criterion after) {
        Criterion criterion = new Criterion("field1", "IN", "");

        List<Criterion> criteria = getCriteria();
        int afterIndex = criteria.indexOf(after) + 1;
        criteria.add(afterIndex, criterion);
    }

    public List<String> getFields(Criterion c) {
        return new ArrayList<String>(Arrays.asList(
                "field1", "field2", "field3", "field4"
        ));
    }

    public List<String> getOperations(Criterion criterion) {
        if (criterion.getField().equals("field1")) {
            return new ArrayList<>(Arrays.asList(
                    "=", ">"
            ));
        } else {
            return new ArrayList<>(Arrays.asList(
                    "IN", "NOT IN"
            ));
        }
    }

    public void openLookup(Criterion criterion) {
        setCriterion(criterion);
        setLookupDialogValue(criterion.getValue());
        setLookupDialogVisible(true);
    }

    public void selectLookupValues() {
        getCriterion().setValue(getLookupDialogValue());
        setLookupDialogVisible(false);
    }

    public boolean isHasLookup(Criterion criterion) {
        return (!criterion.getField().endsWith("1"));
    }

}
