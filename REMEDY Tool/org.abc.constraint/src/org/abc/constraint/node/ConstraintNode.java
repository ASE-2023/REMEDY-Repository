package org.abc.constraint.node;

public abstract class ConstraintNode {
	
	public abstract Object getValue();
	
	/**
	 * 
	 * @return 0 to 1, 1 means total safe, far away from boundary
	 * 				   0 means constraint violated
	 */
	public double getSafeDistance(){
		return 1;
	}
	
	/**
	 * 
	 * @return 0 to 1, 1 means far away from satisfying the constraint,
	 * 				   0 means constraint satisfied
	 */
	public double getViolationDistance(){
		return 0;
	}
	
	/**
	 * 
	 * @return the range of the variable, only valid for variableNode
	 */
	public double getRange(){
		return 0;
	}
	
}
