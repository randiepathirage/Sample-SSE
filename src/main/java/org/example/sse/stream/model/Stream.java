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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Stream details model.
 */
@Document(collation = "Stream")
public class Stream {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String iss, status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> aud, delivery, events_supported, events_requested, events_delivered;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Subject> subjects;

    public Stream() {
    }

    public Stream(String status) {
        this.status = status;
    }

    public Stream(String iss, List<String> aud, List<String> delivery) {
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
    }

    public Stream(String id, String iss, String status, List<String> aud, List<String> delivery,
                  List<String> events_supported, List<String> events_requested,
                  List<String> events_delivered, List<Subject> subjects) {
        this.id = id;
        this.iss = iss;
        this.status = status;
        this.aud = aud;
        this.delivery = delivery;
        this.events_supported = events_supported;
        this.events_requested = events_requested;
        this.events_delivered = events_delivered;
        this.subjects = subjects;
    }

    public Stream(String iss, List<String> aud, List<String> delivery, List<String> events_supported,
                  List<String> events_requested, List<String> events_delivered) {
        this.id = id;
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
        this.events_supported = events_supported;
        this.events_requested = events_requested;
        this.events_delivered = events_delivered;
    }

    public Stream(String id, String iss, List<String> aud, List<String> delivery, List<String> events_requested) {
        this.id = id;
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
        this.events_requested = events_requested;
    }

    public Stream(String id, String iss, String status, List<String> aud, List<String> delivery, List<String> events_supported,
                  List<String> events_requested, List<String> events_delivered) {
        this.id = id;
        this.iss = iss;
        this.status = status;
        this.aud = aud;
        this.delivery = delivery;
        this.events_supported = events_supported;
        this.events_requested = events_requested;
        this.events_delivered = events_delivered;
    }

    public void setEvents_supported(List<String> events_supported) {
        this.events_supported = events_supported;
    }

    public void setEvents_delivered(List<String> events_delivered) {
        this.events_delivered = events_delivered;
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

    public List<String> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<String> delivery) {
        this.delivery = delivery;
    }

    public List<String> getEvents_supported() {
        return events_supported;
    }

    public List<String> getEvents_requested() {
        return events_requested;
    }

    public void setEvents_requested(List<String> events_requested) {
        this.events_requested = events_requested;
    }

    public List<String> getEvents_delivered() {
        return events_delivered;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
