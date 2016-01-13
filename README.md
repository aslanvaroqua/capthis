This is A Rest application that allows you to create users, upload images, and then have users add captions to these users (MEMES). The captions can then be voted up or down. 
It's just an application made for fun and to show my abilities. It shows request objects and models and converters that allow you to validate the data being entered. It also contains examples
of tests using mock objects rather than real infrastructure. 

Also, I included oauth2. 

USAGE:

Run UserServiceTest to create a client (the client info will be in the application configuration file). 

Authenticate Client:

http://localhost:8080/oauth/token?grant_type=client_credentials&client_id=sso-auth-client&client_secret=mySecret

Authenticate User

http://localhost:8080/oauth/token?grant_type=password&username=user@awesome.com&password=very_hard_password&client_id=sso-auth-client&client_secret=mySecret

Then you must pass the access token as a header for subsequent request. You can look in the controllers for end points. I will later put it into a docu. 

Authorization : Bearer {accessToken}

soon i will add the ability to get user infor from the accessToken. 

TO DO: 
Add spring thymeleaf templates, integrate akka into spring project. 

Aslan Varoqua
# capthis
