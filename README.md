# test-external-api
#### Just a set of endpoint to test external API errors

1. GET : 
```sh
 https://test-external-api.herokuapp.com/test/all-good
```
2. POST :
 ```sh
  https://test-external-api.herokuapp.com/test/time-out/{timeOutInMilliSeconds}
 ```
3. POST : 
```sh 
https://test-external-api.herokuapp.com/test/internal-server-error
```
4. POST : 
 ```sh 
 https://test-external-api.herokuapp.com/test/service-unavailable
 ```
