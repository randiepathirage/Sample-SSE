package com.example.API.stream;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StreamService {

    private Stream stream = new Stream(
            "https://tr.example.com",
            "enabled",
            Arrays.asList("http://receiver.example.com/web", "http://receiver.example.com/mobile"),
            Arrays.asList("https://schemas.openid.net/secevent/risc/delivery-method/push"),
            Arrays.asList("urn:example:secevent:events:type_1", "urn:example:secevent:events:type_2", "urn:example:secevent:events:type_3"),
            Arrays.asList("urn:example:secevent:events:type_2", "urn:example:secevent:events:type_3", "urn:example:secevent:events:type_4"),
            Arrays.asList("urn:example:secevent:events:type_3", "urn:example:secevent:events:type_2"),
            Arrays.asList(new Subject("email", "_Spring FrameWork"))
    );


    public Stream getConfiguration() {

        Stream config = new Stream(
                stream.getIss(),
                stream.getAud(),
                stream.getDelivery(),
                stream.getEvents_supported(),
                stream.getEvents_requested(),
                stream.getEvents_delivered()
        );
        return config;
    }

    public String updateConfiguration() {
        return "Stream updated!";
    }

    public String deleteConfiguration() {
        return "Stream Deleted!";
    }

    public Stream getStatus() {
        Stream status = new Stream(
                stream.getStatus()
        );
        return status;
    }

    public String updateStatus() {
        return "Stream status updated!";
    }

    public void addSubject(Subject newSubject) {

        List<Subject> newSubjects = new ArrayList<>();
        newSubjects.addAll(stream.getSubjects());
        newSubjects.add(newSubject);
        stream.setSubjects(newSubjects);
        // return stream.getSubjects();
    }

    public String removeSubject() {
        return "remove subject!";
    }

    public String verification() {
        return "verification!";
    }
}
