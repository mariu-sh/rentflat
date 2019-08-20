# Get all flats

##  Request
| | |
|---|---|
|Method:| `PUT`|
|Endpoint:| `/flat`|
|Path Variables:|`None`|
|Path Parameters:|`None`|
### Body

|Response item|Data type|Description|
|---|---|---|
|cost|double|Cost of created flat|
|surface|double|Surface of created flat|

#### Sample
```json
{
    "cost": 14.2,
    "surface": 12.35
}
```

    
## Responses
### Positive
* Code `200`
* Response items

|Response item|Data type|Description|
|---|---|---|
|id|long int|id of updated flat|
|cost|double|cost of updated flat|
|surface|double|surface of updated flat|
|rooms|list|empty list of rooms|

#### Sample
```json
{
    "id": 1,
    "cost": 14.2,
    "surface": 12.35,
    "rooms": []
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
