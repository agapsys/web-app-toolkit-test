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

import com.agapsys.sevlet.container.ServletContextHandlerBuilder;

/**
 * Default ServletContainerBuilder for web-app-toolkit based applications.
 * @author Leandro Oliveira (leandro@agapsys.com)
 */
public class ServletContainerBuilder extends com.agapsys.sevlet.container.ServletContainerBuilder {

	private final AbstractWebApplication webApp;
	
	public ServletContainerBuilder(AbstractWebApplication webApp) {
		if (webApp == null) throw new IllegalArgumentException("Null web application");
		
		this.webApp = webApp;
	}
	
	@Override
	public ServletContextHandlerBuilder addContext(String contextPath) {
		ServletContextHandlerBuilder ctxHandlerBuilder = super.addContext(contextPath)
			.registerEventListener(webApp)
			.registerFilter(WebApplicationFilter.class, "/*");
		
		return ctxHandlerBuilder;
	}
}
