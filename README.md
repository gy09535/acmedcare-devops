<img src="doc/Acmedcare-Microservices-Project-Template-LOGO.png" width="128px" heigth="128px" alt=Acmedcare-DBM System Logo" />

## Acmedcare+ Micro-services Template Project

> A micro-services sample project.

### Overview

```

├── CHANGELOG.md                                            #   版本发布日志
├── LICENSE                                                 #   版权
├── README.md                                               #   项目描述文件
│
├── api                                                     #   项目基础模块:定义实体,接口等等
├── client                                                  #   客户端用于第三方调用/服务间通讯/SDK等等
│   ├── spring-cloud-openfeign-client                       #   服务间调用的Client依赖模块
│   └── spring-cloud-openfeign-client-sample                #   服务间调用的Client的 demo模块
│       
├── common                                                  #   项目公共模块:定义工具类,常量等等
│   
├── distribution                                            #   项目分发模块:支持区域/单体/云/离线等等模式
│   
├── doc                                                     #├── 项目文档
│   └── database                                             │   └── 数据库设计文档
│       └── account                                          │       └── 案例:通行证账号设计
│           ├── Account\ Model\ Design.ndm                   │           ├── ER图         
│           └── Account.sql                                  └───────────└── 脚本
│
├── endpoint                                                #   项目资源端口模块:RESTful
│   
├── repository                                              #├── 项目持久化模块
│   ├── repository-api                                       │   ├── 项目持久化接口模块
│   └── repository-jdbc                                      └───────└── 持久化 Simple JDBC 实现
│
├── test                                                    #   项目集成测试模块
└── pom.xml

```

### Requirements

Acmedcare+ Maven Repository Configuration

> [Configuration Reference](http://115.29.47.72:8082/acmedback/Acmedcare-Maven-Nexus/blob/master/README.md)

### Quick Start

You can download binaries from [Release Repo](http://115.29.47.72:8082/acmedback/Acmedcare-Microservices-Project-Template/tree/master/release) or [repo.acmedcare.com](http://47.97.26.165:8081/repository/maven-public/).

*First* : unzip release package

```bash
$ tar -zxvf *.tar.gz
```

*Second* : startup & shutdown

```bash
$ sh ./bin/startup.sh -p production  
```

*Third* : check the application log

```bash
$ tail -f logs/start.log
```

> param: -p (optional): `production` | `dev`


### Building from Source

You don’t need to build from source to use `Acmedcare+ Template Project` (binaries in [repo.acmedcare.com](http://47.97.26.165:8081/repository/maven-public/)), 
but if you want to try out the latest and greatest, 
`Acmedcare+ Template Project` can be easily built with the maven wrapper. You also need JDK 1.8.

*First* : git clone source from gitlab
 
```bash
$ git clone http://115.29.47.72:8082/acmedback/Acmedcare-Microservices-Project-Template.git
```

*Second* : build

```bash
$ mvn clean install
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