# Webstore
This is a webstore project that is based on spring framework

Project is build in maven. As server I was using Glassfish 5. 

As database was used postgresql 9.4. Connecting and operarting database is provided by Hibernate 5.

Hibernate is confgured by xml files. For each model was created separate mapping file. 

Web pages are using JSF, Facelets and PrimeFaces commponents. For better desin also was integrated bootstrap.

Process of user Log In and Log out is controlled by spring securiry.

## **Functionality:**
- To access site you should login first. And have any role('ROLE_USER' or 'ROLE_ADMIN')
- Username user that is logged in displays in top left corner, near exit button.
- User can filter books by genre, there is also 'All' button to clear all filters.
- User can search books by name.
-User can make order by clickin 'Buy Now' button.
-There is pagination,  user can select how many items are displayed on page
To confirm order you should fill a little form with your contacts.
All maked orders goes to database.
- Admin can delete books:
If user are logged in as admin, for him renders 'delete' button near each item.


## **Functionality to be aded in future:**
- Registration form
- Logging
- More functions to admin

## Screenshots:

![No image](https://snag.gy/BbWZ2L.jpg)
![No image](https://snag.gy/a8XnGb.jpg)
![No image](https://snag.gy/vIUMxF.jpg)
![No image](https://snag.gy/5D7W2G.jpg)
