# Get all flats

##  Request
* Method `GET`
* Endpoint`/flat`
* Body: `None`
* Path Parameters: `None`
* Path Variables: `None`
    
## Responses
* Code `200`
* Response items

|Response item|Data type|
|---|---|
|id|long int|
|cost|double|
|surface|double|
|rooms|list|
|rooms / id|long int|
|rooms / surface|double|
|rooms / cost|double|

#### Sample
```json
[
    {
        "id": 1,
        "cost": 14.2,
        "surface": 12.35,
        "rooms": [
               {
                   "id": 3,
                   "surface": 1.4,
                   "cost": 13.35
               },
               {
                   "id": 5,
                   "surface": 123.4,
                   "cost": 12.35
               }         
        ]
    }
    {
        "id": 2,
        "cost": 13654.2,
        "surface": 12.35,
        "rooms": []
    }
]
```