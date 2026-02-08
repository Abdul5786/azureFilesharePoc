package com.abdul.AzureFileSharePoc.utils;

import com.abdul.AzureFileSharePoc.constants.BlobConstants;
import com.abdul.AzureFileSharePoc.enums.BlobNamingStrategy;

import java.time.LocalDate;
import java.util.UUID;

public final class BlobPathBuilder {

    private BlobPathBuilder() {}

    public static String build(
            BlobNamingStrategy strategy,
            String source,
            String fileName) {

        String date = LocalDate.now().toString();

        if (strategy == BlobNamingStrategy.UUID) {
            return source
                    + BlobConstants.PATH_SEPARATOR
                    + date
                    + BlobConstants.PATH_SEPARATOR
                    + UUID.randomUUID()
                    + "_" + fileName;
        }

        throw new IllegalArgumentException("Unsupported blob naming strategy");
    }
}
