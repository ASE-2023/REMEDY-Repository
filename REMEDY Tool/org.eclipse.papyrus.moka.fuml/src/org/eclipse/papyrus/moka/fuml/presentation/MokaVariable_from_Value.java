/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

public class MokaVariable_from_Value extends MokaVariable_for_fUML {

	protected Value fUMLValue;

	public MokaVariable_from_Value(Value value) {
		super();
		this.fUMLValue = value;
	}

	// ////////////////////////////////
	// Presentation
	// ////////////////////////////////

	@Override
	public Image getImage() {
		// not used for variables
		return FUMLPresentationUtils.getImage(UMLPackage.eINSTANCE.getInstanceSpecification());
	}

	// ////////////////////////////////
	// Debug
	// ////////////////////////////////
	@Override
	public IValue getValue() throws DebugException {
		return new MokaValue_from_Value(fUMLValue);
	}

}
