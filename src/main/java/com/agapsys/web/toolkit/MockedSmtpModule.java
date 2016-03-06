/* 
 * Copyright (C) 2016 Agapsys Tecnologia - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.agapsys.web.toolkit;

import com.agapsys.mail.Message;
import com.agapsys.web.toolkit.modules.SmtpModule;

public class MockedSmtpModule extends SmtpModule {
	
	private Message message = null;

	public void reset() {
		message = null;
	}
	
	public boolean isMessageSent() {
		return message != null;
	}
	
	public Message getMessage() {
		return message;
	}
	
	@Override
	protected void onSendMessage(Message message) {
		this.message = message;
	}
}
