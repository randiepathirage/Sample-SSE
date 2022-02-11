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

import com.example.API.transmitter.Transmitter;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@RequestMapping(path = "sse")
public class StreamController {

    private final StreamRepository streamRepository;

    public StreamController(StreamRepository streamRepository) {

        this.streamRepository = streamRepository;
    }

    //stream Configuration
    //get
    @GetMapping("stream")
    @ApiOperation(value = "", notes = "Retrieve current stream configuration")
    public ResponseEntity<?> getConfiguration() {

        String id = "1";
        Optional<Stream> stream = streamRepository.findById(id);
        if (stream.isPresent()) {
            return new ResponseEntity<>(stream.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //update/create
    @PostMapping("stream")
    @ApiOperation(value = "", notes = "Update current stream configuration / create a new stream if stream is not " +
            "available")
    public ResponseEntity<?> updateConfiguration(@RequestBody Stream config) {

        String id = "1";
        Optional<Stream> stream = streamRepository.findById(id);
        if (stream.isPresent()) {
            Stream streamUpdate = stream.get();
            streamUpdate.setId(id);
            streamUpdate.setEvents_requested(config.getEvents_requested());
            streamUpdate.setDelivery(config.getDelivery());
            streamRepository.save(streamUpdate);
            return new ResponseEntity<>(streamUpdate, HttpStatus.OK);
        } else {
            try {
                config.setId("1");
                config.setStatus("enabled");
                config.setEvents_supported(Arrays.asList("urn:example:secevent:events:type_1",
                        "urn:example:secevent:events:type_2", "urn:example:secevent:events:type_3"));
                config.setEvents_delivered(Arrays.asList("urn:example:secevent:events:type_2", "urn:example:secevent:events:type_3",
                        "urn:example:secevent:events:type_4"));
                streamRepository.save(config);
                return new ResponseEntity<>(config, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    //delete
    @DeleteMapping("stream")
    @ApiOperation(value = "", notes = "Resets to the streams default configuration.All subjects that have been added" +
            " to the stream, events that have been enqueued in the stream, or status that has been set on the stream " +
            "will also be deleted.")
    public ResponseEntity<?> deleteConfiguration() {

        String id = "1";
        Optional<Stream> stream = streamRepository.findById(id);
        if (stream.isPresent()) {
            Stream streamDelete = stream.get();
            streamDelete.setId(id);
            streamDelete.setEvents_requested(null);
            streamDelete.setDelivery(null);
            streamRepository.save(streamDelete);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    //stream status
    //get
    @GetMapping("status")
    @ApiOperation(value = "", notes = "Checks the current status of an event stream ")
    public ResponseEntity<Stream> getStatus() {

        String id = "1";
        Optional<Stream> stream = streamRepository.findById(id);
        if (stream.isPresent()) {
            Stream status = new Stream(stream.get().getStatus());
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //update
    @PostMapping("status")
    @ApiOperation(value = "", notes = "Updates the current status of a stream")
    public ResponseEntity<Stream> updateStatus(@RequestBody Stream status) {

        String id = "1";
        Optional<Stream> stream = streamRepository.findById(id);
        if (stream.isPresent()) {
            Stream streamUpdate = stream.get();
            streamUpdate.setStatus(status.getStatus());
            streamRepository.save(streamUpdate);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Add Subject
    @PostMapping("subjects:add")
    @ApiOperation(value = "", notes = "Retrieve current stream configuration")
    public ResponseEntity addSubject(@RequestBody Subject subject) {

        String id = "1";
        Optional<Stream> stream = streamRepository.findById(id);
        if (stream.isPresent()) {
            Stream streamUpdate = stream.get();
            List<Subject> newSubjects = new ArrayList<>();
            try {
                newSubjects.addAll(streamUpdate.getSubjects());
            }catch (Exception e){

            }
            newSubjects.add(subject);
            streamUpdate.setSubjects(newSubjects);
            streamRepository.save(streamUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Remove Subject
//    @PostMapping("subjects:remove")
//    @ApiOperation(value = "", notes = "Add new subject to the stream")
//    @ResponseStatus(HttpStatus.NO_CONTENT) //204
//    public void removeSubject(@RequestBody Subject subject) {
//
//        streamService.removeSubject(subject);
//    }
//
//    //Verification
//    @PostMapping("verify")
//    @ApiOperation(value = "", notes = "Remove existing subject from the stream")
//    public Stream verification() {
//
//        return streamService.verification();
//    }
}
