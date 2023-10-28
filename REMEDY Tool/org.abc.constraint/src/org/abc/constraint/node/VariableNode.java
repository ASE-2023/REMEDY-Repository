package org.abc.constraint.node;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.EnumerationValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.PrimitiveValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;

public class VariableNode extends ConstraintNode {
	
	private FeatureValue featureValue;
	private ParameterValue parameterValue;
	
	public VariableNode(Object value){
		if(value instanceof FeatureValue){
			featureValue = (FeatureValue)value;
			parameterValue = null;
		}
		else if(value instanceof ParameterValue){
			parameterValue = (ParameterValue)value;
			featureValue = null;
		}
		else{
			featureValue= null;
			parameterValue = null;
		}
	}
	
	@Override
	public Object getValue() {
		
		Value v;
		
		if(featureValue != null){
			v = featureValue.values.get(0);
		}
		else{
			v = parameterValue.values.get(0);
		}
		
		if(v instanceof EnumerationValue){
			return ((EnumerationValue)v).literal;
		}
		else if(v instanceof PrimitiveValue){
			return ((PrimitiveValue)v).getValue();
		}
		return null;
	}
	
	public double getRange(){
		if(featureValue != null){
			return featureValue.maxValue - featureValue.minValue;
		}
		else{
			return 0;
		}
	}
	
}
