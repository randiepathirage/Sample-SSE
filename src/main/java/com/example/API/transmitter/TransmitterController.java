package com.example.API.transmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="well-known/sse-configuration")
public class TransmitterController {

    private final TransmitterService transmitterService;

    @Autowired
    public TransmitterController(TransmitterService transmitterService) {
        this.transmitterService = transmitterService;
    }

    @GetMapping
    public List<Transmitter> getConfiguration(){
        return transmitterService.getConfiguration();
    }
}
