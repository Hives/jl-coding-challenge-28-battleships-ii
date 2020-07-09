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

Adapted from the instructions for [challenge 27](https://coding-challenges.jl-engineering.net/challenges/challenge-27/):

> The web service accepts a query parameter of `shots`: this is a string containing all the shots you want to fire. A0 is the top left of the opponents grid and J9 is the bottom right of the grid. e.g. `localhost:8080/?shots=B3` fires a shot at grid reference (B,3). To fire more than one shot in a request concatenate each grid reference, e.g. shots=B3B4B5.
  
> The response will be an array telling you the result of each shot. `M` means miss, `H` means hit and `S` means sunk. Eg. `shots=A1B5B6B7` could return: `{"results":["M","H","H","M"]}`. You will only be told if a ship is sunk if you fire all shots at a ship in the same request, as the webservice is stateless. E.g. `shots=A1B2B3B4B5B6B7` could return: `{"results":["M","S","S","S","S","S","M"]}`.
  
So for example, making this request:

```shell script
curl localhost:8080?shots=A2B2C2A9
```

Might return:

```json
{"results":["M","H","M","S"]}
```