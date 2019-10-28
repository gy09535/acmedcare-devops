# Dockerfile for microservices-spring-boot-app
# Build with:
# docker build -t microservices-spring-boot-app .
# Run with:
# docker run -p 9090:9090 -d -v /tmp/logs:/opt/logs --name microservices-spring-boot-app microservices-spring-boot-app

FROM openjdk:8-jre-alpine
MAINTAINER Elve.Xu <iskp.me@gmail.com>

ENV VERSION 2.1.0.BUILD-SNAPSHOT

RUN echo "http://mirrors.aliyun.com/alpine/v3.6/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.6/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ADD microservices-spring-boot-app-${VERSION}.zip /microservices-spring-boot-app/microservices-spring-boot-app-${VERSION}.zip

RUN unzip /microservices-spring-boot-app/microservices-spring-boot-app-${VERSION}.zip -d /microservices-spring-boot-app \
    && rm -rf /microservices-spring-boot-app/microservices-spring-boot-app-${VERSION}.zip \
    && sed -i '$d' /microservices-spring-boot-app/bin/startup.sh \
    && echo "tail -f /dev/null" >> /microservices-spring-boot-app/bin/startup.sh

EXPOSE 9090

CMD ["/microservices-spring-boot-app/bin/startup.sh"]
