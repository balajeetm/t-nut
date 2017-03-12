## Singly Linked List Reversal in Pockets
The formal problem statement would be as below :
```
Given a singly linked list, reverse its every 'n' nodes
```
```
The sample input and respective outputs expected are as below

Input:	1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL and n = 2
Output:	2 -> 1 -> 4 -> 3 -> 6 -> 5 -> NULL.

Input:	1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> NULL and n = 3
Output:	3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 8 -> 7 -> NULL.
```
For more details refer - [linked list reversal in pockets](http://blog.balajeetm.com/blog/2017/02/26/tnut-reverse-linked-list-pocket/)

### Steps to execute the T-Nut
* Run the application either using java -jar or the IDE
* Launch the Swagger UI @ http://localhost:7189/swagger-ui.html
* Choose the accordion named **"Singly Linked List : Reverse list's every n nodes"**

![swagger-ui](/assets/swagger.png)

* All apis can be used to test but the api named - "POST /tnut/reverse-in-pockets/pocketreverse" is the most efficient
* Supply inputs to the api via swagger as a json array of integers as shown

![request](/assets/reverse-in-pockets/request.png)

* The response after reversing in pockets will be shown as below :

![response](/assets/reverse-in-pockets/response.png)
