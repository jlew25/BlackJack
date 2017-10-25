# BlackJack
Simple black jack game with basic functions
Objective: Create a GUI version of BlackJack in which one player plays against the House.
 
About BlackJack: BlackJack is the game of 21 in which a player plays against a dealer.  At the conclusion of play, the person closest to 21,
without going over, wins.
 
Game Play: For each hand, play begins with the player making a wager.  The wager must be greater than 0 and less than or equal to the 
amount they have.  Following the wager, four cards are dealt in the following manner:
Face up Player
Face down House
Face up Player
Face up House
The player can decide to HIT(take a card) or STAY(call the dealer).  The dealer's choices are simple: total<=16, hit; total>=17, stay.
 
Card Information: Aces can count as 1 or 11(whichever is most advantageous in the situation) and face cards count as 10.  
All other cards are face value and suits are irrelevant.  
The game is often dealt from a multi-deck shoe, meaning that there are many of each card, so we need not worry about avoiding duplicates.
 
Assignment Particulars: Build a GUI version of BlackJack.  Players sign in with their name and are given $500.  
Play continues, hand after hand, until the user quits, goes bankrupt ($0) or reaches the floor maximum ($2000). 
Keep track of the number of hands each player plays so that you can maintain an external data file of the Biggest
Winners/Biggest Losers (in other words, how many hands it takes to get to $0 or $2000).  
When a player gets blackjack, the payout is 3:2, in other words, if they bet $4, they win $6. 
Regular wins payout 1:1, in other words, if they bet $4, they win $4.
 
