FROM docker.apiacmed.com/acmedback/kernel:0.1.0
MAINTAINER stefan.gu

ENV VERSION 0.1.0.BUILD-SNAPSHOT

RUN echo "http://mirrors.aliyun.com/alpine/v3.6/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.6/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ADD devops-spring-cloud-app-${VERSION}.zip /devops-spring-cloud-app/devops-spring-cloud-app-${VERSION}.zip

RUN unzip /devops-spring-cloud-app/devops-spring-cloud-app-${VERSION}.zip -d /devops-spring-cloud-app \
    && rm -rf /devops-spring-cloud-app/devops-spring-cloud-app-${VERSION}.zip \
    && sed -i '$d' /devops-spring-cloud-app/bin/startup.sh

ENV ServiceRoot /devops-spring-cloud-app

ENV ControlCenterAddress 127.0.0.1:9998
EXPOSE 7070
CMD ["sh","/go/startup.sh"]