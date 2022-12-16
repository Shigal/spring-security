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


Database Auth
- create 2 entities User and Authority and Join tables
- to handle User, implements UserDetailsService
- create a repo
- to hardcode the user details use init() method with @PostConstruct
- we already added the h2-database, now we enable it in application.yml
- can view the database by going to the link localhost:8080/h2-console
- but it says forbidden
- to make connection we need to give access to this url in config(HttpSecurity)
- but it says forbidden, so we need to disable csrf

H2-database
- go to console localhost:8080/h2-console
- paste the jdbc url
- view all the tables created 


Ant Matcher
? matches one character
* matches zero or more characters
  ** matches zero or more directories in a path
  

csrf
- Cross Site Request Forgery
- here, if we say we are making a money transfer in a bank app
- attacker creates the same page and input his account number and 
- link it to an image tag that automatically loads or 
- creates a form with hidden details which get submitted when the page loads
- in this way attacker can make you transfer money to his account with a click
- to avoid these attacks we have csrf token which is a secret the server generates and sends it to the client

JWT
- user logIns and it checks the identity of the user
- and it grants permissions to access the resources
- number of ways to do authorization
- when we are calling an API we pass username and password, have to do it every time
- for that we generate a token to do authorization on the server