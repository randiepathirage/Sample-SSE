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

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "sse")
public class StreamController {

    private final StreamService streamService;

    public StreamController(StreamService streamService) {

        this.streamService = streamService;
    }

    //stream Configuration
    //get
    @GetMapping("stream")
    @ApiOperation(value = "", notes = "Retrieve current stream configuration")
    public ResponseEntity<Stream> getConfiguration() {

        return streamService.getConfiguration();
    }

    //update
    @PostMapping("stream")
    @ApiOperation(value = "", notes = "Update current stream configuration / create a new stream if stream is not " +
            "available")
    public Stream updateConfiguration(@RequestBody Stream config) {

        return streamService.updateConfiguration(config);
    }

    //delete
    @DeleteMapping("stream")
    @ApiOperation(value = "", notes = "Resets to the streams default configuration.All subjects that have been added" +
            " to the stream, events that have been enqueued in the stream, or status that has been set on the stream " +
            "will also be deleted.")
    public void deleteConfiguration() {

        streamService.deleteConfiguration();
    }

    //stream status
    //get
    @GetMapping("status")
    @ApiOperation(value = "", notes = "Checks the current status of an event stream ")
    public ResponseEntity<Stream> getStatus() {

        return streamService.getStatus();
    }

    //update
    @PostMapping("status")
    @ApiOperation(value = "", notes = "Updates the current status of a stream")
    public ResponseEntity<Stream> updateStatus(@RequestBody Stream status) {

        return streamService.updateStatus(status);
    }

    //Add Subject
    @PostMapping("subjects:add")
    @ApiOperation(value = "", notes = "Retrieve current stream configuration")
    public void addSubject(@RequestBody Subject subject) {

        streamService.addSubject(subject);
    }

    //Remove Subject
    @PostMapping("subjects:remove")
    @ApiOperation(value = "", notes = "Add new subject to the stream")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void removeSubject(@RequestBody Subject subject) {

        streamService.removeSubject(subject);
    }

    //Verification
    @PostMapping("verify")
    @ApiOperation(value = "", notes = "Remove existing subject from the stream")
    public Stream verification() {

        return streamService.verification();
    }
}
