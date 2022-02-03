package com.example.API.stream;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

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

    public Stream updateStatus() {
        stream.setStatus("disabled");
        Stream status = new Stream(
                stream.getStatus()
        );
        return status;
    }

    public void addSubject(Subject newSubject) {

        List<Subject> newSubjects = new ArrayList<>();
        newSubjects.addAll(stream.getSubjects());
        newSubjects.add(newSubject);
        stream.setSubjects(newSubjects);
    }

    //.................
    public List<Subject> removeSubject(Subject removeSubject) {
        List<Subject> newSubjects = new ArrayList<>();
        newSubjects.addAll(stream.getSubjects());
        newSubjects.add(new Subject("email","dfdffdf"));
        int keyLocation = newSubjects.indexOf("email");
        //newSubjects.remove(keyLocation);
        log.println(keyLocation);
        return newSubjects;
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
