package flatroomservice.business

import org.springframework.cloud.contract.spec.Contract

Contract.make{
    description("should return flat by id=1")

    request {
        url "/flat/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body {
            id: 1,
            cost: 200.53,
            surface: 12.35
        }
    }
}