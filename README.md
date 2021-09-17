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

### **2.** Create config service using spring-cloud-config-server

My dependencies below:

- spring-cloud-config-server: using for enable Config server-side to run all client config application.yml

In application.yml, I set up profile is native, so that we find config files in **search-locations** folder, in here it is config folder

We can set multiple config file for a service by using syntax "{service name}-{profile}". Profile mean it can be admin, user, test, database,...

I have a default.yml for all services use it to connect to the eureka server in port 8761, and it auto fetch data to eureka server
