
# Spring Redis Mongo 

* A sample application that demonstrates a simple CRUD process with MongoDB as 
  a persistent store and Redis as a caching layer.

# Run as a docker container

**Build Docker image**

mvn install 

mvn docker:build

**Recreate docker image**

mvn clean install 

mvn docker:build

**Create and run as a docker container**

docker run -it \
--name vendor-reviews-app \
--net=host \
-e SERVICE_PORT=8095 \
-e MONGO_URL=mongodb://127.0.0.1:27010 \
-e REDIS_HOST=127.0.0.1 \
-e REDIS_PORT=6379 \
-e CACHE_EXPIRY_IN_SEC=600 \
vendor-reviews

Runs in network mode

**Rerun the existing container**

docker start vendor-reviews-app

**Stop the container**

docker stop vendor-reviews-app

**Login to the container**

docker exec -it vendor-reviews-app bash

## Swagger API doc

http://localhost:8095/swagger-ui.html

## Quick DB commands

**MongoDB**

use demo

db.vendor.find().pretty()
db.vendor_reviews.find().pretty()

**Redis**

get "<cacheName>:<key>"
Ex - get "vendorReviewCache:AP Apparels"