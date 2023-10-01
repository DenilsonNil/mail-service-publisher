# mail-service

#### How to use this app:

## System requirements
1. A RabbitMQ Instance

## Properties

1. Open the application.yaml file and change the properties below:

```yaml
spring:
  rabbitmq:
      host: HOST_OF_RABBITMQ
      username: RABBIT_MQ_USERNAME
      password: RABBIT_MQ_PASSWORD
      queue: RABBIT_MQ_QUEUE_NAME
      port: RABBIT_MQ_PORT
```

2. To send emails use the curl of the file ./postman/curl.txt

