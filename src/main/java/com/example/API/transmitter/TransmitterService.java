package com.example.API.transmitter;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TransmitterService {

    public List<Transmitter> getConfiguration() {
        return Arrays.asList((new Transmitter(
                "https://tr.example.com",
                "https://tr.example.com/jwks.json",
                "https://tr.example.com/sse/mgmt/subject:add",
                "https://tr.example.com/sse/mgmt/subject:remove",
                "https://tr.example.com/sse/mgmt/verification",
                "https://tr.example.com/sse/mgmt/status",
                Arrays.asList("tenant", "user"),
                Arrays.asList("https://schemas.openid.net/secevent/risc/delivery-method/push",
                        "https://schemas.openid.net/secevent/risc/delivery-method/poll")
        )));
    }
}

//HTTP/1.1 200 OK
//        Content-Type: application/json
//        {
//        "issuer": "https://tr.example.com",
//        "jwks_uri": "https://tr.example.com/jwks.json",
//        "delivery_methods_supported": [ "https://schemas.openid.net/secevent/risc/delivery-method/push",
//        "https://schemas.openid.net/secevent/risc/delivery-method/poll"],
//        "configuration_endpoint": "https://tr.example.com/sse/mgmt/stream",
//        "status_endpoint": "https://tr.example.com/sse/mgmt/status",
//        "add_subject_endpoint": "https://tr.example.com/sse/mgmt/subject:add",
//        "remove_subject_endpoint": "https://tr.example.com/sse/mgmt/subject:remove",
//        "verification_endpoint": "https://tr.example.com/sse/mgmt/verification",
//        "critical_subject_members": [ "tenant", "user" ]
//        }
//
//
