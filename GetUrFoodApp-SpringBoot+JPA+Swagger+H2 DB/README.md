This is GetUrFood SpringBoot Application with JPA+Swagger+H2 DB

Application can be accessed by using "http://localhost:8081/food"

By using swagger can be accessed by "http://localhost:8081/swagger-ui.html"

This Application has list of users and fooditems in the H2DB and can placed/create the orders you want.

Using by endpoints, you can get the user can sign on and get user list or fooditems list or food items list by name

	/food/signon - to do sign on
	/food/items - to get all food items
	/food/users - to get all users	
	/food/items/{itemName} - to get all food items based on item name
	/food/order - to place the food order 

Tables involved are
	
	USERS, FOOD_ITEMS and ORDER_DETAILS

Use below H2DB configurations while you are connecting H2 console
	
	Driver class: org.h2.driver	
	JDBC URL: jdbc:h2:mem:testdb
	User Name: sa  