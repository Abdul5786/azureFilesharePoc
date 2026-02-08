package com.abdul.AzureFileSharePoc.process;


import com.abdul.AzureFileSharePoc.constants.BlobConstants;
import com.abdul.AzureFileSharePoc.enums.BlobNamingStrategy;
import com.abdul.AzureFileSharePoc.utils.BlobPathBuilder;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;



@Component
public class BlobPathProcessor implements Processor
{
    @Override
    public void process(Exchange exchange) throws Exception
    {

        String fileName = exchange.getIn().getHeader(BlobConstants.FILE_NAME_HEADER, String.class);

        String source = exchange.getProperty(BlobConstants.FILE_SOURCE,String.class);

        String blobPath = BlobPathBuilder.build(
                BlobNamingStrategy.UUID,
                source,
                fileName
        );

        exchange.getIn().setHeader(BlobConstants.BLOB_NAME_HEADER,blobPath);

    }
}
