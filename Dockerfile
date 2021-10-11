FROM lpicanco/java11-alpine

WORKDIR /opt/data
RUN apk add tzdata\
    && rm -rf /var/cache/apk/*
RUN rm -rf /etc/localtime
RUN ln -s /usr/share/zoneinfo/Asia/Ho_Chi_Minh /etc/localtime

RUN mkdir -p /opt/data

ADD target/libs $WORKDIR/libs
ADD target/azure.keyvault-0.0.1-SNAPSHOT.jar $WORKDIR/sazure-keyvault.jar
ENTRYPOINT ["java","-jar","sazure-keyvault.jar"]