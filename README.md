

### Configuration

#### Use IntelliJ IDEA to open the project
The default Run Configuration has "-Dspring.profiles.active=dev" JVM parameter
, which specify application-dev.yml as configuration file

#### MongoDB
1) MongoDB should have a database whose name is set 
in the application-dev.yml or application-prod.yml

2) Create a collection named "sites", then import the json data from "design/sites.json"
