# Get all flats

##  Request
| | |
|---|---|
|Method:| `GET`|
|Endpoint:| `/flat/{id}`|
|Body:|`None`|
|Path Variables:| {id} - id of flat to get |
|Path Parameters:|  |
    
## Responses
### Positive
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
```
### Negative
* Code `404`
* Response items

|Response item|Data type|Description|
|---|---|---|
|timestamp|string|Timestamp of an request within ISO-8601 format|
|status|int|Status code of an response|
|error|string|Error message of HTTP Code|
|message|string|Message explaining reason what happened|
|path|string|Endpoint for which request was made, when causing issue|
#### Sample
```json
{
    "timestamp": "2019-08-19T20:09:45.895+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Flat not found",
    "path": "/flat/14"
}
```
