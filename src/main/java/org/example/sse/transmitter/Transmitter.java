/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.com).
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
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

package org.example.sse.transmitter;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Represents transmitter model.
 */
@Document("Transmitter")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Transmitter {

    private String issuer;
    private String jwksUri, addSubjectEndpoint, removeSubjectEndpoint, verificationEndpoint,
            statusEndpoint, configurationEndpoint;
    private List<String> criticalSubjectMembers, deliveryMethodsSupported;

    public Transmitter() {
    }

    public Transmitter(String issuer, String jwksUri, String addSubjectEndpoint, String removeSubjectEndpoint,
                       String verificationEndpoint, String statusEndpoint, String configurationEndpoint,
                       List<String> criticalSubjectMembers,
                       List<String> deliveryMethodsSupported) {
        this.issuer = issuer;
        this.jwksUri = jwksUri;
        this.addSubjectEndpoint = addSubjectEndpoint;
        this.removeSubjectEndpoint = removeSubjectEndpoint;
        this.verificationEndpoint = verificationEndpoint;
        this.statusEndpoint = statusEndpoint;
        this.configurationEndpoint = configurationEndpoint;
        this.criticalSubjectMembers = criticalSubjectMembers;
        this.deliveryMethodsSupported = deliveryMethodsSupported;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getJwksUri() {
        return jwksUri;
    }

    public void setJwksUri(String jwksUri) {
        this.jwksUri = jwksUri;
    }

    public String getAddSubjectEndpoint() {
        return addSubjectEndpoint;
    }

    public void setAddSubjectEndpoint(String addSubjectEndpoint) {
        this.addSubjectEndpoint = addSubjectEndpoint;
    }

    public String getRemoveSubjectEndpoint() {
        return removeSubjectEndpoint;
    }

    public void setRemoveSubjectEndpoint(String removeSubjectEndpoint) {
        this.removeSubjectEndpoint = removeSubjectEndpoint;
    }

    public String getVerificationEndpoint() {
        return verificationEndpoint;
    }

    public void setVerificationEndpoint(String verificationEndpoint) {
        this.verificationEndpoint = verificationEndpoint;
    }

    public String getStatusEndpoint() {
        return statusEndpoint;
    }

    public void setStatusEndpoint(String statusEndpoint) {
        this.statusEndpoint = statusEndpoint;
    }

    public List<String> getCriticalSubjectMembers() {
        return criticalSubjectMembers;
    }

    public void setCriticalSubjectMembers(List<String> criticalSubjectMembers) {
        this.criticalSubjectMembers = criticalSubjectMembers;
    }

    public List<String> getDeliveryMethodsSupported() {
        return deliveryMethodsSupported;
    }

    public void setDeliveryMethodsSupported(List<String> deliveryMethodsSupported) {
        this.deliveryMethodsSupported = deliveryMethodsSupported;
    }

    public String getConfigurationEndpoint() {
        return configurationEndpoint;
    }

    public void setConfigurationEndpoint(String configurationEndpoint) {
        this.configurationEndpoint = configurationEndpoint;
    }

    @Override
    public String toString() {
        return "Transmitter{" +
                "issuer='" + issuer + '\'' +
                ", jwksUri='" + jwksUri + '\'' +
                ", addSubjectEndpoint='" + addSubjectEndpoint + '\'' +
                ", removeSubjectEndpoint='" + removeSubjectEndpoint + '\'' +
                ", verificationEndpoint='" + verificationEndpoint + '\'' +
                ", statusEndpoint='" + statusEndpoint + '\'' +
                ", configurationEndpoint='" + configurationEndpoint + '\'' +
                ", criticalSubjectMembers=" + criticalSubjectMembers +
                ", deliveryMethodsSupported=" + deliveryMethodsSupported +
                '}';
    }
}
