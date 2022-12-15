# Spring Security Demo

1. In-memory authentication
2. Basic Authentication
3. JWT

Basic Auth
- go to Postman and select GET / POST method and select authorization
- provide username and password
- in basic authentication it creates a token (username + password) and encode in 64bit encoded format
- and it will send to the application the token
- in response header we will get the basic authentication token
- also we should enable basic authentication in our spring application [ http.httpBasic();]
