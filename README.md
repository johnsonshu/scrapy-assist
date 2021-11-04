Only site started with "www" , 
we will split partition with second part. 
"ww1" is not "www".

example:
```
ww1.yifymovies.pro => ww/ww1.yifymovies.pro
www.ccdi.gov.cn => cc/ccdi.gov.cn
```

## for packaging with test
mvn package -Dspring.profiles.active=prod