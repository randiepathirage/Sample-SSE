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

package org.example.sse.stream.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Stream details model.
 */
@Document(collation = "Stream")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Stream {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String iss, status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> aud, eventsSupported, eventsRequested, eventsDelivered;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Subject> subjects;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Delivery delivery;

    public Stream() {
    }

    public Stream(String status) {
        this.status = status;
    }

    public Stream(String iss, List<String> aud, Delivery delivery) {
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
    }

    public Stream(String id, String iss, String status, List<String> aud, Delivery delivery,
                  List<String> eventsSupported, List<String> eventsRequested,
                  List<String> eventsDelivered, List<Subject> subjects) {
        this.id = id;
        this.iss = iss;
        this.status = status;
        this.aud = aud;
        this.delivery = delivery;
        this.eventsSupported = eventsSupported;
        this.eventsRequested = eventsRequested;
        this.eventsDelivered = eventsDelivered;
        this.subjects = subjects;
    }

    public Stream(String iss, List<String> aud, Delivery delivery, List<String> eventsSupported,
                  List<String> eventsRequested, List<String> eventsDelivered) {
        this.id = id;
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
        this.eventsSupported = eventsSupported;
        this.eventsRequested = eventsRequested;
        this.eventsDelivered = eventsDelivered;
    }

    public Stream(String id, String iss, List<String> aud, Delivery delivery, List<String> eventsRequested) {
        this.id = id;
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
        this.eventsRequested = eventsRequested;
    }

    public Stream(String id, String iss, String status, List<String> aud, Delivery delivery,
                  List<String> eventsSupported,
                  List<String> eventsRequested, List<String> eventsDelivered) {
        this.id = id;
        this.iss = iss;
        this.status = status;
        this.aud = aud;
        this.delivery = delivery;
        this.eventsSupported = eventsSupported;
        this.eventsRequested = eventsRequested;
        this.eventsDelivered = eventsDelivered;
    }

    public Stream(String iss, List<String> aud, List<String> eventsDelivered) {
        this.iss = iss;
        this.aud = aud;
        this.eventsDelivered = eventsDelivered;
    }

    public void seteventsSupported(List<String> eventsSupported) {
        this.eventsSupported = eventsSupported;
    }

    public void seteventsDelivered(List<String> eventsDelivered) {
        this.eventsDelivered = eventsDelivered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIss() {
        return iss;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAud() {
        return aud;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<String> getEventsSupported() {
        return eventsSupported;
    }

    public List<String> getEventsRequested() {
        return eventsRequested;
    }

    public void setEventsRequested(List<String> eventsRequested) {
        this.eventsRequested = eventsRequested;
    }

    public List<String> getEventsDelivered() {
        return eventsDelivered;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
