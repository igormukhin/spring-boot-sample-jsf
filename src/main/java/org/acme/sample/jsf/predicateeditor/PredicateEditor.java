package org.acme.sample.jsf.predicateeditor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ListenerFor;
import javax.faces.event.PostAddToViewEvent;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
@FacesComponent(createTag = true, tagName = "predicateEditor")
@ListenerFor(systemEventClass = PostAddToViewEvent.class)
public class PredicateEditor extends UIPanel {

    private static final Logger logger = LoggerFactory.getLogger(PredicateEditor.class);

    @SuppressWarnings("unchecked")
    public static <T extends UIComponent> T createComponent(String componentType) {
        FacesContext fc = FacesContext.getCurrentInstance();
        return (T) fc.getApplication().createComponent(componentType);
    }

    public static ValueExpression createValueExpression(String expression) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExpressionFactory ef = fc.getApplication().getExpressionFactory();
        return ef.createValueExpression(fc.getELContext(), expression, Object.class);
    }


    @Override
    public void processEvent(ComponentSystemEvent ev) throws AbortProcessingException {
        if (ev instanceof PostAddToViewEvent) {
            //logger.info("Building component tree");

            HtmlOutputText text = createComponent(HtmlOutputText.COMPONENT_TYPE);
            text.setValue("sklsdlfkjslkdfj sldkfj slkdfj slkdfj sldkfj slkdfj ");
            this.getChildren().add(text);

        }

        super.processEvent(ev);
    }

}
