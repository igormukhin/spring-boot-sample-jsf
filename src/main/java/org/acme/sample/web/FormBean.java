package org.acme.sample.web;

import org.acme.sample.jsf.FacesViewScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("formBean")
@Scope(FacesViewScope.NAME)
public class FormBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(FormBean.class);

	private static final long serialVersionUID = 1L;
	
    private List<String> submittedValues = new ArrayList<>();
    
	private String field;

	private List<Criterion> criteria = new ArrayList<>(Arrays.asList(
			new Criterion("field1", "=", "3"),
			new Criterion("field2", "IN", "6; 5")
	));

    private Criterion criterion = new Criterion(null, null, null);

    private String lookupDialogValue = "";

    private boolean lookupDialogVisible = false;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

    public List<String> getSubmittedValues() {
        return submittedValues;
    }

    public void setSubmittedValues(List<String> submittedValues) {
        this.submittedValues = submittedValues;
    }

	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
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

    public void openLookup(Criterion criterion) {
        setCriterion(criterion);
        setLookupDialogValue(criterion.value);
        setLookupDialogVisible(true);
    }

    public void selectLookupValues() {
        getCriterion().setValue(getLookupDialogValue());
        setLookupDialogVisible(false);
    }

    public boolean isLookupDialogVisible() {
        return lookupDialogVisible;
    }

    public void setLookupDialogVisible(boolean lookupDialogVisible) {
        this.lookupDialogVisible = lookupDialogVisible;
    }

    public boolean isHasLookup(Criterion criterion) {
        return (!criterion.getField().endsWith("1"));
    }

    public static class Criterion {
		private String field;
		private String oper;
		private String value;

		public Criterion() {
		}

		public Criterion(String field, String oper, String value) {
			this.field = field;
			this.oper = oper;
			this.value = value;
		}

        public void copyTo(Criterion dest) {
            dest.setField(getField());
            dest.setOper(getOper());
            dest.setValue(getValue());
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
                    "field='" + field + '\'' +
                    ", oper='" + oper + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
