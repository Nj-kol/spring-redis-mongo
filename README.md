
# Spring Redis Mongo 

A sample application that demonstrates a simple CRUD process with MongoDB as a persistent store
and Redis as a caching layer.


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