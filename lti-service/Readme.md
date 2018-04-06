# LTI Launch Reference
## Demonstrates
* Calling the User service to get the wiley id assocated with the lti user 
* Generating a JWT for the user 
## To Test
    http://localhost:8080
https://bitbucket.org/b_c/jose4j/wiki/Home

# Local CANVAS testing
https://hub.docker.com/r/lbjay/canvas-docker/

    docker run -t -i -p 3000:3000 --name canvas-docker canvas-docker
    
Point your browser to http://localhost:3000. The admin user/pass login is `canvas@example.edu/canvas-docker`. 


# Reference
* https://github.com/IMSGlobal/basiclti-util-java   