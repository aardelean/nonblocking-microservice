Non blocking microservice which selects from database and returns to a rest call

Tehnologies used: 
    -   gradle
    -   vertx for light nonblocking underline framework
    -   qbit for annotation like rest services and still non blocking
    -   jooq for light sql execution
    -   quasar for encapsulating jdbc calls resulting in fiber opens and not threads
    -   spring for configuration and DI
    -   capsule for building fat jar and keep vm parameters. Total size is 17MB.
    -   mysql as database
