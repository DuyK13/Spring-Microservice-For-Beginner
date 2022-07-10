# **Spring Microservice For Beginner**

Basic microservice using Spring cloud I do it by myself, so it's not correctly 100%

P/s: my english is not good, so i so sorry for my bad
Default dependency: _spring-boot-starter-log4j2, I use it for logging info, error instead of default spring-boot-starter-logging. You can
  remove it, if you don't need to log anything to console

### **1. Create discovery service using netflix eureka server**

In my dependency, I use all dependencies below:

- spring-cloud-starter-netflix-eureka-server: for enable eureka server - we can call it is a discovery server

Next, you need t add @EnableEurekaServer to enable _eureka server_

Finally, in the application.properties I have change to application.yml.

- The default port is 8761
- Cause this project I only run in the local, so my default hostname is "localhost"
- fetch-registry and register-with-eureka set false to make eureka server not fetch registry and register itself
- defaultZone: it bases on the host name and port

For all thing I mention above, you can read this document: [spring-cloud-eureka-server-standalone-mode](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server-standalone-mode)
### **2.** Create config service using spring-cloud-config-server

My dependencies below:

- spring-cloud-config-server: using for enable Config server-side to run all client config application.yml

The syntax of the config file in the following form: {application}-{profile}.{yml/properties}

To enable Config server in service, we use @EnableConfigServer annotation in main class

In this, I run my config service in the local, so I use the "**native**" profile in my application.yml. Then use "**search-location**" to point to the path of folder contains config files

You can read the document in here: [spring_cloud_config_server](https://cloud.spring.io/spring-cloud-config/reference/html/#_spring_cloud_config_server)