# **# Spring Microservice For Beginner**

Basic microservice using Spring cloud I do it by myself, so it's not correctly 100%

P/s: my english is not good, so i so sorry for my bad

### **1. Create a discovery service using netflix eureka server**

In my dependency, I use all dependencies below:

- spring-cloud-starter-netflix-eureka-server: for enable eureka server - we can call it is a discovery server
- spring-boot-starter-log4j2: i use it for logging info, error instead of default spring-boot-starter-logging. You can
  remove it, if you don't need to log anything to console

Next, you need t add @EnableEurekaServer to enable _eureka server_

Finally, in the application.properties I have change to application.yml.

- The default port is 8761
- Cause this project I only run in the local, so my default hostname is "localhost"
- fetch-registry and register-with-eureka set false to make eureka server not fetch registry and register itself
- defaultZone: it bases on the host name and port

### **2.**

