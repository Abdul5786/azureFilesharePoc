Azure File Share to Blob Storage – POC
Overview

This POC demonstrates a file ingestion pipeline using Apache Camel that reads files from Azure File Share and stores them in Azure Blob Storage in a source-segregated and collision-free manner.

Flow
Azure File Share (Navblue / Fomax / SITA)
        |
     Apache Camel
        |
Azure Blob Storage (single container, logical paths)

Key Points

One route per source system

Single reusable processor for blob path generation

UUID-based blob naming to prevent overwrites

Config-driven Azure endpoints (no hardcoding)

Single Blob container, separated by source paths

Blob Storage Structure
apm-output/
 ├── navblue/yyyy-MM-dd/UUID_file.json
 ├── fomax/yyyy-MM-dd/UUID_file.json
 └── sita/yyyy-MM-dd/UUID_file.json

Tech Stack

Java

Apache Camel (Spring Boot)

Azure File Share

Azure Blob Storage

Authentication

POC: Azure Storage Connection String

Production-ready: Azure Entra ID (Managed Identity)

Purpose

Designed to be scalable, clean, and production-aligned, with easy extensibility for Kafka, validation, and security enhancements.
