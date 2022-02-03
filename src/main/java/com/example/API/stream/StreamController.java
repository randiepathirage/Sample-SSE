package com.example.API.stream;

import com.example.API.transmitter.Transmitter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public String updateStatus() {

        return streamService.updateStatus();
    }

    //Add Subject
    @PostMapping("subjects:add")
    public String addSubject() {

        return streamService.addSubject();
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
