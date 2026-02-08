package com.abdul.AzureFileSharePoc.routes;


import com.abdul.AzureFileSharePoc.endpoints.AzureEndpointResolver;
import com.abdul.AzureFileSharePoc.process.BlobPathProcessor;
import com.abdul.AzureFileSharePoc.properties.DirectoryConfig;
import org.springframework.stereotype.Component;

@Component
public class NavBlueRoute extends AbstractFileIngestionRoute
{
    private  final DirectoryConfig directoryConfig;

    public NavBlueRoute(DirectoryConfig directoryConfig, AzureEndpointResolver azureEndpointResolver, BlobPathProcessor blobPathProcessor)
    {
        super(azureEndpointResolver,blobPathProcessor);
        this.directoryConfig = directoryConfig;
    }

    @Override
    protected String directory()
    {
       return directoryConfig.getNavJob();
    }
}
