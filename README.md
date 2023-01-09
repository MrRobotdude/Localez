# Localez
Project Mobile Programming
2201792972 - Yose Pratama Siburian
2301920626 - Doddie Prawarjito
2440030872 - Jovito Colin
2440057501 - Nicole Wijaya

Localez
Localez is an android application that provides various information articles from various sources around the worlds.
You can read any updated and hot-topic news from many sources on this app without opening different apps or opening some specific website.

We are using News API from https://newsapi.org/

# Login Page

![Login](https://user-images.githubusercontent.com/54783708/211239995-bfb00e6b-e467-4184-ae74-8d98d91fe09e.png)

This is the view of the login page, user can login via google, or just type their credential into the textboxes if they have any account. The textboxes have validations such as: user can't leave any textboxes empty, or inputing invalid email. If they fail to login with an account, Localez will notify them that authentication failed or some certain validation need to be followed.

# Register Page

![Register](https://user-images.githubusercontent.com/54783708/211240356-34f70fe6-a250-4488-a9d1-309ad06ba8ae.png)

This is the view of register page. Similar to login, in this page, user can just login via google, or just create new account with email and new password. The textboxes have validations such as: user can't leave any textboxes empty, inputing invalid email, inputing password less than 8 characters long or did not contain atleast 1 alphabet, 1 number, and 1 special character, and also user can't fill password textbox and confirm password textbox different. If they fail to register with new account, Localez will notify them that registration error or some certain validation need to be followed.

# Home Page

![Main](https://user-images.githubusercontent.com/54783708/211240962-6767d697-0882-4cad-864c-918a29b3b781.png)

This is the default view of Home page. It consists of log out button to log out from any account you logged on, categories tab to change news list into specific categories, regions spinner to change region of the news user want to read, and list of the top news from each categories, which include title, short abstracts, header image, author, and the time they were released.

![Main-Health](https://user-images.githubusercontent.com/54783708/211241218-ececb048-1ad0-470c-9ace-0fd5c961066f.png)

This is the look of different view of Home page when user change different category.

![Main-US](https://user-images.githubusercontent.com/54783708/211241262-5ae46747-0378-4e7c-b143-28310fe1e62a.png)

This is the look of dfferent view of Home page when user change different region.

# Web View Page

![WebView](https://user-images.githubusercontent.com/54783708/211241323-c55a3b76-ca1a-47f4-84d1-a9f9c529cdba.png)

This is the view of Web View Page. In this page, user can read the news without leaving Localez. if user finished reading the news they chose, they can go back to the home page with back button on left side of Localez text.
