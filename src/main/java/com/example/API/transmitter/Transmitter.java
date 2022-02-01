package com.example.API.transmitter;

import java.util.List;

public class Transmitter {
    private String issuer, jwks_uri,add_subject_endpoint,remove_subject_endpoint,verification_endpoint,status_endpoint;
    private List<String> critical_subject_members,delivery_methods_supported;

    public Transmitter(String issuer, String jwks_uri, String add_subject_endpoint, String remove_subject_endpoint, String verification_endpoint, String status_endpoint, List<String> critical_subject_members, List<String> delivery_methods_supported) {
        this.issuer = issuer;
        this.jwks_uri = jwks_uri;
        this.add_subject_endpoint = add_subject_endpoint;
        this.remove_subject_endpoint = remove_subject_endpoint;
        this.verification_endpoint = verification_endpoint;
        this.status_endpoint = status_endpoint;
        this.critical_subject_members = critical_subject_members;
        this.delivery_methods_supported = delivery_methods_supported;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getJwks_uri() {
        return jwks_uri;
    }

    public void setJwks_uri(String jwks_uri) {
        this.jwks_uri = jwks_uri;
    }

    public String getAdd_subject_endpoint() {
        return add_subject_endpoint;
    }

    public void setAdd_subject_endpoint(String add_subject_endpoint) {
        this.add_subject_endpoint = add_subject_endpoint;
    }

    public String getRemove_subject_endpoint() {
        return remove_subject_endpoint;
    }

    public void setRemove_subject_endpoint(String remove_subject_endpoint) {
        this.remove_subject_endpoint = remove_subject_endpoint;
    }

    public String getVerification_endpoint() {
        return verification_endpoint;
    }

    public void setVerification_endpoint(String verification_endpoint) {
        this.verification_endpoint = verification_endpoint;
    }

    public String getStatus_endpoint() {
        return status_endpoint;
    }

    public void setStatus_endpoint(String status_endpoint) {
        this.status_endpoint = status_endpoint;
    }

    public List<String> getCritical_subject_members() {
        return critical_subject_members;
    }

    public void setCritical_subject_members(List<String> critical_subject_members) {
        this.critical_subject_members = critical_subject_members;
    }

    public List<String> getDelivery_methods_supported() {
        return delivery_methods_supported;
    }

    public void setDelivery_methods_supported(List<String> delivery_methods_supported) {
        this.delivery_methods_supported = delivery_methods_supported;
    }

    @Override
    public String toString() {
        return "Transmitter{" +
                ", issuer='" + issuer + '\'' +
                ", jwks_uri='" + jwks_uri + '\'' +
                ", add_subject_endpoint='" + add_subject_endpoint + '\'' +
                ", remove_subject_endpoint='" + remove_subject_endpoint + '\'' +
                ", verification_endpoint='" + verification_endpoint + '\'' +
                ", status_endpoint='" + status_endpoint + '\'' +
                ", critical_subject_members=" + critical_subject_members +
                ", delivery_methods_supported=" + delivery_methods_supported +
                '}';
    }
}
