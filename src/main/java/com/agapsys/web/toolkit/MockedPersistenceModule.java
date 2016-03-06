/* 
 * Copyright (C) 2016 Agapsys Tecnologia - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.agapsys.web.toolkit;

import com.agapsys.web.toolkit.modules.PersistenceModule;

public class MockedPersistenceModule extends PersistenceModule {
	
	@Override
	protected String getPersistenceUnitName() {
		return "test";
	}
}
