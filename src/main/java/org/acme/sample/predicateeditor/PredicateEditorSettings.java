package org.acme.sample.predicateeditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
public class PredicateEditorSettings {

    private List<String> fields = new ArrayList<String>(Arrays.asList(
                "field1", "field2", "field3", "field4"
            ));

    // TODO: should return List<Field>
    public List<String> getFields() {
        return fields;
    }

    // TODO: should return List<Operation>
    public List<String> getOperations(String field) {
        if (field.equals("field1")) {
            return new ArrayList<>(Arrays.asList(
                    "=", ">"
            ));
        } else {
            return new ArrayList<>(Arrays.asList(
                    "IN", "NOT IN"
            ));
        }
    }

    public boolean canHaveMultipleValues(String operation) {
        return (operation.equals("IN") || operation.equals("NOT IN"));
    }

    public boolean hasLookupValues(Criterion criterion) {
        return (!criterion.getField().endsWith("1"));
    }

    // TODO: should return List<LookupOption>
    public List<String> getLookupOptions(Criterion criterion) {
        return new ArrayList<String>(Arrays.asList(
                "val1", "val2", "val3", "val4"
        ));
    }

}
