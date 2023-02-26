# Back-to-the-classics
An application I developed for the Human Computer Interaction subject at the University of Oviedo

In the development of the project I followed the façade pattern like in the lab. In the module package I have the classes associated with the entities used like Caracter used to initiate the board, the Ticked and Store used for validation, the Product used in the shop and the game Board which represents the state of the game in any given moment as it s represented as a two-dimensional array with the dimensions of 7x7. Initially the board is filled with five random caracters at any change the board is updated and we check the neighbors of the updated cell with the method checkInvader(); which checks every possible combination of neighbors and marks them using the class eliminate for further use.

Further we have three classes(Order, Rules, TicketCheck ) that implement the main methods of every part of the app and the façade Game.

In the MainWindow we have everything related to the GUI . The invaders are generated when each wave starts dynamically as a random image is loaded for each dynamic label created in the caracters Panel(newDissapear()).
