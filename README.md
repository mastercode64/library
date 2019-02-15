# library

Simple Rest API library for inserting and retrieving books. Also using Jsoup as a webcrawler



**Get book by id**
----
  Returns json data about a single book.

* **URL**

  /books/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "bookId": 1235,
    "title": "title example",
    "description": "description example",
    "isbn": "isbn example",
    "language": "pt-br"
}`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />



## Built With

* [Eclipse](https://www.eclipse.org/) - IDE
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://spring.io/) - Spring framework, JPA, Boot
* [Jsoup](https://jsoup.org/) - Web crawler
