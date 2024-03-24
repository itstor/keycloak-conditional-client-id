# Keycloak Conditional Flow for Client ID Matching

This repository contains a Keycloak extension that introduces a conditional flow for matching the current authentication session's client ID using regular expressions (regex). This extension is particularly useful for scenarios where Keycloak's default behaviors do not provide the necessary flexibility for managing client-specific idp authentication flows.

## Use Cases

One of the primary use cases for this extension is in environments where:

- **IdP-First Broker Login Override:** There is a need to customize the default IdP-first broker login on a per-client basis, which is not natively supported by Keycloak.
- **Client-Specific Registration Controls:** In multi-tenant setups, it may be necessary to disable idp registration or apply specific registration policies for certain clients.
- **Selective Authentication Flow Configuration**: There's a need to configure the authentication flow for specific clients without the need to manually override settings for each one individually. 

## Getting Started

### Build

This project uses Gradle for building and packaging the extension. To compile the project, ensure you have Gradle installed on your system, and run the following command in the project's root directory:

```bash
./gradlew build
```

### Installation

#### Standalone (without container)
Copy the jar to the `providers` folder and run the following command:

```bash
${KEYCLOAK_HOME}/bin/kc.sh build
```

#### Docker
Mount or copy the jar to `/opt/keycloak/providers`.

### Configuration
Here is the example of the configuration:
[![image.png](https://i.postimg.cc/sXJ9N1G0/image.png)](https://postimg.cc/XGpCZj8w)
