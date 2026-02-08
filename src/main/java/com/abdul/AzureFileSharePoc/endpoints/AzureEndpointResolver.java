package com.abdul.AzureFileSharePoc.endpoints;


import com.abdul.AzureFileSharePoc.properties.AzureConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AzureEndpointResolver
{

    private final AzureConfig azureConfig;

    public String fileShare(String path)
    {
        return String.format(azureConfig.getFileShareTemplate(),path);
    }

    public String blob()
    {
        return azureConfig.getBlobTemplate();
    }

}
