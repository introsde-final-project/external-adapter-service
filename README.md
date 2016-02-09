# External Adapter Service

External Adapter Service is responsible to interact with external services.  In fact, this service creates a link between our application and Edamam - Eat Better! and Quotes on Design. 

####	[Edamam - Eat Better!](https://www.edamam.com/) 
External Adapter Service obtains the information about the type of food that we are looking for, from Edamam - Eat Better. For instance, if we supply the types like high protein, low carbohydrate, balanced diet, low fat, absolutely low fat then it will return the food which has the respective quality. The communication between these services are in REST with JSON objects.

####	[Quotes on Design](http://quotesondesign.com/)
External Adapter Service obtains quotes which we use in our application as ‘Thought of the Day’ from Quotes on Design. The communication between these services are in REST and uses JSON objects.

After obtaining necessary data, this service pass them to the Storage Service.

Further information on this service can be found in its [Wiki Page](https://github.com/introsde-final-project/external-adapter-service/wiki).

[Click here to access this service in Heroku.](http://external-adapter-service.herokuapp.com/adapter/quote)
