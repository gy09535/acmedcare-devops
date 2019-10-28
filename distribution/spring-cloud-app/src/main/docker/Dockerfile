# Dockerfile for microservices-spring-cloud-app
# Build with:
# docker build -t microservices-spring-cloud-app .
# Run with:
# docker run -p 19090:19090 -d -v /tmp/logs:/opt/logs --name microservices-spring-cloud-app microservices-spring-cloud-app

FROM openjdk:8-jre-alpine
MAINTAINER Elve.Xu <iskp.me@gmail.com>

ENV VERSION 2.1.0.BUILD-SNAPSHOT

RUN echo "http://mirrors.aliyun.com/alpine/v3.6/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.6/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ADD microservices-spring-cloud-app-${VERSION}.zip /microservices-spring-cloud-app/microservices-spring-cloud-app-${VERSION}.zip

RUN unzip /microservices-spring-cloud-app/microservices-spring-cloud-app-${VERSION}.zip -d /microservices-spring-cloud-app \
    && rm -rf /microservices-spring-cloud-app/microservices-spring-cloud-app-${VERSION}.zip \
    && sed -i '$d' /microservices-spring-cloud-app/bin/startup.sh \
    && echo "tail -f /dev/null" >> /microservices-spring-cloud-app/bin/startup.sh

EXPOSE 19090

CMD ["/microservices-spring-cloud-app/bin/startup.sh"]
