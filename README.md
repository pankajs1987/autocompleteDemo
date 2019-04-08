TO Run Application Kindly use following process
1. Run mvn -U clean install
2. mvn spring-boot:run

URL: http://localhost:8089/suggest_cities?start=che&atmost=5

How this Application works
1.Its Load data from dummyDataCities.xlsx and load List of Cities.
2.When User Queries with String and number of required result then it query that list and return a list of required cities. 
