package org.abcd.sysmlevolver.test.utils;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.EnumerationValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.uml2.uml.EnumerationLiteral;

public class PropertyUtil {
	
	public FeatureValue featureValue;
	
	public PropertyUtil(FeatureValue featureValue) {
		this.featureValue = featureValue;
	}
	
	public void setValue(double value) {
		
		Value v = featureValue.getValues().get(0);
		
		if (v instanceof BooleanValue) {
			BooleanValue newValue = new BooleanValue();
			if(value == 0) {
				newValue.value = false;
			}
			else{
				newValue.value = true;
			}
			featureValue.getValues().set(0, newValue);
		}
		if (v instanceof IntegerValue) {
			IntegerValue newValue = new IntegerValue();
			newValue.value = (int)value;
			featureValue.getValues().set(0, newValue);
		}
		else if (v instanceof RealValue) {
			RealValue newValue = new RealValue();
			newValue.value = value;
			featureValue.getValues().set(0, newValue);
		}
	}
	
	public double getValue() {
		
		Value v = featureValue.getValues().get(0);
		
		double variableValue = -1;
		if (v instanceof BooleanValue) {
			boolean bv = ((BooleanValue) v).value;
			if (bv) {
				variableValue = 1;
			}
			else {
				variableValue = 0;
			}
		}
		else if (v instanceof IntegerValue) {
			variableValue = ((IntegerValue) v).value;
		}
		else if (v instanceof RealValue) {
			variableValue = ((RealValue) v).value;
		}
		else if (v instanceof EnumerationValue) {
			variableValue = -1;
			List<EnumerationLiteral> literals = ((EnumerationValue) v).literal.getEnumeration().getOwnedLiterals();
			for (int i = 0; i < literals.size(); i++) {
				if (literals.get(i).equals(((EnumerationValue) v).literal)) {
					variableValue = i;
					break;
				}
			}
		}
		return variableValue;
	}
	
}
