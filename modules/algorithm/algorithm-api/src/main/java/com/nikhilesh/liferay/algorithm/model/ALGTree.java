/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.nikhilesh.liferay.algorithm.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ALGTree service. Represents a row in the &quot;FOO_ALGTree&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ALGTreeModel
 * @see com.nikhilesh.liferay.algorithm.model.impl.ALGTreeImpl
 * @see com.nikhilesh.liferay.algorithm.model.impl.ALGTreeModelImpl
 * @generated
 */
@ImplementationClassName("com.nikhilesh.liferay.algorithm.model.impl.ALGTreeImpl")
@ProviderType
public interface ALGTree extends ALGTreeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.nikhilesh.liferay.algorithm.model.impl.ALGTreeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ALGTree, Long> TREE_ID_ACCESSOR = new Accessor<ALGTree, Long>() {
			@Override
			public Long get(ALGTree algTree) {
				return algTree.getTreeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ALGTree> getTypeClass() {
				return ALGTree.class;
			}
		};
}