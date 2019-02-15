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
  
  
  
**Insert new book**
----
  Send json data.

* **URL**

  /books

* **Method:**

  `POST`
  
*  **Body Params**

    `{
        "title": "title example",
        "description": "description example",
        "isbn": "isbn example",
        "language": "pt-br"
    }`

* **Success Response:**

  * **Code:** 201 <br />
    **Content:** `{
    "bookId": 1235,
    "title": "title example",
    "description": "description example",
    "isbn": "isbn example",
    "language": "pt-br"
}`

**Search books using web crawler**
----
  Retrieve books from https://kotlinlang.org/docs/books.html.

* **URL**

  /books

* **Method:**

  `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "numberBooks": 2,
    "books": [
        {
            "bookId": null,
            "title": "Kotlin in Action",
            "description": "Kotlin in Action teaches you to use the Kotlin language for production-quality applications. Written for experienced Java developers, this example-rich book goes further than most language books, covering interesting topics like building DSLs with natural language syntax.The book is written by Dmitry Jemerov and Svetlana Isakova, developers on the Kotlin team.Chapter 6, covering the Kotlin type system, and chapter 11, covering DSLs, are available as a free preview on the publisher Web site.",
            "isbn": "9781617293290",
            "language": "en"
        },
        {
            "bookId": null,
            "title": "Kotlin for Android Developers",
            "description": "Kotlin for Android Developers is a book by Antonio Leiva showing how Kotlin can be used for creating an Android application from scratch.",
            "isbn": "Unavailable",
            "language": "en"
        }
      ]
    }`



## Built With

* [Eclipse](https://www.eclipse.org/) - IDE
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://spring.io/) - Spring framework, JPA, Boot
* [Jsoup](https://jsoup.org/) - Web crawler
* [Lombok Project](https://projectlombok.org/setup/eclipse) - Getters and Setters generator
