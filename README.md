# iQuest Keyboards & Mice - Brașov - 2016
Description
--
This repo contains the source code of a JEE 7 web application to be used during the "Deploying JEE to HEROKU" session at the "[Keyboards & Mice](http://www.iquestgroup.com/en/event/keyboards-mice-brasov-2016/)" iQuest public event, which will take place in Brașov on October 12th, 2016.  
The web application is composed of a servlet which reads some rows from a database via JPA, a simplified setup meant to present one approach to performing deployments on [Heroku cloud application platform](https://www.heroku.com/home).

Continuous Integration
--
* drone.io: [![Build Status](https://drone.io/github.com/satrapu/iquest-keyboards-and-mice-brasov-2016/status.png)](https://drone.io/github.com/satrapu/iquest-keyboards-and-mice-brasov-2016/latest)

Live Application
-- 
[http://iq-kam-brasov-2016.herokuapp.com/demo/](http://iq-kam-brasov-2016.herokuapp.com/demo/)

References
--
* Heroku
  * Official Site: https://www.heroku.com/home
  * How Heroku Works: https://devcenter.heroku.com/articles/how-heroku-works  
  * Pricing: https://www.heroku.com/pricing
  * Heroku CLI: https://devcenter.heroku.com/categories/command-line
  * Limits: https://devcenter.heroku.com/articles/limits  
  * Error Codes: https://devcenter.heroku.com/articles/error-codes  
  * Java on Heroku: https://devcenter.heroku.com/categories/java  
  * Heroku Java Support: https://devcenter.heroku.com/articles/java-support  
  * Troubleshooting Memory Issues in Java Applications: https://devcenter.heroku.com/articles/java-memory-issues  
  * Alternatives:
    * Red Hat OpenShift: https://www.openshift.com/  
    * IBM Blue Mix: http://www.ibm.com/cloud-computing/bluemix/  
    * Others
* WildFly Swarm
  * Official Site: http://wildfly-swarm.io/
  * User Guide: https://www.gitbook.com/book/wildfly-swarm/wildfly-swarm-users-guide/details
  * Generator: http://wildfly-swarm.io/generator/
  * Just Enough App Server with WildFly Swarm presentation by Antonio Goncalves: https://antoniogoncalves.org/2016/07/13/just-enough-app-server-with-wildfly-swarm/
  * Alternatives:
    * Payara Micro Edition: http://www.payara.fish/payara_micro
    * Spring Boot: http://projects.spring.io/spring-boot/
    * Others
* Drone.io
  * Official Site: https://drone.io/
  * Heroku Deployments: http://docs.drone.io/heroku.html
  * Alternatives:
    * CodeShip: https://devcenter.heroku.com/articles/codeship
    * Travis CI: https://docs.travis-ci.com/user/deployment/heroku
    * Others
* Java Enterprise Edition 7
  * Official Site: http://www.oracle.com/technetwork/java/javaee/overview/index.html
  * JEE7 Tutorial: https://docs.oracle.com/javaee/7/tutorial/
  * Ticket Monster: http://developers.redhat.com/ticket-monster
* Database Migration Tools
  * Flyway: http://www.hascode.com/2013/04/easy-database-migrations-using-flyway-java-ee-6-and-glassfish/
  * Liquibase: http://www.hascode.com/2014/07/java-ee-7-database-migrations-with-liquibase-and-wildfly/
  * Others
  
Useful Heroku CLI commands
--
* Run Heroku application on my Windows machine:
````
heroku local -f Procfile.windows -e .env -p 6789
````

* Display all environment variables defined on the Heroku node:
````
heroku run printenv
````

* Display all config vars defined inside the Heroku application:
````
heroku run printenv
````

* Dispaly the details of the Heroku node OS:
````
heroku run 'cat /etc/*-release' --app iq-kam-brasov-2016
````

* Copy config var from Heroku application to local .env file:
````
heroku config:get DATABASE_URL -s  >> .env
````
