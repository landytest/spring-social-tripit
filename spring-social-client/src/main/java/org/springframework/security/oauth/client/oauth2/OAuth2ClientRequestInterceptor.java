/*
 * Copyright 2011 the original author or authors.
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
package org.springframework.security.oauth.client.oauth2;

import org.springframework.security.oauth.client.ClientRequest;
import org.springframework.security.oauth.client.RestTemplateInterceptor;

/**
 * ClientRequestInterceptor implementation that adds the OAuth2 access token to the request before execution.
 * This implementation adds the Authorization header using the bearer token style described in the latest draft (draft 12) of the OAuth2 specification:
 * http://tools.ietf.org/html/draft-ietf-oauth-v2-12#section-7.1
 * @author Keith Donald
 * @author Craig Walls
 */
public class OAuth2ClientRequestInterceptor implements RestTemplateInterceptor {

	private String accessToken;
	
	public OAuth2ClientRequestInterceptor(String accessToken) {
		this.accessToken = accessToken;
	}

	public void beforeExecution(ClientRequest request) {
		request.getHeaders().set("Authorization", "BEARER " + accessToken + "");
	}
	
}