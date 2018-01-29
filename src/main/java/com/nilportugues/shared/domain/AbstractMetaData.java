package com.nilportugues.shared.domain;

import com.jcabi.manifests.Manifests;
import java.net.InetAddress;
import java.net.UnknownHostException;

abstract public class AbstractMetaData implements DomainEvent.MetaData {
    private final static String IMPLEMENTATION_TITLE = "Implementation-Title";
    private final static String IMPLEMENTATION_VERSION = "Implementation-Version";

    private String applicationName;
    private String applicationVersion;
    private String hostName;
    private String hostIpAddress;

    public AbstractMetaData() {
        if (Manifests.exists(IMPLEMENTATION_TITLE)) {
            applicationName = Manifests.read(IMPLEMENTATION_TITLE);
        }

        if (Manifests.exists(IMPLEMENTATION_VERSION)) {
            applicationVersion = Manifests.read(IMPLEMENTATION_VERSION);
        }

        try {
            final InetAddress inetAddress = InetAddress.getLocalHost();
            hostName = inetAddress.getHostName();
            hostIpAddress = inetAddress.getHostAddress();
        } catch (UnknownHostException ignored) {
            hostName = "";
            hostIpAddress = "";
        }
    }

    @Override
    public String getHostName() {
        return hostName;
    }

    @Override
    public String getHostIpAddress() {
        return hostIpAddress;
    }

    @Override
    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public String getApplicationVersion() {
        return applicationVersion;
    }
}
