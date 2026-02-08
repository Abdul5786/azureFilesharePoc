package com.abdul.AzureFileSharePoc.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="apm.directories")
public class DirectoryConfig
{
    private String navJob;
    private String fomaxJob;
    private String sitaJob;
}
