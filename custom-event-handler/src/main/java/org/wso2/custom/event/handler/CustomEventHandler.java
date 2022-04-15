/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.custom.event.handler;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jwt.JWTClaimsSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.wso2.carbon.identity.event.IdentityEventConstants;
import org.wso2.carbon.identity.event.IdentityEventException;
import org.wso2.carbon.identity.event.event.Event;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;
import org.wso2.carbon.identity.oauth2.IdentityOAuth2Exception;
import org.wso2.carbon.identity.oauth2.util.OAuth2Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomEventHandler extends AbstractEventHandler {

    private static Log log = LogFactory.getLog(CustomEventHandler.class);

    @Override
    public void handleEvent(Event event) throws IdentityEventException {

        log.info("Custom event handler received events successfully.");
        String eventName = "POST_UPDATE_CREDENTIAL_BY_ADMIN";
        if (eventName.equals(event.getEventName())) {
            Map<String, Object> eventProperties = event.getEventProperties();
            String userName = (String) eventProperties.get(IdentityEventConstants.EventProperty.USER_NAME);

            log.info("Received event: " + event);
            log.info(eventProperties);

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().issuer(userName).audience("aud1").subject("tenantId").build();
            List<NameValuePair> reqParams = new ArrayList<>();

            try {
                String token = OAuth2Util.signJWTWithRSA(claimsSet, JWSAlgorithm.RS256, "carbon.super").serialize();
                log.info(token);

                String url = this.configs.getModuleProperties().getProperty("custom.event.handler.url");
                log.info(url);
                HttpClient client = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost(url);

                String json = "";

                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("token", token);
                jsonObject.accumulate("subject", userName);
                jsonObject.accumulate("event", eventName);

                json = jsonObject.toString();

                StringEntity se = new StringEntity(json);

                httpPost.setEntity(se);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");

                HttpResponse response = client.execute(httpPost);
                System.out.println(response.getStatusLine().getStatusCode());

            } catch (IOException | IdentityOAuth2Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getName() {
        return "custom.event.handler";
    }
}


