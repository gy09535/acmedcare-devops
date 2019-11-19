<img src="doc/Acmedcare-Microservices-Project-Template-LOGO.png" width="128px" heigth="128px" alt=Acmedcare-DBM System Logo" />

## Acmedcare+ DevOps

> Simple operation platform, with service register, service discover, service control. 
Must work with sidecar(more sidecar info in [Kernel](http://115.29.47.72:8082/acmedback/kernel))

### Overview
<img src="doc/operation-system.png" width="500px" heigth="500px" alt=Acmedcare-DevOps" />

### Requirements

Acmedcare+ Maven Repository Configuration

> [Configuration Reference](http://115.29.47.72:8082/acmedback/Acmedcare-Maven-Nexus/blob/master/README.md)

### Quick Start

Download Code 
```bash
$ git clone http://115.29.47.72:8082/acmedback/acmedcare-devops.git -b master

$ cd acmedcare-devops

$ mvn clean package -Dmaven.test.skip=true

$ ./distribution/spring-cloud-app/target

```

*First* : Build docker image

```bash
$ docker build -t devops:0.1.0.BUILD-SNAPSHOT -f /distribution/spring-cloud-app/src/main/docker/Dockerfile ./distribution/spring-cloud-app/target
```

*Second* : Run image

```bash
$ docker-compose -f ./script/docker-compose-devops.yml
```

*Third* : Check the application log

```bash
$ tail -f logs/start.log
```

> param: -p (optional): `production` | `dev`


### One step build

*First* : Just run script
 
```bash
$ sh ./script/devops-image-build.sh
```

If you want to build with the regular `mvn` command, you will need [Maven v3.5.0 or above](https://maven.apache.org/run-maven/index.html).


### Document

> editing

### License
 
```
Copyright (c) 2019 Acmedcare+

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```