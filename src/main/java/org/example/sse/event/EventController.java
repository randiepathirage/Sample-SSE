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

package org.example.sse.event;

import io.swagger.annotations.ApiOperation;
import org.example.sse.stream.StreamRepository;
import org.example.sse.stream.model.Stream;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for event delivery endpoints.
 */
@RestController
@RequestMapping(path = "event")
public class EventController {

    private final EventRepository eventRepository;
    private final StreamRepository streamRepository;

    @Autowired
    public EventController(EventRepository eventRepository, StreamRepository streamRepository) {
        this.eventRepository = eventRepository;
        this.streamRepository = streamRepository;
    }

    //add event to database
    @PostMapping
    @ApiOperation(value = "", notes = "Add events to database")
    public void addEvent(@RequestBody Event token) {

        eventRepository.save(token);

        //check whether there are streams subscribed to this event
        List<Stream> stream = streamRepository.findByEventsRequestedAndSubjectsEmail(token.getEvent(),
                token.getSubject());
        if (stream.size() > 0) {
            Stream stream1 = stream.get(0);
            System.out.println(stream1.getIss());
        } else {
            System.out.println("not found");
        }
    }

    //retrieve events
    @GetMapping
    @ApiOperation(value = "", notes = "Retrieve events by subject")
    public ResponseEntity<?> getEvent(@RequestHeader("subject") String subject) {

        List<Event> event = eventRepository.findBySubject(subject);
        if (event.size() > 0) {

            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

