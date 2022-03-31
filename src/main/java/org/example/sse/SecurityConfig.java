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

package org.example.sse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security layer configuration.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-uri}")
    String introspectionUri;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-id}")
    String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-secret}")
    String clientSecret;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(authz -> {
                            try {
                                authz
                                        .antMatchers(HttpMethod.GET, "/sse/status")
                                        .hasAuthority("SCOPE_status_read")

                                        .antMatchers(HttpMethod.POST, "/sse/status")
                                        .hasAuthority("SCOPE_status_write")

                                        .antMatchers(HttpMethod.GET, "/sse/stream")
                                        .hasAuthority("SCOPE_stream_read")

                                        .antMatchers(HttpMethod.POST, "/sse/stream")
                                        .hasAuthority("SCOPE_stream_write")

                                        .antMatchers(HttpMethod.DELETE, "/sse/stream")
                                        .hasAuthority("SCOPE_stream_write")

                                        .antMatchers(HttpMethod.POST, "/sse/subjects:add")
                                        .hasAuthority("SCOPE_add_subject")

                                        .antMatchers(HttpMethod.POST, "/sse/subjects:remove")
                                        .hasAuthority("SCOPE_remove_subject")

                                        .antMatchers(HttpMethod.POST, "/sse/verify")
                                        .hasAuthority("SCOPE_verify")

                                        .antMatchers("/.well-known/sse-configuration")
                                        .permitAll()

                                        .and()
                                        .csrf().disable().authorizeRequests()
                                        .antMatchers("/event").permitAll();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .opaqueToken(token -> token.introspectionUri(this.introspectionUri)
                                .introspectionClientCredentials(this.clientId, this.clientSecret)));

    }
}
