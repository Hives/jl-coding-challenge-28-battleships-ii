# John Lewis Coding Challenge 28

Making the battleships application used in challenge 27

<https://coding-challenges.jl-engineering.net/challenges/challenge-28/>

Using Kotlin and Ktor.

## To run

```shell script
./gradlew run
```

## To test

```shell script
./gradlew test
```

## To play

Make a request to the endpoint with a query parameter `shots` containing the list of squares you want to take shots at, like this:

```shell script
curl localhost:8080?shots=A2B2C2A9
```

The response will tell you whether each shot was a hit (`H`) or a miss (`M`), or if a number of shots have sunk a battleship those shots will be marked as sunk (`S`):

```json
{
  "results" : [ "M", "H", "M", "S" ]
}
```