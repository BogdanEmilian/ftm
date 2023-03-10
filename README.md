# Tabs

- **Dashboard**
- **List of players**
- **Player performance**
- **Last games**


## Dashboard
Last **X** games statistics. (10 points on the graph - for multiple games, 
there is an average between them and the user is required to select last 10-20-30-40-50 games progress to be displayed)

Statistics included: 
- score leads (goals scored - goals received)
- possession
- goal accuracy
- last **10** games scores (red if game was lost, green if game was won): Opposing team, score, duration 

## List of players
Each player will have the general data about them:
- name
- age
- position
- height (in cm)
- weight (in kg)
- value (amount to be paid by other teams)
- salary
- number of appearances


## Player performance
Specific data for each player:
- free kicks shot
- free kicks scored
- injured (bool - if he is injured at that very moment, since medication period could increase/decrease)
- number of goals
- yellow cards
- red cards
- passing accuracy
- fouls committed
- goal accuracy


## Game list:
Each game will have:
- opposing team name
- goals scored
- goals received
- date
- possession
- corners
- penalties
- free kicks
- time (in minutes, plus overtime)
- misses


## Touch-ups
- CSS for the UI in JavaFX
- dashboard is the last **10** or **X** games statistics
- additional function: find best performing team setup
- team members should have a randomly generated name
- random data for placeholders should be included when creating a new entry
- get optimal team comp - PDF analysis export
- adding/removing data would pop-up an external window
