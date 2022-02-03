package com.example.API.stream;

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
    public Stream getConfiguration() {

        return streamService.getConfiguration();
    }

    //update
    @PostMapping("stream")
    public String updateConfiguration() {

        return streamService.updateConfiguration();
    }

    //delete
    @DeleteMapping("stream")
    public String deleteConfiguration() {

        return streamService.deleteConfiguration();
    }

    //stream status
    //get
    @GetMapping("status")
    public Stream getStatus() {

        return streamService.getStatus();
    }

    //update
    @PostMapping("status")
    public String updateStatus() {

        return streamService.updateStatus();
    }

    //Add Subject
    @PostMapping("subjects:add")
    public void addSubject(@RequestBody Subject subject) {

        streamService.addSubject(subject);
    }

    //Remove Subject
    @PostMapping("subjects:remove")
    public String removeSubject() {

        return streamService.removeSubject();
    }

    //Verification
    @PostMapping("verify")
    public String verification() {

        return streamService.verification();
    }
}
