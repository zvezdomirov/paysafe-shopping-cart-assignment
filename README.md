# Shopping Cart Application *(Command Line)*
### List of the available commands:
- `register ` *@username* *@password*
  - Registers a new user with *@username* and *@password*
  - If you don't `register` before trying to `login`,
    the app registers you automatically.
  - Useful when creating multiple users before logging in
  
- `login` *@username* *@password*
  - Tries to login with *@username* and *@password*:
  - Prints a warning if *@password* doesn't match
    the user, registered under *@username*
      
- `add` *@item_id* *@quantity*
  - *@item_id* should be a valid item id from the provided item list
  - Adds *@quantity* number of items with *@item_id*
  
- `remove` *@item_id* *@quantity*
  - *@item_id* should be a valid item id from your shopping cart (items you already added)
  - Removes *@quantity* number of items with *@item_id* from your shopping cart
  
- `review`
  - Prints information about every item you have in the shopping cart
    and total price of the shopping cart's content
    
- `checkout`
  - Finalizes your shopping session
            :arrow_down:
  - Empties the shopping cart
            :arrow_down:
  - Terminates the program
