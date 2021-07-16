#Getting started

### STEP 1-  Create new project: currency-exchange-service using sprintinitializer

* group name: com.margub.microservice
* Artifact: currency-exchange-service
* Dependencies: Add actuator, web(rest Api), devtools, config-client(to connect config server) 

### STEP-2: Run CurrencyExchangeServiceApplication 

use following property for a name and port for service

    spring.application.name=currency-exchange
    server.port=8000

initially there is no config server:, so we can avoid the import config server check using.

    spring.cloud.config.import-check.enabled=false


### URL
[http://localhost:8000/currency-exchange/from/USD/to/INR](http://localhost:8000/currency-exchange/from/USD/to/INR)

### RESPONSE
    {
    "id":10001,
    "from":"USD",
    "to":"INR",
    "conversionMultiple":65.00,
    "environment":"8000 instance-id"
    }


### Adding JPA and inmemory database
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>

For JPA connection- Annotate CurrencyExchange as Entity and annotate id as @Id
Other thing is to field-name from and to are sql identifier so annotate both with
@Column(name="currency_to") and @Column(name="currency_from")

This will be enough to create a table (CURRENCY_EXCHANGE) in h2.
you can check this in [h2-console](http://localhost:8000/h2-console)

## To initialize data in table
create a data.sql file in src/main/resource  and put these value in it

    insert into currency_exchange
    (id, currency_from, currency_to, conversion_multiple,environment)
    values ( 10001, 'USD', 'INR', '65', '' );
    
    insert into currency_exchange
    (id, currency_from, currency_to, conversion_multiple,environment)
    values ( 10002, 'EUR', 'INR', '75', '' );
    
    insert into currency_exchange
    (id, currency_from, currency_to, conversion_multiple,environment)
    values ( 10003, 'AUD', 'INR', '25', '' )

we will see issue add following into application.properties

    #This is required for initialization of datasource defer incase of jpa, otherwise exception comes when to execute data.sql
    spring.jpa.defer-datasource-initialization=true 