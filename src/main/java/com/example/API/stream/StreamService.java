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

package com.example.API.stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
public class StreamService {

//    private Stream stream = new Stream(
//            "https://tr.example.com",
//            "enabled",
//            Arrays.asList("http://receiver.example.com/web", "http://receiver.example.com/mobile"),
//            Arrays.asList("https://schemas.openid.net/secevent/risc/delivery-method/push"),
//            Arrays.asList("urn:example:secevent:events:type_1", "urn:example:secevent:events:type_2",
//            "urn:example:secevent:events:type_3"),
//            Arrays.asList("urn:example:secevent:events:type_2", "urn:example:secevent:events:type_3",
//            "urn:example:secevent:events:type_4"),
//            Arrays.asList("urn:example:secevent:events:type_3", "urn:example:secevent:events:type_2"),
//            Arrays.asList(new Subject("email", "_Spring FrameWork"))
//    );

    private Stream stream = null;


    public ResponseEntity<Stream> getConfiguration() {

        if (stream != null) {
            Stream config = new Stream(
                    stream.getIss(),
                    stream.getAud(),
                    stream.getDelivery(),
                    stream.getEvents_supported(),
                    stream.getEvents_requested(),
                    stream.getEvents_delivered()
            );
            return new ResponseEntity<>(config, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public Stream updateConfiguration(Stream newConfig) {
        if (stream == null) {
            stream = new Stream("https://tr.example.com",
                    "enabled",
                    Arrays.asList("http://receiver.example.com/web", "http://receiver.example.com/mobile"),
                    newConfig.getDelivery(),
                    Arrays.asList("urn:example:secevent:events:type_1", "urn:example:secevent:events:type_2",
                            "urn:example:secevent:events:type_3"),
                    Arrays.asList("urn:example:secevent:events:type_2", "urn:example:secevent:events:type_3",
                            "urn:example:secevent:events:type_4"),
                    newConfig.getEvents_requested());
        } else {
            stream.setEvents_requested(newConfig.getEvents_requested());
            stream.setDelivery(newConfig.getDelivery());
        }


        Stream updatedConfig = new Stream(
                stream.getIss(),
                stream.getAud(),
                stream.getDelivery(),
                stream.getEvents_supported(),
                stream.getEvents_requested(),
                stream.getEvents_delivered()
        );

        return updatedConfig;
    }

    public void deleteConfiguration() {
        stream.setEvents_requested(null);
        stream.setDelivery(null);
    }

    public ResponseEntity<Stream> getStatus() {
        if (stream != null) {
            Stream status = new Stream(
                    stream.getStatus()
            );
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Stream> updateStatus(Stream status) {

        if (stream != null) {
            String newStatus = status.getStatus();
            stream.setStatus(newStatus);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public void addSubject(Subject newSubject) {

        List<Subject> newSubjects = new ArrayList<>();
        newSubjects.addAll(stream.getSubjects());
        newSubjects.add(newSubject);
        stream.setSubjects(newSubjects);

    }

    public void removeSubject(Subject removeSubject) {
        List<Subject> newSubjects = new ArrayList<>();
        newSubjects.addAll(stream.getSubjects());

        int flag = 0;
        for (int i = 0; i < newSubjects.size(); i++) {
            if (removeSubject.getFormat().equals(newSubjects.get(i).getFormat())) {
                if (removeSubject.getEmail().equals(newSubjects.get(i).getEmail())) {
                    flag = i;
                    break;
                }
                if (removeSubject.getIss().equals(newSubjects.get(i).getIss())) {
                    flag = i;
                    break;
                }
                if (removeSubject.getPhone_number().equals(newSubjects.get(i).getPhone_number())) {
                    flag = i;
                    break;
                }
            }
        }
        log.println(flag);
        newSubjects.remove(flag);
        stream.setSubjects(newSubjects);
    }

    public Stream verification() {
        Stream verify = new Stream(
                stream.getIss(),
                stream.getAud(),
                stream.getEvents_delivered()
        );
        return verify;
    }
}
