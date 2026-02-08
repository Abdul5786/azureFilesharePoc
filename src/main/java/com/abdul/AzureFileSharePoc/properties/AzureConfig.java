package com.abdul.AzureFileSharePoc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "apm.azure")
public class AzureConfig
{
    private String fileShareTemplate;
    private  String blobTemplate;
}
