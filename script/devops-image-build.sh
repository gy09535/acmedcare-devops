#!/usr/bin/env bash
#!/usr/bin/env bash
GIT_URL="http://115.29.47.72:8082/acmedback/acmedcare-devops.git"
BRANCH="master"
ROOT="${PWD}/acmedcare-devops"
BUILD_DIR="./distribution/spring-cloud-app/target"
DOCKERFILE_DIR="./distribution/spring-cloud-app/src/main/docker/Dockerfile"
IMAGE_NAME="devops"
VERSION="0.1.0.BUILD-SNAPSHOT"

echo $GIT_URL
if [ -d "${ROOT}" ]; then
 echo "rm -rf ${ROOT}"
 rm -rf ${ROOT}
fi

## git clone
pwd
echo "git clone ${GIT_URL} -b ${BRANCH}"
git clone ${GIT_URL} -b ${BRANCH}
if [ $? -ne 0 ];then
  echo "exe git fail"
  exit
fi

## mvn build
cd $ROOT
mvn clean package -Dmaven.test.skip=true
if [ $? -ne 0 ];then
  echo "exe mvn fail"
  exit
fi

# cop spark
# cp -r ./executor/lib/spark-2.4.3-bin-hadoop2.7.tgz ./executor/target/spark-2.4.3-bin-hadoop2.7.tgz

## docker build
docker build -t "${IMAGE_NAME}:${VERSION}" -f $DOCKERFILE_DIR $BUILD_DIR
if [ $? -ne 0 ];then
  echo "exe docker fail"
  exit
fi

docker tag "${IMAGE_NAME}:${VERSION}" "docker.apiacmed.com/acmedback/${IMAGE_NAME}:${VERSION}"
if [ $? -ne 0 ];then
  echo "exe tag fail"
  exit
fi

## docker push
docker push "docker.apiacmed.com/acmedback/${IMAGE_NAME}:${VERSION}"