package org.acme.sample.predicateeditor;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("predicateEditor")
@Scope("request")
public class PredicateEditor {

    public List<String> getFields(UIComponent cc) {
        Attrs attrs = Attrs.of(cc);
        return attrs.getDataProvider().getFields();
    }

    public List<String> getOperations(UIComponent cc, Criterion criterion) {
        Attrs attrs = Attrs.of(cc);
        return attrs.getDataProvider().getOperations(criterion.getField());
    }

    public void removeCriterion(UIComponent cc, Criterion toDelete) {
        Attrs attrs = Attrs.of(cc);
        
        List<Criterion> criteria = attrs.getModel().getCriteria();

        criteria.remove(toDelete);

        if (criteria.isEmpty()) {
            addCriterionAfter(cc, null, Link.NOOP.name());
        }

    }

    public void addCriterionAfter(UIComponent cc, Criterion after, String operationId) {
        Attrs attrs = Attrs.of(cc);
        
        Criterion criterion = new Criterion(Link.valueOf(operationId), "field1", "IN", "");

        List<Criterion> criteria = attrs.getModel().getCriteria();
        int afterIndex = criteria.indexOf(after) + 1;
        criteria.add(afterIndex, criterion);
    }

    public void openLookup(UIComponent cc, Criterion criterion) {
        Attrs attrs = Attrs.of(cc);
        
        attrs.getModel().setCriterion(criterion);
        attrs.getModel().setLookupDialogVisible(true);

        List<String> current = PredicateEditorUtils.inputTextToStringList(criterion.getValue());
        List<String> source = attrs.getDataProvider().getLookupOptions(criterion);
        List<String> target = new ArrayList<>(source);
        target.retainAll(current);
        source.removeAll(target);

        DualListModel<String> lkModel = new DualListModel<>(source, target);

        attrs.getModel().setLookupModel(lkModel);
    }

    public void selectLookupValues(UIComponent cc) {
        Attrs attrs = Attrs.of(cc);
        
        attrs.getModel().getCriterion().setValue(PredicateEditorUtils.stringListToInputText(
                attrs.getModel().getLookupModel().getTarget()));
        attrs.getModel().setLookupDialogVisible(false);
    }

    public boolean hasLookupValues(UIComponent cc, Criterion criterion) {
        Attrs attrs = Attrs.of(cc);
        
        return attrs.getDataProvider().hasLookupValues(criterion);
    }

    public void lookupDialogClosed(UIComponent cc) {
        Attrs attrs = Attrs.of(cc);
        
        attrs.getModel().setLookupDialogVisible(false);
    }
    
    private static class Attrs {
        private PredicateEditorModel model;
        private PredicateEditorDataProvider dataProvider;
        
        public static Attrs of(UIComponent cc) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            return new Attrs(
                        (PredicateEditorModel) cc.getValueExpression("model").getValue(elContext),
                        (PredicateEditorDataProvider) cc.getValueExpression("dataProvider").getValue(elContext)
                    ); 
        }

        public Attrs(PredicateEditorModel model, PredicateEditorDataProvider dataProvider) {
            this.model = model;
            this.dataProvider = dataProvider;
        }

        public PredicateEditorModel getModel() {
            return model;
        }

        public PredicateEditorDataProvider getDataProvider() {
            return dataProvider;
        }
        
    }
    
}
