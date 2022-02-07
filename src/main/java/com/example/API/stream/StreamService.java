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

    public Stream updateConfiguration(Stream newConfig) {
        stream.setEvents_requested(newConfig.getEvents_requested());
        stream.setDelivery(newConfig.getDelivery());

        Stream updatedConfig = new Stream(
                stream.getIss(),
                stream.getAud(),
                stream.getDelivery(),
                stream.getEvents_supported(),
                stream.getEvents_requested(),
                stream.getEvents_delivered()
        );

        return updatedConfig;
    }

    public void deleteConfiguration() {
        stream.setEvents_requested(null);
        stream.setDelivery(null);
    }

    public Stream getStatus() {
        Stream status = new Stream(
                stream.getStatus()
        );
        return status;
    }

    public Stream updateStatus(Stream status) {

        String newStatus = status.getStatus();
        stream.setStatus(newStatus);
        return status;
    }

    public void addSubject(Subject newSubject) {

        List<Subject> newSubjects = new ArrayList<>();
        newSubjects.addAll(stream.getSubjects());
        newSubjects.add(newSubject);
        stream.setSubjects(newSubjects);

    }

    public void removeSubject(Subject removeSubject) {
        List<Subject> newSubjects = new ArrayList<>();
        newSubjects.addAll(stream.getSubjects());

        int flag =0;
        for (int i=0; i < newSubjects.size(); i++) {
            if (removeSubject.getFormat().equals(newSubjects.get(i).getFormat())) {
                if (removeSubject.getEmail().equals(newSubjects.get(i).getEmail())) {
                    flag=i;
                   break;
                }
                if (removeSubject.getIss().equals(newSubjects.get(i).getIss())) {
                    flag=i;
                    break;
                }
                if (removeSubject.getPhone_number().equals(newSubjects.get(i).getPhone_number())) {
                    flag=i;
                    break;
                }
            }
        }
        log.println(flag);
        newSubjects.remove(flag);
        stream.setSubjects(newSubjects);
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
