package org.acme.sample.jsf.predicateeditor;


import org.acme.sample.web.FormBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ListenerFor;
import javax.faces.event.PostAddToViewEvent;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
@FacesComponent(createTag = true, tagName = "predicateValueEditor")
@ListenerFor(systemEventClass = PostAddToViewEvent.class)
public class PredicateValueEditor extends UIPanel {

    private static final Logger logger = LoggerFactory.getLogger(PredicateValueEditor.class);

    private enum PropertyKeys {
        criterion
    }

    public void setCriterion(FormBean.Criterion criterion) {
        getStateHelper().put(PropertyKeys.criterion, criterion);
    }
    public FormBean.Criterion getSurvey() {
        return (FormBean.Criterion) getStateHelper().eval(PropertyKeys.criterion);
    }

    @Override
    public void processEvent(ComponentSystemEvent ev) throws AbortProcessingException {
        if (ev instanceof PostAddToViewEvent) {
            logger.info("Building component tree");

            //PredicateEditor.createValueExpression("#{criterion.value}")

            HtmlOutputText text = PredicateEditor.createComponent(HtmlOutputText.COMPONENT_TYPE);
            text.setValueExpression("value", this.getValueExpression("criterion"));
            this.getChildren().add(text);

        }

        super.processEvent(ev);
    }

}
