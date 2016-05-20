/*
 * Copyright 2016 Agapsys Tecnologia Ltda-ME.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agapsys.web.toolkit;

import com.agapsys.web.toolkit.modules.PersistenceModule;

@Deprecated
public class MockedPersistenceModule extends PersistenceModule {
	// STATIC SCOPE ============================================================
	public static final String DEFAULT_PERSISTENCE_UNIT_NAME = "test";
	// =========================================================================
	
	// INSTANCE SCOPE ==========================================================
	private final String persistenceUnitName;
	
	public MockedPersistenceModule() {
		this(DEFAULT_PERSISTENCE_UNIT_NAME);
	}
	
	public MockedPersistenceModule(String persistenceUnitName) {
		if (persistenceUnitName == null || persistenceUnitName.trim().isEmpty())
			throw new IllegalArgumentException("Null/Empty name");
		
		this.persistenceUnitName = persistenceUnitName;
	}
	
	@Override
	protected String getPersistenceUnitName() {
		return persistenceUnitName;
	}
	// =========================================================================

}
