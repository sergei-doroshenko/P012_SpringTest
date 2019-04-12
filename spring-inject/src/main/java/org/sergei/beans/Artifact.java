package org.sergei.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Artifact {

    @Value("${artifact.groupId}")
    private String groupId;

    @Value("${artifact.artifactId}")
    private String artifactId;

    @Value("${artifact.groupId}")
    private String version;

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Artifact{" +
            "groupId='" + groupId + '\'' +
            ", artifactId='" + artifactId + '\'' +
            ", version='" + version + '\'' +
            '}';
    }
}
