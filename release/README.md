## Release Binaries Packages

> NOTE: gitlab does not support uploading files larger than 10M. So please put the release package in this directory

### Release Steps

*First* : build your release package

*Second* : [Create new gitlab tag](http://115.29.47.72:8082/acmedback/Acmedcare-Microservices-Project-Template/tags/new)

*Third* : copy binaries package into `release/${project.release.version}/` .

*Fourth* :  edit [CHANGELOG.md](../CHANGELOG.md)

*Fifth* : commit & push . 