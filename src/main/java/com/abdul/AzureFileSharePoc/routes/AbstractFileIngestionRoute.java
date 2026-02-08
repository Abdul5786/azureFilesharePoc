package com.abdul.AzureFileSharePoc.routes;

import com.abdul.AzureFileSharePoc.endpoints.AzureEndpointResolver;
import com.abdul.AzureFileSharePoc.process.BlobPathProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@RequiredArgsConstructor
public abstract  class AbstractFileIngestionRoute extends RouteBuilder
{
    protected final AzureEndpointResolver azureEnpointResolver;

    protected  final BlobPathProcessor blobPathProcessor;

    protected abstract String directory();


    @Override
    public void configure() throws Exception
    {
            from(azureEnpointResolver.fileShare(directory()))
                    .routeId("file-ingestion"+directory())

                    .setProperty("source",constant(directory()))
                    .log("started-processing")
                    .process(blobPathProcessor)
                    .to(azureEnpointResolver.blob())
                    .log("Stored in Blob: ${header.CamelAzureStorageBlobBlobName}");

    }
}
