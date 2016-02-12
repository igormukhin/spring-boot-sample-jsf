package org.acme.sample.predicateeditor;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
public class Criterion {
    private Link link;
    private String field;
    private String oper;
    private String value;

    public Criterion() {
    }

    public Criterion(Link link, String field, String oper, String value) {
        this.link = link;
        this.field = field;
        this.oper = oper;
        this.value = value;
    }

    public void copyTo(Criterion dest) {
        dest.setLink(getLink());
        dest.setField(getField());
        dest.setOper(getOper());
        dest.setValue(getValue());
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Criterion{" +
                "link=" + link +
                ", field='" + field + '\'' +
                ", oper='" + oper + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
