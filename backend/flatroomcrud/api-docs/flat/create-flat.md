# Get all flats

##  Request
| | |
|---|---|
|Method:| `POST`|
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
* Code `200`
* Response items

|Response item|Data type|Description|
|---|---|---|
|id|long int|id of created flat|
|cost|double|cost of created flat|
|surface|double|surface of created flat|
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
