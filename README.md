LIBRARY MANGEMENT SERVICE

Library Management Service is a service which provide basic functionalities to maintain library. This system aims to reduce the manual efforts of librarian and allows librarian to maintain library in a more effective manner.

USER STORIES.

ROLE OF LIBRARIAN

1.A librarian will have the privilege to add new book into the database.

2.A librarian can issue books to students.

3.As a librarian he can search a book by category as well as title.

4.As a librarian he can see list of books which are not returned by students in a given due date.

5.A librarian has the privilege to view total active book issued against each user.

6.A librarian can view the total quantity of book available against each category.

7.A librarian can view the location of a particular book.

ROLE OF A STUDENT.

1.A student can view the total number of books issued against him.

2.A student can view the total number of book which has not been returned on time.

3.A student can issue book.

4.A student when trying to issue a book of the same ISBN number multiple times should not be allowed.--\&gt;throw exception in this case.

FULL API DESIGN

a)API FOR LIBRARIAN

1.AddBook to Database

Description: This API will add a book to the database.

Input: This API will take the information about the book that is name, title, category, author, ISBNnumber.

Output: Return a message to the user that book is successfully added in db.

Exception:

1. If user enters UUID manually then validate if that UUID exists in db or not.

If it exists then throw an exception that user cannot enter duplicate record.

2.Also if user enters an invalid category then throw an exception saying that user is entering invalid category.

2.Issue book to student.

Description: This API will issue a book to student.

Input: Student Id, UUID bookid, Duration of book issued.

Output: Return a successful message if book is successfully issued else will throw an exception if book is not available or book is already issued. [Good]

3.Return book by category.

Description: This API will return all the available books of the same category.

Input: Category of book

Output: List of books available of that category.

4.Return list of books not returned in given time

Description: This API will return list of books which are not returned in a given time.

Input: Not applicable

Output: List of books, book issue time, book expiry time, to whom it was issued.

5.View total active book against each student

Description: This API will return total active book against each user.

Input: Student id

Output: List of total active book against each user, issue date, expiry date

6.View total quantity of book available against each category//It is the same as 3rd API

Description: This API will return the total quantity of book available in the database against each category.

Input: Category name of book

Output: Total quantity of book available.

7.View location of a particular book

Description: This API will return the location of the book.

Input: Category of the book

Output: Return the location of the book.

b)API FOR STUDENT

1.View total number of book issued against each student

Description: This API will return the total number of book issued against each student.

Input: Student Id of student

Output: List of book issued by that student

2.Total book not returned on time.

Description: This API will return the total number of book which are not returned on time for each student.

Input: Student Id of the student.

Output: List of book not returned on time for that student.

3.Issue book to student

Description: This API will issue book to student.

Input: Student id of the student, Category of book ,Title of book.

Output: Return successful message if book is successfully issued

NAME OF API FOR LIBRARIAN

1. Public String addBookToDatabase(Book b)
2. Public String issueBookToStudent(UUID studentid,String bookTitle,String bookCategory)
3. Public List\&lt;Book\&gt; findBookByCategory(String categoryOfBook)
4. Public List\&lt;Book\&gt; findListOfBookNotReturnedInGivenTime( )
5. Public List\&lt;Book\&gt; findActiveBookAgainstEachUser(UUID roolNumber)
6. Public int totalQuantityOfBookAgainstEachCategory(String categoryName

NAME OF API FOR STUDENT

1. Public List\&lt;Book\&gt; listOfBookIssued(UUID rollNumber)
2. Public List\&lt;Book\&gt; listOfBookNotReturnedForEachStudent(UUID rollNumber)

API FOR BOOK

1)public boolean createCategoryForBook()

BOOK MODEL..

1.bookname

2.booktitle

3.bookauthor

4.bookcategory

5.isbnnumer

6.totalbookavailable

7.totalbooksbooked

STUDENT MODEL

1.studentId

2.isbnnumber

3.bookcategory

4.dateofissue

5.dateofreturn
