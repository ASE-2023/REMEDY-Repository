package org.abc.constraint.node.operationnode;

import org.abc.constraint.node.ConstraintNode;

public class XorOpNode extends OperationNode {

	public static String symbol = "xor";
	
	public XorOpNode(ConstraintNode sourceNode, ConstraintNode argumentNode) {
		super(sourceNode, argumentNode);
	}

	@Override
	public Object getValue() {
		return (Boolean)sourceNode.getValue() ^ (Boolean)argumentNode.getValue();
	}
	
	@Override
	public double getSafeDistance(){
		double dt1 = sourceNode.getSafeDistance();
		double dt2 = argumentNode.getSafeDistance();
		
		double d1 = dt1 * (1 - dt2);
		double d2 = dt2 * (1 - dt1);
		return (d1 < d2) ? d1 : d2;
	}
	
	@Override
	public double getViolationDistance(){
		double d1 = sourceNode.getViolationDistance();
		double d2 = argumentNode.getViolationDistance();
		
		if(d1 == 0 && d2 != 0){
			return 0;
		}
		else if(d1 != 0 && d2 == 0){
			return 0;
		}
		else{
			double dt1 = 1 - 1 / (d1 + 1 - d2 + 1);
			double dt2 = 1 - 1 / (d2 + 1 - d1 + 1);
			
			return (dt1 < dt2) ? dt1 : dt2;
		}
		
	}
}
