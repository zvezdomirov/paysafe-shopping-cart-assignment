# Shopping Cart Application *(Command Line)*

###  Available commands description:

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
  - Finalizes your shopping session -> Empties the shopping cart -> Terminates the program

### Sample program run:
```
  *Program automatically generates and outputs a list of available items on the stdout*:
List of available items in the shop:
ShopItem{id=0, name='Item 0', price=6.20}
ShopItem{id=1, name='Item 1', price=7.74}
ShopItem{id=2, name='Item 2', price=4.89}
ShopItem{id=3, name='Item 3', price=6.51}
ShopItem{id=4, name='Item 4', price=4.68}
ShopItem{id=5, name='Item 5', price=6.12}
ShopItem{id=6, name='Item 6', price=9.04}
ShopItem{id=7, name='Item 7', price=2.73}
ShopItem{id=8, name='Item 8', price=6.93}
ShopItem{id=9, name='Item 9', price=4.72}

  *Waits for input through stdin*
register john 1234
register george 5678
login john 1234
add 3 7
add 1 5
review
ShopItem{id=1, name='Item 1', price=7.74} x 5
ShopItem{id=3, name='Item 3', price=6.51} x 7
Total Price: 38.70
remove 1 3
checkout
Thank you for shopping here!
Your bill has a total of 15.48

Process finished with exit code 0
```
