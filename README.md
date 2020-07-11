# Customer Relationships Management RESTful API
## Endpoints
- GET ```/api/customers```: get list of customers
- POST ```/api/customers```: add a new customer
- POST ```/api/customers-multiples```: add multiple customers
- PUT ```/api/customers```: update an existing customer (include id in request body)
- PUT ```/api/customers/{id}```: update an existing customer (not include id in request body)
- DELETE ```/api/customers/{id}```: delete a customer

---

## Notes
- *__@PostMapping:__* add new entity
- *__@PutMapping:__* update existing entity
- *__@RequestBody:__* binds the POJO (converted from JSON in upcoming request body) to a method parameter, used for POST/PUT
- Set id to 0 when POST a new entity, so that ```saveOrUpdate()``` identifies empty then force a save of new entity, instead of update.
- If id does not existing, Hibernate returns a null entity.








