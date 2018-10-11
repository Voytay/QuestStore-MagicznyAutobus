Code coverage with tests: 23% of classes, 12% of methods, 6% of lines

Methods and issues:

# AbstractHttpHandletTest.checkIfParseFormDataHandlesEmptyLoginData()

Login website was crashing after entering empty input. 
We found a reason in parseFormData() method and fix it. 
This test is checking it.

# ProfileHandlerTest.testIfHandlesInvalidCookie() 

Checks if ProfileHandler redirects to main site when user is not recognized because of invalid cookie.

# ProfileHandlerTest.testIfHandlesNullCookie() 

Checks if ProfileHandler redirects to main site when user is not recognized because of null cookie value.

# ProfileServiceTest.testIfHandlePostHandlesUnexpectedInput()

Checks if service can handle with unexpected input - before it was crashing if it didn't recognized input and it wasn't a number. We fixed that problem.


# ifUserHasWalletTRUE() 
checking if making proper user also make proper wallet 
only Students have wallets, so if role is set to MENTOR we should get null 			from getWallet() method
		problems: need to change access modifier from private to public

# canRunServerOnPort80()  
checking if able to start server on restricted port
					

# ifSessionRemovedTRUE()  
checking if terminating session also deleting it from SessionPool 
		problems: need to change access modifier from private to public

# LoginHandlarTest.testIfHandlePostMethodGetsCalled():

This test mocks HttpExchange object and checks if handlePost method gets calld.

# LoginHandlarTest.testIfRedirectMethodGetsCalld():

This test mocks HttpExchange object and checks if redirect method gets calld. This test checks if user will be redirected to his/her profile page when his/her session is valid meaning if session exist in SessionPool and has the same UUID as user cookie value.

# LoginServiceTest.testIfsessionIsNullWhenUserIsNotInDatabase():

This test checks if new session will not be created when user does not exist in database while login.

# LoginServiceTest.testIfSessionGetsCreatedWhenUserIsInDataBase():

This test checks if new session will be created and added to SessionPool when user exist in database while login.
Encountered problems: To test this funcionality modificatin in Login and LoginService class was needed.

# LogoutServiceTest.checksIfsessionExistswhenLogout():

This test checks the logout funcionality. When user logout from application his/her session should be removed from SessionPool.
Encountered problems: Due to missing brackets in getSessionByUUID method in SessionPool wrong session were being removed.


