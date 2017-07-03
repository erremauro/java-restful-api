# Java RestfulAPI

A Java Restful API boilerplate project based on [Jersey][1], 
built with [Gradle][2].

RestfulAPI is configured to run using [Gretty][3] and has the `jdbc-postgresql`
library declare as a gradle's dependency.

[1]: https://jersey.github.io
[2]: https://gradle.org
[3]: http://akhikhl.github.io/gretty-doc/Getting-started.html

## Installation

Clone the repository locally:

    git clone https://github.com/erremauro/java-restful-api.git
    cd java-restful-api

To run the project using [Gretty][1] type in the console:

    gradle appRun

## Setup

You'll probably want to update your project package domain from the bootstrapped
`com.erremauro.restfulapi`. After having updated the packaged proceed as 
following:

Edit `src/main/webapp/WEB-INF/web.xml` and change the parameter that points to
your resource's package (i.e. the package containing the Api services):

  ```xml
  <init-param>
      <param-name>jersey.config.server.provider.packages</param-name>
      <param-value>COM.MY_PACKAGE.RESOURCES</param-value>
  </init-param`>
  ```

You can change the API root path in: `src/main/webapp/META-INF/context.xml`

## Configurations

Database configurations are store in 
`src/main/resources/com/erremauro/restfulapi/configuration.properties` and can
be read using the `Properties object`:

    ```java
    Properties props = new Properties();
    props.load(Resource.class.getResourceAsStream("configuration.properties");
    String host = props.getProperty("host");
    ```

## Netbeans IDE

To correctly open this project with Netbeans, please install `Gradle Support`
plugin from the Plugin Manager in ``Tools > Plugins > Available Plugins