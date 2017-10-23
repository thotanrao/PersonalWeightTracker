# PersonalWeightTracker

Person Weight Tracker application using SpringBoot, MongoDB, Morphia
This application is responsible for storing the data into the data in a MongoDB collection using Morphia API 

Metrics API – stores the data in  metrics collection
Alerts API – stores the alerts that were created by the rules in alerts collection
API methods:
create – this is the API that will create data
read – reads all the metrics stored in your database
readByTimeRange – reads all the metrics that were created between the given two timestamps
