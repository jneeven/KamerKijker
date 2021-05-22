#What does this service do

#How to use the service

#How to run locally
- `docker-compose run -d --name kk-postgres -p 5432:5432 kk-postgres`
- Run the kotlin service

TODO YS: create complete docker compose file


#How to test

##Local intergration tests

Run all integration tests:
- `docker-compose run kk-postgres-it`
- `mvn integration-test jacoco:report verify -Pfailsafe -Dspring.profiles.active=localci`

Run single test case via Intelij:
- `docker-compose run kk-postgres-it`
- Run the selected test case with the active spring profile "localci" in Intellij (`SPRING_PROFILES_ACTIVE=localci`)
  https://prnt.sc/12t29zk
