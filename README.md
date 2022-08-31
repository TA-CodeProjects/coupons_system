# coupons_system

The system acts as a micro service that implement CRUD operation.

### The system have three type of users:

**Companies** - can create discount coupons to promote their products.

**Customers** - the system have registered customers that can purchase coupon,
customer limit to one kind of coupon purchase, the coupons have expired date and limited amount.

**Admin** - can create companies and customers.

### Login:

Depends on the client type login the system give access to the relevant CRUD
operations.

### Main technologies:

**Backend:** Spring Boot.<br/>
- Libraries: Web, Spring-data-JPA(Hibernate), Spring-security.
- Build tool: Maven.

**Frontend:** React.
- Libraries: Typescript, Redux, Bootstrap.
- Build tool: npm.

**Database:** MySQL.

