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
                "https://tr.example.com/sse/mgmt/config",
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
