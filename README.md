# Customer Relationships Management RESTful API
## Notes
- @PostMapping: add new entity
- @PutMapping: update existing entity
- @RequestBody: binds the POJO (converted from JSON in upcoming request body) to a method parameter, used for POST
- Set id to 0 when POST a new entity, so that ```saveOrUpdate()``` identify empty then force a save of new entity, instead of update
- If id does not existing, Hibernate returns a null entity.








