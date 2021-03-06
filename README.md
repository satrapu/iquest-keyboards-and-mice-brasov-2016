# iQuest Keyboards & Mice - Brașov - 2016
**Table of Contents**  
- [Description](#description)  
- [Presentation Slides](#slides)  
- [Presentation Video](#video)  
- [Event Photos](#photos)
- [Event Highlights Video](#highlights-video)
- [Continuous Integration](#ci)  
- [Live Application](#live-application)  
- [References](#references)  
- [Useful Heroku CLI commands](#heroku-cli-commands)  

<a name="description">Description</a>
--
This repo contains the source code of a JEE 7 web application used during the "Deploying JEE to HEROKU" session at the "[Keyboards & Mice](http://www.iquestgroup.com/en/event/keyboards-mice-brasov-2016/)" iQuest public event, which took place in Brașov on October 12th, 2016.  
The web application is composed of a servlet which reads some rows from a database via JPA, a simplified setup meant to present one approach to performing deployments on [Heroku cloud application platform](https://www.heroku.com/home).

<a name="slides">Presentation Slides</a>
--
* SlideShare: http://www.slideshare.net/satrapu/deploying-jee-to-heroku

<a name="video">Presentation Video [Romanian]</a>
--
* Youtube: https://www.youtube.com/watch?v=7OHYeat8rQM

<a name="photos">Event Photos</a>
--
* Flickr: https://www.flickr.com/photos/iquestgroup/sets/72157671845375494

<a name="highlights-video">Event Highlights Video</a>
--
* Youtube: https://www.youtube.com/watch?v=otZuVHMsmow

<a name="ci">Continuous Integration</a>
--
* drone.io: [![Build Status](https://drone.io/github.com/satrapu/iquest-keyboards-and-mice-brasov-2016/status.png)](https://drone.io/github.com/satrapu/iquest-keyboards-and-mice-brasov-2016/latest)

<a name="live-application">Live Application</a>
-- 
[http://iq-kam-brasov-2016.herokuapp.com/demo/](http://iq-kam-brasov-2016.herokuapp.com/demo/)

<a name="references">References</a>
--
* Heroku
  * Official Site: https://www.heroku.com/home
  * Pricing: https://www.heroku.com/pricing
  * Heroku Architecture: https://devcenter.heroku.com/categories/heroku-architecture
  * Limits: https://devcenter.heroku.com/articles/limits  
  * Elements: https://elements.heroku.com/
  * Heroku CLI: https://devcenter.heroku.com/categories/command-line
  * Buildpacks: https://devcenter.heroku.com/articles/buildpacks
  * Deployment: https://devcenter.heroku.com/categories/deployment
  * Error Codes: https://devcenter.heroku.com/articles/error-codes  
  * Java on Heroku: https://devcenter.heroku.com/categories/java  
    * Customize Maven: https://github.com/heroku/heroku-buildpack-java#customize-maven
    * Heroku Java Support: https://devcenter.heroku.com/articles/java-support  
    * Troubleshooting Memory Issues in Java Applications: https://devcenter.heroku.com/articles/java-memory-issues  
    * Remote Debugging: https://jkutner.github.io/2015/05/19/heroku-remote-debug-java.html - TO BE CONFIRMED!!!
  * PostgreSQL: https://devcenter.heroku.com/categories/heroku-postgres
    * Connecting in Java: https://devcenter.heroku.com/articles/heroku-postgresql#connecting-in-java
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
* Java Enterprise Edition 7
  * Official Site: http://www.oracle.com/technetwork/java/javaee/overview/index.html
  * JEE7 Tutorial: https://docs.oracle.com/javaee/7/tutorial/
  * Ticket Monster: http://developers.redhat.com/ticket-monster
* Database Migration Tools
  * Flyway: http://www.hascode.com/2013/04/easy-database-migrations-using-flyway-java-ee-6-and-glassfish/
  * Liquibase: http://www.hascode.com/2014/07/java-ee-7-database-migrations-with-liquibase-and-wildfly/
  * Others
* Drone.io
  * Official Site: https://drone.io/
  * Docs: 
    * Old: http://docs.drone.io/
    * New: http://readme.drone.io/
  * Source Code: https://github.com/drone/drone/
  * Demos: https://github.com/drone-demos/
  * Plugins: https://github.com/drone-plugins/
  * Heroku Deployments: http://docs.drone.io/heroku.html
  * Alternatives:
    * CodeShip: https://documentation.codeship.com/continuous-deployment/deployment-to-heroku/
    * Travis CI: https://docs.travis-ci.com/user/deployment/heroku
    * Others
  
<a name="heroku-cli-commands">Useful Heroku CLI commands</a>
--
* Run Heroku application on a Windows machine:
```bash
heroku local -f Procfile.windows -e .env -p 6789
```

* Display all environment variables defined on the Heroku node:
```bash
heroku run printenv --app iq-kam-brasov-2016
```

* Display all config vars defined inside the Heroku application:
```bash
heroku config --app iq-kam-brasov-2016
```

* Display the details of the Heroku node OS:
```bash
heroku run 'cat /etc/*-release' --app iq-kam-brasov-2016
```

* Display the last 250 logged messages and keep monitoring the log:
```bash
heroku logs -t -n 250 --app iq-kam-brasov-2016
```

* Copy config var "DATABASE_URL", which contains the URL pointing to the Heroku managed PostgreSQL database, from Heroku application to the local .env file:
```bash
heroku config:get DATABASE_URL -s  >> .env --app iq-kam-brasov-2016
```
