This project was made upon request by a Manga Translation group to help them connect a NoSQL like MongoDB to their website. 

This REST API allows them to add Mangas, Chapters and Staff to the Database to help management tasks.
About mangas they want to store data such as:
-Title
-Author
-Release date
About chapters they just want to store just the info. (The pages themselves are stored in their website)
-Number
-Title
-Which manga they belong
-Which staff members worked on it and what were their roles

The RestAPI will perform merely CRUD operations upon request, following HTTP requests. Returning appropriate responses depending on the situations (like 200, 404, 405, 500, etc.)

The project uses libraries like MapStruct & Lombok to reduce boilerplate code like setters/getters/constructors and JUnit for testing the functionality
