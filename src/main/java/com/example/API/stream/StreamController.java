package com.example.API.stream;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Stream updateStatus(@RequestBody Stream status) {

        return streamService.updateStatus(status);
    }

    //Add Subject
    @PostMapping("subjects:add")
    public void addSubject(@RequestBody Subject subject) {

        streamService.addSubject(subject);
    }

    //Remove Subject
    @PostMapping("subjects:remove")
    //@ResponseStatus(HttpStatus.NO_CONTENT) //204
    public List<Subject> removeSubject(@RequestBody Subject subject) {

        return streamService.removeSubject(subject);
    }

    //Verification
    @PostMapping("verify")
    public Stream verification() {

        return streamService.verification();
    }
}
