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
