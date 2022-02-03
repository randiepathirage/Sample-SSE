package com.example.API.stream;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StreamService {
    public List<Stream> getConfiguration() {
        return Arrays.asList((new Stream(
                "https://tr.example.com")
        ));
    }

    public List<Stream> getStatus() {
        return Arrays.asList((new Stream(
                "https://tr.example.com")
        ));
    }

    public String updateConfiguration() {
        return "Stream updated!";
    }

    public String deleteConfiguration() {
        return "Stream Deleted!";
    }

    public String updateStatus() {
        return "Stream status updated!";
    }

    public String addSubject() {
        return "new subject added to the stream!";
    }

    public String removeSubject() {
        return "remove subject!";
    }

    public String verification() {
        return "verification!";
    }
}
