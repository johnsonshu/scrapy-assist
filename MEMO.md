Only if site started with "www" ,
will we split partition with second part of domain.
So, "ww1" will not be under "www" folder.

example:
```
ww1.yifymovies.pro => ww/ww1.yifymovies.pro
www.ccdi.gov.cn => cc/ccdi.gov.cn
```

## for packaging with test
mvn package -Dspring.profiles.active=prod
## for packaging without test
mvn package -Dmaven.test.skip

java -Dspring.profiles.active=prod -jar scrapy

## Very good article for installing tomcat as Service
https://tecadmin.net/how-to-install-tomcat-10-on-ubuntu-20-04/