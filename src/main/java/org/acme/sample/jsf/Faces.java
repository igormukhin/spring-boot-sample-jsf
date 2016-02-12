package org.acme.sample.jsf;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
public class Faces {

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


}
